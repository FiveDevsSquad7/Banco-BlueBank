package com.banco.bluebank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banco.bluebank.model.Movimentacao;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    @Query("select p from Movimentacao p where (p.numeroContaCredito=:numeroConta or p.numeroContaDebito=:numeroConta) "+
            "and p.dataMovimento>=:dataInicial and p.dataMovimento<:dataFinal")
    Page<Movimentacao> findByConta(@Param("numeroConta") Long numeroConta,
                                   @Param("dataInicial") OffsetDateTime dataInicial,
                                   @Param("dataFinal") OffsetDateTime dataFinal,
                                   Pageable pageable);

}
