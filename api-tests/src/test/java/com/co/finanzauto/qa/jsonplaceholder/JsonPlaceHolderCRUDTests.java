package com.co.finanzauto.qa.jsonplaceholder;

import com.co.finanzauto.qa.base.BasePlaceHolder;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

public class JsonPlaceHolderCRUDTests extends BasePlaceHolder {

    @Test
    void getPosts() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", is(100));
    }

    @Test
    void getPostById() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", notNullValue());
    }

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


    @Test
    void deletePost() {
        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(anyOf(is(200), is(204)));
    }
}
