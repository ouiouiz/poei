import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tp1Test { //new test


    @Test //Annotation
    public void test1() {

        System.out.println("Test Ouiza");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.fr/");
        driver.manage().window().maximize();

        driver.quit();
    }
    @Test
    public void testAmazon() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("IPhone pro 13");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

