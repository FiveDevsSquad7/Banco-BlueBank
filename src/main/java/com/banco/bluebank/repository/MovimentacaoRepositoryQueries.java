package com.banco.bluebank.repository;

import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.dto.output.SaldoOutput;

import java.time.OffsetDateTime;
import java.util.List;

public interface MovimentacaoRepositoryQueries {
    List<Movimentacao> findByConta(Long numeroConta, OffsetDateTime dataInicial, OffsetDateTime dataFinal);
}
