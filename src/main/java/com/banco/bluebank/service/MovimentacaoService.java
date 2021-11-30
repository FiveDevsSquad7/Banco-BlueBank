package com.banco.bluebank.service;

import java.util.ArrayList;
import java.util.List;

import com.banco.bluebank.exceptionhandler.exceptions.ContaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.DigitoVerificadorInvalidoException;
import com.banco.bluebank.service.MovimentacaoRealizadaEvent;
import com.banco.bluebank.utils.DigitoVerificadorLuhn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.bluebank.exceptionhandler.exceptions.MovimentacaoNaoEncontradaException;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.repository.ContaRepository;
import com.banco.bluebank.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private DigitoVerificadorLuhn dv;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Transactional(readOnly = false)
	public Movimentacao salvar(Movimentacao movimentacao) {

		if(! dv.verificaDigitoVerificador(movimentacao.getNumeroContaDebito().toString())){
			throw new DigitoVerificadorInvalidoException(movimentacao.getNumeroContaDebito());
		}
		if(! dv.verificaDigitoVerificador(movimentacao.getNumeroContaCredito().toString())){
			throw new DigitoVerificadorInvalidoException(movimentacao.getNumeroContaCredito());
		}
		String stringContaDebito = movimentacao.getNumeroContaDebito().toString();
		Long contaDebitoSemDigito = Long.parseLong(stringContaDebito.substring(0,stringContaDebito.length()-1));
		Conta contaDebito = contaRepository.findById(contaDebitoSemDigito)
				.orElseThrow(() -> new ContaNaoEncontradaException(contaDebitoSemDigito));
		String stringContaCredito = movimentacao.getNumeroContaCredito().toString();
		Long contaCreditoSemDigito = Long.parseLong(stringContaCredito.substring(0,stringContaCredito.length()-1));
		Conta contaCredito = contaRepository.findById(contaCreditoSemDigito)
				.orElseThrow(() -> new ContaNaoEncontradaException(contaCreditoSemDigito));

		movimentacao.setContaDebito(contaDebito);
		movimentacao.setContaCredito(contaCredito);
		movimentacao.setNumeroContaDebito(contaDebitoSemDigito);
		movimentacao.setNumeroContaCredito(contaCreditoSemDigito);

		movimentacao = movimentacaoRepository.save(movimentacao);

		eventPublisher.publishEvent(new MovimentacaoRealizadaEvent(movimentacao));
		System.out.println("ja publiquei o evento para notificacoes");

		return movimentacao;

	}

	public List<Movimentacao> listar(long numeroConta) {
		ArrayList<Movimentacao> lista = (ArrayList<Movimentacao>) movimentacaoRepository.findAll();
		ArrayList<Movimentacao> lista2 = new ArrayList<Movimentacao>();
		for (Movimentacao m1 : lista) {
			if (m1.getNumeroContaCredito() == numeroConta || m1.getNumeroContaDebito() == numeroConta) {
				lista2.add(m1);
			}

		}
		return lista2;
	}

	public Movimentacao buscarPorId(Long idMovimentacao) {
		return movimentacaoRepository.findById(idMovimentacao)
				.orElseThrow(() -> new MovimentacaoNaoEncontradaException(idMovimentacao));
	}

	public void excluir(Long idMovimentacao) {
		try {
			movimentacaoRepository.deleteById(idMovimentacao);

		} catch (EmptyResultDataAccessException e) {
			throw new MovimentacaoNaoEncontradaException(idMovimentacao);
		}
	}
}
