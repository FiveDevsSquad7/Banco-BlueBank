package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.ContaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.CorrentistaNaoEncontradoException;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.model.dto.input.ContaInputDTO;
import com.banco.bluebank.model.dto.output.ContaOutputDTO;
import com.banco.bluebank.repository.AgenciaRepository;
import com.banco.bluebank.repository.ContaRepository;
import com.banco.bluebank.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

	@Autowired
    private ContaRepository contaRepository;

	@Autowired
	private CorrentistaRepository correntistaRepository;

	@Autowired
	private AgenciaRepository agenciaRepository;

	@Autowired
	private ContaMapper contaMapper;


	public ContaService() {
	}

	public List<ContaOutputDTO> buscarTodos() {
		return contaRepository.findAll()
				.stream()
				.map(conta -> contaMapper.converterModelParaOutputDTO(conta))
				.collect(Collectors.toList());
	}

	/*public List<Conta> listar() {
		return contaRepository.findAll();
	}*/

	public ContaOutputDTO buscarId(Long id) {
		Optional<Conta> conta = contaRepository.findById(id);
		return contaMapper.converterModelParaOutputDTO(conta.get());
	}
	
	public Conta buscar(Long id) {
		return contaRepository.findById(id)
				.orElseThrow(() -> new ContaNaoEncontradaException(id));
	}

	public Optional<Conta> buscarPorId(Long id) {
		return contaRepository.findById(id);
	}

	@Transactional
	public ContaOutputDTO salvar(ContaInputDTO contaInputDTO) {

		Long idCorrentista = contaInputDTO.getIdCorrentista();
		Long idAgencia = 	 contaInputDTO.getIdAgencia();
		Conta conta1 = contaMapper.converterInputDTOParaModel(contaInputDTO);
		Correntista correntista = correntistaRepository.findById(contaInputDTO.getIdCorrentista())
				.orElseThrow(() -> new CorrentistaNaoEncontradoException("ERRO"+idCorrentista));

		Agencia agencia = agenciaRepository.findById(contaInputDTO.getIdAgencia())
				.orElseThrow(() -> new AgenciaNaoEncontradaException("ERRO"+idAgencia));

		Conta conta = contaRepository.save(conta1);
		conta.setCorrentista(correntista);
		conta.setAgencia(agencia);
		return contaMapper.converterModelParaOutputDTO(conta);

	}

	@Transactional()
	public ContaOutputDTO atualizar(Conta conta, ContaInputDTO contaInputDTO) {

		Long idCorrentista = contaInputDTO.getIdCorrentista();
		Long idAgencia = 	 contaInputDTO.getIdAgencia();
		Correntista correntista = correntistaRepository.findById(contaInputDTO.getIdCorrentista())
				.orElseThrow(() -> new CorrentistaNaoEncontradoException("ERRO"+idCorrentista));

		Agencia agencia = agenciaRepository.findById(contaInputDTO.getIdAgencia())
				.orElseThrow(() -> new AgenciaNaoEncontradaException("ERRO"+idAgencia));

		Conta conta1 = contaRepository.save(conta);
		conta.setCorrentista(correntista);
		conta.setAgencia(agencia);
		return contaMapper.converterModelParaOutputDTO(conta1);
	}


/*
	public Conta atualizar(Long id, Conta contaAtual) {
		Conta conta = buscar(id);
		
		Correntista correntista = correntistaRepository.findById(contaAtual.getIdCorrentista())
				.orElseThrow(() -> new CorrentistaNaoEncontradoException(contaAtual.getIdCorrentista()));
		
		Agencia agencia = agenciaRepository.findById(contaAtual.getIdAgencia())
				.orElseThrow(() -> new AgenciaNaoEncontradaException(contaAtual.getIdAgencia()));
		
		conta = contaRepository.save(conta);
		conta.setCorrentista(correntista);
		conta.setAgencia(agencia);
		return conta;
	}*/
	
	public void excluir(Long id) {
		try {
			contaRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ContaNaoEncontradaException(id);
		
		}
	}
}
