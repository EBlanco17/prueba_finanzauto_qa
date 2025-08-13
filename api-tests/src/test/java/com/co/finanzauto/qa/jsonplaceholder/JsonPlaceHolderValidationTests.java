package com.co.finanzauto.qa.jsonplaceholder;

import com.co.finanzauto.qa.base.BasePlaceHolder;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

public class JsonPlaceHolderValidationTests extends BasePlaceHolder {

    @Test
    void getAllPosts_schema() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body(matchesJsonSchemaInClasspath("schemas/posts_schema.json"));
    }

    @Test
    void postSchemaValidation() {

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
                .body(matchesJsonSchemaInClasspath("schemas/post_schema.json"));

    }
}
