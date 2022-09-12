package carrefour.carrefour;

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
    private int TimeoutsRayon = 5;
    private By openRayons = By.cssSelector("span.mainbar__nav-toggle-icon");
    private By allerRayonSport = By.cssSelector("#data-menu-level-0 > li:nth-child(5) > a");
    private By meilleuresVentes= By.cssSelector("#data-menu-level-1_R26 > li:nth-child(3) > a");

    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
    }


    public ShoppingPage openRayons() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeoutsRayon));


        WebElement rayons = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.mainbar__nav-toggle-icon")));
        rayons.click();
        return this;


    }

    public ShoppingPage allerRayonSport() {
        WebElement sportLoisirs = driver.findElement(By.cssSelector("#data-menu-level-0 > li:nth-child(5) > a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sportLoisirs);
        actions.perform();
        return this;
    }




    public ShoppingPage meilleuresVentes () {
        WebElement affichermeilleuresVentes = driver.findElement(By.cssSelector("#data-menu-level-1_R26 > li:nth-child(3) > a"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(affichermeilleuresVentes);
        actions1.perform();
        return this;

    }



}
