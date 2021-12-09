package com.banco.bluebank.controller;

import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.MovimentacaoInput;
import com.banco.bluebank.security.CheckSecurity;
import com.banco.bluebank.service.MovimentacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/movimentacoes")
public class MovimentacaoController {

    public static final long NUMERO_CONTA_CAIXA_ADM = 18L;
    @Autowired
    private MovimentacaoService service;


    @ApiOperation(value = "Cria uma nova Movimentacao de transferencia")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após criação"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @CheckSecurity.Movimentacoes.PodeTransferir
    @PostMapping(path="/transferencia")
    @ResponseStatus(HttpStatus.CREATED)
    public Movimentacao salvar(@RequestBody Movimentacao movimentacao) {
        movimentacao.setNumeroContaCredito(movimentacao.getNumeroContaCredito());
        movimentacao.setNumeroContaDebito(movimentacao.getNumeroContaDebito());
        service.salvar(movimentacao);
        return this.buscar(movimentacao.getId());
    }

    @ApiOperation(value = "Cria uma nova Movimentacao de deposito")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após criação"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @CheckSecurity.Movimentacoes.PodeDepositar
    @PostMapping(path = "/deposito")
    @ResponseStatus(HttpStatus.CREATED)
    public Movimentacao depositar(@RequestBody MovimentacaoInput movimentacaoInput) {
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setNumeroContaDebito(NUMERO_CONTA_CAIXA_ADM);
        movimentacao.setNumeroContaCredito(movimentacaoInput.getNumeroConta());
        movimentacao.setDescricao(movimentacaoInput.getDescricao());
        movimentacao.setValor(movimentacaoInput.getValor());
        service.salvar(movimentacao);
        return this.buscar(movimentacao.getId());
    }

    @ApiOperation(value = "Cria uma nova Movimentacao de saque")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após criação"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @CheckSecurity.Movimentacoes.PodeSacar
    @PostMapping(path = "/saque")
    @ResponseStatus(HttpStatus.CREATED)
    public Movimentacao sacar(@RequestBody MovimentacaoInput movimentacaoInput) {
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setNumeroContaCredito(NUMERO_CONTA_CAIXA_ADM);
        movimentacao.setNumeroContaDebito(movimentacaoInput.getNumeroConta());
        movimentacao.setDescricao(movimentacaoInput.getDescricao());
        movimentacao.setValor(movimentacaoInput.getValor());
        service.salvar(movimentacao);
        return this.buscar(movimentacao.getId());
    }

    @ApiOperation(value = "Busca movimentacao por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um recurso de movimentacoes específico"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @CheckSecurity.Movimentacoes.PodeConsultar
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movimentacao buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

}