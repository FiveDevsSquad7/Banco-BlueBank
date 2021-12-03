package com.banco.bluebank.exceptionhandler.exceptions;

public class PeriodoInvalidoException extends BusinessException {

private static final long serialVersionUID = 1L;

	public PeriodoInvalidoException(String mensagem) {
		super(mensagem);
	}

	public PeriodoInvalidoException() {
		this("O período especificado está inválido");
	}
	
}
