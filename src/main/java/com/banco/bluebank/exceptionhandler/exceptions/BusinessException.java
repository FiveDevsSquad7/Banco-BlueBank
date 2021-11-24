package com.banco.bluebank.exceptionhandler.exceptions;


public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException() {
        super();
    }

    public BusinessException(String message){
        super(message);
    }
}

