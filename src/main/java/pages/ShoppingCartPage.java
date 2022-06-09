package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;


public class ShoppingCartPage extends BasePage{
    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']")
    private WebElement price;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getElementPrice(){
        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return price;
    }

    public int getPrice() {
        int n= price.getText().length();
        return Integer.parseInt(price.getText().substring(0, n-2));
    }

}
