package netology.ru;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchhoTest {
    @Test
    void apiTest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(404)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    void apiTestRus() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Тест")
                .when()
                .post("/post")
                .then()
                .statusCode(404)
                .body("data", equalTo("Тест"))
        ;
    }
}
