package org.example.spoonacular;

import org.example.PriceItem;
import io.restassured.RestAssured;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.is;

public class RecipesTest {

    private static final String API_KEY = "c3493dd4483a467cb188f45af01882d4";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com/recipes/";
    }

    @Test
    void getSimilarRecipes () throws IOException {
        String actually = given()
                .log()
                .all()
                .param("apiKey", API_KEY)
                .pathParam("id",715538)
                .expect()
                .log()
                .body()
                .when()
                .get("{id}/similar")
                .body()
                .prettyPrint();

        String expected = getResourceAsString("getSimilarRecipes/expected.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER));
    }

    @Test
    void testPriceBreakdownById () {

        PriceItem target = new PriceItem("blueberries.jpg", "blueberries", 174.43F);

        given()
                .log()
                .all()
                .param("apiKey", API_KEY)
                .pathParam("id", 1003464)
                .expect()
                .log()
                .body()
                .body("ingredients[0].name", is("blueberries"))
                .body("ingredients[0].image", is("blueberries.jpg"))
                .body("ingredients[0].price", is(174.43F))
                .when()
                .get("{id}/priceBreakdownWidget.json");
    }

    @Test
    void convertAmounts() {
        given()
                .log()
                .all()
                .param("apiKey", API_KEY)
                .param("ingredientName", "flour")
                .param("sourceAmount", "2.5")
                .param("sourceUnit", "cups")
                .param("targetUnit", "grams")
                .expect()
                .log()
                .body()
                .body("sourceAmount", is(2.5F))
                .body("sourceUnit", is("cups"))
                .body("targetAmount", is(312.5F))
                .body("targetUnit", is("grams"))
                .body("answer", is("2.5 cups flour are 312.5 grams."))
                .body("type", is("CONVERSION"))
                .when()
                .get("convert");
    }

    @Test
    void summarizeRecipe() {
        given()
                .log()
                .all()
                .param("apiKey", API_KEY)
                .pathParam("id", 4632)
                .expect()
                .log()
                .body()
                .body("id", is(4632))
                .body("title", is("Soy-and-Ginger-Glazed Salmon with Udon Noodles"))
                .when()
                .get("{id}/summary");

    }

    @Test
    void getMenuItemInformation() {

        given()
                .log()
                .all()
                .baseUri("https://api.spoonacular.com/food/")
                .param("apiKey", API_KEY)
                .pathParam("id", 424571)
                .expect()
                .log()
                .body()
                .body("id", is(424571))
                .body("title", is("Bacon King Burger"))
                .body("likes", is(0.0F))
                .when()
                .get("menuItems/{id}");
    }

    public String getResourceAsString(String resource) throws IOException {
        InputStream stream = getClass().getResourceAsStream(resource);
        assert stream != null;
        byte[] bytes = stream.readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
