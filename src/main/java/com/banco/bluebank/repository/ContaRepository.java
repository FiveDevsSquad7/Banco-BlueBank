package com.banco.bluebank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banco.bluebank.model.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>, ContaRepositoryQueries {

 }
