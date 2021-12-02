package com.banco.bluebank.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.service.MovimentacaoService;

import java.util.List;

@RestController
@RequestMapping(path = "/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;

	@ApiOperation(value = "Cria uma nova Movimentacao")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retornar SUCESSO após criação"),
			@ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
			@ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
			@ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
			@ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movimentacao salvar(@RequestBody Movimentacao movimentacao) {
		movimentacao.setNumeroContaCredito(movimentacao.getNumeroContaCredito());
		movimentacao.setNumeroContaDebito(movimentacao.getNumeroContaDebito());
		service.salvar(movimentacao);
		return this.buscar(movimentacao.getId());
	}

	@ApiOperation(value = "Pesquisa Movimentacao pelo numero da conta")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de movimentacoes"),
			@ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
			@ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
			@ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
			@ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
	})
	@GetMapping(path = "/{numeroConta}")
	@ResponseStatus(HttpStatus.OK)
	public List<Movimentacao> listar(@PathVariable Long numeroConta) {
		return service.listar(numeroConta);
	}


	@ResponseStatus(HttpStatus.OK)
	public Movimentacao buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}


	@ApiOperation(value = "Faz atualização global das movimentacoes específico pelo ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retornar SUCESSO após atualização"),
			@ApiResponse(code = 201, message = "Retornar SUCESSO após criação"),
			@ApiResponse(code = 204, message = "Retornar SUCESSO SEM ALTERAR CONTEÚDO"),
			@ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
			@ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
			@ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
			@ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
	})
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Movimentacao atualizar(@PathVariable Long id, @RequestBody Movimentacao movimentacao) {
		Movimentacao MovimentacaoAtual = service.buscarPorId(id);
		BeanUtils.copyProperties(movimentacao, MovimentacaoAtual, "id");
		return service.salvar(MovimentacaoAtual);
	}

	@ApiOperation(value = "Exclui Movimentacao exclisivo por meio do ID passado!")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retornar SUCESSO após EXCLUSÃO"),
			@ApiResponse(code = 202, message = "Retornar SUCESSO DE RECEBIMENTO, PORÉM A REQUISIÇÃO não pode atuar NO MOMENTO"),
			@ApiResponse(code = 204, message = "Retornar SUCESSO SEM ALTERAR CONTEÚDO"),
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
}