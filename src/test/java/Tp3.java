import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tp3 {
    @Test
    public void testCSS() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();
        /*
        WebElement touteButton = driver.findElement(By.cssSelector("[.hm-icon-label]"));
        touteButton.click();
        */
        WebElement touteButton = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        touteButton.click();

        WebElement troisiemeButton = driver.findElement(By.cssSelector ("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(4) > a"));
        troisiemeButton.click();

    }

}
