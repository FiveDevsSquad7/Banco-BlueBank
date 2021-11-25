package com.banco.bluebank.exceptionhandler.exceptions;

public class AgenciaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public AgenciaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public AgenciaNaoEncontradaException(Long agenciaId) {
		this(String.format("Não existe um cadastro de agência com id %d", agenciaId));
	}
	
}
