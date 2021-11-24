package com.banco.bluebank.service;

import com.banco.bluebank.exceptions.ContaException;
import com.banco.bluebank.model.*;
import com.banco.bluebank.repository.*;
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
	
//	@Autowired
//	private SaldoRepository saldoRepository;
	
	
	//ok
	public List<Conta> listar() {
		return contaRepository.findAll();
	}
	
	//ok
	public Conta buscar(Long id) {
		return contaRepository.findById(id)
				.orElseThrow( () -> new ContaException(id));
	}
	
	//ok
	public Conta salvar(Conta conta) {
		
		Correntista correntista = correntistaRepository.findById(conta.getCorrentista().getId())
				.orElseThrow( () -> new IllegalArgumentException("Correntista não existe!"));
		
		conta.setIdCorrentista(correntista.getId());
		
		Agencia agencia = agenciaRepository.findById(conta.getAgencia().getId())
				.orElseThrow( () -> new IllegalArgumentException("Agencia não existe!"));
		
		conta.setIdAgencia(agencia.getId());
		
		 conta = contaRepository.save(conta);
		 conta.setCorrentista(correntista);
		 conta.setAgencia(agencia);
		 return conta;

	}
	
	//
	public Conta atualizar(Long id, Conta contaAtual) {
		Conta conta = buscar(id);
		
		Correntista correntista = correntistaRepository.findById(contaAtual.getIdCorrentista())
				.orElseThrow( () -> new IllegalArgumentException("Correntista não existe!"));
		
		Agencia agencia = agenciaRepository.findById(contaAtual.getIdAgencia())
				.orElseThrow( () -> new IllegalArgumentException("Agencia não existe!"));
		
		conta = contaRepository.save(conta);
		conta.setCorrentista(correntista);
		conta.setAgencia(agencia);
		return conta;
		
//		Correntista correntista = correntistaRepository.findById(contaAtual.getId())
//				.orElseThrow( () -> new IllegalArgumentException("Correntista não existe!"));
//		Agencia agencia = agenciaRepository.findById(contaAtual.getId())
//				.orElseThrow( () -> new IllegalArgumentException("Agencia não existe!")); 
//		conta.setNumeroConta(contaAtual.getNumeroConta());
//		conta.setDigito(contaAtual.getNumeroConta());
//		conta.setTipoConta(contaAtual.getTipoConta());
//		conta.setCorrentista(correntista);
//		conta.setAgencia(agencia);
//		return contaRepository.save(conta);
	}
	
	//ok	
	public void excluir(Long id) {
		try {
			//Saldo saldo = saldoRepository.findById(conta.getId)).orElseThrow( () -> new IllegalArgumentException("Conta com saldo!"));
			
			contaRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ContaException(id);
		
		}
	}
  
}
