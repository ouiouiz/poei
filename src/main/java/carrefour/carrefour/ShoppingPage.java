package carrefour.carrefour;

import carrefour.BestSellerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage {
    WebDriver driver;

    String info = "Sports, Loisirs et Mobilité urbaine";
    private int TimeoutsRayon= 5;
    private By openRayons = By.cssSelector("span.mainbar__nav-toggle-icon");

    public ShoppingPage (WebDriver driver) {
        this.driver= driver;
    }



    public ShoppingPage openRayons  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeoutsRayon));


        WebElement rayons = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.mainbar__nav-toggle-icon")));
        rayons.click();
        return this;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void allerRayonSport () {
        WebElement sportLoisirs = driver.findElement(By.cssSelector("#data-menu-level-0 > li:nth-child(5) > a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sportLoisirs);
        actions.perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public BestSellerPage meilleursVentes() {
        WebElement meilleuresVentes = driver.findElement(By.cssSelector("#data-menu-level-1_R26 > li:nth-child(3) > a"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(meilleuresVentes);
        actions1.perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        public BestSellerPage meilleuresvente () {
        WebElement meilleuresVente = driver.findElement(By.cssSelector("#data-menu-level-1_R26 > li:nth-child(3) > a"));
        meilleuresVente.click();
        return new BestSellerPage(driver);
    }







}
