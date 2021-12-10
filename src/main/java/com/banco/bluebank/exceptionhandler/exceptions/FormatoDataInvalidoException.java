package com.banco.bluebank.exceptionhandler.exceptions;

public class FormatoDataInvalidoException extends BusinessException {

private static final long serialVersionUID = 1L;

	public FormatoDataInvalidoException(String mensagem) {
		super(mensagem);
	}

	public FormatoDataInvalidoException() {
		this("Formato de data inválido, use data UTC, exemplo 2021-12-10T00:00Z");
	}
	
}
