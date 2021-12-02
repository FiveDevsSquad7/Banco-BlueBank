package com.banco.bluebank.controller;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.PeriodoInput;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;
import com.banco.bluebank.model.dto.output.SaldoOutput;
import com.banco.bluebank.service.ContaDisassemblerDTO;
import com.banco.bluebank.service.ContaService;
import com.banco.bluebank.service.MovimentacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
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
	public List<ContaOutputDTO> listar() {
		return mapper.toCollectionModelDTO(contaservice.listar());
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

	@GetMapping(path = "/{id}/saldo/{data}")
	@ResponseStatus(HttpStatus.OK)
	public SaldoOutput saldo(@PathVariable Long id, @PathVariable String data) {
		return contaservice.buscarSaldo(id,OffsetDateTime.parse(data));
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
