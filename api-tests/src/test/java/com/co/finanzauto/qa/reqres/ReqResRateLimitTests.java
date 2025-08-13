package com.co.finanzauto.qa.reqres;

import com.co.finanzauto.qa.base.BaseReqRes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ReqResRateLimitTests extends BaseReqRes {

    @DisplayName("Verifica el límite de tasa de la API")
    @Test
    void rateLimitTest() {
        given()
                .headers("x-api-key", "reqres-free-v1")
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .header("Ratelimit-Limit", "100")
                .header("Ratelimit-Remaining", notNullValue())
                .header("Ratelimit-Remaining", matchesPattern("\\d+"));
    }
}