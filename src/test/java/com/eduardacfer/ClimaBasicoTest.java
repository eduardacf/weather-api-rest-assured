package com.eduardacfer;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static com.eduardacfer.WeatherConstants.*;
import static org.hamcrest.Matchers.equalTo;

public class ClimaBasicoTest extends BaseTest {

    @Test
    public void testeClimaPorCidade() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_Q, SAO_PAULO)
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(200);
    }

    @Test
    public void testeCidadeInexistente() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_Q, CIDADE_INEXISTENTE)
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(404)
                   .body(BODY_MESSAGE, equalTo(MSG_CITY_NOT_FOUND));
    }

    @Test
    public void testeSemChaveApi() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_Q, RIO_DE_JANEIRO)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(401)
                   .body(BODY_MESSAGE, equalTo(MSG_INVALID_KEY));
    }
}
