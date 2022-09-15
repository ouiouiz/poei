package test.java;

import main.java.amazon.CartPage;
import main.java.amazon.HomePage;

import main.java.commun.SetupTeardowm;
import org.testng.Assert;

import org.testng.annotations.Test;

public class TpPageObject extends SetupTeardowm {


   // ChromeOptions options = new ChromeOptions();
    //FirefoxOptions options2 = new FirefoxOptions();
   // EdgeOptions options3 = new EdgeOptions();


    final String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
    final int searchResultIndex = 0;
    final int quantityIndex = 2;

    //Expected results:
    final String expectedProductName = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
    final String expectedSubTotal = "Sous-total (2 articles):";
    final String expectedSize = "256Go";
    final String expectedColor = "Vert alpin";
    final String expectedCongig = "Sans AppleCare+";



    @Test
    public void testPO() {
        //Action
        HomePage homePage = new HomePage(driver);

        CartPage cartPage = homePage.acceptCookies()
                .searchWithButton(searchKeyword)
                .OpenSearchResult(searchResultIndex)
                .addToCart()
                .refuseAppleCare()
                .openCart()
                .selectQuantity(quantityIndex);

        //Assert
        Assert.assertEquals(cartPage.getFirstProductName(), expectedProductName, "Le titre du produit est incorrect");
        Assert.assertEquals(cartPage.getFirstProductCapacity(), expectedSize, "La taille affichée n'est pas correcte");
        Assert.assertEquals(cartPage.getFirstProductColor(), expectedColor, "La couleur affichée n'est pas correcte");
        Assert.assertEquals(cartPage.getFirstProductSubConfiguration(), expectedCongig, "La config affichée n'est pas correcte");

        //Cas particulier
        Assert.assertEquals(cartPage.GetFirstProductSubTotalCart(), expectedSubTotal, "Le nombre de produits est incorrect");
    }



}
