package com.co.finanzauto.qa.jsonplaceholder;

import com.co.finanzauto.qa.base.BasePlaceHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;

public class JsonPlaceHolderRelationsTests extends BasePlaceHolder {

    @DisplayName("Verifica que los comentarios pertenecen al post")
    @Test
    void commentsXPostId() {
        int postId = 1;
        given()
                .when()
                .get("/posts/{id}/comments", postId)
                .then()
                .statusCode(200)
                .body("postId", everyItem(equalTo(postId)))
                .body(matchesJsonSchemaInClasspath("schemas/comments_schema.json"));
    }

    @DisplayName("Verifica que los posts pertenecen al usuario")
    @Test
    void postsXUserId() {
        int userId = 1;
        given()
                .when()
                .get("/users/{id}/posts", userId)
                .then()
                .statusCode(200)
                .body("userId", everyItem(equalTo(userId)));
    }

}
