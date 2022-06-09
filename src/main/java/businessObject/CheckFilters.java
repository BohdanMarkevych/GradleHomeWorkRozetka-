package businessObject;

import pages.HomePage;
import pages.SearchResultPage;

import java.util.Objects;

public class CheckFilters {

    public void takeCheckBox(SearchResultPage searchResultPage, long DEFAULT_WAITING_TIME, String brand) throws InterruptedException {
        Thread.sleep(1000);
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        searchResultPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchResultPage.getSearchField());
        searchResultPage.waitForElementIsClicable(DEFAULT_WAITING_TIME, searchResultPage.getSearchField());
        searchResultPage.searchBrend(brand);
        switch (brand) {
            case "HP":
                searchResultPage.takeCheckBoxHP();
                break;
            case "Samsung":
                searchResultPage.takeCheckBoxSamsung();
                break;
            case "Apple":
                searchResultPage.takeCheckBoxApple();
                break;
        }
    }

    public void takeExpensiveItem(SearchResultPage searchResultPage, long DEFAULT_WAITING_TIME) throws InterruptedException {
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        searchResultPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchResultPage.getSearchField());
        Thread.sleep(1000);
        searchResultPage.takeExpensiveItem();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        searchResultPage.waitForElementIsClicable(DEFAULT_WAITING_TIME, searchResultPage.getCartButtons());
        searchResultPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchResultPage.getSearchField());
        Thread.sleep(1000);
        searchResultPage.clickCartButtonOnFirstProduct();
    }

    public void clickFirstItem(HomePage homePage, long DEFAULT_WAITING_TIME){
        homePage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, homePage.getHeaderCartButton());
        homePage.clickHeaderCartButton();
    }

}
