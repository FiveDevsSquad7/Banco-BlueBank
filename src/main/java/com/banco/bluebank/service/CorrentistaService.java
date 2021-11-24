package com.banco.bluebank.service;

import com.banco.bluebank.exceptions.ContatoNaoEncontradoException;
import com.banco.bluebank.exceptions.CorrentistaNaoEncontradoException;
import com.banco.bluebank.exceptions.EnderecoNaoEncontradoException;
import com.banco.bluebank.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.model.ContatoCliente;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.model.Endereco;
import com.banco.bluebank.repository.ContatoClienteRepository;
import com.banco.bluebank.repository.CorrentistaRepository;
import com.banco.bluebank.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CorrentistaService {

    private static final String MSG_CORRENTISTA_EM_USO = "Correntista de id %d não pode ser removido, pois está em uso";

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContatoClienteRepository contatoClienteRepository;

    @Transactional(readOnly = false)
    public Correntista create(Correntista correntista) {

        Correntista novoCorrentista = correntistaRepository.save(correntista);

        List<Endereco> enderecos = correntista.getEnderecos();
        for(Endereco endereco: enderecos) {
            endereco.setIdCorrentista(novoCorrentista.getId());
            endereco = enderecoRepository.save(endereco);
        }

        List<ContatoCliente> contatos = correntista.getContatos();
        for(ContatoCliente contato: contatos) {
            contato.setIdCorrentista(novoCorrentista.getId());
            contato = contatoClienteRepository.save(contato);
        }

        return correntista;
    }

    @Transactional(readOnly = false)
    public Correntista update(Correntista correntista) {

        return correntistaRepository.save(correntista);

    }

    public  List<Correntista> listar() {
        return correntistaRepository.findAll();
    }


    public Correntista buscar(Long correntistaId) {
        return correntistaRepository.findById(correntistaId)
                .orElseThrow( () -> new CorrentistaNaoEncontradoException(correntistaId));
    }

    public void excluir(Long correntistaId) {

        buscar(correntistaId);

        try {
            correntistaRepository.deleteById(correntistaId);

        } catch (EmptyResultDataAccessException e) {
            throw new CorrentistaNaoEncontradoException(correntistaId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_CORRENTISTA_EM_USO, correntistaId));
        }
    }

    public List<Endereco> listarEnderecosPorCorrentista(Long correntistaId) {
        Correntista correntista = this.buscar(correntistaId);
        return correntista.getEnderecos();
    }

    public List<ContatoCliente> listarContatosPorCorrentista(Long correntistaId) {
        Correntista correntista = this.buscar(correntistaId);
        return correntista.getContatos();
    }

    @Transactional(readOnly = false)
    public List<Endereco> adicionarEndereco(Long correntistaId, Endereco endereco) {

        Correntista correntista = this.buscar(correntistaId);

        endereco.setIdCorrentista(correntistaId);
        endereco = enderecoRepository.save(endereco);

        return listarEnderecosPorCorrentista(correntistaId);

    }

    @Transactional(readOnly = false)
    public List<ContatoCliente> adicionarContato(Long correntistaId, ContatoCliente contato) {

        Correntista correntista = this.buscar(correntistaId);

        contato.setIdCorrentista(correntistaId);
        contato = contatoClienteRepository.save(contato);

        return listarContatosPorCorrentista(correntistaId);

    }

    public void excluirEndereco(Long correntistaId, Long enderecoId) {

        buscar(correntistaId);

        try {
            enderecoRepository.deleteById(enderecoId);

        } catch (EmptyResultDataAccessException e) {
            throw new EnderecoNaoEncontradoException(enderecoId);
        }

    }

    public void excluirContato(Long correntistaId, Long contatoId) {

        buscar(correntistaId);

        try {
            contatoClienteRepository.deleteById(contatoId);

        } catch (EmptyResultDataAccessException e) {
            throw new ContatoNaoEncontradoException(contatoId);
        }
    }
}

