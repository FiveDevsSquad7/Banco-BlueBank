package com.banco.bluebank.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class MovimentacaoInput {

    @ApiModelProperty(required = true, value = "Campo referente número da Conta a ser movimentada")
    @NotNull(message = "O número da conta deve ser preenchido")
    private Long numeroConta;

    @ApiModelProperty(value = "Campo referente descrição")
    @Size(max = 100, message = "A descrição deve ter no máximo 100 caracteres.")
    private String descricao;

    @ApiModelProperty(value = "Campo referente valor")
    @NotNull(message = "O valor deve ser preenchido")
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
