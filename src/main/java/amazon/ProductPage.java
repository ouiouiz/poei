package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private int TimeoutsCart= 5;
    private int TimeoutAppleCare= 6;
    private int TimeoutopenCart= 5;

    private By addToCart = By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']");

    private By  refuseAppleCare = By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']");

    private By openCart = By.cssSelector("#attach-sidesheet-view-cart-button");


    public ProductPage (WebDriver driver) {
        this.driver = driver;
    }


    public ProductPage addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeoutsCart));
        WebElement ajouterAuPanierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']")));
        ajouterAuPanierButton.click();
        return this;
    }
   public ProductPage refuseAppleCare () {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeoutAppleCare));
       WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']")));
       nonmerci.click();
       return this;
   }


    public  CartPage openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeoutopenCart));
       WebElement panierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#attach-sidesheet-view-cart-button")));
       panierButton.click();
       return new CartPage(driver);


    }


}
