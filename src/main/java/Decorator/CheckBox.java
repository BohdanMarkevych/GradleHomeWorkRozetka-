package Decorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class CheckBox extends AbstractElement{
    public static Logger logger = Logger.getLogger((CheckBox.class).toString());
    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public void mySetChecked(boolean shouldBeChecked){
        if (webElement.isSelected() && !shouldBeChecked){
            webElement.click();
        }
        else {
            logger.info("Element is checked!");
        }
    }
}
