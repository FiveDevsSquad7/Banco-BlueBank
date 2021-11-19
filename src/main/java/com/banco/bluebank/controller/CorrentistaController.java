package com.banco.bluebank.controller;


import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.service.CorrentistaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> listar() {
        return service.listar();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Correntista buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Correntista salvar(@RequestBody Correntista correntista) {
        return service.salvar(correntista);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Correntista atualizar(@PathVariable Long id, @RequestBody Correntista correntista) {
        Correntista correntistaAtual = service.buscar(id);
        BeanUtils.copyProperties(correntista, correntistaAtual, "id");
        return service.salvar(correntistaAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }
}
