package com.banco.bluebank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banco.bluebank.exceptions.ContaEmUsoException;
import com.banco.bluebank.exceptions.ContaNaoEncontradaException;
import com.banco.bluebank.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.exceptions.EntidadeNaoEncontradaException;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.repository.ContaRepository;

@Service
public class ContaService 
{

	@Autowired
	private ContaRepository contaRepository;

	public List<Conta> buscarTodos() {
		return contaRepository.findAll();
	}

	public Conta buscarId(Long id) throws EntidadeNaoEncontradaException, EntidadeEmUsoException {
		try {
			return contaRepository.findById(id).get();
		} catch (EmptyResultDataAccessException e) {
			throw new ContaNaoEncontradaException(id);
		}
	}

	public Conta salvar(Conta contaInput) {
		return contaRepository.save(contaInput);
	}

	public Conta buscarPorIdParaAtualizar(Long id) throws EntidadeNaoEncontradaException {

		
		try {
    		Conta optionalConta = contaRepository.findById(id).get();
    		return optionalConta;
    	}catch (EmptyResultDataAccessException e) {
			throw new ContaNaoEncontradaException(id);
    	}
    }

	@Transactional
	public void excluir(Long id) throws EntidadeNaoEncontradaException, EntidadeEmUsoException {
		try {
			contaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ContaNaoEncontradaException(id);

		} catch (DataIntegrityViolationException e) {
			String MSG_AGENCIA_EM_USO = "Conta de id %d não pode ser removida, pois está em uso";
			String.format(MSG_AGENCIA_EM_USO, id);

			throw new ContaEmUsoException(String.format(MSG_AGENCIA_EM_USO, id));
		}
	}
}
