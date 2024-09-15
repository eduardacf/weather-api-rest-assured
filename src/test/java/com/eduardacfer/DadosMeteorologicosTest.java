package com.eduardacfer;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static com.eduardacfer.WeatherConstants.*;
import static org.hamcrest.Matchers.*;

public class DadosMeteorologicosTest extends BaseTest {

    @Test
    public void testeTemperaturaCidade() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_Q, BRASILIA)
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(200)
                   .body("main.temp", notNullValue());
    }

    @Test
    public void testeUmidade() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_Q, MANAUS)
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(200)
                   .body("main.humidity", greaterThan(0))
                   .body("main.humidity", lessThan(100));
    }

    @Test
    public void testePressaoAtmosferica() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_Q, SAO_CARLOS)
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(200)
                   .body("main.pressure", greaterThan(800))
                   .body("main.pressure", lessThan(1100));
    }
}