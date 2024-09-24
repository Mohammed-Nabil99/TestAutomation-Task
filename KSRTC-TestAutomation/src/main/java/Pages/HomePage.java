package Pages;
import org.openqa.selenium.*;

public class HomePage extends BasePage{
    private By fromCityList=By.xpath("//div[@class=\"search-from-city\"]/div/div/div[@class=\"input-bottom-box\"][1]");
    private By fromCitySearch=By.xpath("//*[@id=\"fromCity_chosen\"]/div/div[1]/input");
    private By departCity =By.xpath("//*[@id=\"fromCity_chosen\"]/div/ul/li[1]");
    private By toCityList=By.xpath("//div[@class=\"search-to-city\"]/div/div/div[@class=\"input-bottom-box\"][1]");
    private By toCitySearch=By.xpath("//*[@id=\"toCity_chosen\"]/div/div[1]/input");
    private By destCity=By.xpath("//*[@id=\"toCity_chosen\"]/div/ul/li[1]");
    private By departDateList=By.id("departDate");
    private By searchBusesBtn=By.cssSelector("div#submitSearch");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectDeparture(String DepartureCity) throws InterruptedException {
        clickOn(fromCityList);
        Thread.sleep(1000);
        send(fromCitySearch,DepartureCity);
        clickOn(departCity);
    }

    public void selectDestination(String DestinationCity) throws InterruptedException {
        clickOn(toCityList);
        Thread.sleep(1000);
        send(toCitySearch,DestinationCity);
        clickOn(destCity);
    }

    public void setDepartureDate(String day, String month, String year) {
        clickOn(departDateList);
        int monthInt = Integer.parseInt(month);
        monthInt--;
        By date=By.xpath("//td[@data-month='"+monthInt+"'][@data-year='"+year+"']/a[text()='"+day+"']");
        clickOn(date);
    }

    public BookingPage clickSearchBuses(){
        clickOn(searchBusesBtn);
        return new BookingPage(driver);
    }
}
