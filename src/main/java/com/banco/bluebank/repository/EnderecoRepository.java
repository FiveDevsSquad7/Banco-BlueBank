package com.banco.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.bluebank.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
