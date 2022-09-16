package main.java.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    final int TIMEOUT_COOKIE = 6;
    By acceptCookiesSelector = By.cssSelector("\".a-button-input.celwidget\"");
   By searchBarSelector = By.cssSelector("#twotabsearchtextbox");
    //@FindBy(css = ".a-button-input.celwidget") private WebElement searchBarSelector;
    By magnifierButton = By.cssSelector("#nav-search-submit-button");

   protected static final Logger Log = LogManager.getLogger(HomePage.class);




    public HomePage(WebDriver driver){

        this.driver = driver;
    }

    /**
     * Accpter les cookies
     * @return
     */

    public HomePage acceptCookies(){

        Log.info("J'accepete les cookies");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookiesSelector));
        acceptButton.click();
        return this;
    }

    /**
     * Faire la recherche avec le bouton loupe
     * @param keyword
     * @return
     */

    public SearchResultPage searchWithButton(String keyword){
        Log.info("chercher le premier resultat");
        WebElement searchBar = driver.findElement(searchBarSelector);
        searchBar.sendKeys(keyword);
        WebElement loupe = driver.findElement(magnifierButton);
        loupe.click();

        return new SearchResultPage(driver);
    }
}
