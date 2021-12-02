package com.banco.bluebank.exceptionhandler.exceptions;

public class SaldoIndisponivelException extends BusinessException {

private static final long serialVersionUID = 1L;

	public SaldoIndisponivelException(String mensagem) {
		super(mensagem);
	}

	public SaldoIndisponivelException(Long id) {
		this(String.format("Saldo indisponível para a conta %d", id));
	}
	
}
