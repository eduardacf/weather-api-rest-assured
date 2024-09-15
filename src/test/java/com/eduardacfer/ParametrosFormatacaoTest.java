package com.eduardacfer;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static com.eduardacfer.WeatherConstants.*;


public class ParametrosFormatacaoTest extends BaseTest {

    @Test
    public void testeCidadeComEspaco() {
        RestAssured.given()
                   .queryParam(QUERY_PARAM_Q, NOVA_IGUACU)
                   .queryParam(QUERY_PARAM_APPID, KEY_WEATHER)
                   .when()
                   .get(ENDPOINT_WEATHER)
                   .then()
                   .statusCode(200);
    }
}
