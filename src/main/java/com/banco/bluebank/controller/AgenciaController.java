package com.banco.bluebank.controller;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.service.AgenciaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaService service;

    @ApiOperation(value = "Busca todas as Agencias na Base de Dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de Agencias"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<Agencia> listar() {
        return service.listar();
    }

    @ApiOperation(value = "Pesquisa Agencia pelo código gerado no Banco de Dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de agencias"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agencia buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @ApiOperation(value = "Insere uma nova agencia")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após criação"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agencia salvar(@RequestBody Agencia agencia) {
        return service.salvar(agencia);
    }

    @ApiOperation(value = "Faz atualização global do Agencia específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após atualização"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agencia atualizar(@PathVariable Long id, @RequestBody Agencia agencia) {
        Agencia agenciaAtual = service.buscar(id);
        BeanUtils.copyProperties(agencia, agenciaAtual, "id");
        return service.salvar(agenciaAtual);
    }
    @ApiOperation(value = "Exclui Agencia exclisivo por meio do ID passado!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após exclusão"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }

}