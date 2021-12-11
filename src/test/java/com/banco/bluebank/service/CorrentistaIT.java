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
import com.banco.bluebank.exceptionhandler.exceptions.ContatoNaoEncontradoException;
import com.banco.bluebank.exceptionhandler.exceptions.CorrentistaNaoEncontradoException;
import com.banco.bluebank.exceptionhandler.exceptions.EnderecoNaoEncontradoException;
import com.banco.bluebank.exceptionhandler.exceptions.EntidadeEmUsoException;
import com.banco.bluebank.model.Correntista;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class CorrentistaIT {

	@Autowired
	private CorrentistaService service;
	

	@Test
	public void deveInserirCorrentistaComSucesso_QuandoCorrentistaCorreto() {
		
		Correntista novoCorrentista = 
				new Correntista("Harry Thiago","45899657566","145897586", null,"F","HT@teste.com","999999999");
		
		Correntista correntista = service.create(novoCorrentista);
		
		assertThat(correntista).isNotNull();
		assertThat(correntista.getId()).isNotNull();
		
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void deveFalharAoInserirCorrentista_QuandoNomeCorrentistaInvalido() {
		
		Correntista novoCorrentista = 
				new Correntista(null,"45899657566","145897586", null,"F","HT@teste.com","999999999");
		
		Correntista correntista = service.create(novoCorrentista);
		
		assertThat(correntista).isNotNull();
		assertThat(correntista.getId()).isNotNull();
		
	}
	
	@Test(expected = CorrentistaNaoEncontradoException.class)
	public void devefalharAoBuscarCorrentista_QuandoIdInformadoErrado() {
				service.buscar(999999999998L);
	}
	
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void devefalharAoBuscarCorrentista_QuandoNaoInformado() {
				service.buscar(null);
	}
	
	@Test(expected = EntidadeEmUsoException.class)
	public void deveFalharAoExcluirCorrentista_QuandoCorrentistaEmUso() {
		service.excluir(2L);
	}
	
	@Test(expected = CorrentistaNaoEncontradoException.class)
	public void deveFalharAoExcluirCorrentista_QuandoCorrentistaNaoExistente() {
		service.excluir(999999998L);
	}
		
	@Test(expected = ContatoNaoEncontradoException.class)
	public void deveFalharAoExcluirContatoCorrentista_QuandoContatoNaoExistente() {
		service.excluirContato(6L, 99999999L);
	}
	
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void deveFalharAoExcluirContatoCorrentista_QuandoContatoForNulo() {
		service.excluirContato(6L, null);
		
	}
	
	@Test(expected = EnderecoNaoEncontradoException.class)
	public void deveFalharAoExcluirEnderecoCorrentista_QuandoEnderecoNaoExistente() {
		service.excluirEndereco(6L, 99999999L);
	}
	
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void deveFalharAoExcluirEnderecoCorrentista_QuandoEnderecoForNulo() {
		service.excluirEndereco(6L, null);
	}

}
