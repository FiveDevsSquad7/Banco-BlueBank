package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.correntista.CorrentistaSemCadastroException;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.repository.CorrentistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CorrentistaService {

    private static final String MSG_AGENCIA_EM_USO = " Correntista de id %d não pode ser removida, pois está em uso";
    @Autowired
    private CorrentistaRepository correntistaRepositoryrepository;

    @Transactional(readOnly = false)
    public Correntista salvar(Correntista correntista) {
        correntistaRepositoryrepository.save(correntista);
        return correntista;
    }

    public  List<Correntista> listar() {
        return correntistaRepositoryrepository.findAll();
    }


    @Transactional(readOnly = true)
    public Optional<Correntista> listarPorId(Long id) {

        Optional<Correntista> correntistas = correntistaRepositoryrepository.findById(id);
        correntistas.stream()
                .map(Correntista::getId)
                .collect(Collectors.toList());
        return correntistas;

    }

    public Correntista buscar(Long correntistaId) {
        return correntistaRepositoryrepository.findById(correntistaId)
                .orElseThrow(() -> new CorrentistaSemCadastroException("Não foi possível encontrar correntista com essa identificação!"));
    }

    public void excluir(Long correntistaId) {
        listarPorId(correntistaId);
        //buscar(correntistaId);

        try {
            correntistaRepositoryrepository.deleteById(correntistaId);

        } catch (EmptyResultDataAccessException e) {
            throw new CorrentistaSemCadastroException(" ");

        } catch (DataIntegrityViolationException e) {
            throw new CorrentistaSemCadastroException(
                    String.format(MSG_AGENCIA_EM_USO, correntistaId));
        }
    }

    /*
    @Transactional(readOnly = true)
    public Correntista buscarCorrentistasContatoCliente(Long id) {
        return correntistaRepositoryrepository.findByIdCorrentista(id).orElseThrow(() ->
                new RuntimeException("Não foi possivel em encontrar correntista por essa identificação: "));
    }*/
    /*
    @Transactional(readOnly = false)
    public Correntista atualizarCorrentista(Correntista correntista) {

        Correntista correntistaAtualizar = buscarCorrentistasContatoCliente(correntista.getId());
        correntistaAtualizar.setNome(correntista.getNome());
        correntistaAtualizar.setCpf(correntista.getCpf());
        correntistaAtualizar.setRg(correntista.getRg());
        correntistaAtualizar.setCnpj(correntista.getNome());
        correntistaAtualizar.setTipoPessoa(correntista.getTipoPessoa());
        correntistaAtualizar.setEmailValidacao(correntista.getEmailValidacao());
        correntistaAtualizar.setSms(correntista.getSms());
        correntistaAtualizar.setEnderecos(correntista.getEnderecos());
        correntistaAtualizar.setContatos(correntista.getContatos());

        correntistaRepositoryrepository.save(correntista);

        return correntistaAtualizar;
    }*/

}

