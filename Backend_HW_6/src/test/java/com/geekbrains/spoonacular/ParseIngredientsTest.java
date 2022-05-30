package com.geekbrains.spoonacular;



import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ParseIngredientsTest extends SpoonacularTest {

    @Test
    void ParseIngredients() {

        given()
                .param("ingredientList", "1 cup green tea")
                .param("servings", 1)
                .param("includeNutrition", "true")
                .expect()
                .body("id[0]", is(10014355))
                .body("original[0]", is("1 cup green tea"))
                .body("originalName[0]", is("green tea"))
                .body("name[0]", is("tea"))
                .body("amount[0]", is(1.0F))
                .body("unit[0]", is("cup"))
                .body("unitShort[0]", is("cup"))
                .body("unitLong[0]", is("cup"))
                .log()
                .body()
                .when()
                .post("recipes/parseIngredients");
    }

}
