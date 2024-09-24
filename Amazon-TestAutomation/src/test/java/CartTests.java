import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
public class CartTests extends BaseTests{

    @Test
    public void testAddItemToCart() {
        var resultsPage=homePage.search("car accessories");
        var productPage=resultsPage.clickFirstResult();
        var cartPage=productPage.clickAddToCart();
        String actualMessage= cartPage.getCartStatus();
        String expectedMessage= "Added to Cart";
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
