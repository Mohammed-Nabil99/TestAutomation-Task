package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BookingPage extends BasePage{
    private By selectSeatsBtn= By.className("selectbutton");
    private By firstBoardPoint=By.xpath("//div[@class='pick--val']");
    private By firstDropPoint =By.xpath("//div[@class='drop--val']");
    private By droppingList=By.xpath("//div[text()='Select Dropping Point']");
    private By seat=By.xpath("//div[@class=\"seats\"]/div/div[1]/div[@class=\"seatlook\"][7]");
    private By passDetailsBtn= By.className("btnPassDetails");
    private By custMobileField=By.name("mobileNo");
    private By custEmailField=By.name("email");
    private By proceedToPassDetailsBtn=By.xpath("//div[@class='navswitchbtn flex-all-c' and contains(text(),'PROCEED TO passenger detail as')]");
    private By passNameField=By.name("paxName[0]");
    private By passGenderField=By.name("paxGender[0]");
    private By passSearchField =By.id("searchInput");
    private By passAgeField=By.name("paxAge[0]");
    private By passConcessionField=By.name("paxConcessionType[0]");
    private By passIdTypeField=By.name("paxIDCardType[0]");
    private By passIdNoField=By.name("paxIDCardNo[0]");
    private By proceedToCheckoutBtn=By.xpath("//div[text()='Proceed to Checkout']");
    private By resultTxt=By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div/div[4]/div[1]/div");

    public BookingPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickSelectSeats()
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement>elements= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selectSeatsBtn));
        WebElement tripIndex=elements.get(1);
        tripIndex.click();
    }

    public String getResultTxt(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultTxt)).getText();
    }

    public void selectSeat(){
        clickOn(seat);
    }

    public void selectFirstBoardingPoint(){
        clickOn(firstBoardPoint);
    }

    public void selectFirstDroppingPoint(){
        clickOn(droppingList);
        clickOn(firstDropPoint);
    }

    public void clickProvidePassengerDetails(){
        clickOn(passDetailsBtn);
    }

    public void setCustomerDetails(String MobileNum , String Email)
    {
        send(custMobileField,MobileNum);
        send(custEmailField,Email);
        clickOn(proceedToPassDetailsBtn);
    }

    public Boolean isProceedToCheckoutEnabled(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutBtn)).isEnabled();
    }

    public ReviewBookingPage setPassengerDetails(String Name,String Gender, String Age,
                                    String ConcessionType, String IdType, String IdNum)
    {
        send(passNameField,Name);
        clickOn(passGenderField);
        send(passSearchField,Gender+"\n");
        send(passAgeField,Age);
        clickOn(passConcessionField);
        send(passSearchField,ConcessionType+"\n");
        clickOn(passIdTypeField);
        send(passSearchField,IdType+"\n");
        send(passIdNoField,IdNum+"\n");
        clickOn(proceedToCheckoutBtn);

        return new ReviewBookingPage(driver);
    }
}
