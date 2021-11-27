package com.banco.bluebank.controller;

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

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movimentacao salvar(@RequestBody Movimentacao movimentacao) {
		movimentacao.setNumeroContaCredito(movimentacao.getNumeroContaCredito());
		movimentacao.setNumeroContaDebito(movimentacao.getNumeroContaDebito());
		service.salvar(movimentacao);
		return this.buscar(movimentacao.getId());
	}

	@GetMapping(path = "/{numeroConta}")
	@ResponseStatus(HttpStatus.OK)
	public List<Movimentacao> listar(@PathVariable Long numeroConta) {
		return service.listar(numeroConta);
	}

	// @GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Movimentacao buscar(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Movimentacao atualizar(@PathVariable Long id, @RequestBody Movimentacao movimentacao) {
		Movimentacao MovimentacaoAtual = service.buscarPorId(id);
		BeanUtils.copyProperties(movimentacao, MovimentacaoAtual, "id");
		return service.salvar(MovimentacaoAtual);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		service.excluir(id);
	}
}