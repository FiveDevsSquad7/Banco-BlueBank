package com.banco.bluebank.controller;

import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.security.CheckSecurity;
import com.banco.bluebank.service.AgenciaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaService service;

    @ApiOperation(value = "Busca todas as Agencias na Base de Dados", httpMethod = "GET",
            notes = "Busca todas as Agencias na Base de Dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de Agencias"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor"),
    })
    @CheckSecurity.Agencias.PodeConsultar
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<Agencia> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @ApiOperation(value = "Pesquisa Agencia pelo código gerado no Banco de Dados", httpMethod = "GET",
            notes = "Busca Agencias pelo ID Base de Dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de agencias"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor"),
    })
    @CheckSecurity.Agencias.PodeConsultar
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agencia buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @ApiOperation(value = "Insere uma nova agencia", httpMethod = "POST",
            notes = "Insere nova agencia")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retornar SUCESSO após criação"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor"),
    })
    @CheckSecurity.Agencias.PodeEditar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agencia salvar(@RequestBody @Valid Agencia agencia) {
        return service.salvar(agencia);
    }

    @ApiOperation(value = "Faz atualização global do Agencia específico pelo ID", httpMethod = "PUT",
            notes = "Atualiza agencia via ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após atualização"),
            @ApiResponse(code = 201, message = "Retornar SUCESSO após criação"),
            @ApiResponse(code = 204, message = "Retornar SUCESSO SEM ALTERAR CONTEÚDO"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor"),
    })
    @CheckSecurity.Agencias.PodeEditar
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agencia atualizar(@PathVariable Long id, @RequestBody @Valid Agencia agencia) {
        Agencia agenciaAtual = service.buscar(id);
        BeanUtils.copyProperties(agencia, agenciaAtual, "id", "dataCadastro");
        return service.salvar(agenciaAtual);
    }

    @ApiOperation(value = "Exclui Agencia exclisivo por meio do ID passado!", httpMethod = "DELETE",
            notes = "Exclui agencia via ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após EXCLUSÃO"),
            @ApiResponse(code = 202, message = "Retornar SUCESSO DE RECEBIMENTO, PORÉM A REQUISIÇÃO não pode atuar NO MOMENTO"),
            @ApiResponse(code = 204, message = "Retornar SUCESSO SEM ALTERAR CONTEÚDO"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor"),
    })
    @CheckSecurity.Agencias.PodeEditar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }

}