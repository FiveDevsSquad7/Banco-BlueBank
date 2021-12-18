package com.banco.bluebank.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class MovimentacaoEndPointIT extends RestAssuredOAuth2Test {

    @LocalServerPort
    private int Webport;


    @Before
    public void iniciar() {
        RestAssured.port = Webport;

    }

    @Test
    public void deveRetornar200AoCriarDeposito() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/movimentacoes/deposito")
                .header("Authorization", "Bearer " + token)
                .body("{\n    \"numeroConta\":  83,\n    \"descricao\":\"deposito \",\n    \"valor\": 1000.0\n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().post().then().statusCode(HttpStatus.CREATED.value());


    }

    @Test
    public void deveFalharRetornar500AoCriarDepositoValorIvalido() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/movimentacoes/deposito")
                .header("Authorization", "Bearer " + token)
                .body("{\n    \"numeroConta\":  83,\n    \"descricao\":\"deposito \",\n    \"valor\": 10000000000000000000000000000000000000000000000000000000.0\n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().post().then().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());


    }


    @Test
    public void deveRetornar200AoCriarTransferencia() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/movimentacoes")
                .header("Authorization", "Bearer " + token)
                .body("{\n \"numeroContaDebito\": 83 ,\n  \"numeroContaCredito\": 109 ,\n  \"descricao\":\"transferencia\",\n  \"valor\": 10.0 \n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().post("/transferencia").then().statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void deveFalharRetornar400AoCriarTransferenciaValorInvalido() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/movimentacoes")
                .header("Authorization", "Bearer " + token)
                .body("{\n \"numeroContaDebito\": 83 ,\n  \"numeroContaCredito\": 109 ,\n  \"descricao\":\"transferencia\",\n  \"valor\": 100000000000000000000.0 \n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().post("/transferencia").then().statusCode(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    public void deveRetornar200AoCriarSaque() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/movimentacoes")
                .header("Authorization", "Bearer " + token)
                .body("{\n \"numeroConta\":  42 ,\n  \"descricao\":\"saque \",\n  \"valor\": 5.0\n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().post("/saque").then().statusCode(HttpStatus.CREATED.value());

    }

    @Test
    public void deveFalharRetornar400AoCriarSaqueSaldoInsuficiente() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/movimentacoes")
                .header("Authorization", "Bearer " + token)
                .body("{\n \"numeroConta\":  109 ,\n  \"descricao\":\"saque \",\n  \"valor\": 500000000000000000.0\n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().post("/saque").then().statusCode(HttpStatus.BAD_REQUEST.value());

    }

    @Test
    public void deveRetornar200AoListarMovimentações() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/movimentacoes")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 1)
                .accept(ContentType.JSON).when().get("/{id}")
                .then().statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveFalharRetornar404AoListarMovimentações() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/movimentacoes")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 0)
                .accept(ContentType.JSON).when().get("/{id}")
                .then().statusCode(HttpStatus.NOT_FOUND.value());

    }


}
