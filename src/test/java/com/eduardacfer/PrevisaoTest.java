package com.eduardacfer;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static com.eduardacfer.WeatherConstants.*;
import static org.hamcrest.Matchers.greaterThan;

public class PrevisaoTest extends BaseTest {

    @Test
    public void testePrevisao5Dias() {
        RestAssured
                .given()
                .queryParam(QUERY_PARAM_Q, FORTALEZA)
                .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                .when()
                .get(ENDPOINT_FORECAST)
                .then()
                .statusCode(200)
                .body(LIST_SIZE, greaterThan(0));
    }
}
