package com.banco.bluebank.controller;

import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.dto.input.ContaInputDTO;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;
import com.banco.bluebank.service.ContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaservice;

    @GetMapping
	public List<ContaOutputDTO> listar() {
		return contaservice.buscarTodos();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ContaOutputDTO buscar(@PathVariable Long id) {
		return contaservice.buscarId(id);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContaOutputDTO salvar(@RequestBody ContaInputDTO contaInputDTOconta) {
		return contaservice.salvar(contaInputDTOconta);
	}
	/*
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Conta atualizar (@PathVariable Long id, @RequestBody Conta conta){
		Conta contaAtual = contaservice.buscar(id);
		BeanUtils.copyProperties(conta, contaAtual, "id");
		return contaservice.salvar(contaAtual);
	}*/

	@PutMapping("/{id}")
	public ResponseEntity<ContaOutputDTO> atualizar(@RequestBody ContaInputDTO contaInputDTO,
													  @PathVariable Long id) {
		Optional<Conta> contaOptional = contaservice.buscarPorId(id);
		if(contaOptional.isPresent()){
			return ResponseEntity.ok(contaservice.atualizar(contaOptional.get(), contaInputDTO));
		}
		return ResponseEntity.notFound().build();
	}

	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long id) {
		contaservice.excluir(id);
	}

}
