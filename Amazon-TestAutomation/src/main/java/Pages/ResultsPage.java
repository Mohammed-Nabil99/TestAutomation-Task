package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends BasePage{
    private By firstResult= By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]");

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickFirstResult() {
        scrollTo(firstResult);
        clickOn(firstResult);
        return new ProductPage(driver);
    }
}