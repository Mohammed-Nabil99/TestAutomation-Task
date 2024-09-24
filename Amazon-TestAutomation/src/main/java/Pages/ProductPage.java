package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    private By addToCartBtn=By.id("add-to-cart-button");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickAddToCart() {
        clickOn(addToCartBtn);
        return new CartPage(driver);
    }
}