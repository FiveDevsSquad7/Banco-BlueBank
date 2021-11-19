package com.banco.bluebank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bluebank.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.exceptions.EntidadeNaoEncontradaException;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.service.ContaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/conta")
public class ContaController
{

    @Autowired
    private ContaService service;

    @GetMapping
    public List<Conta> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
    	Conta conta = null;
    	try {
    		conta = service.buscarId(id);
            	return ResponseEntity.ok().build();
        	} catch (RuntimeException ex) {
        		//1 caso captura a messagem de erro e exibir para no front ou encapsula no body da resposta JSON no back
                return ResponseEntity.ok(ex.getMessage());

        	}
       
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta salvar(@RequestBody @Valid Conta contaInput) {
        return service.salvar(contaInput);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Conta contaInput, @PathVariable Long id){
        Optional<Conta> optionalConta = Optional.ofNullable(service.buscarPorIdParaAtualizar(id));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
    	try {
        Conta conta = service.buscarId(id);
        service.excluir(id);
        return ResponseEntity.noContent().build();
    	}catch(EntidadeNaoEncontradaException e) {
        return ResponseEntity.notFound().build();
    	}catch(EntidadeEmUsoException e) {
          return ResponseEntity.internalServerError().build();
        }
    }

}
