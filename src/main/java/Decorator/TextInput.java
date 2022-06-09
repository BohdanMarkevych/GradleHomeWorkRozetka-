package Decorator;

import org.openqa.selenium.WebElement;

public class TextInput extends AbstractElement{
    public TextInput(WebElement webElement) {
        super(webElement);
    }
    public void mySendKeys(CharSequence... charSequence){
        webElement.clear();
        webElement.sendKeys(charSequence);
    }
}
