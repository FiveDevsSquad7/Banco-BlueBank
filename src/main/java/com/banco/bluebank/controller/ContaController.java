package com.banco.bluebank.controller;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;
import com.banco.bluebank.service.ContaDisassemblerDTO;
import com.banco.bluebank.service.ContaService;
import com.banco.bluebank.service.MovimentacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaservice;

	@Autowired
	private ContaDisassemblerDTO mapper;

	@Autowired
	private MovimentacaoService serviceMovimentacao;

	@GetMapping
	public Page<ContaOutputDTO> listar(Pageable pageable) {
		return mapper.toCollectionModelDTO(contaservice.listar(pageable));
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ContaOutputDTO buscar(@PathVariable Long id) {
		Conta conta = contaservice.buscar(id);
		return mapper.toModelDTO(conta);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContaOutputDTO salvar(@RequestBody Conta conta) {
		Conta novaConta = contaservice.salvar(conta);
		return mapper.toModelDTO(novaConta);
	}

	@GetMapping(path = "/{id}/extrato")
	@ResponseStatus(HttpStatus.OK)
	public List<Movimentacao> extrato(@PathVariable Long id) {
		return serviceMovimentacao.listar(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ContaOutputDTO atualizar (@PathVariable Long id, @RequestBody Conta conta){
		Conta contaAtual = contaservice.buscar(id);
		BeanUtils.copyProperties(conta, contaAtual, "numeroConta");
		Conta contaModificada = contaservice.salvar(contaAtual);
		return mapper.toModelDTO(contaModificada);
	}


	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long id) {
		contaservice.excluir(id);
	}

}
