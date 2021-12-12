package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.*;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.model.dto.output.SaldoOutput;
import com.banco.bluebank.repository.AgenciaRepository;
import com.banco.bluebank.repository.ContaRepository;
import com.banco.bluebank.repository.CorrentistaRepository;
import com.banco.bluebank.security.SysSecurity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;

import static com.banco.bluebank.service.CorrentistaService.CORRENTISTA_BLUEBANK;

@Service
public class ContaService {

    private static final String MSG_CONTA_EM_USO
            = "Conta de número %d não pode ser removida, pois está em uso";

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private AgenciaRepository agenciaRepository;


    public Page<Conta> listar(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

    @Autowired
    private ContaUtils contaUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SaldoOutput buscarSaldo(Long numeroConta, String data) {

        if(numeroConta==null) throw new DadoRequeridoException("O número da conta é requerido");

        OffsetDateTime dt;

        try {
            dt = OffsetDateTime.parse(data);
        } catch (DateTimeParseException e) {
            throw new FormatoDataInvalidoException();
        }

        Long numeroContaSemDigito = contaUtils.verificaNumeroConta(numeroConta);

        Conta conta = this.buscar(numeroConta);
        return contaRepository.findSaldo(numeroContaSemDigito, dt);
    }

    public Conta buscar(Long numeroConta) {

        if(numeroConta==null) throw new DadoRequeridoException("O número da conta é requerido");

        Long numeroContaSemDigito = contaUtils.verificaNumeroConta(numeroConta);

        return contaRepository.findById(numeroContaSemDigito)
                .orElseThrow(() -> new ContaNaoEncontradaException(numeroContaSemDigito));
    }

    @Transactional(readOnly = false)
    public Conta salvar(Conta conta) {

        Conta finalConta = conta;
        Correntista correntista = correntistaRepository.findById(conta.getCorrentista().getId())
                .orElseThrow(() -> new CorrentistaNaoEncontradoException(finalConta.getCorrentista().getId()));

        if(correntista.getId() == CORRENTISTA_BLUEBANK) {
            throw new RecursoComBloqueioException("Id de correntista bloqueado para esta operacão por motivo de manter a integridade da regra de negócios");
        }

        conta.setIdCorrentista(correntista.getId());

        Conta finalConta1 = conta;
        Agencia agencia = agenciaRepository.findById(conta.getAgencia().getId())
                .orElseThrow(() -> new AgenciaNaoEncontradaException(finalConta1.getAgencia().getId()));

        conta.setIdAgencia(agencia.getId());

        conta.setSenha(passwordEncoder.encode(conta.getSenha()));

        conta = contaRepository.save(conta);
        conta.setCorrentista(correntista);
        conta.setAgencia(agencia);

        return conta;

    }

    @Transactional(readOnly = false)
    public Conta atualizar(Long numeroConta, Conta conta) {

        Conta contaAtual = buscar(numeroConta);
        Long idCorrentistaArmazenado = contaAtual.getCorrentista().getId();

        BeanUtils.copyProperties(conta, contaAtual, "numeroConta", "dataCadastro");

        contaAtual.setIdCorrentista(contaAtual.getCorrentista().getId());
        contaAtual.setIdAgencia(contaAtual.getAgencia().getId());

        Correntista correntista = correntistaRepository.findById(contaAtual.getIdCorrentista())
                .orElseThrow(() -> new CorrentistaNaoEncontradoException(contaAtual.getIdCorrentista()));

        if(correntista.getId() == CORRENTISTA_BLUEBANK || idCorrentistaArmazenado == CORRENTISTA_BLUEBANK) {
            throw new RecursoComBloqueioException("Recurso de conta bloqueado para esta operacão por motivo de manter a integridade da regra de negócios");
        }

        Agencia agencia = agenciaRepository.findById(contaAtual.getIdAgencia())
                .orElseThrow(() -> new AgenciaNaoEncontradaException(contaAtual.getIdAgencia()));

        conta.setSenha(passwordEncoder.encode(conta.getSenha()));

        conta = contaRepository.save(contaAtual);
        conta.setCorrentista(correntista);
        conta.setAgencia(agencia);
        return conta;

    }

    public void excluir(Long numeroConta) {
        if(numeroConta==null) throw new DadoRequeridoException("O número da conta é requerido");

        Conta conta = buscar(numeroConta);

        Correntista correntista = correntistaRepository.findById(conta.getIdCorrentista())
                .orElseThrow(() -> new CorrentistaNaoEncontradoException(conta.getIdCorrentista()));

        if(correntista.getId() == CORRENTISTA_BLUEBANK) {
            throw new RecursoComBloqueioException("Recurso de conta bloqueado para esta operacão por motivo de manter a integridade da regra de negócios");
        }

        Long numeroContaSemDigito = contaUtils.verificaNumeroConta(numeroConta);

        try {
            contaRepository.deleteById(numeroContaSemDigito);

        } catch (EmptyResultDataAccessException e) {
            throw new ContaNaoEncontradaException(numeroConta);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_CONTA_EM_USO, numeroConta));
        }

    }

}
