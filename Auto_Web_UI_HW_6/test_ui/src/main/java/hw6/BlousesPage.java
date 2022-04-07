package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BlousesPage extends BaseView {

    public BlousesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Size']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> sizeList;

    public BlousesPage selectSizeFilters(String size) {
        sizeList.stream().filter(s -> s.getText().contains(size)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//ul[contains(@class, 'product_list')]")
    private List<WebElement> productsList;

    @FindBy(xpath = "//span[.='Add to cart']")
    WebElement addToCartButton;

    public BlousesPage hoverAndClickProductByName(String productName) {
        actions.moveToElement(productsList.stream().filter(s -> s.getText().contains(productName)).findFirst().get())
                .build().perform();
        addToCartButton.click();
        return this;
    }
}
