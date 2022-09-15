package main.java.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    private final int TIMEOUT_APPLECARE = 5;
    private final int TIMEOUT_CART = 5;
    By addToCartButtonSelector = By.cssSelector("[name='submit.add-to-cart']");
    By noAppleCareSelector = By.cssSelector("#attachSiNoCoverage");
    By cartButtonSelector = By.cssSelector("#attach-view-cart-button-form");
    private static final Logger cap = LogManager.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Ajouter au panier
     * @return
     */

    public ProductPage addToCart(){
        WebElement addCartButton = driver.findElement(addToCartButtonSelector);
        addCartButton.click();
        return this;
    }

    /**
     * Refuser l'applecare
     * @return
     */

    public ProductPage refuseAppleCare(){
        cap.info("je n'accepte pas l'applecare");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_APPLECARE));
        WebElement noGarantyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(noAppleCareSelector));
        noGarantyButton.click();
        return this;
    }

    /**
     * ouvrir le panier
     * @return
     */

    public CartPage openCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_CART));
        WebElement basketButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cartButtonSelector));
        basketButton.click();
        return new CartPage(driver);
    }
}
