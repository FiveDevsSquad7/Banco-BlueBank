package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.ContaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.CorrentistaNaoEncontradoException;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.repository.AgenciaRepository;
import com.banco.bluebank.repository.ContaRepository;
import com.banco.bluebank.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private CorrentistaRepository correntistaRepository;

	@Autowired
	private AgenciaRepository agenciaRepository;

	public List<Conta> listar() {
		return contaRepository.findAll();
	}

	public Conta buscar(Long id) {
		return contaRepository.findById(id)
				.orElseThrow( () -> new ContaNaoEncontradaException(id));
	}

	public Conta salvar(Conta conta) {

		Conta finalConta = conta;
		Correntista correntista = correntistaRepository.findById(conta.getCorrentista().getId())
				.orElseThrow( () -> new CorrentistaNaoEncontradoException(finalConta.getCorrentista().getId()));

		conta.setIdCorrentista(correntista.getId());

		Conta finalConta1 = conta;
		Agencia agencia = agenciaRepository.findById(conta.getAgencia().getId())
				.orElseThrow( () -> new AgenciaNaoEncontradaException(finalConta1.getAgencia().getId()));

		conta.setIdAgencia(agencia.getId());

		conta = contaRepository.save(conta);
		conta.setCorrentista(correntista);
		conta.setAgencia(agencia);
		return conta;

	}

	public Conta atualizar(Long id, Conta contaAtual) {
		Conta conta = buscar(id);

		Correntista correntista = correntistaRepository.findById(contaAtual.getIdCorrentista())
				.orElseThrow( () -> new CorrentistaNaoEncontradoException(contaAtual.getIdCorrentista()));

		Agencia agencia = agenciaRepository.findById(contaAtual.getIdAgencia())
				.orElseThrow( () -> new AgenciaNaoEncontradaException(contaAtual.getIdAgencia()));

		conta = contaRepository.save(conta);
		conta.setCorrentista(correntista);
		conta.setAgencia(agencia);
		return conta;

	}

	public void excluir(Long id) {
		try {
			contaRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ContaNaoEncontradaException(id);

		}
	}

}
