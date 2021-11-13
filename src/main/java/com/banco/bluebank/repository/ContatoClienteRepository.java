package com.banco.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.bluebank.model.ContatoCliente;

@Repository
public interface ContatoClienteRepository extends JpaRepository<ContatoCliente, Long>{

}
