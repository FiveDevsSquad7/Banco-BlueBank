package com.banco.bluebank.service;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public  List<Agencia> buscarTodos() {
        return agenciaRepository.findAll();
    }

    public Optional<Agencia> buscarId(Long id){
        return agenciaRepository.findById(id);
    }

    public Agencia salvar(Agencia agenciaInput){
        return agenciaRepository.save(agenciaInput);
    }

    public Agencia buscarPorIdParaAtualizar(Long id) {
        Optional<Agencia> optionalAgencia = agenciaRepository.findById(id);
        return optionalAgencia.orElseThrow(() -> new RuntimeException("Não foi possível encontrar essa com por esse ID!"));
    }

    @Transactional
    public void excluir(Long id) {
        agenciaRepository.deleteById(id);
    }
}