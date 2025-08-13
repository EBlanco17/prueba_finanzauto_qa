package com.co.finanzauto.qa.base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

public class BasePlaceHolder {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = System.getProperty("base.uri", "https://jsonplaceholder.typicode.com");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
