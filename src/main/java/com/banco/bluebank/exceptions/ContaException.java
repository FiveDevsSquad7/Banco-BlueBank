package com.banco.bluebank.exceptions;

public class ContaException extends EntidadeNaoEncontradaException {

private static final long serialVersionUID = 1L;
	
	public ContaException(String mensagem) {
		super(mensagem);
	}
	
	public ContaException(Long id) {
		this(String.format("Não existe um cadastro de conta com o id %d", id));
	}
	
}
