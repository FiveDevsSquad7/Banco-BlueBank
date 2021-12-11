package com.banco.bluebank.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.OffsetDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.banco.bluebank.exceptionhandler.exceptions.AgenciaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.ContaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.CorrentistaNaoEncontradoException;
import com.banco.bluebank.exceptionhandler.exceptions.DigitoVerificadorInvalidoException;
import com.banco.bluebank.exceptionhandler.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.repository.ContaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class ContaIT {

	@Autowired
	private ContaService service;
	
	@Autowired
	private ContaRepository contaRepository;
	

	@Test
	public void deveSalvarConta_QuandoContaCorreta() {
		
		OffsetDateTime data = OffsetDateTime.now();
		Agencia agencia = new Agencia("055-3","Beco Diagonal");
		Correntista correntista = new Correntista("Harry Thiago","45899657566","145897586", null,"F","HT@teste.com","999999999");
			
		Conta conta = new Conta();
		conta.setTipoConta("CC");
		conta.setIdCorrentista(correntista.getId());
		conta.setIdAgencia(agencia.getId());
		conta.setDataCadastro(data);
		conta = contaRepository.save(conta);
		conta.setCorrentista(correntista);
		conta.setAgencia(agencia);
		
		
		assertThat(conta).isNotNull();
	}
	
		
	@Test	
	public void deveAtualizarContaPorId_QuandoContaCorreta() {
		Conta contaatual = new Conta(9,"CC",null,null,5L,1L,1);
		Conta conta = service.atualizar(91L, contaatual);
		
		assertThat(conta).isNotNull();
	}
	
	@Test(expected = ContaNaoEncontradaException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoContaIncorreta() {
		Conta contaatual = new Conta(9,"CC",null,null,5L,1L,1);
		Conta conta = service.atualizar(9999996L, contaatual);
		
		assertThat(conta).isNotNull();
	}
	
	
	@Test(expected = NullPointerException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoContaNull() {
		Conta contaatual = new Conta(9,"CC",null,null,5L,1L,1);
		Conta conta = service.atualizar(null, contaatual);
		
		assertThat(conta).isNotNull();
	}
	
	@Test(expected = CorrentistaNaoEncontradoException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoCorrentistaIncorreto() {
		Conta contaatual = new Conta(9,"CC",null,null,99999999998L,1L,1);
		Conta conta = service.atualizar(91L, contaatual);
		
		assertThat(conta).isNotNull();
	}
	

	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoCorrentistaNull() {
		Conta contaatual = new Conta(9,"CC",null,null,null,1L,1);
		Conta conta = service.atualizar(91L, contaatual);
		
		assertThat(conta).isNotNull();
	}
	
	@Test(expected = AgenciaNaoEncontradaException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoAgenciaIncorreto() {
		Conta contaatual = new Conta(9,"CC",null,null,5L,99999999998L,1);
		Conta conta = service.atualizar(91L, contaatual);
		
		assertThat(conta).isNotNull();
	}
	
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoAgenciaNull() {
		Conta contaatual = new Conta(9,"CC",null,null,5L,null,1);
		Conta conta = service.atualizar(91L, contaatual);
		
		assertThat(conta).isNotNull();
	}
	
	
	@Test(expected = DigitoVerificadorInvalidoException.class)
	public void deveExcluirContaBuscandoPorId__QuandoContaComDigitoInvalido() {
		service.excluir(9999998L);
	}
	
	@Test(expected = ContaNaoEncontradaException.class)
	public void deveExcluirContaBuscandoPorId__QuandoContaNaoEncontrada() {
		service.excluir(9999996L);
	}
	
	@Test(expected = EntidadeEmUsoException.class)
	public void deveExcluirContaBuscandoPorId__QuandoContaEmUso() {
		service.excluir(18L);
	}

	

	@Test(expected = NullPointerException.class)
	public void deveExcluirContaBuscandoPorId__QuandoContaForNull() {
		service.excluir(null);
	}

	
}
