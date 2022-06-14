package rozetka.pages;


import decorator.Button;
import decorator.CheckBox;
import decorator.TextInput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//input[@_ngcontent-rz-client-c134]")
    private TextInput sidebarSearchInput;

    @FindBy(xpath = "//ul[@class='checkbox-filter']/descendant::a[@_ngcontent-rz-client-c136]")
    private List<WebElement> checkBoxBrandList;

    @FindBy(xpath = "//ul[@class='checkbox-filter']/descendant::a[@_ngcontent-rz-client-c136][1]")
    private Button checkBoxBrandElement;

    @FindBy(xpath = "//div[@class='goods-tile__inner']/descendant::app-buy-button[@extclass='goods-tile__buy-button']")
    private List<WebElement> addProductToCartButtonList;

    @FindBy(xpath = "//div[@class='goods-tile__inner']/descendant::app-buy-button[@extclass='goods-tile__buy-button'][1]")
    private Button addProductToCartPanel;

    @FindBy(xpath = "//select[@_ngcontent-rz-client-c181]")
    private Button sortProductButton;

    @FindBy(xpath = "//option[@class='ng-star-inserted']")
    private List<WebElement> sortProductButtonOptionsList;

    @FindBy(xpath = "//rz-cart/button[@type='button']")
    private Button cartButton;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void searchBrandByKeyword(String keyword){
        sidebarSearchInput.sendKeys(keyword, Keys.ENTER);
    }

    public Button getSortProductButton() {
        return sortProductButton;
    }

    public void filterBrandInCheckBox(){
        checkBoxBrandList.get(0).click();
    }

    public void clickSortProductOptionButton(){
       sortProductButton.click();
    }

    public void filterProductByPriceInOptionList(){
        //waitForPageLoadComplete(50);
        sortProductButtonOptionsList.get(0).click();
    }



    public void addFirstProductToCart(){
        //waitForPageLoadComplete(70);
        implicitWait(50);
        addProductToCartButtonList.get(0).click();
    }


    public void clickCartButton(){
        cartButton.click();
    }

}
