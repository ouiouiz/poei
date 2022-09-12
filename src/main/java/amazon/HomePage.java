package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By acceptCookieSelector =  By.cssSelector("[data-cel-widget=sp-cc-accept]");
    private By SearchWithButton = By.cssSelector("[aria-label=Rechercher]");
    private By loupeButton    =By.cssSelector("[type=submit]");
    private final int TIMEOUT_COOKIE = 6;
    private  String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage acceptCookie () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();
        return this;
    }

        public HomePage SearchWithButton () {
            WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
            searchBar.sendKeys(searchKeyword);
            return this;

        }
        public SearchResultPage loupeButton () {
            WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
            loupeButton.click();
            return new SearchResultPage(driver);
        }




}
