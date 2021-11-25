package com.banco.bluebank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.bluebank.exceptions.MovimentacaoNaoEncontradaException;
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
		System.out.println(movimentacao.getDescricao());
		System.out.println(movimentacao.getIdContaDebito());
		System.out.println(movimentacao.getIdContaCredito());
		System.out.println(movimentacao.getValor());
		System.out.println(movimentacao.getDataMovimento());
		Conta c1 = contaRepository.findById(movimentacao.getIdContaCredito())
				.orElseThrow(() -> new IllegalArgumentException("Conta de Credito não existe!"));
		Conta c2 = contaRepository.findById(movimentacao.getIdContaCredito())
				.orElseThrow(() -> new IllegalArgumentException("Conta de Debito não existe!"));
		movimentacao.setContaCredito(c1);
		movimentacao.setContaDebito(c2);
		/*
		 * movimentacao.setDataMovimento(movimentacao.getDataMovimento()); Movimentacao
		 * movimentacao1 = movimentacao;
		 * movimentacao1.setContaCredito(movimentacao.getContaCredito());
		 * movimentacao1.setContaCredito(movimentacao.getContaCredito());
		 */
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
