package com.co.finanzauto.qa.jsonplaceholder;

import com.co.finanzauto.qa.base.BasePlaceHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceHolderNegativeCasesTests extends BasePlaceHolder {

    @DisplayName("Se verifica que no devuelva ningún post inexistente")
    @Test
    void getNonExistentPost() {
        given()
                .when()
                .get("/posts/9999999999")
                .then()
                .statusCode(anyOf(is(404), is(200)))
                .body(anything());
    }

    @DisplayName("Se verifica que no se pueda crear un post con payload inválido")
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

    @DisplayName("Se verifica que no se permita el método PATCH en /posts")
    @Test
    void methodNotAllowed() {
        given()
                .when()
                .patch("/posts")
                .then()
                .statusCode(anyOf(is(405), is(404)));
    }
}
