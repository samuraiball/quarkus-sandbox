package dev.hirooka;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class EchoResourceTest {
    @Test
    void testEchoResource() {
        given().pathParam("value", "hello")
                .when().get("/echo/{value}")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }
}