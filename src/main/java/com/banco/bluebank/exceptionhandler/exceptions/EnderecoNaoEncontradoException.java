package com.banco.bluebank.exceptionhandler.exceptions;

public class EnderecoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public EnderecoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public EnderecoNaoEncontradoException(Long enderecoId) {
        this(String.format("Não existe o endereco com id %d", enderecoId));
    }
}
