package com.banco.bluebank.exceptionhandler.exceptions;

public class DadoRequeridoException extends BusinessException {

private static final long serialVersionUID = 1L;

	public DadoRequeridoException(String mensagem) {
		super(mensagem);
	}

	public DadoRequeridoException() {
		this("O período especificado está inválido");
	}
	
}
