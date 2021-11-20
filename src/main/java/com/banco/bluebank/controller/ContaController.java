package com.banco.bluebank.controller;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @GetMapping
    public List<Conta> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
       Optional<Conta> conta = service.buscarId(id);
        if(!conta.isEmpty()) {
            return ResponseEntity.ok(conta.orElseThrow(() -> new RuntimeException("Não foi possível encontrar essa com por esse ID!")));
        }
        return ResponseEntity.ok().build();
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
        Optional<Conta> optionalConta = service.buscarId(id);
        if(optionalConta.isPresent()) {
            service.excluir(id);
            return 	ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
