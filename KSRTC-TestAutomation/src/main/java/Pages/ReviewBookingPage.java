package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static java.lang.Thread.sleep;

public class ReviewBookingPage extends BasePage{
    private By agreeToTermsBtn= By.className("checkbox");
    private By proceedToPayBtn=By.xpath("//div[text()='PROCEED TO PAY']");

    public ReviewBookingPage(WebDriver driver)
    {
        super(driver);
    }

    public PaymentPage clickProceedToPay() throws InterruptedException {
        sleep(3500);
        clickOn(agreeToTermsBtn);
        clickOn(proceedToPayBtn);
        return new PaymentPage(driver);
    }
}
