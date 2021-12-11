package com.banco.bluebank.model.dto.output;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class SaldoOutput {

    private Long numeroConta;

    private OffsetDateTime data;

    private BigDecimal saldo;

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public OffsetDateTime getData() {
        return data;
    }

    public void setData(OffsetDateTime data) {
        this.data = data;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public SaldoOutput(Long numeroConta, OffsetDateTime data, BigDecimal saldo) {
        this.numeroConta = numeroConta;
        this.data = data;
        this.saldo = saldo;
    }

}
