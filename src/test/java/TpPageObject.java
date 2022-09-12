import amazon.CartPage;
import amazon.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
            CartPage cartPage = new CartPage(driver);

            cartPage = homePage.acceptCookie()
                    .SearchWithButton()
                    .loupeButton()
                    .openSearchResult(index)
                    .addToCart()
                    .refuseAppleCare()
                    .openCart()
                    .selectQuantity(quantity);


   // Assert
            Assert.assertEquals(cartPage.getFirstProductName(),expectedTaille,"Taille pas bon");
            Assert.assertEquals(cartPage.getFirstProductCapacity(),expectedTaille,"Taille pas bon");
            Assert.assertEquals(cartPage.getFirstProductColor(),expectedCouleur ,"couleur pas bon");
            Assert.assertEquals(cartPage.getFirstProductConfiguration(),expectedConfiguration ,"config pas bon");
            Assert.assertEquals(cartPage.getSubtotalCart(),expectedTotale,"sous total pa bon");
        }

}
