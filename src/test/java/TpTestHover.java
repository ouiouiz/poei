package test.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.commun.SetupTeardowm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TpTestHover extends SetupTeardowm {


    @Test
    public void testHover(){


        Actions actions = new Actions(driver);
        WebElement elementToHover = driver.findElement(By.cssSelector("#nav-link-accountList"));
        actions.moveToElement(elementToHover);
        actions.perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
