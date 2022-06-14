package rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span[not(@class='cart-receipt__sum-currency')]")
    private WebElement cartReceiptIcon;

    public int getSumInCart() {
        return Integer.parseInt(cartReceiptIcon.getText());
    }

    public WebElement getCartReceiptIcon(){
        return cartReceiptIcon;
    }

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


}
