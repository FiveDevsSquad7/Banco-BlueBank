package com.banco.bluebank.service;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;


    public  List<Conta> buscarTodos() {
        return contaRepository.findAll();
    }

    public Optional<Conta> buscarId(Long id){
      return contaRepository.findById(id);
    }

   public Conta salvar(Conta contaInput){
        return contaRepository.save(contaInput);    
   }

    public Conta buscarPorIdParaAtualizar(Long id) {
        Optional<Conta> optionalConta = contaRepository.findById(id);
        return optionalConta.orElseThrow(() -> new RuntimeException("Não foi possível encontrar essa com por esse ID!"));
    }

    @Transactional
    public void excluir(Long id) {
        contaRepository.deleteById(id);
    }
}
