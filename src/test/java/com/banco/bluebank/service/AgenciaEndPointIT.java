package com.banco.bluebank.service;

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
public class AgenciaEndPointIT {

	@LocalServerPort
	private int Webport;
	
		
	@Before
	public void iniciar() {
		RestAssured.port = Webport;
		
	}
	
	
	@Test
	public void deveRetornar200AoListarAgencias() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencias").accept(ContentType.JSON)
		.when().get().then().statusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	public void deveRetornar404AoListarAgenciasComErroNoPath() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencia").accept(ContentType.JSON)
		.when().get().then().statusCode(HttpStatus.NOT_FOUND.value());
		
	}
	
	
	@Test
	public void deveRetornar200AoListarAgenciasPorId() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencias").pathParam("id",1)
		.accept(ContentType.JSON).when().get("/{id}")
		.then().statusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	public void deveRetornar404AoListarAgenciasPorIdInexistente() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencias").pathParam("id",11)
		.accept(ContentType.JSON).when().get("/{id}")
		.then().statusCode(HttpStatus.NOT_FOUND.value());
		
	}
		
	@Test
	public void deveRetornar200AoCriarAgencia() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencias")
		.body("{\n    \"agencia\": \"070-2\",\n    \"nome\": \"Carimã\"\n}")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().post().then().statusCode(HttpStatus.CREATED.value());
		
		
	}
	
	
	@Test
	public void deveRetornar400AoCriarAgenciaJaExitente() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencias")
		.body("{\n    \"agencia\": \"030-7\",\n    \"nome\": \"Pavuna\"\n}")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().post().then().statusCode(HttpStatus.CREATED.value());
		
		
	}
	
	
	@Test
	public void deveRetornar200AoAtualizarAgenciaBuscandoPorId() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencias").pathParam("id", 3)
		.body("{\n    \"agencia\": \"037-4\",\n    \"nome\": \"Sao Paulo\"\n}")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().put("/{id}").then().statusCode(HttpStatus.OK.value());
	}
	
	
	@Test
	public void deveRetornar500AoAtualizarAgenciaBuscandoPorIdComInformacoesInexistente() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencias").pathParam("id", 3)
		.body("{\n    \"agencia\": \" \",\n    \"nome\": \"\"\n}")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().put("/{id}").then().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
		
	

	@Test
	public void deveRetornar200AoRemoverAgenciaPorId() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencias").pathParam("id", 4)
		.accept(ContentType.JSON).when().delete("/{id}")
		.then().statusCode(HttpStatus.NO_CONTENT.value());
		
	}
	
	@Test
	public void deveRetornar404AoRemoverAgenciaPorIdPassandoIdInexistente() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given().basePath("/agencias").pathParam("id", 14)
		.accept(ContentType.JSON).when().delete("/{id}")
		.then().statusCode(HttpStatus.NOT_FOUND.value());
		
	}
	
}
