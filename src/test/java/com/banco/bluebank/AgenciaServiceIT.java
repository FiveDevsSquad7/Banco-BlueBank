package com.banco.bluebank;

import com.banco.bluebank.exceptionhandler.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.service.AgenciaService;
import com.banco.bluebank.service.ContaService;
import com.banco.bluebank.service.CorrentistaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AgenciaServiceIT {

	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private ContaService contaService;

	@Autowired
	private CorrentistaService correntistaService;

	@Test
	void deveInserirAgenciaComSucesso_QuandoAgenciaCorreta() {
		Agencia novaAgencia = new Agencia();
		novaAgencia.setAgencia("055-3");
		novaAgencia.setNome("Cassiopéia");

		novaAgencia = agenciaService.salvar(novaAgencia);

		Assertions.assertNotNull(novaAgencia);
		Assertions.assertNotNull(novaAgencia.getId());

	}

	@Test
	void deveFalharAoInserirAgencia_QuandoSemNome() {

		Agencia novaAgencia = new Agencia();
		novaAgencia.setAgencia("055-3");
		novaAgencia.setNome(null);

		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					agenciaService.salvar(novaAgencia);
				});

		Assertions.assertNotNull(erroEsperado);

	}

	@Test
	void deveFalharAoInserirAgencia_QuandoSemAgencia() {

		Agencia novaAgencia = new Agencia();
		novaAgencia.setAgencia(null);
		novaAgencia.setNome("Cassiopéia");

		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					agenciaService.salvar(novaAgencia);
				});

		Assertions.assertNotNull(erroEsperado);

	}

	@Test
	void deveFalharAoInserirAgencia_QuandoNomeVazio() {

		Agencia novaAgencia = new Agencia();
		novaAgencia.setAgencia("055-3");
		novaAgencia.setNome("");

		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					agenciaService.salvar(novaAgencia);
				});

		Assertions.assertNotNull(erroEsperado);

	}

	@Test
	void deveFalharAoInserirAgencia_QuandoAgenciaVazio() {

		Agencia novaAgencia = new Agencia();
		novaAgencia.setAgencia("");
		novaAgencia.setNome("Cassiopéia");

		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					agenciaService.salvar(novaAgencia);
				});

		Assertions.assertNotNull(erroEsperado);

	}

	@Test
	void deveFalharAoInserirAgencia_QuandoNomeMaior40() {

		Agencia novaAgencia = new Agencia();
		novaAgencia.setAgencia("055-3");
		novaAgencia.setNome("01234567890123456789012345678901234567899");

		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					agenciaService.salvar(novaAgencia);
				});

		Assertions.assertNotNull(erroEsperado);

	}

	@Test
	void deveFalharAoInserirAgencia_QuandoAgenciaMaior9() {

		Agencia novaAgencia = new Agencia();
		novaAgencia.setAgencia("0123456789");
		novaAgencia.setNome("Cassiopéia");

		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					agenciaService.salvar(novaAgencia);
				});

		Assertions.assertNotNull(erroEsperado);

	}

	@Test
	void deveFalharAoExcluirAgencia_QuandoAgenciaEmUso() {

		Agencia novaAgencia = new Agencia();
		novaAgencia.setAgencia("0123-6");
		novaAgencia.setNome("Cassiopéia");
		novaAgencia = agenciaService.salvar(novaAgencia);

		Conta novaConta = new Conta();
		novaConta.setTipoConta("CC");
		novaConta.setCorrentista(correntistaService.buscar(1L));
		novaConta.setIdCorrentista(novaConta.getCorrentista().getId());
		novaConta.setAgencia(agenciaService.buscar(novaAgencia.getId()));
		novaConta.setIdAgencia(novaConta.getAgencia().getId());

		contaService.salvar(novaConta);

		Agencia finalNovaAgencia = novaAgencia;

		EntidadeEmUsoException erroEsperado =
				Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
					agenciaService.excluir(finalNovaAgencia.getId());
				});

		Assertions.assertNotNull(erroEsperado);

	}

	@Test
	void deveFalharAoExcluirAgencia_QuandoAgenciaNaoExistente() {

		AgenciaNaoEncontradaException erroEsperado =
				Assertions.assertThrows(AgenciaNaoEncontradaException.class, () -> {
					agenciaService.excluir(999998L);
				});

		Assertions.assertNotNull(erroEsperado);

	}

}
