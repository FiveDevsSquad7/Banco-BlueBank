package com.banco.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.bluebank.model.Saldo;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Long>{

}
