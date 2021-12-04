package com.banco.bluebank.exceptionhandler.exceptions;

public class DigitoVerificadorInvalidoException extends BusinessException {

private static final long serialVersionUID = 1L;

	public DigitoVerificadorInvalidoException(String mensagem) {
		super(mensagem);
	}

	public DigitoVerificadorInvalidoException(Long id) {
		this(String.format("Digito verificador invalido para a conta %d", id));
	}
	
}
