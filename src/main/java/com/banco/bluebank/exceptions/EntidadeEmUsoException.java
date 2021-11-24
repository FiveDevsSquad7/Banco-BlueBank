package com.banco.bluebank.exceptions;

import com.banco.bluebank.exceptions.BusinessException;

public class EntidadeEmUsoException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}
	
}
