package businessObject;

import pages.ShoppingCartPage;

public class CheckPrice {
    public int checkPrice(ShoppingCartPage shoppingCartPage, long DEFAULT_WAITING_TIME){
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, shoppingCartPage.getElementPrice());
       return shoppingCartPage.getPrice();
    }
}
