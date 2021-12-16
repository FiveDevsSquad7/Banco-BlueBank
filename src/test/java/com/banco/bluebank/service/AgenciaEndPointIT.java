package com.banco.bluebank.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

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

		final String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2Mzk3MTY5MzgsInVzZXJfbmFtZSI6IjE4IiwiYXV0aG9yaXRpZXMiOls"+
				"iQURNSU4iXSwianRpIjoiOGQ1YWFhMmQtOTY0My00NTA0LThkNzQtMjdlYjRjZDg1Mjc4IiwiY2xpZW50X2lkIjoiYmx1ZWJhbmstYXBwIiwic2NvcGU"+
				"iOlsiUkVBRCIsIldSSVRFIl19.dxnEvmzPAKllzNrYNw4r0Nc1Rgt7vhPZaZMSHvcOAy5FZ6gHqsgs5n-qB-HURD3lBKMF8K2SNAG4PpvGJr9hBD9c"+
				"8bDtu6P8YXXVySeF9XZ77S6PmO4RjrCkuwbNM_ZNjnIcYE6JiEZh5MuaQ7-l85nIgQez7nU9eM7Ly7i2L-nqUxVwW2sqfAjZqvVKKeX0QUKtMKDQPaQGS"+
				"z0R-5PShm1mEdpfiE228WDXnKN1d4u3lo7kAn4eVX1aIrhuga7KscsRxjQslEoe29L1n_e1-MYM_ic4w--MVcab9Bjkr0CrTtJRPMmnPvjqk93vYALrQD"+
				"o6YXmIpyJi4k-eR74izA";

		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		RestAssured.given()
				.basePath("/agencias")
				.header("Authorization", "Bearer "+token)
				.accept(ContentType.JSON)
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
