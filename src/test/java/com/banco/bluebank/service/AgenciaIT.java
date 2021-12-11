package com.banco.bluebank.service;

import static org.assertj.core.api.Assertions.assertThat;
import javax.validation.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.banco.bluebank.exceptionhandler.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.model.Agencia;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class AgenciaIT {

	@Autowired
	private AgenciaService service;
	
	@Test
	public void deveInserirAgenciaComSucesso_QuandoAgenciaCorreta() {
		
		Agencia novAgencia = new Agencia("055-3","Beco Diagonal");
		
		Agencia agencia = service.salvar(novAgencia);
		
		assertThat(agencia).isNotNull();
		assertThat(agencia.getId()).isNotNull();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void deveFalharAoInserirAgencia_QuandoSemNome() {
		
		Agencia novAgencia = new Agencia("055-4",null);
		
		Agencia agencia = service.salvar(novAgencia);
		
		assertThat(agencia).isNotNull();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void deveFalharAoInserirAgencia_QuandoSemAgencia() {
		
		Agencia novAgencia = new Agencia(null ,"3 Vassoura");
		
		Agencia agencia = service.salvar(novAgencia);
		
		assertThat(agencia).isNotNull();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void deveFalharAoInserirAgencia_QuandoNomeVazio() {

		Agencia novAgencia = new Agencia("000-4" ,"");
		
		Agencia agencia = service.salvar(novAgencia);
		
		assertThat(agencia).isNotNull();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void deveFalharAoInserirAgencia_QuandoAgenciaVazio() {

		Agencia novAgencia = new Agencia("" ,"Caldeirão Furado");
		
		Agencia agencia = service.salvar(novAgencia);
		
		assertThat(agencia).isNotNull();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void deveFalharAoInserirAgencia_QuandoNomeMaior40() {
		
		Agencia novAgencia = new Agencia("055-4" ,"Beco Diagonallllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
		
		Agencia agencia = service.salvar(novAgencia);
		
		assertThat(agencia).isNotNull();
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void deveFalharAoInserirAgencia_QuandoAgenciaMaior9() {

		Agencia novAgencia = new Agencia("0123456789" ,"Floreios");
		
		Agencia agencia = service.salvar(novAgencia);
		
		assertThat(agencia).isNotNull();
	}
	
	@Test(expected = AgenciaNaoEncontradaException.class)
	public void devefalharAoBuscarAgencia_QuandoNaoEncontrada() {
		
		service.buscar(99999998L);	
	}
	
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void devefalharAoBuscarAgencia_QuandoNaoInformada() {
		
		service.buscar(null);	
	}
	
	@Test(expected = AgenciaNaoEncontradaException.class)
	public void deveFalharAoExcluirAgencia_QuandoAgenciaNaoExistente() {
		
		   service.excluir(999998L);
		
	}
	
	@Test(expected = EntidadeEmUsoException.class)
	public void deveFalharAoExcluirAgencia_QuandoAgenciaEmUso() {
		
			service.excluir(1L);
	}
	
}
