package com.banco.bluebank.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class MovimentacaoInput {

    private Long numeroConta;
    private String descricao;
    private BigDecimal valor;

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
