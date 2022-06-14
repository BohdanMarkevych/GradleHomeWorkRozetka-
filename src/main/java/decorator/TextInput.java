package decorator;

import org.openqa.selenium.WebElement;

public class TextInput extends AbstractElement {

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(CharSequence... charSequences) {
        webElement.clear();
        webElement.sendKeys(charSequences);
    }
}

