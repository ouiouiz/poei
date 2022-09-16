package main.java.commun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class SetupTeardowm {
     protected WebDriver driver;
     String browser= "chrome";



    @BeforeMethod
    public void setup() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\Resources\\chromedriver.exe");
        //driver = new RemoteWebDriver(new URL("http://admin:admin@192.168.121.15:4449"), options);
      /*
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefoxe":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }
   */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
    }



    @AfterMethod
     public void teardown(ITestResult result) throws IOException, NoSuchAlgorithmException, KeyStoreException, InterruptedException, KeyManagementException {

        ImportResultsToXray res = new ImportResultsToXray();

        if(result.getStatus() == ITestResult.SUCCESS)
        {
            res.generateJsonResults( "PASSED");

        }
        else if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed **");
            res.generateJsonResults("FAILED");

         //Take screenshots
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source =  ts.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source , new File( System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png"));
        }
        else if(result.getStatus() == ITestResult.SKIP ){

            System.out.println("Skiped**");
            res.generateJsonResults("SKIPED");

        }
       // res.RemonteResultats();

        driver.quit();
    }
}
