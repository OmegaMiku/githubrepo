package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenSuggestBlock extends BaseView {

    public WomenSuggestBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Blouses']")
    private WebElement blousesButton;

    public BlousesPage blousesButtonClick() {
        blousesButton.click();
        return new BlousesPage(driver);
    }
}
