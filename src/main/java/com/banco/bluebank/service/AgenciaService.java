package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.exceptionhandler.exceptions.RecursoComBloqueioException;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {

    private static final String MSG_AGENCIA_EM_USO
            = "Agência de id %d não pode ser removida, pois está em uso";
    public static final long AGENCIA_GLOBAL = 1L;

    @Autowired
    private AgenciaRepository agenciaRepository;

    public Agencia salvar(Agencia agencia){
        if(agencia.getId()!=null && agencia.getId()== AGENCIA_GLOBAL)
            throw new RecursoComBloqueioException("Recurso de agência bloqueado para esta operacão por motivo de manter a integridade da regra de negócios");

        return agenciaRepository.save(agencia);
    }

     public Page<Agencia> listar(Pageable pageable) {
        return agenciaRepository.findAll(pageable);
     }

    public Agencia buscar(Long agenciaId) {
        return agenciaRepository.findById(agenciaId)
                .orElseThrow( () -> new AgenciaNaoEncontradaException(agenciaId));
    }

    public void excluir(Long agenciaId) {
        if(agenciaId == AGENCIA_GLOBAL)
            throw new RecursoComBloqueioException("Recurso de agência bloqueado para esta operacão por motivo de manter a integridade da regra de negócios");

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