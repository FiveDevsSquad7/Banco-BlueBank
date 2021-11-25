package com.banco.bluebank.exceptions;

public class MovimentacaoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public MovimentacaoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public MovimentacaoNaoEncontradaException(Long movimentacaoId) {
		this(String.format("Não existe um registro de movimentação com id %d", movimentacaoId));
	}
	
}
