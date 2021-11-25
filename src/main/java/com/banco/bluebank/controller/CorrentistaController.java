package com.banco.bluebank.controller;


import com.banco.bluebank.model.ContatoCliente;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.model.Endereco;
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
        return service.create(correntista);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Correntista atualizar(@PathVariable Long id, @RequestBody Correntista correntista) {
        Correntista correntistaAtual = service.buscar(id);
        BeanUtils.copyProperties(correntista, correntistaAtual, "id", "enderecos", "contatos");
        return service.update(correntistaAtual);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }


    @GetMapping(path = "/{id}/enderecos")
    @ResponseStatus(HttpStatus.OK)
    public List<Endereco> listarEnderecos(@PathVariable Long id) {
        return service.listarEnderecosPorCorrentista(id);
    }

    @GetMapping(path = "/{id}/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<ContatoCliente> listarContatos(@PathVariable Long id) {
        return service.listarContatosPorCorrentista(id);
    }

    @PostMapping(path = "/{id}/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Endereco> adicionarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        return service.adicionarEndereco(id, endereco);
    }

    @PostMapping(path = "/{id}/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ContatoCliente> adicionarContato(@PathVariable Long id, @RequestBody ContatoCliente contato) {
        return service.adicionarContato(id, contato);
    }

    @DeleteMapping("/{id}/enderecos/{enderecoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEndereco(@PathVariable Long id, @PathVariable Long enderecoId) {
        service.excluirEndereco(id, enderecoId );
    }

    @DeleteMapping("/{id}/contatos/{contatoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerContato(@PathVariable Long id, @PathVariable Long contatoId) {
        service.excluirContato(id, contatoId );
    }

}
