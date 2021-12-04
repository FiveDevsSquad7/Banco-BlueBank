package com.banco.bluebank.exceptionhandler.exceptions;

public class SaldoCorrentistaIndisponivelException extends BusinessException {

private static final long serialVersionUID = 1L;

	public SaldoCorrentistaIndisponivelException(String mensagem) {
		super(mensagem);
	}

	public SaldoCorrentistaIndisponivelException(Long id) {
		this(String.format("Saldo indisponível para a conta %d", id));
	}
	
}
