package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage extends BasePage{
    private By goToBasketBtn= By.xpath("//a[@data-csa-c-type='button']");
    private By cartStatusMsg=By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartStatus(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartStatusMsg)).getText();
    }
}