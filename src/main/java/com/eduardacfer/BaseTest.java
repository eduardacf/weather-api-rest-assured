package com.eduardacfer;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.config.HttpClientConfig.httpClientConfig;

public abstract class BaseTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
        RestAssured.config = RestAssured.config()
                                        .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())
                                        .and()
                                        .httpClient(httpClientConfig().setParam("http.connection.timeout", 5000));
    }
}
