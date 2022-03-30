package hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPracticeTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
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
    void autorizationTest() {
        driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='center_column']"))));

        Assertions.assertTrue(driver.findElement(By.id("email")).isDisplayed());
        driver.findElement(By.id("email")).sendKeys("testuserforhw@yandex.ru");

        Assertions.assertTrue(driver.findElement(By.id("passwd")).isDisplayed());
        driver.findElement(By.id("passwd")).sendKeys("1232311Aa");

        Assertions.assertTrue(driver.findElement(By.id("SubmitLogin")).isDisplayed());
        driver.findElement(By.id("SubmitLogin")).click();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
