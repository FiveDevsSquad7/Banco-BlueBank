package com.banco.bluebank.controller;

import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movimentacao salvar(@RequestBody Movimentacao movimentacao) {
		movimentacao.setNumeroContaCredito(movimentacao.getNumeroContaCredito());
		movimentacao.setNumeroContaDebito(movimentacao.getNumeroContaDebito());
		service.salvar(movimentacao);
		return this.buscar(movimentacao.getId());
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Movimentacao buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}


}