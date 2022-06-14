package test;


import org.testng.Assert;
import rozetka.pages.HomePage;
import rozetka.pages.SearchResultPage;
import util.PropertiesReader;


public class AddToCartTest extends BaseTest {
    long DEFAULT_WAITING_TIME = new PropertiesReader().getDefaultWaitTime();


    @org.testng.annotations.Test(dataProvider = "useFilterData")
    public void verifyThatCartContainsBillThatIsLessThanSpecifiedSum(String type, String brand, int sum) {
        HomePage homePage = getHomePage();
        homePage.implicitWait(DEFAULT_WAITING_TIME);
        SearchResultPage searchResultPage = homePage.searchByKeyword(type);
        searchResultPage.searchBrandByKeyword(brand);
        searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
        searchResultPage.filterBrandInCheckBox();
        searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
        searchResultPage.clickSortProductOptionButton();
        searchResultPage.filterProductByPriceInOptionList();
        searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
        searchResultPage.addFirstProductToCart();
        searchResultPage.implicitWait(DEFAULT_WAITING_TIME);
        searchResultPage.clickCartButton();
        searchResultPage.waitForVisibilityOfElement(20, getShoppingCartPage().getCartReceiptIcon());
        Assert.assertTrue(getShoppingCartPage().getSumInCart() < sum);



    }
}

