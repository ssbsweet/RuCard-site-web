import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import srv.rucard.BasePage;
import srv.rucard.pages.CoalitionPage;

import java.util.concurrent.TimeUnit;

public class TestCoalitionPage extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://rucard.srv.lan/giftcard");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.coalitionPage = new CoalitionPage(driver);
        jse = (JavascriptExecutor) driver;
    }

//TESTS

    @Test
    public void backToMainPage() {
        basePage.backToMainPage();
    }
    @Test
    public void numerationOfBlocksCheck() {
        coalitionPage.numerationOfBlocks();
    }
    @Test
    public void consultationFooterFormEnable() {
        coalitionPage.consultationFormWait();

    }
    @Test
    public void goToYandexMaps() {
        basePage.goToYandexMaps();
        basePage.checkYandexMapsCoordinates();
    }
}
