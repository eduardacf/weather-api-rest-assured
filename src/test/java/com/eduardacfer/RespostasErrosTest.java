package com.eduardacfer;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static com.eduardacfer.WeatherConstants.*;
import static org.hamcrest.Matchers.equalTo;

public class RespostasErrosTest extends BaseTest {

    @Test
    public void testeCoordenadasInvalidas() {
        RestAssured.given()
                   .queryParam("lat", "999")
                   .queryParam("lon", "999")
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(400)
                   .body(BODY_MESSAGE, equalTo(MSG_WRONG_LATITUDE));
    }

    @Test
    public void testeChaveApiInvalida() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_Q, ARACAJU)
                   .queryParam(QUERY_PARAM_APPID, CHAVE_INVALIDA)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(401)
                   .body(BODY_MESSAGE, equalTo(MSG_INVALID_KEY));
    }
}
