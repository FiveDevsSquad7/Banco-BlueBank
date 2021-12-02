package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AgenciaService {

    private static final String MSG_AGENCIA_EM_USO
            = "Agência de id %d não pode ser removida, pois está em uso";

    @Autowired
    private AgenciaRepository agenciaRepository;

    public Agencia salvar(Agencia agencia){
        return agenciaRepository.save(agencia);
    }

    public  List<Agencia> listar() {
        return agenciaRepository.findAll();
    }

    public Agencia buscar(Long agenciaId) {
        return agenciaRepository.findById(agenciaId)
                .orElseThrow( () -> new AgenciaNaoEncontradaException(agenciaId));
    }

    @Transactional(readOnly = false)
    public void excluir(Long agenciaId) {
        try {
            agenciaRepository.deleteById(agenciaId);

        } catch (EmptyResultDataAccessException e) {
            throw new AgenciaNaoEncontradaException(agenciaId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_AGENCIA_EM_USO, agenciaId));
        }
    }
}