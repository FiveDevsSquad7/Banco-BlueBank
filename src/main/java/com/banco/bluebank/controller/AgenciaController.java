package com.banco.bluebank.controller;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class AgenciaController {
    @Autowired
    private AgenciaService service;

    @GetMapping(path = "/agencias")
    public List<Agencia> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping(path = "agencia/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Agencia> conta = service.buscarId(id);
        if(!conta.isEmpty()) {
            return ResponseEntity.ok(conta.orElseThrow(() -> new RuntimeException("Não foi possível encontrar essa com por esse ID!")));
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping (path = "agencia/novaAgencia")
    @ResponseStatus(HttpStatus.CREATED)
    public Agencia salvar(@RequestBody @Valid Agencia agenciaInput) {
        return service.salvar(agenciaInput);
    }

    @PutMapping("agencia/atualizar/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Agencia agenciaInput, @PathVariable Long id){
        Optional<Agencia> optionalAgencia = Optional.ofNullable(service.buscarPorIdParaAtualizar(id));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("agencia/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        Optional<Agencia> optionalAgencia = service.buscarId(id);
        if(optionalAgencia.isPresent()) {
            service.excluir(id);
            return     ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}