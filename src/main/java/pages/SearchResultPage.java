package pages;

import Decorator.Button;
import Decorator.CheckBox;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{
    @FindBy(xpath = "//div[@class='sidebar-search']//input[@name='searchline']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@data-id='Samsung']")
    private CheckBox checkboxSamsung;

    @FindBy(xpath = "//a[@data-id='HP']")
    private CheckBox checkboxHP;

    @FindBy(xpath = "//a[@data-id='Apple']")
    private CheckBox checkboxApple;

    @FindBy(xpath = "//option[contains(@value, 'expensive')]")
    private Button expensiveItem;

    @FindBy(xpath = " //button[@class='buy-button goods-tile__buy-button ng-star-inserted']")
    private WebElement cartButtons;


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCartButtons(){return cartButtons;}

    public Button getExpensiveItem(){return expensiveItem;}

    public void clickCartButtonOnFirstProduct() {
       cartButtons.click();
   }

    public WebElement getSearchField() {
        return searchField;
    }

    public void takeExpensiveItem(){expensiveItem.myClick();}

    public void takeCheckBoxSamsung(){checkboxSamsung.mySetChecked(true);}
    public void takeCheckBoxHP(){checkboxHP.mySetChecked(true);}
    public void takeCheckBoxApple(){checkboxApple.mySetChecked(true);}
    public void searchBrend(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER);;
    }
    }

