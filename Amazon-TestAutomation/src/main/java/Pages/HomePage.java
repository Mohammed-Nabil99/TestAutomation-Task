package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By searchField= By.id("twotabsearchtextbox");
    private By todayDeals=By.linkText("Today's Deals");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ResultsPage search(String text) {
        send(searchField, text+"\n");
        return new ResultsPage(driver);
    }

    public TodayDealsPage clickTodayDeals(){
        clickOn(todayDeals);
        return new TodayDealsPage(driver);
    }
}