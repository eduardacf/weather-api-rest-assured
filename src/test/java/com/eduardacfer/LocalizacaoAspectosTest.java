package com.eduardacfer;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static com.eduardacfer.WeatherConstants.*;
import static org.hamcrest.Matchers.equalTo;

public class LocalizacaoAspectosTest extends BaseTest {

    @Test
    public void testeClimaPorCoordenadas() {
        RestAssured.given()
                   .queryParam("lat", "-23.5505")
                   .queryParam("lon", "-46.6333")
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(200);
    }

    @Test
    public void testeClimaPorIdCidade() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_ID, ID_CIDADE_SAO_PAULO)
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(200);
    }

    @Test
    public void testeCidadeCodificada() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_Q, SAO_LUIS)
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(200)
                   .body(BODY_NAME, equalTo(SAO_LUIS));
    }
}
