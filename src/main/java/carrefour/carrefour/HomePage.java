package carrefour.carrefour;

import carrefour.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    private By toutAccepter = By.cssSelector("div.banner-actions-container");
    private By openMaisoLoisir = By.cssSelector("div.banner-actions-container");
    public HomePage (WebDriver driver){
        this.driver = driver;

    }
    public carrefour.HomePage toutAccepter () {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement cookieButton = wait.until( ExpectedConditions.elementToBeClickable(By.cssSelector("div.banner-actions-container")));
        cookieButton.click();
        return this;
    }
    public ShoppingPage openMaisonLoisir() {
        WebElement afficherloisirs = driver.findElement(By.cssSelector("#data-top-bar"));
        afficherloisirs.click();
        return new ShoppingPage(driver);

    }




}
