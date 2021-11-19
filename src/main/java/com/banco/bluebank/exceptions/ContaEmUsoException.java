package com.banco.bluebank.exceptions;

public class ContaEmUsoException extends EntidadeEmUsoException 
{

	private static final long serialVersionUID = 1L;

	public ContaEmUsoException(String mensagem) {
		super(mensagem);
	}

	public ContaEmUsoException(Long agenciaId) {
		this(String.format("Não existe um cadastro de agência com id %d", agenciaId));
	}
	
}
