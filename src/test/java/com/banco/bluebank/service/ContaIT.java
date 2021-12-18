package com.banco.bluebank.service;

import com.banco.bluebank.exceptionhandler.exceptions.*;
import com.banco.bluebank.model.Agencia;
import com.banco.bluebank.model.Conta;
import com.banco.bluebank.model.Correntista;
import com.banco.bluebank.repository.ContaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

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
		
		Conta conta = new Conta();
		conta.setTipoConta("CC");
		conta.setSenha("46524");
		Agencia agencia = new Agencia();
		agencia.setId(3L);
		Correntista correntista = new Correntista();
		correntista.setId(3L);
		conta.setAgencia(agencia);
		conta.setCorrentista(correntista);

		conta = service.salvar(conta);

		assertThat(conta).isNotNull();
	}
	
		
	@Test
	public void deveAtualizarContaPorId_QuandoContaCorreta() {
		Conta conta = new Conta();
		conta.setTipoConta("CC");
		conta.setSenha("46524");
		Agencia agencia = new Agencia();
		agencia.setId(3L);
		Correntista correntista = new Correntista();
		correntista.setId(3L);
		conta.setAgencia(agencia);
		conta.setCorrentista(correntista);

		conta = service.atualizar(91L, conta);

		assertThat(conta).isNotNull();

	}
	
	@Test(expected = ContaNaoEncontradaException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoContaIncorreta() {
		Conta conta = new Conta();
		conta.setTipoConta("CC");
		conta.setSenha("46524");
		Agencia agencia = new Agencia();
		agencia.setId(3L);
		Correntista correntista = new Correntista();
		correntista.setId(3L);
		conta.setAgencia(agencia);
		conta.setCorrentista(correntista);

		conta = service.atualizar(9993L, conta);

		assertThat(conta).isNotNull();
	}
	
	
	@Test(expected = DadoRequeridoException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoContaNull() {
		Conta conta = new Conta();
		conta.setTipoConta("CC");
		conta.setSenha("46524");
		Agencia agencia = new Agencia();
		agencia.setId(3L);
		Correntista correntista = new Correntista();
		correntista.setId(3L);
		conta.setAgencia(agencia);
		conta.setCorrentista(correntista);

		conta = service.atualizar(null, conta);

		assertThat(conta).isNotNull();
	}
	
	@Test(expected = CorrentistaNaoEncontradoException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoCorrentistaIncorreto() {
		Conta conta = new Conta();
		conta.setTipoConta("CC");
		conta.setSenha("46524");
		Agencia agencia = new Agencia();
		agencia.setId(3L);
		Correntista correntista = new Correntista();
		correntista.setId(39785L);
		conta.setAgencia(agencia);
		conta.setCorrentista(correntista);

		conta = service.atualizar(91L, conta);

		assertThat(conta).isNotNull();
	}
	

	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoCorrentistaNull() {
		Conta conta = new Conta();
		conta.setTipoConta("CC");
		conta.setSenha("46524");
		Agencia agencia = new Agencia();
		agencia.setId(3L);
		Correntista correntista = new Correntista();
		correntista.setId(null);
		conta.setAgencia(agencia);
		conta.setCorrentista(correntista);

		conta = service.atualizar(91L, conta);

		assertThat(conta).isNotNull();
	}
	
	@Test(expected = AgenciaNaoEncontradaException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoAgenciaIncorreto() {
		Conta contaAtual = new Conta();
		contaAtual.setSenha("04564");
		contaAtual.setTipoConta("CC");
		Correntista correntista = new Correntista();
		correntista.setId(5L);
		contaAtual.setCorrentista(correntista);
		Agencia agencia = new Agencia();
		agencia.setId(89888L);
		contaAtual.setAgencia(agencia);

		Conta conta = service.atualizar(91L, contaAtual);
		
		assertThat(conta).isNotNull();
	}
	
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void deveFalharAoAtualizarContaPorId_QuandoAgenciaNull() {
		Conta contaAtual = new Conta();
		contaAtual.setSenha("04564");
		contaAtual.setTipoConta("CC");
		Correntista correntista = new Correntista();
		correntista.setId(5L);
		contaAtual.setCorrentista(correntista);
		Agencia agencia = new Agencia();
		agencia.setId(null);
		contaAtual.setAgencia(agencia);

		Conta conta = service.atualizar(91L, contaAtual);

		assertThat(conta).isNotNull();
	}
	
	
	@Test(expected = DigitoVerificadorInvalidoException.class)
	public void deveFalharAoExcluirContaPorId__QuandoComDigitoInvalido() {

		service.excluir(92L);
	}
	
	@Test(expected = ContaNaoEncontradaException.class)
	public void deveFalharAoExcluirContaPorId__QuandoContaNaoEncontrada() {

		service.excluir(9999996L);
	}
	
	@Test(expected = EntidadeEmUsoException.class)
	public void deveFalharAoExcluirContaPorId__QuandoContaEmUso() {

		service.excluir(42L);
	}

}
