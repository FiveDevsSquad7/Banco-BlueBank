package com.banco.bluebank.repository;

import com.banco.bluebank.model.dto.output.SaldoOutput;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Repository
public class ContaRepositoryImpl implements ContaRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public SaldoOutput findSaldo(Long numeroConta, OffsetDateTime data) {

        var jpql = "select function('f_saldo_conta',:numeroConta , :data) as saldo from Conta p where p.numeroConta=:numeroConta";

        BigDecimal saldo = manager.createQuery(jpql, BigDecimal.class)
                .setParameter("numeroConta", numeroConta)
                .setParameter("data", data)
                .getSingleResult();

        return new SaldoOutput(numeroConta, data, saldo);

    }

}
