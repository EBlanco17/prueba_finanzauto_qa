package com.co.finanzauto.qa.jsonplaceholder;

import com.co.finanzauto.qa.base.BasePlaceHolder;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceHolderNegativeCasesTests extends BasePlaceHolder {
    @Test
    void getNonExistentPost() {
        given()
                .when()
                .get("/posts/9999999999")
                .then()
                .statusCode(anyOf(is(404), is(200)))
                .body(anything());
    }

    @Test
    void createPost_invalidPayload() {
        String invalidPayload = """
            { "title": 123, "body: true }
            """;

        given()
                .contentType("application/json")
                .body(invalidPayload)
                .when()
                .post("/posts")
                .then()
                .statusCode(anyOf(is(400), is(500)));
    }

    @Test
    void methodNotAllowed() {
        given()
                .when()
                .patch("/posts")
                .then()
                .statusCode(anyOf(is(405), is(404)));
    }
}
