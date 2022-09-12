package carrefour.carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BestSellerPage {
    WebDriver driver;

    public BestSellerPage(WebDriver driver) {
        this.driver = driver;
    }
public CartPage openBestSellerProduct () {

    List<WebElement> firstResult = driver.findElements(By.cssSelector("a.product-card-image"));
    firstResult.get(20).click();
    try {
        Thread.sleep(6000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

}


}