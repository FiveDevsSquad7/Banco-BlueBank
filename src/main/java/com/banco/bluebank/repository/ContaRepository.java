package com.banco.bluebank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banco.bluebank.model.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

    @Query("select function('f_saldo_conta',p.numeroConta , '2021-12-01') from Conta p where p.numeroConta=2")
    Optional<BigDecimal> findSaldo(Long numeroConta, OffsetDateTime data);

}
