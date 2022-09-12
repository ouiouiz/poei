package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

      private  WebDriver driver;
      private int TimeoutSubtotalCart= 4;
      private   int SubtotalBuybox= 5;
      private By selectQuantity = By.cssSelector("#quantity");
      private By  getFirstProductName = By.cssSelector(".a-text-bold + span");
      private By getSubtotalBuybox = By.cssSelector("a-section sc-buy-box-inner-box");
      private int index = 0;

      final String expectedTaille  = "256Go";
      final String expectedCouleur  = "Vert alpin";
      final String expectedConfiguration  = "Sans AppleCare+";
      final String expectedTotale  = "Sous-total (2 articles):";

      public CartPage (WebDriver driver) {
            this.driver= driver;

      }
     public CartPage selectQuantity(int quantity) {
           WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
           Select quantiteDropdown = new Select(dropdown);
           quantiteDropdown.selectByIndex(quantity);
           return this;
     }
     public String getFirstProductName() {
          WebElement informations = driver.findElement(By.cssSelector("a-truncate-cut"));
         return (informations.getText());
     }
     public String  getFirstProductCapacity() {
         List<WebElement> informations = driver.findElements(By.cssSelector(".a-text-bold + span"));
         WebElement taille = informations.get(0);
         return (taille.getText());

     }
      public String getFirstProductColor( ) {
          List<WebElement> informations = driver.findElements(By.cssSelector(".a-text-bold + span"));
          WebElement couleur = informations.get(1);
          return (couleur.getText());
      }
      public String  getFirstProductConfiguration() {
          List<WebElement> informations = driver.findElements(By.cssSelector(".a-text-bold + span"));
          WebElement configuration = informations.get(2);
          return(configuration.getText());
      }
      public String  getSubtotalCart() {
          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(TimeoutSubtotalCart));

          WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sc-subtotal-label-activecart")));
          return(soustotale.getText());
      }
      public String getSubtotalBuybox() {
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SubtotalBuybox));
          WebElement subTotalBuy = driver.findElement(By.cssSelector("a-section sc-buy-box-inner-box"));
          return(subTotalBuy.getText());



      }


}
