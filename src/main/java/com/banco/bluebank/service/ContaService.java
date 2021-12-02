package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.ContaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.CorrentistaNaoEncontradoException;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.model.dto.output.SaldoOutput;
import com.banco.bluebank.repository.AgenciaRepository;
import com.banco.bluebank.repository.ContaRepository;
import com.banco.bluebank.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private CorrentistaRepository correntistaRepository;

	@Autowired
	private AgenciaRepository agenciaRepository;

	@Autowired
	private ContaUtils contaUtils;

	public List<Conta> listar() {
		return contaRepository.findAll();
	}

	public SaldoOutput buscarSaldo(Long numeroConta, OffsetDateTime data) {

		Long numeroContaSemDigito = contaUtils.verificaNumeroConta(numeroConta);

		Conta conta = this.buscar(numeroConta);
		return contaRepository.findSaldo(numeroContaSemDigito, data);
	}

	public Conta buscar(Long numeroConta) {

		Long numeroContaSemDigito = contaUtils.verificaNumeroConta(numeroConta);

		return contaRepository.findById(numeroContaSemDigito)
				.orElseThrow( () -> new ContaNaoEncontradaException(numeroContaSemDigito));
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

	public Conta atualizar(Long numeroConta, Conta contaAtual) {

		Conta conta = buscar(numeroConta);

		Correntista correntista = correntistaRepository.findById(contaAtual.getIdCorrentista())
				.orElseThrow( () -> new CorrentistaNaoEncontradoException(contaAtual.getIdCorrentista()));

		Agencia agencia = agenciaRepository.findById(contaAtual.getIdAgencia())
				.orElseThrow( () -> new AgenciaNaoEncontradaException(contaAtual.getIdAgencia()));

		conta = contaRepository.save(conta);
		conta.setCorrentista(correntista);
		conta.setAgencia(agencia);
		return conta;

	}

	public void excluir(Long numeroConta) {
		Long numeroContaSemDigito = contaUtils.verificaNumeroConta(numeroConta);
		try {
			contaRepository.deleteById(numeroContaSemDigito);

		} catch (EmptyResultDataAccessException e) {
			throw new ContaNaoEncontradaException(numeroConta);

		}
	}

}
