package com.banco.bluebank.exceptionhandler.exceptions;

public class CorrentistaNaoEncontradoException extends EntidadeNaoEncontradaException {

    public CorrentistaNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public CorrentistaNaoEncontradoException(Long correntistaId) {
        this(String.format("Não existe um cadastro de correntista com id %d", correntistaId));
    }
}
