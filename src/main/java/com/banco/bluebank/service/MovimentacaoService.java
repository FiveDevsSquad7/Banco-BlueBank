package com.banco.bluebank.service;

import java.util.List;

import com.banco.bluebank.exceptionhandler.exceptions.ContaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Transactional(readOnly = false)
	public Movimentacao salvar(Movimentacao movimentacao) {
		Conta contaDebito = contaRepository.findById(movimentacao.getNumeroContaDebito())
				.orElseThrow(() -> new ContaNaoEncontradaException(movimentacao.getNumeroContaDebito()));
		Conta contaCredito = contaRepository.findById(movimentacao.getNumeroContaCredito())
				.orElseThrow(() -> new ContaNaoEncontradaException(movimentacao.getNumeroContaCredito()));
		movimentacao.setContaDebito(contaDebito);
		movimentacao.setContaCredito(contaCredito);

		return movimentacaoRepository.save(movimentacao);
	}

	public List<Movimentacao> listar() {
		return movimentacaoRepository.findAll();
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
