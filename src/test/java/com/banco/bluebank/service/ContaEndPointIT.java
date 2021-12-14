package com.banco.bluebank.service;


import static org.mockito.ArgumentMatchers.isNull;

import java.time.OffsetDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class ContaEndPointIT {

	@LocalServerPort
	private int Webport;
	
	@Before
	public void iniciar() {
		RestAssured.port = Webport;
	}
	

	
	@Test
	public void deveRetornar200AoListarContas() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas").accept(ContentType.JSON)
		.when().get().then().statusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	public void deveRetornar404AoListarContasComErroNoPath() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/conta").accept(ContentType.JSON)
		.when().get().then().statusCode(HttpStatus.NOT_FOUND.value());
		
	}
	
	@Test
	public void deveRetornar200AoBuscarPorIdContas() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas").pathParam("id", 42)
		.accept(ContentType.JSON).when().get("/{id}")
		.then().statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornar400AoBuscarPorIdContasInexistente() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas").pathParam("id", 92)
		.accept(ContentType.JSON).when().get("/{id}")
		.then().statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void deveRetornar200AoCriarNovaConta() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas")
		.body("{\n  \"tipoConta\":\"CC\",\n  \"correntista\": {\"id\":6} ,\n   \"agencia\": {\"id\": 2}\n}")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().post().then().statusCode(HttpStatus.CREATED.value());
		
	}
	
	@Test
	public void deveRetornar500AoCriarNovaContaComDadosInvalidados() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas")
		.body("{\n  \"tipoConta\":\"CC\",\n  \"correntista\": {\"id\":6} ,\n   \"agencia\": {\"id\": null}\n}")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().post().then().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
	}
	
	@Test
	public void deveRetornar200AoBuscarSaldoEmConta() {
		
		OffsetDateTime data = OffsetDateTime.now();
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas").pathParams("id",42, "data", data.toString())
		.accept(ContentType.JSON).when().get("/{id}/saldo/{data}")
		.then().statusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	public void deveRetornar500AoBuscarSaldoEmContaComDataInvalida() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas").pathParams("id",42, "data", isNull())
		.accept(ContentType.JSON).when().get("/{id}/saldo/{data}")
		.then().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
	}
	
	@Test
	public void deveRetornar200AoBuscarExtratoPorIdPeriodo() {
		
		OffsetDateTime dataInicial = OffsetDateTime.now().minusDays(1);
		OffsetDateTime dataFinal = OffsetDateTime.now();
		
			
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas")
		.pathParams("id",42, "dataInicial", dataInicial.toString() ,"dataFinal", dataFinal.toString() )
		.accept(ContentType.JSON).when().get("/{id}/extrato/{dataInicial}/{dataFinal}")
		.then().statusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	public void deveRetornar200AoAtualizarConta() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas").pathParam("id", 67)
		.body("{\n \"tipoConta\":\"PP\",\n \"correntista\": {\"id\": 2} ,\n \"agencia\": {\"id\": 2}\n}\n")
		.contentType(ContentType.JSON).accept(ContentType.JSON).when()
		.put("/{id}").then().statusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	public void deveRetornar400AoAtualizarContaPassandoDadosVazios() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas").pathParam("id", 75)
		.body("{\n \"tipoConta\":\"\",\n \"correntista\": {\"id\": } ,\n \"agencia\": {\"id\": }\n}\n")
		.contentType(ContentType.JSON).accept(ContentType.JSON).when()
		.put("/{id}").then().statusCode(HttpStatus.BAD_REQUEST.value());
		
	}
	
	@Test
	public void deveRetornar200AoExcluirConta() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas").pathParam("id", 75)
		.accept(ContentType.JSON).when().delete("/{id}")
		.then().statusCode(HttpStatus.NO_CONTENT.value());
		
	}
	
	@Test
	public void deveRetornar400AoExcluirContaInexistente() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/contas").pathParam("id", 100)
		.accept(ContentType.JSON).when().delete("/{id}")
		.then().statusCode(HttpStatus.BAD_REQUEST.value());
		
	}
	
	
}
