package com.banco.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.bluebank.model.Correntista;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Long>{



}
