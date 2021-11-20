package com.banco.bluebank.controller;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.service.AgenciaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.banco.bluebank.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.exceptions.EntidadeNaoEncontradaException;
@RestController
@RequestMapping(path = "/agencias")
public class AgenciaController 
{

    @Autowired
    private AgenciaService service;

    @GetMapping
    public List<Agencia> listar() {
        return service.listar();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agencia buscar(@PathVariable Long id) {
    	try {
        return service.buscar(id);
    	} catch (EntidadeNaoEncontradaException ex) {
    		//mostara messagem de erro ou enpusla no sjon
    	}
		return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agencia salvar(@RequestBody Agencia agencia) {
        return service.salvar(agencia);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agencia atualizar(@PathVariable Long id, @RequestBody Agencia agencia) {
        Agencia agenciaAtual = service.buscar(id);
        BeanUtils.copyProperties(agencia, agenciaAtual, "id");
        return service.salvar(agenciaAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
    	try {
        service.excluir(id);
    	}catch(EntidadeNaoEncontradaException e) {
    		
    		
    	}catch (EntidadeEmUsoException e) {
    	}
          
    }

}