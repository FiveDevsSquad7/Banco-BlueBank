package com.banco.bluebank.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.banco.bluebank.exceptionhandler.exceptions.ContaNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.MovimentacaoNaoEncontradaException;
import com.banco.bluebank.exceptionhandler.exceptions.PeriodoInvalidoException;
import com.banco.bluebank.model.Movimentacao;
import com.banco.bluebank.repository.MovimentacaoRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class MovimentacaoIT {

	@Autowired
	private MovimentacaoService service;
	@Autowired
	private ContaService contaService;
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	
	@Test
	public void deveSalvarMovimentacao() {
		OffsetDateTime data = OffsetDateTime.now();
		
		Movimentacao novMovimentacao = 
				new Movimentacao(data, BigDecimal.valueOf(100.0), "test");
		novMovimentacao.setContaDebito(contaService.buscar(83L));
		movimentacaoRepository.save(novMovimentacao);
		
		assertThat(novMovimentacao).isNotNull();
		
	}
	

	@Test
	public void deveListarMovimentacao() {
		Pageable pageable = PageRequest.of(0, 10);
		OffsetDateTime dataInicial = OffsetDateTime.now().minusDays(1);
		OffsetDateTime dataFinal = OffsetDateTime.now();
		
		service.listar(18L, dataInicial, dataFinal, pageable);
	}
	
	@Test(expected = ContaNaoEncontradaException.class)
	public void deveFalharAoListarMovimentacao_QuandoContaInexistente() {
		Pageable pageable = PageRequest.of(0, 10);
		OffsetDateTime dataInicial = OffsetDateTime.now().minusDays(1);
		OffsetDateTime dataFinal = OffsetDateTime.now();
		
		service.listar(9999996L, dataInicial, dataFinal, pageable);
	}
	
	@Test(expected = PeriodoInvalidoException.class)
	public void deveFalharAoListarMovimentacao_QuandoDatasInexistente() {
		Pageable pageable = PageRequest.of(0, 10);
		OffsetDateTime dataInicial = OffsetDateTime.now();
		OffsetDateTime dataFinal = OffsetDateTime.now().minusDays(1);
		
		service.listar(18L, dataInicial, dataFinal, pageable);
	}
	
	@Test
	public void deveBuscarMovimentacaoPorId() {
		service.buscarPorId(1L);

	}
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void deveFalharAoBuscarMovimentacaoPorId_QuandoNull() {
		service.buscarPorId(null);
	}
	
	@Test(expected = MovimentacaoNaoEncontradaException.class)
	public void deveFalharAoBuscarMovimentacaoPorId_QuandoInexistente() {
		service.buscarPorId(999999999L);
	}
	
}
