import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import java.time.Duration;
import java.util.List;
    public class TpPageObject {
        WebDriver driver;
        private  String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
         int quantity= 2;
         int index = 0;
         String taille;
         String couleur;
         String configuration;
         String totale;
        final String expectedTaille  = "256Go";
        final String expectedCouleur  = "Vert alpin";
        final String expectedConfiguration  = "Sans AppleCare+";
        final String expectedTotale  = "Sous-total (2 articles):";


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
        public void testPO() {
            HomePage homePage = new HomePage(driver);
            homePage.acceptCookie();
            homePage.SearchWithButton();
            homePage.loupeButton();

            SearchResultPage resultPage = new SearchResultPage(driver);
            resultPage.openSearchResult(index);

            ProductPage productPage = new ProductPage(driver);
            productPage.addToCart();
            productPage.refuseAppleCare();
            productPage.openCart();

            CartPage cartPage = new CartPage(driver);
            cartPage.selectQuantity(quantity);






   // Assert
            Assert.assertEquals(cartPage.getFirstProductName(),expectedTaille,"Taille pas bon");
            Assert.assertEquals(cartPage.getFirstProductCapacity(),expectedTaille,"Taille pas bon");
            Assert.assertEquals(cartPage.getFirstProductColor(),expectedCouleur ,"couleur pas bon");
            Assert.assertEquals(cartPage.getFirstProductConfiguration(),expectedConfiguration ,"config pas bon");
            Assert.assertEquals(cartPage.getSubtotalCart(),expectedTotale,"sous total pa bon");


        }

}
