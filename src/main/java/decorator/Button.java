package decorator;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Button extends AbstractElement {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public Button(WebElement webElement) {
        super(webElement);
    }

        public void click() {
            try {
                webElement.click();
            } catch (ElementClickInterceptedException e){
                new WebDriverWait(getDriver(), Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(webElement));
            }
    }
}
