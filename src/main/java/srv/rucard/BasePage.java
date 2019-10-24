package srv.rucard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import srv.rucard.pages.*;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class BasePage extends PageObject {
    protected static WebDriver driver;
    public static JavascriptExecutor jse;
    public static Actions actions;
    public static SoftAssert softAssert;
    public MainPage mainPage;
    public BanksPage banksPage;
    public CompaniesPage companiesPage;
    public LoyaltyPage loyaltyPage;
    public ContactsPage contactsPage;
    public AboutPage aboutPage;
    public GiftCardPage giftCardPage;
    public VirtualCardPage virtualCardPage;
    public LoyaltyCardPage loyaltyCardPage;
    public CoalitionPage coalitionPage;
    public MenuMain menuMain;
    public BasePage basePage;

//UNIVERSALS LOCATORS

    @FindBy(css = ".logo__image")
    private WebElement site_logo;

    @FindBy(css = ".clipboard__action-wrapper")
    private WebElement yandex_coordinates;

    @FindBy(css = ".Address-hobn3y-0")
    private WebElement yandexMapsGo;

    @FindBy(css = ".Button-sc-1wudyxw-0.gazvzc")
    private WebElement giveOffering;

//SUPER DRIVER

    public BasePage() {
        super(driver);
    }

//BEFORE AND AFTER

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
    }
    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

//UNIVERSAL OPERATIONS

    public void backToMainPage() {
        this.site_logo.click();
        assertEquals(driver.getCurrentUrl(), "http://rucard.srv.lan/", "!Пользователь не на главной странице!");
    }
    public void goToYandexMaps() {
        this.yandexMapsGo.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }
    public void checkYandexMapsCoordinates() {
        assertEquals(this.yandex_coordinates.getText(), "55.793464, 37.563503", "!Координаты отличаются!");
    }
    public void giveOfferingClick() {
        this.giveOffering.click();
    }
    public void switchTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }
}