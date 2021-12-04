package com.banco.bluebank.repository;

import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.dto.output.SaldoOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class MovimentacaoRepositoryImpl implements MovimentacaoRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Movimentacao> findByConta(Long numeroConta, OffsetDateTime dataInicial, OffsetDateTime dataFinal) {

        dataFinal = dataFinal.plusDays(1);
        var jpql = "select p from Movimentacao p where (p.numeroContaCredito=:numeroConta or p.numeroContaDebito=:numeroConta) "+
                "and p.dataMovimento>=:dataInicial and p.dataMovimento<:dataFinal";

        List<Movimentacao> lista =  manager.createQuery(jpql, Movimentacao.class)
                .setParameter("numeroConta", numeroConta)
                .setParameter("dataInicial", dataInicial)
                .setParameter("dataFinal", dataFinal)
                .getResultList();
        Page<Movimentacao> page = new PageImpl<>(lista);
        return page;

    }
}
