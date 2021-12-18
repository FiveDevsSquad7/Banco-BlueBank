package com.banco.bluebank.service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class RestAssuredOAuth2Test {

    public static String clientId = "bluebank-app";
    public static String clientPassword = "web123";
    public static String scope = "READ WRITE";
    public static String username = "18";
    public static String password = "8912";

    public static String  encodeToBase64(String str1, String str2) {
        return new String(Base64.getEncoder().encode((str1 + ":" + str2).getBytes()));
    }

    public Response doAuth() {
        String authorization = encodeToBase64(clientId, clientPassword);

        return
                given()
                        .baseUri("http://localhost:8081/")
                        .header("Authorization", "Basic " + authorization)
                        .contentType(ContentType.URLENC)
                        .formParam("grant_type", "password")
                        .formParam("username", username)
                        .formParam("password", password)
                        .formParam("scope", scope)
                        .post("/oauth/token")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }

    public String parseToken(Response response) {
        return response.jsonPath().getString("access_token");
    }

    public String getToken() {
        return parseToken(doAuth());
    }

}
