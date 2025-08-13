package com.co.finanzauto.qa.reqres;

import com.co.finanzauto.qa.base.BaseReqRes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ReqResAuthTests extends BaseReqRes {

    @DisplayName("Verifica login exitoso, devuelve token")
    @Test
    void loginSuccess() {
        String payload = """
            { "email": "eve.holt@reqres.in", "password": "cityslicka" }
            """;

        given()
                .contentType("application/json")
                .headers("x-api-key","reqres-free-v1")
                .body(payload)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }

    @DisplayName("Verifica login fallido, devuelve error 400")
    @Test
    void loginFail() {
        String payload = """
            { "email": "eve.holt@reqres.in" }
            """;

        given()
                .contentType("application/json")
                .headers("x-api-key","reqres-free-v1")
                .body(payload)
                .when()
                .post("/login")
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    @DisplayName("Verifica registro exitoso, devuelve id y token")
    @Test
    void registerSuccess() {
        String payload = """
            { "email": "eve.holt@reqres.in", "password": "pistol" }
            """;

        given()
                .contentType("application/json")
                .headers("x-api-key","reqres-free-v1")
                .body(payload)
                .when()
                .post("/register")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("token", notNullValue());
    }

    @DisplayName("Verifica registro fallido, devuelve error 400")
    @Test
    void registerFail() {
        String payload = """
                { "email": "sydney@fife"
                """;

        given()
                .contentType("application/json")
                .headers("x-api-key", "reqres-free-v1")
                .body(payload)
                .when()
                .post("/register")
                .then()
                .statusCode(400);
    }

}
