import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import srv.rucard.BasePage;
import srv.rucard.pages.AboutPage;

import java.util.concurrent.TimeUnit;

public class TestAboutPage extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://rucard.ru/about");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.aboutPage = new AboutPage(driver);
        jse = (JavascriptExecutor)driver;
    }

//TESTS

    @Test
    public void backToMainPage() {
        basePage.backToMainPage();
    }
    @Test
    public void checkNumerationOfBlocks() {
        aboutPage.numerationOfBlocks();
    }
    @Test
    public void giftCards() {
        aboutPage.goToPolicyForTheProcessingAndProtectionOfPersonalDataPdf();
        basePage.switchTab();
        aboutPage.giftCardsUrlCheck();
    }@Test
    public void goToYandexMaps() {
        basePage.goToYandexMaps();
        basePage.checkYandexMapsCoordinates();
    }

}
