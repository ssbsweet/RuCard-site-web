import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import srv.rucard.BasePage;
import srv.rucard.pages.GiftCardPage;

import java.util.concurrent.TimeUnit;

public class TestGiftCardPage extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://rucard.ru/giftcard");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.giftCardPage = new GiftCardPage(driver);
        jse = (JavascriptExecutor) driver;
    }

//TESTS

    @Test
    public void backToMainPageCheck() {
        basePage.backToMainPage();
    }
    @Test
    public void goToYandexMapsCheck() {
        basePage.goToYandexMaps();
        basePage.checkYandexMapsCoordinates();
    }
    @Test
    public void numerationOfBlocksCheck() {
        giftCardPage.numerationOfBlocks();
    }
    @Test
    public void consultationFooterFormEnableCheck() {
        giftCardPage.consultationFooterButtonClick();
    }
}
