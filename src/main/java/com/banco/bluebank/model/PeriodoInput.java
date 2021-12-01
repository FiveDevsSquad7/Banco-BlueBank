package com.banco.bluebank.model;

import java.time.OffsetDateTime;

public class PeriodoInput {

    private OffsetDateTime dataInicial;
    private OffsetDateTime dataFinal;

    public OffsetDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(OffsetDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public OffsetDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(OffsetDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }
}
