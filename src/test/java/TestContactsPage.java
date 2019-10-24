import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import srv.rucard.BasePage;
import srv.rucard.pages.ContactsPage;

import java.util.concurrent.TimeUnit;

public class TestContactsPage extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://rucard.srv.lan/contacts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.contactsPage = new ContactsPage(driver);
        jse = (JavascriptExecutor) driver;
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
    public void goToInformationRevealCheck() {
        contactsPage.goToInformationReveal();
    }
    @Test
    public void insideInformationFormRevealCheck() throws InterruptedException {
        contactsPage.insideInformationFormReveal();
    }
    @Test
    public void reportingFormRevealCheck() {
        contactsPage.reportingFormReveal();
    }
}
