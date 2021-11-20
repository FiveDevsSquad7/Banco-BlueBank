package com.banco.bluebank.exceptions;

public class ContaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public ContaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public ContaNaoEncontradaException(Long agenciaId) {
		this(String.format("Não existe um cadastro de conta com id %d", agenciaId));
	}
	
}
