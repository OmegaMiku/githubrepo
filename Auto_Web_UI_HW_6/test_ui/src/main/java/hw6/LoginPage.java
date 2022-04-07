package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwdField;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    public MyAccountPage login(String email, String passwd) {
        emailField.sendKeys(email);
        passwdField.sendKeys(passwd);
        submitLoginButton.click();
        return new MyAccountPage(driver);
    }
}
