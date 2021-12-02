package com.banco.bluebank.exceptionhandler.exceptions;

public class SaldoBancoIndisponivelException extends BusinessException {

private static final long serialVersionUID = 1L;

	public SaldoBancoIndisponivelException(String mensagem) {
		super(mensagem);
	}

	public SaldoBancoIndisponivelException() {
		this("Saldo indisponível no caixa do banco");
	}
	
}
