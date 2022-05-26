package org.example.spoonacular;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;


public class ImageClassificationTest extends SpoonacularTest {

    @Test
    void testBurgerClassification() {
        given()
                .multiPart(getFile("brownie.jpg"))
                .expect()
                .body("category", is("brownies"))
                .body("probability", greaterThan(0.3F))
                .log()
                .body()
                .when()
                .post("food/images/classify");
    }
}
