package com.banco.bluebank.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.banco.bluebank.model.ContatoCliente;

import java.util.Optional;

@Repository
public interface ContatoClienteRepository extends PagingAndSortingRepository<ContatoCliente, Long>,
        JpaSpecificationExecutor<ContatoCliente> {

    @Query("select contaCorr from ContatoCliente contaCorr where contaCorr.infoRecado =:#{#busca.infoRecado}")
    Optional<ContatoCliente> buscaGeral(@Param("busca") ContatoCliente busca);
}
