package com.banco.bluebank.exceptions;

import com.banco.bluebank.exceptions.BusinessException;

public abstract class EntidadeNaoEncontradaException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
}
