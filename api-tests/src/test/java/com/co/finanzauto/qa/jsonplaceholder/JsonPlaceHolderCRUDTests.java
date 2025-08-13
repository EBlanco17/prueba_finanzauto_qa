package com.co.finanzauto.qa.jsonplaceholder;

import com.co.finanzauto.qa.base.BasePlaceHolder;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;

public class JsonPlaceHolderCRUDTests extends BasePlaceHolder {

    @DisplayName("Se verifica que se obtienen todos los posts")
    @Test
    void getPosts() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", is(100));
    }

    @DisplayName("Se verifica que se obtiene un post por ID")
    @Test
    void getPostById() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", notNullValue());
    }

    @DisplayName("Se verifica que se crea un nuevo post")
    @Test
    void createPost() {
        String payload = """
            { "title": "foo", "body": "bar", "userId": 1 }
            """;

        given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("id", notNullValue());
    }

    @DisplayName("Se verifica que se actualiza un post existente")
    @Test
    void putPost() {
        String payload = """
            { "id": 1, "title": "updated", "body": "content updated", "userId": 1 }
            """;

        given()
                .contentType("application/json")
                .body(payload)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("updated"))
                .body("body", equalTo("content updated"));
    }

    @DisplayName("Se verifica que se actualiza parcialmente un post existente")
    @Test
    void patchPost() {
        String payload = """
            { "title": "partially updated" }
            """;

        given()
                .contentType("application/json")
                .body(payload)
                .when()
                .patch("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("partially updated"));
    }

    @DisplayName("Se verifica que se elimina un post existente")
    @Test
    void deletePost() {
        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(anyOf(is(200), is(204)));
    }
}
