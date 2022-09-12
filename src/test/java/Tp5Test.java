import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Tp5Test {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    @Test
    public void testCSS() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonCookie= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
        searchBar.sendKeys("Coque iphone 13");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();

        WebElement premierResultat = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=MAIN-SEARCH_RESULTS-2]")));
        premierResultat.click();

        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        ajouterAuPanierButton.click();

        WebElement panierButton = driver.findElement(By.cssSelector("#nav-cart"));
        panierButton.click();

        driver.quit();
    }
}
