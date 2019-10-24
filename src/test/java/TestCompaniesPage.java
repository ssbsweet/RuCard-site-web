import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import srv.rucard.BasePage;
import srv.rucard.pages.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TestCompaniesPage extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://rucard.ru/companies");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.companiesPage = new CompaniesPage(driver);
        jse = (JavascriptExecutor)driver;
        softAssert = new SoftAssert();
    }

//TESTS

    @Test
    public void backToMainPage() {
        basePage.backToMainPage();
    }
    @Test
    public void giveOfferingCheck() {
        companiesPage.giveOfferingOpen();
    }
    @Test
    public void numerationOfBlocksCheck() {
        companiesPage.numerationOfBlocks();
    }
    @Test
    public void selfServiceDevicesTextCheck() {
        companiesPage.getSelfServiceDevicesTexts();
    }
    @Test
    public void cardButtonsCheck() {
        companiesPage.cardsButtonClick();
    }
    @Test
    public void colorsCheck() throws InterruptedException {
        companiesPage.leftMenuColorScroll();
    }
    @Test
    public void goToYandexMaps() {
        basePage.goToYandexMaps();
        basePage.checkYandexMapsCoordinates();
    }
}
