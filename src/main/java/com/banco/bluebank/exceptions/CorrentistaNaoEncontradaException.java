package com.banco.bluebank.exceptions;

public class CorrentistaNaoEncontradaException extends EntidadeNaoEncontradaException{

    public CorrentistaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CorrentistaNaoEncontradaException(Long agenciaId) {
        this(String.format("Não existe um cadastro correntista com id %d", agenciaId));
    }
}
