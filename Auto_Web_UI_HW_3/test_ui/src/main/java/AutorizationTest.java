import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutorizationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");

        driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();

        driver.findElement(By.id("email")).sendKeys("testuserforhw@yandex.ru");
        driver.findElement(By.id("passwd")).sendKeys("1232311Aa");

        driver.findElement(By.id("SubmitLogin")).click();


        Thread.sleep(5000);
        driver.quit();
    }
}
