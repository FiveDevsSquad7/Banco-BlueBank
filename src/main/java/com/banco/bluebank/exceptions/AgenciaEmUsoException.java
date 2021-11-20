package com.banco.bluebank.exceptions;

public class AgenciaEmUsoException extends EntidadeEmUsoException {

	private static final long serialVersionUID = 1L;

	public AgenciaEmUsoException(String mensagem) {
		super(mensagem);
	}

	public AgenciaEmUsoException(Long agenciaId) {
		this(String.format("Não existe um cadastro de agência com id %d", agenciaId));
	}
	
}
