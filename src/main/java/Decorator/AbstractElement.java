package Decorator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.util.List;

public abstract class AbstractElement implements WebElement {
    protected WebElement webElement;

    public AbstractElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public static class ExtendedFieldDecorator extends DefaultFieldDecorator {
        public ExtendedFieldDecorator(ElementLocatorFactory factory) {
            super(factory);
        }

        @Override
        public Object decorate(ClassLoader loader, Field field) {
            if (field.getType().equals(CheckBox.class)) {
                ElementLocator locator = factory.createLocator(field);
                if (locator == null) {
                    return null;
                }
                return new CheckBox(proxyForLocator(loader, locator)) {
                };
            }
            else if(field.getType().equals(Button.class)){
                ElementLocator locator = factory.createLocator(field);
                if (locator == null) {
                    return null;
                }
                return new Button(proxyForLocator(loader, locator)) {
                };
            }
            else if(field.getType().equals(TextInput.class)){
                ElementLocator locator = factory.createLocator(field);
                if (locator == null) {
                    return null;
                }
                return new TextInput(proxyForLocator(loader, locator)) {
                };
            }
            return super.decorate(loader, field);
        }
    }



    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
