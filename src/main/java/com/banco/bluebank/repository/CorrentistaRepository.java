package com.banco.bluebank.repository;

import com.banco.bluebank.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Long>{

}
