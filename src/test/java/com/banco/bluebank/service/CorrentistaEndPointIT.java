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
public class CorrentistaEndPointIT extends RestAssuredOAuth2Test {

    @LocalServerPort
    private int Webport;

    @Before
    public void iniciar() {
        RestAssured.port = Webport;

    }

    @Test
    public void deveRetornar200AoListarCorrentistas() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .accept(ContentType.JSON)
                .when().get().then().statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornar404AoListarCorrentistasComErroNoPath() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntista")
                .header("Authorization", "Bearer " + token)
                .accept(ContentType.JSON)
                .when().get().then().statusCode(HttpStatus.NOT_FOUND.value());

    }

    @Test
    public void deveRetornar200AoListarCorrentistasPorId() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 3)
                .accept(ContentType.JSON).when().get("/{id}")
                .then().statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornar404AoListarCorrentistasPorIdInexistente() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 55)
                .accept(ContentType.JSON).when().get("/{id}")
                .then().statusCode(HttpStatus.NOT_FOUND.value());

    }


    @Test
    public void deveRetornar200AoCriarCorrentista() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .body("{\n \"nome\": \"Jorge Jesus\",\n  \"cpf\": \"58025713067\",\n  \"rg\": \"465464649\",\n  \"cnpj\": null,\n  \"tipoPessoa\": \"F\",\n \"emailValidacao\": \"JJ@b.dev\",\n  \"enderecos\": [\n   {\n   \"logradouro\": \"Rua do Flamengo\",\n    \"numero\": \"3 \",\n   \"complemento\": \"Gavea\",\n   \"cep\": \"20700000\",\n   \"bairro\": \"Centro\",\n  \"cidade\": \"Rio de Janeiro\",\n   \"estado\": \"RJ\"\n   },\n  {\n   \"logradouro\": \"Rua dos Campeoes\",\n   \"numero\": \"3\",\n   \"complemento\": null,\n   \"cep\": \"20720000\",\n   \"bairro\": \"Guaratiba\",\n  \"cidade\": \"Rio de Janeiro\",\n  \"estado\": \"RJ\"\n  }\n  ],\n    \"contatos\": [\n   {\n  \"telefone\": \"888888888\",\n   \"email\": \"sed@h.com\",\n   \"infoRecado\": \"o proprio\"\n    },\n   {\n   \"telefone\": \"999999999\",\n   \"email\": \"diretoria@n.com\",\n  \"infoRecado\": \"Braz\"\n   }\n    ],\n    \"sms\": \"99999999\"\n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().post().then().statusCode(HttpStatus.CREATED.value());

    }

    @Test
    public void deveRetornar400AoCriarCorrentistaVazio() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .body("{\n \"nome\": \"\",\n  \"cpf\": \"\",\n  \"rg\": \"\",\n  \"cnpj\": \"\",\n  \"tipoPessoa\": \"\",\n \"emailValidacao\": \"\",\n  \"enderecos\": [\n   {\n   \"\": \"\",\n    \"numero\": \" \",\n   \"complemento\": \"\",\n   \"cep\": \"\",\n   \"bairro\": \"\",\n  \"cidade\": \"\",\n   \"estado\": \"\"\n   },\n  {\n   \"logradouro\": \"\",\n   \"numero\": \"\",\n   \"complemento\": \"\",\n   \"cep\": \"\",\n   \"bairro\": \"\",\n  \"cidade\": \"\",\n  \"estado\": \"\"\n  }\n  ],\n    \"contatos\": [\n   {\n  \"telefone\": \"\",\n   \"email\": \"\",\n   \"infoRecado\": \"\"\n    },\n   {\n   \"telefone\": \"\",\n   \"email\": \"\",\n  \"infoRecado\": \"\"\n   }\n    ],\n    \"sms\": \"\"\n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().post().then().statusCode(HttpStatus.BAD_REQUEST.value());

    }

    @Test
    public void deveRetornar200AoAtualizarCorrentistaBuscandoPorId() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 3)
                .body("{\n \"nome\": \"Carlos Betiol\",\n \"cpf\": \"58025713067\",\n \"rg\": \"46546464\",\n \"cnpj\": null,\n \"tipoPessoa\": \"F\",\n  \"emailValidacao\": \"carlos@betiol.dev\",\n \"sms\": \"6456465\"\n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().put("/{id}").then().statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornar404AoAtualizarCorrentistaBuscandoPorIdInexistente() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 11)
                .body("{\n \"id\": 4,\n \"nome\": \"Carlos Betiol\",\n \"cpf\": \"58025713067\",\n \"rg\": \"46546464\",\n \"cnpj\": null,\n \"tipoPessoa\": \"F\",\n  \"emailValidacao\": \"carlos@betiol.dev\",\n \"sms\": \"6456465\"\n}")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().put("/{id}").then().statusCode(HttpStatus.NOT_FOUND.value());

    }

    @Test
    public void deveRetornar200AoListarEnderecosDoCorrentistasDaBuscaPorId() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 3)
                .accept(ContentType.JSON).when().get("/{id}/enderecos")
                .then().statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornar200AoInserirEnderecosDoCorrentistasDaBuscaPorId() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 3)
                .body("{\n \"logradouro\": \"rua do angico\",\n  \"numero\": \"333\",\n  \"complemento\": \"dolore \",\n \"cep\": \"38567235\",\n \"bairro\": \"Casa grande\",\n  \"cidade\": \"manaus\",\n \"estado\": \"AM\"\n}")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).when().post("/{id}/enderecos")
                .then().statusCode(HttpStatus.CREATED.value());

    }

    @Test
    public void deveRetornar200AoExcluirEnderecosDoCorrentistasDaBuscaPorId() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParams("id", 3, "enderecoId", 4)
                .accept(ContentType.JSON).when().delete("/{id}/enderecos/{enderecoId}")
                .then().statusCode(HttpStatus.NO_CONTENT.value());

    }

    @Test
    public void deveRetornar404AoExcluirEnderecosDeCorrentistasDiferentesDaBuscaPorId() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParams("id", 3, "enderecoId", 2)
                .accept(ContentType.JSON).when().delete("/{id}/enderecos/{enderecoId}")
                .then().statusCode(HttpStatus.NOT_FOUND.value());

    }

    @Test
    public void deveRetornar200AoListarContatosDoCorrentistasDaBuscaPorId() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 3)
                .accept(ContentType.JSON).when().get("/{id}/contatos")
                .then().statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornar200AoInserirContatosDoCorrentistasDaBuscaPorId() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 3)
                .body("{\n  \"telefone\": \"9999999\",\n    \"email\": \"joca@email.com\",\n  \"infoRecado\": \"ad voluptate anim eiusmod\"\n}")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).when().post("/{id}/contatos")
                .then().statusCode(HttpStatus.CREATED.value());

    }


    @Test
    public void deveRetornar200AoRemoverCorrentistaPorId() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 7)
                .accept(ContentType.JSON).when().delete("/{id}")
                .then().statusCode(HttpStatus.NO_CONTENT.value());

    }

    @Test
    public void deveRetornar404AoRemoverCorrentistaPorIdInexistente() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        final String token = getToken();

        RestAssured.given().basePath("/correntistas")
                .header("Authorization", "Bearer " + token)
                .pathParam("id", 11)
                .accept(ContentType.JSON).when().delete("/{id}")
                .then().statusCode(HttpStatus.NOT_FOUND.value());

    }

}
