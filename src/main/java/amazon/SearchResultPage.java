package main.java.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    WebDriver driver;

    By firstSearchResultSelector = By.cssSelector("img.s-image");
    protected static final Logger Sog = LogManager.getLogger(SearchResultPage.class);

    public SearchResultPage(WebDriver driver){

        this.driver = driver;
    }

    /**
     * Ouvrir le resultat avec un index
     * @param index
     * @return
     */
    public ProductPage OpenSearchResult(int index) {
        Sog.info("Ouvrir le resultat");
        List<WebElement> listResults = driver.findElements(firstSearchResultSelector);
        listResults.get(index).click();

        return new ProductPage(driver);
    }
}
