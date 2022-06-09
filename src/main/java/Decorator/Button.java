package Decorator;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class Button extends AbstractElement{
    public static Logger logger = Logger.getLogger((Button.class).toString());
    public Button(WebElement webElement) {
        super(webElement);
    }
    public void myClick(){
        try{
            webElement.click();
        }
        catch (ElementClickInterceptedException e){
            logger.info("ElementClickInterceptedException!");
        }
    }
}
