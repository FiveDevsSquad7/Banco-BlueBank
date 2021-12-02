package com.banco.bluebank.controller;


import com.banco.bluebank.model.ContatoCliente;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.model.Endereco;
import com.banco.bluebank.service.CorrentistaService;
import com.banco.bluebank.service.MovimentacaoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
    
    @Autowired
    private MovimentacaoService serviceMovimentacao;

    @ApiOperation(value = "Busca todos Correntistas na Base de Dados",  httpMethod = "GET",
            notes = "Busca todos Correntistas na Base de Dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de Correntistas"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @GetMapping
    public List<Correntista> listar() {
        return service.listar();
    }

    @ApiOperation(value = "Pesquisa Correntista pelo código gerado no Banco de Dados",  httpMethod = "GET",
            notes = "Busca Correntista pelo ID Base de Dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Correntista buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @ApiOperation(value = "Insere uma novo Correntista",  httpMethod = "POST",
            notes = "Insere nova Correntista")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retornar SUCESSO após criação"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Correntista salvar(@RequestBody Correntista correntista) {
        return service.create(correntista);
    }

    @ApiOperation(value = "Faz atualização global do Correntista específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após atualização"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Correntista atualizar(@PathVariable Long id, @RequestBody Correntista correntista) {
        Correntista correntistaAtual = service.buscar(id);
        BeanUtils.copyProperties(correntista, correntistaAtual, "id", "enderecos", "contatos");
        return service.update(correntistaAtual);

    }

    @ApiOperation(value = "Exclui Correntista exclisivo por meio do ID passado!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após exclusão"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }

    @ApiOperation(value = "Busca todos os Todos os Endereços relacionados Correntistas na Base de Dadosmeio do ID passado!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após exclusão"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @GetMapping(path = "/{id}/enderecos")
    @ResponseStatus(HttpStatus.OK)
    public List<Endereco> listarEnderecos(@PathVariable Long id) {
        return service.listarEnderecosPorCorrentista(id);
    }

    @ApiOperation(value = "Insere um novo Endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de endereço"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @PostMapping(path = "/{id}/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Endereco> adicionarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        return service.adicionarEndereco(id, endereco);
    }

    @ApiOperation(value = "Exclui Endereço do Correntista exclisivo por meio do ID passado!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após exclusão"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @DeleteMapping("/{id}/enderecos/{enderecoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEndereco(@PathVariable Long id, @PathVariable Long enderecoId) {
        service.excluirEndereco(id, enderecoId );
    }

    @ApiOperation(value = "Busca todos os Todos os Contatos relacionados Correntistas na Base de Dadosmeio do ID passado!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após exclusão"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @GetMapping(path = "/{id}/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<ContatoCliente> listarContatos(@PathVariable Long id) {
        return service.listarContatosPorCorrentista(id);
    }

    @ApiOperation(value = "Insere um novo Contato")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retorna a contato"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @PostMapping(path = "/{id}/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ContatoCliente> adicionarContato(@PathVariable Long id, @RequestBody ContatoCliente contato) {
        return service.adicionarContato(id, contato);
    }

    @ApiOperation(value = "Exclui Contato do Correntista exclisivo por meio do ID passado!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornar SUCESSO após EXCLUSÃO"),
            @ApiResponse(code = 202, message = "Retornar SUCESSO DE RECEBIMENTO, PORÉM A REQUISIÇÃO não pode atuar NO MOMENTO"),
            @ApiResponse(code = 204, message = "Retornar SUCESSO SEM ALTERAR CONTEÚDO"),
            @ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
            @ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
            @ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
    })
    @DeleteMapping("/{id}/contatos/{contatoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerContato(@PathVariable Long id, @PathVariable Long contatoId) {
        service.excluirContato(id, contatoId );
    }
}
