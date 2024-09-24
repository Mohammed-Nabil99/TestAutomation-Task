package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage extends BasePage{
    private By cardMethod=By.xpath("//button[@method='card']");
    private By paymentFrame= By.className("razorpay-checkout-frame");
    private By cardNumField=By.id("card_number");
    private By cardExpiryField=By.id("card_expiry");
    private By cardCvvField=By.id("card_cvv");
    private By titleTxt=By.id("merchant-desc");

    public PaymentPage(WebDriver driver)
    {
        super(driver);
    }

    public void setCardMethod(){
        switchToPaymentFrame();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement card =wait.until(ExpectedConditions.visibilityOfElementLocated(cardMethod));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", card);
        clickOn(cardMethod);
    }

    public void setCardDetails(String CardNumber, String Expiry, String CVV)
    {
        send(cardNumField,CardNumber);
        send(cardExpiryField,Expiry);
        send(cardCvvField,CVV);
    }

    public String getFrameTitle(){
        return driver.findElement(titleTxt).getText();
    }

    private void switchToPaymentFrame(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement frame =wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFrame));
        driver.switchTo().frame(frame);
    }
}
