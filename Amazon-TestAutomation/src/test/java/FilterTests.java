import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class FilterTests extends BaseTests {
    @DataProvider(name = "Departments")
    public Object[][] dpMethodDepartments(){
        return new Object[][] {{"Grocery"},{"Books"}};
    }

    @Test(dataProvider = "Departments")
    public void testFilterByDepartment(String Departments) throws InterruptedException {
        var todayPage=homePage.clickTodayDeals();
        todayPage.setDepartment(Departments);
        todayPage.setDiscount("10% off or more");
        var productPage=todayPage.clickOnItem();
        var cartPage=productPage.clickAddToCart();
        String actualMessage= cartPage.getCartStatus();
        String expectedMessage= "Added to Cart";
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
