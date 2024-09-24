package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static java.lang.Thread.sleep;

public class TodayDealsPage extends BasePage {
    private By seeMore= By.linkText("See more");
    private By fourthRowProduct=By.xpath("//div[@data-test-index='12']");
    public TodayDealsPage(WebDriver driver){
        super(driver);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void setDepartment(String Department){
       clickOn(seeMore);
        By department=By.xpath("//span[@class='a-label a-radio-label']/span[text()='"+Department+"']");
        clickOn(department);
    }

    public void setDiscount(String Discount){
        By discount=By.xpath("//span[@class='a-label a-radio-label']/span[text()='"+Discount+"']");
        scrollTo(discount);
        clickOn(discount);
    }

    public ProductPage clickOnItem() throws InterruptedException {
        sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        clickOn(fourthRowProduct);
        return new ProductPage(driver);
    }
}