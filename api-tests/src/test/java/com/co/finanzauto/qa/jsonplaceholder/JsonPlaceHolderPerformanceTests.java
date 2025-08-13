package com.co.finanzauto.qa.jsonplaceholder;

import com.co.finanzauto.qa.base.BasePlaceHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

public class JsonPlaceHolderPerformanceTests extends BasePlaceHolder {

    @DisplayName("Se verifica la respuesta de la API en posts")
    @Test
    void getPostsPerformance() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body(matchesJsonSchemaInClasspath("schemas/posts_schema.json"));
    }

    @DisplayName("Se verifica la respuesta de la API en comentarios")
    @Test
    void getCommentsPerformance() {
        given()
                .when()
                .get("/comments")
                .then()
                .statusCode(200)
                .time(lessThan(2000L))
                .body(matchesJsonSchemaInClasspath("schemas/comments_schema.json"));
    }
}
