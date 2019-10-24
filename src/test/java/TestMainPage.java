import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import srv.rucard.BasePage;
import srv.rucard.pages.BanksPage;
import srv.rucard.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class TestMainPage extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://rucard.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.mainPage = new MainPage(driver);
        this.banksPage = new BanksPage(driver);
        jse = (JavascriptExecutor)driver;
        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }

//TESTS

    @Test
    public void backToMainPage() {
        basePage.backToMainPage();
    }
    @Test
    public void goToYandexMaps() {
        basePage.goToYandexMaps();
        basePage.checkYandexMapsCoordinates();
    }
    @Test
    public void goToBankPageButtonWorkCheck() {
        mainPage.banksButtonClick();
    }
    @Test
    public void goToCompaniesPageButtonWorkCheck() {
        mainPage.companiesButtonClick();
    }
    @Test
    public void consultationFormEnableCheck() {
        mainPage.consultationButtonClick();
    }
    @Test
    public void consultationFormWorks() throws InterruptedException {
        mainPage.consultationButtonClickAndFullForm();
    }
    @Test
    public void menuEnableCheck() {
        mainPage.menuButtonClick();
    }
    @Test
    public void backToMainPageCheck() {
        mainPage.banksButtonClick();
        basePage.backToMainPage();
    }
    @Test
    public void menuCloseAfterLogoClick() {
        mainPage.menuButtonClickAndWait();
    }
    @Test
    public void moreInfoButtonClick() {
        mainPage.moreInfoButton();
    }
    @Test
    public void downArrowClickCheck() {
        mainPage.downArrowButton();
    }
    @Test
    public void numerationOfBlocksCheck() {
        mainPage.numerationOfBlocks();
    }
    @Test
    public void goToCalculatePriceCheck() {
        mainPage.calcullateButtonClick();
    }
    @Test
    public void iDintWantWriteAnythingsCheck() {
        mainPage.iDonWantWriteAnything();
    }
    @Test
    public void goToChoosePage() {
        mainPage.nextButtonClick();
    }
    @Test
    public void RadioButtonsCheck() {
        mainPage.RadioButtons();
    }
    @Test
    public void individualTariffPlanCheckboxIsDisplayed() {
        mainPage.individualTariffPlanCheckboxIsDisplayed();
    }
    @Test
    public void individualTariffPlanScrollLinesChangesValue() {
        mainPage.individualTariffPlanScrollLinesChangesValue();
    }
    @Test
    public void individualTariffCheckboxIsDisplayed2() {
        mainPage.individualTariffCheckboxIsDisplayed2();
    }
    @Test
    public void tariffCompleteForm() {
       mainPage.tarifCompleteForm();
    }
    @Test
    public void programsButtonsCheck() throws InterruptedException {
        mainPage.programsButtonsClick();
    }
}
