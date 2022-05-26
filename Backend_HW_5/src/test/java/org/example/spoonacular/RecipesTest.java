package org.example.spoonacular;

import org.example.PriceItem;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RecipesTest extends SpoonacularTest {


    @Test
    void getSimilarRecipes () throws Exception {
        String actually = given()
                .pathParam("id",715538)
                .expect()
                .when()
                .get("recipes/{id}/similar")
                .body()
                .prettyPrint();

        String expected = getResource("expected.json");

        assertJson(expected, actually);
    }

    @Test
    void testPriceBreakdownById () {

        PriceItem target = new PriceItem("blueberries.jpg", "blueberries", 174.43F);

        given()
                .pathParam("id", 1003464)
                .expect()
                .body("ingredients[0].name", is("blueberries"))
                .body("ingredients[0].image", is("blueberries.jpg"))
                .body("ingredients[0].price", is(174.43F))
                .log()
                .body()
                .when()
                .get("recipes/{id}/priceBreakdownWidget.json");
    }

    @Test
    void convertAmounts() {
        given()
                .param("ingredientName", "flour")
                .param("sourceAmount", "2.5")
                .param("sourceUnit", "cups")
                .param("targetUnit", "grams")
                .expect()
                .body("sourceAmount", is(2.5F))
                .body("sourceUnit", is("cups"))
                .body("targetAmount", is(312.5F))
                .body("targetUnit", is("grams"))
                .body("answer", is("2.5 cups flour are 312.5 grams."))
                .body("type", is("CONVERSION"))
                .log()
                .body()
                .when()
                .get("recipes/convert");
    }

    @Test
    void summarizeRecipe() {
        given()
                .pathParam("id", 4632)
                .expect()
                .body("id", is(4632))
                .body("title", is("Soy-and-Ginger-Glazed Salmon with Udon Noodles"))
                .log()
                .body()
                .when()
                .get("recipes/{id}/summary");

    }

    @Test
    void getMenuItemInformation() {

        given()
                .pathParam("id", 424571)
                .expect()
                .body("id", is(424571))
                .body("title", is("Bacon King Burger"))
                .body("likes", is(0.0F))
                .log()
                .body()
                .when()
                .get("food/menuItems/{id}");
    }
}
