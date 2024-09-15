package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.CartPage;
import Pages.WomenFragrancesPage;

public class WomenFragrancesTest {
    WebDriver driver;
    WomenFragrancesPage womenFragrancesPage;
    CartPage cartPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.o2morny.com/");

        womenFragrancesPage = new WomenFragrancesPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void verifyTotalCostAtCheckout() {
        // Navigate to Women Fragrances
        womenFragrancesPage.goToWomenFragrances();

        // Add items under 2500 LE to the cart
        womenFragrancesPage.addItemsUnder2500LEToCart();

        // Verify total cost
        int totalCost = cartPage.getTotalCost();
        Assert.assertTrue(totalCost > 0, "Total cost should be more than 0.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
