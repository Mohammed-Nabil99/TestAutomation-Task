import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class CategoryTests extends BaseTests{
    @Test
    public void testTodayDealsCategory() throws InterruptedException {
        var todayPage=homePage.clickTodayDeals();
        String actualTitle=todayPage.getPageTitle();
        String expectedTitle = "Today's Deals";
        assertTrue(actualTitle.contains(expectedTitle));
    }
}
