package com.banco.bluebank.repository;

import com.banco.bluebank.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banco.bluebank.model.ContatoCliente;

import java.util.List;

@Repository
public interface ContatoClienteRepository extends JpaRepository<ContatoCliente, Long>{

}
