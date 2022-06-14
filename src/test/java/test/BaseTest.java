package test;

import model.SearchFilters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import rozetka.pages.HomePage;
import rozetka.pages.SearchResultPage;
import rozetka.pages.ShoppingCartPage;
import util.PropertiesReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private static final ThreadLocal<WebDriver> WEBDRIVER_THREADLOCAL = new ThreadLocal<WebDriver>();

    protected static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeTest
    public void profileSetUp(){
        chromedriver().setup();
        logger.info("Let's start!");
    }

    @BeforeMethod
    public void testsSetUp(){
        String ROZETKA_URL=new PropertiesReader().getURL();
        driver = new ChromeDriver();
        WEBDRIVER_THREADLOCAL.set(driver);
        driver = WEBDRIVER_THREADLOCAL.get();
        driver.manage().window().maximize();
        driver.get(ROZETKA_URL);
    }

@AfterMethod
    public void tearDown(){
    WebDriver driver = WEBDRIVER_THREADLOCAL.get();
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public HomePage getHomePage(){
        return new HomePage(getDriver());
    }

    public ShoppingCartPage getShoppingCartPage(){
        return new ShoppingCartPage(getDriver());
    }

    public SearchResultPage getSearchResultPage(){return new SearchResultPage(getDriver());
    }

    //@DataProvider(name = "useFilterData", parallel = true)
    @DataProvider(name = "useFilterData")
    public static Object[][] useFilterData() throws JAXBException {
        File file = new File("src\\main\\resources\\searchFilters.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(SearchFilters.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SearchFilters searchFilters = (SearchFilters) unmarshaller.unmarshal(file);
        Object[][] searchFiltersArray = searchFilters.getSearchFilterList().stream()
                .map(x -> new Object[]{
                        x.getProductType(), x.getBrand(), x.getAllowedSum()
                }).toArray(Object[][]::new);
        return searchFiltersArray;
    }
}



