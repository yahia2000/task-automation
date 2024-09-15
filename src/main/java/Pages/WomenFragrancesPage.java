package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WomenFragrancesPage {
    WebDriver driver;



    public WomenFragrancesPage(WebDriver driver) {
        this.driver = driver;
    }

   // Going to target page
    public void goToWomenFragrances() {
        driver.findElement(By.linkText("Fragrances")).click();
        driver.findElement(By.linkText("Women Fragrances")).click();
    }

    // Add items needed
    public void addItemsUnder2500LEToCart() {
        List<WebElement> prices = driver.findElements(By.className("item-price"));
        for (WebElement priceElement : prices) {
            String priceText = priceElement.getText().replaceAll("[^0-9]", "");
            int price = Integer.parseInt(priceText);

            if (price < 2500) {
                WebElement addToCartButton = priceElement.findElement(By
                        .xpath("//button[text()='Add to Cart']"));
                addToCartButton.click();
            }
        }
    }
}
