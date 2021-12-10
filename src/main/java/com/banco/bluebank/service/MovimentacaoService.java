package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.*;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.model.dto.output.SaldoOutput;
import com.banco.bluebank.repository.ContaRepository;
import com.banco.bluebank.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MovimentacaoService {

	private static final Integer PRIMEIRA_CONTA_CORRENTISTAS = 3;

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Autowired ContaUtils contaUtils;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Transactional(readOnly = false)
	public Movimentacao salvar(Movimentacao movimentacao) {

		Long contaDebitoSemDigito = contaUtils.verificaNumeroConta(movimentacao.getNumeroContaDebito());
		Long contaCreditoSemDigito = contaUtils.verificaNumeroConta(movimentacao.getNumeroContaCredito());

		Conta contaDebito = contaRepository.findById(contaDebitoSemDigito)
				.orElseThrow(() -> new ContaNaoEncontradaException(contaDebitoSemDigito));

		Conta contaCredito = contaRepository.findById(contaCreditoSemDigito)
				.orElseThrow(() -> new ContaNaoEncontradaException(contaCreditoSemDigito));

		if( contaDebitoSemDigito >= PRIMEIRA_CONTA_CORRENTISTAS) {
			SaldoOutput saldo = contaRepository.findSaldo(contaDebitoSemDigito, OffsetDateTime.now());
			if (saldo.getSaldo().add(movimentacao.getValor()).compareTo(BigDecimal.ZERO) >= 0) {
				throw new SaldoCorrentistaIndisponivelException(contaDebitoSemDigito);
			}
		}

		if( contaCreditoSemDigito < PRIMEIRA_CONTA_CORRENTISTAS &&
				contaDebitoSemDigito >= PRIMEIRA_CONTA_CORRENTISTAS ) {
			SaldoOutput saldo = contaRepository.findSaldo(contaCreditoSemDigito, OffsetDateTime.now());
			if (saldo.getSaldo().subtract(movimentacao.getValor()).compareTo(BigDecimal.ZERO) < 0) {
				throw new SaldoBancoIndisponivelException();
			}
		}

		movimentacao.setContaDebito(contaDebito);
		movimentacao.setContaCredito(contaCredito);
		movimentacao.setNumeroContaDebito(contaDebitoSemDigito);
		movimentacao.setNumeroContaCredito(contaCreditoSemDigito);

		movimentacao = movimentacaoRepository.save(movimentacao);

		eventPublisher.publishEvent(new MovimentacaoRealizadaEvent(movimentacao));

		return movimentacao;

	}

	public Page<Movimentacao> listar(Long numeroConta, String dataInicial, String dataFinal, Pageable pageable) {

		OffsetDateTime dtInicial,dtFinal;

		try {
			dtInicial = OffsetDateTime.parse(dataInicial);
		} catch (DateTimeParseException e) {
			throw new FormatoDataInvalidoException();
		}

		try {
			dtFinal = OffsetDateTime.parse(dataFinal);
		} catch (DateTimeParseException e) {
			throw new FormatoDataInvalidoException();
		}

		Long numeroContaSemDigito = contaUtils.verificaNumeroConta(numeroConta);
		Conta conta = contaRepository.findById(numeroContaSemDigito)
				.orElseThrow( () -> new ContaNaoEncontradaException(numeroContaSemDigito));

		if(dataFinal.compareTo(dataInicial)<0) {
			throw new PeriodoInvalidoException();
		}

		dtFinal = dtFinal.plusDays(1);
		return movimentacaoRepository.findByConta(numeroContaSemDigito, dtInicial, dtFinal, pageable);

	}

	public Movimentacao buscarPorId(Long idMovimentacao) {
		return movimentacaoRepository.findById(idMovimentacao)
				.orElseThrow(() -> new MovimentacaoNaoEncontradaException(idMovimentacao));
	}

}
