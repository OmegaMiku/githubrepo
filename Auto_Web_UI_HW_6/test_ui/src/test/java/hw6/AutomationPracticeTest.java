package hw6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class AutomationPracticeTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String AUTOMATIONPRACTICE_BASE_URL = "http://automationpractice.com/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(AUTOMATIONPRACTICE_BASE_URL);
    }

    @Test
    void addToCartTest() {
        new MainPage(driver)
                .clickSignInButton()
                .login("testuserforhw@yandex.ru", "1232311Aa")
                .hoverWomenButton()
                .blousesButtonClick()
                .selectSizeFilters("S")
                .hoverAndClickProductByName("Blouse");

        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='layer_cart']/div[@class='clearfix']"))));
        assertThat(driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']")), hasText("$29.00"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
