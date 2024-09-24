import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class BookingTests extends BaseTests{


    @Test(priority = 1)
    public void testSearchingTrip() throws InterruptedException {
        homePage.selectDeparture("Chikkamagaluru");
        homePage.selectDestination("Bengaluru");
        homePage.setDepartureDate("27","9","2024");
        var bookingPage=homePage.clickSearchBuses();
        String actualResult=bookingPage.getResultTxt();
        String expectedResult="Chikkamagaluru";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @DataProvider(name = "CustomerData")
    public Object[][] dpMethodCustomer(){
        return new Object[][] {{"6789125987", "Test2020@test.com"}, {"6789125900", "Test2021@test.com"}};
    }

    @Test(priority = 2,dataProvider = "CustomerData")
    public void testValidCustomerDetails(String MobileNum, String email) throws InterruptedException {
        homePage.selectDeparture("Chikkamagaluru");
        homePage.selectDestination("Bengaluru");
        homePage.setDepartureDate("27","9","2024");
        var bookingPage=homePage.clickSearchBuses();
        bookingPage.clickSelectSeats();
        bookingPage.selectSeat();
        bookingPage.selectFirstBoardingPoint();
        bookingPage.selectFirstDroppingPoint();
        bookingPage.clickProvidePassengerDetails();
        bookingPage.setCustomerDetails(MobileNum,email);
        Assert.assertTrue(bookingPage.isProceedToCheckoutEnabled());
    }

    @Test(priority = 3)
    public void testCheckout() throws InterruptedException {
        homePage.selectDeparture("Chikkamagaluru");
        homePage.selectDestination("Bengaluru");
        homePage.setDepartureDate("27","9","2024");
        var bookingPage=homePage.clickSearchBuses();
        bookingPage.clickSelectSeats();
        bookingPage.selectSeat();
        bookingPage.selectFirstBoardingPoint();
        bookingPage.selectFirstDroppingPoint();
        bookingPage.clickProvidePassengerDetails();
        bookingPage.setCustomerDetails("6789125987","test123@test.com");
        var reviewPage=bookingPage.setPassengerDetails("Ali","male","23",
                "General", "PAN", "123456");
        var paymentPage=reviewPage.clickProceedToPay();
        paymentPage.setCardMethod();
        paymentPage.setCardDetails("5000333641352301","0225","100");
        String actualTitle=paymentPage.getFrameTitle();
        String expectedTitle="Bus Booking Transaction";
        Assert.assertEquals(actualTitle,expectedTitle);
    }


}
