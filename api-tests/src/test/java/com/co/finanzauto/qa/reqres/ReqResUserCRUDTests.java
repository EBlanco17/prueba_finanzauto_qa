package com.co.finanzauto.qa.reqres;

import com.co.finanzauto.qa.base.BaseReqRes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqResUserCRUDTests extends BaseReqRes {

    @DisplayName("Se obtiene un usuario por ID, se verifica que retorna 200 y los datos correctos")
    @Test
    void getUser() {
        given()
                .headers("x-api-key", "reqres-free-v1")
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
    }

    @DisplayName("Se crea un usuario, se verifica que retorna 201 y los datos correctos")
    @Test
    void createUser() {
        String payload = """
            { "name": "morpheus", "job": "leader" }
            """;

        given()
                .contentType("application/json")
                .headers("x-api-key", "reqres-free-v1")
                .body(payload)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }

    @DisplayName("Se actualiza un usuario, se verifica que retorna 200 y el trabajo actualizado")
    @Test
    void updateUser() {
        String payload = """
            { "name": "morpheus", "job": "zion resident" }
            """;

        given()
                .contentType("application/json")
                .headers("x-api-key", "reqres-free-v1")
                .body(payload)
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .body("job", equalTo("zion resident"));
    }

    @DisplayName("Se actualiza parcialmente un usuario con PATCH, se verifica que retorna 200 y el trabajo actualizado")
    @Test
    void updateUserWithPatch() {
        String payload = """
            { "job": "zion resident" }
            """;

        given()
                .contentType("application/json")
                .headers("x-api-key", "reqres-free-v1")
                .body(payload)
                .when()
                .patch("/users/2")
                .then()
                .statusCode(200)
                .body("job", equalTo("zion resident"));
    }

    @DisplayName("Se elimina un usuario, se verifica que retorna 204")
    @Test
    void deleteUser() {
        given()
                .headers("x-api-key", "reqres-free-v1")
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204);
    }

    @DisplayName("Se intenta obtener un usuario no existente, se verifica que retorna 404")
    @Test
    void getUserNotExist() {
        given()
                .headers("x-api-key", "reqres-free-v1")
                .when()
                .get("/users/23")
                .then()
                .statusCode(404)
                .body(equalTo("{}"));
    }
}
