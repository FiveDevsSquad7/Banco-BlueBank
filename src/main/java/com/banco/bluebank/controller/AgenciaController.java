package com.banco.bluebank.controller;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.service.AgenciaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaService service;

    @GetMapping
    public Page<Agencia> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agencia buscar(@PathVariable Long id) {
        return service.buscar(id);
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
        service.excluir(id);
    }

}