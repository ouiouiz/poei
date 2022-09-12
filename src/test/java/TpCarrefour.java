import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;



public class TpCarrefour {
    WebDriver driver;
    private Actions action;
         /*
        //Arrange
        // public String info = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
        final String expectedTaille = "256Go";
        final String expectedCouleur= "Vert alpin";
        final String expectedConfiguration= "Sans AppleCare+";
        final String expectedsousTotale= "Sous-total (1 article) ";

          */

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.carrefour.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test() {

        // Act

















/*
            WebElement  livraisonDomicile = driver.findElement(By.cssSelector("ds-body-text ds-body-text--size-m ds-body-text--color-standard-11"));
            livraisonDomicile.click();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
*/


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        WebElement ajouterPanier = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mainDetailNonFoodPdpButtonContainer"))) ;

        ajouterPanier.click();

        WebElement openPanier = driver.findElement(By.cssSelector("div.basket-resum-cta__amount-label"));
        openPanier.click();

/*
            WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
            Select categorieSelect = new Select(dropdown);
            categorieSelect.selectByIndex(2);

            List<WebElement> infos = driver.findElements(By.cssSelector(".a-text-bold + span"));
            WebElement Taille = infos.get(0);
            WebElement Couleur= infos.get(1);
            WebElement Configuration= infos.get(2);
            WebElement sousTotale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sc-subtotal-label-activecart")));


            //Assert

            Assert.assertEquals(Taille.getText(), expectedTaille, "Taille pas bonne" );

            Assert.assertEquals(Couleur.getText(), expectedCouleur, "Couleur pas bonne");

            Assert.assertEquals(Configuration.getText(), expectedConfiguration, "Cinfiguration pas bonne");


            Assert.assertEquals(sousTotale.getText(), expectedsousTotale, "sousTotal Bon");


    */

    }

}


