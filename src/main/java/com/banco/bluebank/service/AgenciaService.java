package com.banco.bluebank.service;

import com.banco.bluebank.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptions.EntidadeNaoEncontradaException;
import com.banco.bluebank.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import com.banco.bluebank.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgenciaService 
{


	@Autowired
	private AgenciaRepository agenciaRepository;

	public Agencia salvar(Agencia agencia) {
		return agenciaRepository.save(agencia);
	}

	public List<Agencia> listar() {
		return agenciaRepository.findAll();
	}

	public Agencia buscar(Long agenciaId) throws EntidadeNaoEncontradaException {
		try {
			return agenciaRepository.findById(agenciaId).get();
		} catch (EmptyResultDataAccessException e) {
			throw new AgenciaNaoEncontradaException(agenciaId);
		}

	}

	public void excluir(Long agenciaId ) throws EntidadeNaoEncontradaException, EntidadeEmUsoException {
		try {
			agenciaRepository.deleteById(agenciaId);

		} catch (EmptyResultDataAccessException e) {
			throw new AgenciaNaoEncontradaException(agenciaId);

		} catch (DataIntegrityViolationException e) {
			String MSG_AGENCIA_EM_USO = "Agência de id %d não pode ser removida, pois está em uso";
            String.format(MSG_AGENCIA_EM_USO, agenciaId);
			throw new EntidadeEmUsoException(String.format(MSG_AGENCIA_EM_USO, agenciaId));
		}
	}
}