package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    WebDriver driver;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // calculate total price
    public int getTotalCost() {
        String totalCostText = driver.findElement(By.id("total-cost")).getText();
        return Integer.parseInt(totalCostText.replaceAll("[^0-9]", ""));
    }
}
