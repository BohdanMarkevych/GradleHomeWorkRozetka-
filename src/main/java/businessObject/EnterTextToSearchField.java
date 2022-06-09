package businessObject;

import pages.HomePage;


public class EnterTextToSearchField {
    public void enterText(HomePage homePage, long DEFAULT_WAITING_TIME, String search ){
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        homePage.isSearchFieldVisible();
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        homePage.enterTextToSearchField(search);
    }
}
