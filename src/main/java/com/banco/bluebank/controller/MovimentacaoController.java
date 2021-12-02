package com.banco.bluebank.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping(path = "/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;

	@ApiOperation(value = "Cria uma nova Movimentacao")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retornar SUCESSO após criação"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movimentacao salvar(@RequestBody Movimentacao movimentacao) {
		movimentacao.setNumeroContaCredito(movimentacao.getNumeroContaCredito());
		movimentacao.setNumeroContaDebito(movimentacao.getNumeroContaDebito());
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
  
  @GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Movimentacao buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

}