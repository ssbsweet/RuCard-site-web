package srv.rucard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srv.rucard.BasePage;
import srv.rucard.PageObject;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static srv.rucard.BasePage.softAssert;

public class MenuMain extends PageObject {

    BasePage basePage = new BasePage();

//LOCATORS

    @FindBy(css =".MenuBtn-sc-1rkj2p3-0 > span")
    private WebElement menuButton;

    @FindBy(css = ".Nav-sc-1t1hd04-0 > li:nth-child(1) > a")
    private WebElement goToAboutPage;

    @FindBy(css = ".Nav-sc-1t1hd04-0 > li:nth-child(2) > a")
    private WebElement goToBankPage;

    @FindBy(css = ".Nav-sc-1t1hd04-0 > li:nth-child(3) > a")
    private WebElement goToOrganisations;

    @FindBy(css = ".Nav-sc-1t1hd04-0 > li:nth-child(4) > a")
    private WebElement goToProgrammLoyalty;

    @FindBy(css = "li:nth-child(5) > a:nth-child(1)")
    private WebElement goToContacts;

    @FindBy(css = "ul:nth-child(1) > li:nth-child(1) > a")
    private WebElement goToOldVersionOnSite;

    @FindBy(css = "ul:nth-child(1) > li:nth-child(2) > a")
    private WebElement goToTechSupport;

    @FindBy(css = "ul:nth-child(1) > li:nth-child(3) > a")
    private WebElement goToserviceCentre;

    @FindBy(css = ".Contacts__List-r5jmow-2:nth-child(3) li:nth-child(1) > a")
    private WebElement goToInformationDisclosure;

    @FindBy(css = ".Contacts__List-r5jmow-2:nth-child(3) li:nth-child(2) > a")
    private WebElement goToInsiderDisclosure;

    @FindBy(css = ".Modal__Wrapper-xpwccw-0.knAmpL")
    private WebElement insiderDisclosureForm;

    @FindBy(css = ".Contacts__List-r5jmow-2:nth-child(3) li:nth-child(3) > a")
    private WebElement goToReporting;

    @FindBy(css = ".Contacts__List-r5jmow-2:nth-child(4) li:nth-child(1) > a")
    private WebElement goToFacebook;

    @FindBy(css = ".Contacts__List-r5jmow-2:nth-child(4) li:nth-child(2) > a")
    private WebElement goToVK;

    @FindBy(css = ".Contacts__List-r5jmow-2:nth-child(4) li:nth-child(3) > a")
    private WebElement goToInstagram;

    @FindBy(css = ".Contacts__List-r5jmow-2 li:nth-child(4) > a")
    private WebElement goToOK;

    @FindBy(css = "li.Language__Item-sc-17l6ywi-1.gJvMcW")
    private WebElement switchToAnotherLang;

    @FindBy(css = "li.Language__Item-sc-17l6ywi-1.fQLFiJ")
    private WebElement activeSwitchTextLang;

    @FindBy(css = ".Contacts__Address-r5jmow-1.bRSzOS > div")
    private WebElement curretLanguageTextCheck;

//SUPER DRIVER

    public MenuMain(WebDriver driver) {
        super(driver);
    }

//OPERATIONS

    public void menuButtonClick() throws InterruptedException {
        this.menuButton.click();
        Thread.sleep(500);
    }
    public void goToOldVersionOnSite() {
        this.goToOldVersionOnSite.click();
        basePage.switchTab();
        assertEquals(driver.getCurrentUrl(), "http://old.rucard.net/");
    }
    public void goToTechSupport() {
        this.goToTechSupport.click();
        assertEquals(driver.getCurrentUrl(), "http://rucard.srv.lan/contacts");
    }
    public void goToserviceCentre() {
        this.goToserviceCentre.click();
        basePage.switchTab();
        assertEquals(driver.getCurrentUrl(), "http://services.rucard.ru/");
    }
    public void goToInformationDisclosure() {
        this.goToInformationDisclosure.click();
        basePage.switchTab();
        assertEquals(driver.getCurrentUrl(), "http://www.e-disclosure.ru/portal/company.aspx?id=37100");
    }
    public void goToInsiderDisclosure() throws InterruptedException {
        this.goToInsiderDisclosure.click();
        Thread.sleep(500);
        assertTrue(this.insiderDisclosureForm.isDisplayed());
    }
    public void goToReporting() {
        this.goToReporting.click();
        assertEquals(driver.getCurrentUrl(), "http://rucard.srv.lan/reports");
    }
    public void goToSocialLiks() {
        WebElement[] socialButtons = new WebElement[] {
                this.goToFacebook,
                this.goToVK,
                this.goToInstagram,
                this.goToOK};
        String[] socialLinks = new String[] {
                "http://rucard.srv.lan/#",
                "http://rucard.srv.lan/#",
                "http://rucard.srv.lan/#",
                "http://rucard.srv.lan/#"};
        for (int i = 0; i < socialButtons.length; i++) {
            socialButtons[i].click();
            softAssert.assertEquals(driver.getCurrentUrl(), socialLinks[i]);
        }
        softAssert.assertAll();
    }
    public void switchToAnotherLang() {
        this.switchToAnotherLang.click();
        assertEquals(this.curretLanguageTextCheck.getText(),"Bld. 1, 10, Petrovsko-Razumovskaya alley\n" + "+7 (495) 737-06-80\n" + "info@rucard.net");
    }
    public void activeSwitchTextLangClick() {
        this.activeSwitchTextLang.click();
        assertEquals(this.curretLanguageTextCheck.getText(),"Петровско-Разумовская аллея, д. 10, корп. 1\n" + "+7 (495) 737-06-80\n" + "info@rucard.net");
    }
    public void goToAbout() {
        this.goToAboutPage.click();
        assertEquals(driver.getCurrentUrl(), "http://rucard.srv.lan/about");
    }
}
