package com.co.finanzauto.qa.reqres;

import com.co.finanzauto.qa.base.BaseReqRes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class ReqResPaginationTests extends BaseReqRes {

    @DisplayName("Paginación de usuarios - Página 2")
    @Test
    void getUsersPage() {
        given()
                .headers("x-api-key", "reqres-free-v1")
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data.size()", greaterThan(0));
    }
}
