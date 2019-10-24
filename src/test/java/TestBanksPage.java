import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import srv.rucard.BasePage;
import srv.rucard.pages.BanksPage;

import java.util.concurrent.TimeUnit;

public class TestBanksPage extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://rucard.ru/banks");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.banksPage = new BanksPage(driver);
        jse = (JavascriptExecutor)driver;
        softAssert = new SoftAssert();
    }

//TESTS

    @Test
    public void backToMainPage() {
        basePage.backToMainPage();
    }
    @Test
    public void offeringButtonCheck() {
        basePage.giveOfferingClick();
        banksPage.giveOfferingIsPresent();
    }
    @Test
    public void numerationOfBlocksCheck() {
        banksPage.numerationOfBlocks();
    }
    @Test
    public void programsBlockButtonsCheck() {
        banksPage.programsButtonsClick();
    }
    @Test
    public void cardsBlockButtonsCheck() {
        banksPage.cardsButtonClick();
    }
    @Test
    public void textOnPageCheck() {
        banksPage.textsAssertCheck();
    }
    @Test
    public void colorsCheck() throws InterruptedException {
        banksPage.leftMenuColorScroll();
    }
    @Test
    public void goToYandexMaps() {
        basePage.goToYandexMaps();
        basePage.checkYandexMapsCoordinates();
    }
}
