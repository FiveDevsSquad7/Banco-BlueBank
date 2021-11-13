package com.banco.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.bluebank.model.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

}
