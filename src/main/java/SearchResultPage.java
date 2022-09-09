import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    private WebDriver driver;
    private By openSearchResult = By.cssSelector("img.s-image");
    private int index = 0;


    public SearchResultPage (WebDriver driver) {
        this.driver= driver;

    }
    public void openSearchResult(int index) {
    List<WebElement> resultatList = driver.findElements(By.cssSelector("img.s-image"));
            resultatList.get(0).click();


   }
}
