package com.banco.bluebank.service;

import com.banco.bluebank.model.Movimentacao;

public class MovimentacaoRealizadaEvent {

    private Movimentacao movimentacao;

    public MovimentacaoRealizadaEvent(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }
}
