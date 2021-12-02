package com.banco.bluebank.controller;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;
import com.banco.bluebank.model.dto.output.SaldoOutput;
import com.banco.bluebank.service.ContaDisassemblerDTO;
import com.banco.bluebank.service.ContaService;
import com.banco.bluebank.service.MovimentacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

	@ApiOperation(value = "Busca todas as Contas na Base de Dados",  httpMethod = "GET",
			notes = "Busca todas as Contas na Base de Dados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de Contas"),
			@ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
			@ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
			@ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
			@ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
	})
	@GetMapping
	public List<ContaOutputDTO> listar() {
		return mapper.toCollectionModelDTO(contaservice.listar());
	}

	@ApiOperation(value = "Pesquisa Contas pelo código gerado no Banco de Dados",  httpMethod = "GET",
			notes = "Busca Conta pelo ID Base de Dados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de contas"),
			@ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
			@ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
			@ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
			@ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
	})
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ContaOutputDTO buscar(@PathVariable Long id) {
		Conta conta = contaservice.buscar(id);
		return mapper.toModelDTO(conta);
	}

	@ApiOperation(value = "Insere uma nova Conta",  httpMethod = "POST",
			notes = "Insere nova Conta")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retornar SUCESSO após criação"),
			@ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
			@ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
			@ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
			@ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContaOutputDTO salvar(@RequestBody Conta conta) {
		Conta novaConta = contaservice.salvar(conta);
		return mapper.toModelDTO(novaConta);
	}

  @ApiOperation(value = "Busca o saldo de uma conta ao final de um determinado dia")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o saldo"),
			@ApiResponse(code = 401, message = "Você não tem permissão para acessar, desde que não esteja logado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
  
	@GetMapping(path = "/{id}/saldo/{data}")
	@ResponseStatus(HttpStatus.OK)
	public SaldoOutput saldo(@PathVariable Long id, @PathVariable String data) {
		return contaservice.buscarSaldo(id,OffsetDateTime.parse(data));
	}
  

	@ApiOperation(value = "Busca todas as transações efetuadas e retorna o extrato",  httpMethod = "GET",
		notes = "Busca todas as transações efetuadas e retorna o extrato")	
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o extrato da conta"),
			@ApiResponse(code = 401, message = "Você não tem AUTORIZAÇÃO para acessar, desde que não esteja logado"),
			@ApiResponse(code = 403, message = "Você não tem AUTENTICAÇAO para acessar este recurso"),
			@ApiResponse(code = 404, message = "O servidor não conseguiu encontrar o URL solicitado"),
			@ApiResponse(code = 500, message = "Ocorreu um erro interno do servidor" ),
	})
	@GetMapping(path = "/{id}/extrato/{dataInicial}/{dataFinal}")
	@ResponseStatus(HttpStatus.OK)
	public List<Movimentacao> extrato(@PathVariable Long id,
									  @PathVariable String dataInicial,
									  @PathVariable String dataFinal) {
		return serviceMovimentacao.listar(id,OffsetDateTime.parse(dataInicial),OffsetDateTime.parse(dataFinal));
	}

	@ApiOperation(value = "Faz atualização global das Contas pelo específico ID",  httpMethod = "PUT",
			notes = "Atualiza Conta via ID")
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
	public ContaOutputDTO atualizar (@PathVariable Long id, @RequestBody Conta conta){
		Conta contaAtual = contaservice.buscar(id);
		BeanUtils.copyProperties(conta, contaAtual, "numeroConta", "dataCadastro");
		Conta contaModificada = contaservice.salvar(contaAtual);
		return mapper.toModelDTO(contaModificada);
	}

	@ApiOperation(value = "Exclui Conta exclisivo por meio do ID passado!",  httpMethod = "DELETE",
			notes = "Exclui Conta via ID")
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
	public void remover (@PathVariable Long id) {
		contaservice.excluir(id);
	}

}
