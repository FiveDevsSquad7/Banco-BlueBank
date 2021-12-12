package com.banco.bluebank.exceptionhandler.exceptions;

public class RecursoComBloqueioException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public RecursoComBloqueioException(String mensagem) {
		super(mensagem);
	}
	
}
