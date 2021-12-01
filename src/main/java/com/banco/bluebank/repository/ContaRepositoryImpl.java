package com.banco.bluebank.repository;

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
    public BigDecimal findSaldo(Long numeroConta, OffsetDateTime data) {

        System.out.println("Chegou no repositorio");

        var jpql = "select function('f_saldo_conta',:numeroConta , :data) as saldo from Conta p where p.numeroConta=:numeroConta";

        return manager.createQuery(jpql, BigDecimal.class)
                .setParameter("numeroConta", numeroConta)
                .setParameter("data", data)
                .getSingleResult();
    }
}
