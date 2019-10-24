import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import srv.rucard.BasePage;
import srv.rucard.pages.LoyaltyPage;

import java.util.concurrent.TimeUnit;

public class TestLoyaltyPage extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://rucard.ru/loyalty");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.loyaltyPage = new LoyaltyPage(driver);
        jse = (JavascriptExecutor)driver;
    }

//TESTS

    @Test
    public void backToMainPage() {
        basePage.backToMainPage();
    }
    @Test
    public void goToYandexMaps() {
        basePage.goToYandexMaps();
    }
    @Test
    public void consultationFormEnable() {
        loyaltyPage.consultationButtonClick();
    }
    @Test
    public void numerationOfBlocks() {
        loyaltyPage.numerationOfBlocks();
    }
    @Test
    public void giftCards() {
        loyaltyPage.cardsButtonClick();
    }
    @Test
    public void consultationFooterFormEnable() {
        loyaltyPage.consultationFooterButtonClick();
    }
}
