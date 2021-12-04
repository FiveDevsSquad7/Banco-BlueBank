package com.banco.bluebank.repository;

import com.banco.bluebank.model.dto.output.SaldoOutput;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface ContaRepositoryQueries {
    SaldoOutput findSaldo(Long numeroConta, OffsetDateTime data);
}
