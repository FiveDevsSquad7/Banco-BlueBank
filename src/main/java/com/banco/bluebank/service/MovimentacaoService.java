package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.ContaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.MovimentacaoNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.SaldoIndisponivelException;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.dto.output.SaldoOutput;
import com.banco.bluebank.repository.ContaRepository;
import com.banco.bluebank.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Autowired ContaUtils contaUtils;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Transactional(readOnly = false)
	public Movimentacao salvar(Movimentacao movimentacao) {

		Long contaDebitoSemDigito = contaUtils.verificaNumeroConta(movimentacao.getNumeroContaDebito());
		Long contaCreditoSemDigito = contaUtils.verificaNumeroConta(movimentacao.getNumeroContaCredito());

		Conta contaDebito = contaRepository.findById(contaDebitoSemDigito)
				.orElseThrow(() -> new ContaNaoEncontradaException(contaDebitoSemDigito));

		Conta contaCredito = contaRepository.findById(contaCreditoSemDigito)
				.orElseThrow(() -> new ContaNaoEncontradaException(contaCreditoSemDigito));

		SaldoOutput saldo = contaRepository.findSaldo(contaDebitoSemDigito, OffsetDateTime.now());

		if (saldo.getSaldo().add(movimentacao.getValor()).compareTo(BigDecimal.ZERO) >= 0) {
			throw new SaldoIndisponivelException(contaDebitoSemDigito);
		}

		movimentacao.setContaDebito(contaDebito);
		movimentacao.setContaCredito(contaCredito);
		movimentacao.setNumeroContaDebito(contaDebitoSemDigito);
		movimentacao.setNumeroContaCredito(contaCreditoSemDigito);

		movimentacao = movimentacaoRepository.save(movimentacao);

		eventPublisher.publishEvent(new MovimentacaoRealizadaEvent(movimentacao));

		return movimentacao;

	}

	public List<Movimentacao> listar(Long numeroConta) {

		Long numeroContaSemDigito = contaUtils.verificaNumeroConta(numeroConta);
		Conta conta = contaRepository.findById(numeroContaSemDigito)
				.orElseThrow( () -> new ContaNaoEncontradaException(numeroContaSemDigito));

		ArrayList<Movimentacao> lista = (ArrayList<Movimentacao>) movimentacaoRepository.findAll();
		ArrayList<Movimentacao> lista2 = new ArrayList<Movimentacao>();
		for (Movimentacao m1 : lista) {
			if (Objects.equals(m1.getNumeroContaCredito(), numeroContaSemDigito) || Objects.equals(m1.getNumeroContaDebito(), numeroContaSemDigito)) {
				lista2.add(m1);
			}
		}

		return lista2;
	}

	public Movimentacao buscarPorId(Long idMovimentacao) {
		return movimentacaoRepository.findById(idMovimentacao)
				.orElseThrow(() -> new MovimentacaoNaoEncontradaException(idMovimentacao));
	}

}
