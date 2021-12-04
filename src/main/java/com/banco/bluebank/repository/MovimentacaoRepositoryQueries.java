package com.banco.bluebank.repository;

import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.dto.output.SaldoOutput;
import org.springframework.data.domain.Page;

import java.time.OffsetDateTime;
import java.util.List;

public interface MovimentacaoRepositoryQueries {
    Page<Movimentacao> findByConta(Long numeroConta, OffsetDateTime dataInicial, OffsetDateTime dataFinal);
}
