import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import srv.rucard.BasePage;
import srv.rucard.pages.MenuMain;

import java.util.concurrent.TimeUnit;

public class TestMenuMain extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://rucard.srv.lan/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.menuMain = new MenuMain(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        menuMain.menuButtonClick();
    }

//TESTS

    @Test
    public void currentLanguageTextCheck() {
        menuMain.activeSwitchTextLangClick();
    }
    @Test
    public void switchToAnotherLangCheck() {
        menuMain.switchToAnotherLang();
    }
    @Test
    public void goToAboutCheck() {
        menuMain.goToAbout();
    }
    @Test
    public void goToOldVersionSiteCheck() {
        menuMain.goToOldVersionOnSite();
    }
    @Test
    public void goToTechSupport() {
        menuMain.goToTechSupport();
    }
    @Test
    public void goToServiceCentre() {
        menuMain.goToserviceCentre();
    }
    @Test
    public void goToInformationDisclosure() {
        menuMain.goToInformationDisclosure();
    }
    @Test
    public void goToInsiderDisclosure() throws InterruptedException {
        menuMain.goToInsiderDisclosure();
    }
    @Test
    public void goToReporting() {
        menuMain.goToReporting();
    }
    @Test
    public void socialLinksCheck() {
        menuMain.goToSocialLiks();
    }
}

