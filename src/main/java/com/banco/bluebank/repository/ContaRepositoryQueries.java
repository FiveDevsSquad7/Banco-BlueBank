package com.banco.bluebank.repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface ContaRepositoryQueries {
    BigDecimal findSaldo(Long numeroConta, OffsetDateTime data);
}
