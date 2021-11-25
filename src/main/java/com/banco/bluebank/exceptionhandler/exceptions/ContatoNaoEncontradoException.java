package com.banco.bluebank.exceptionhandler.exceptions;

public class ContatoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public ContatoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public ContatoNaoEncontradoException(Long contatoId) {
        this(String.format("Não existe o contato com id %d", contatoId));
    }
}
