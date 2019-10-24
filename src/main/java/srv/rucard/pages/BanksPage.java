package srv.rucard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srv.rucard.BasePage;
import srv.rucard.PageObject;

import static org.testng.Assert.assertEquals;
import static srv.rucard.BasePage.jse;
import static srv.rucard.BasePage.softAssert;

public class BanksPage extends PageObject {

    BasePage basePage = new BasePage();

//LOCATORS

    @FindBy(css = ".CloseBtn-kckeqv-0.kfbyhz")
    private WebElement closeOfferingCross;

    @FindBy(css = ".formRow > .Card-sc-1rt6151-0-Component:nth-child(1)")
    private WebElement iTouchButton;

    @FindBy(css = ".formRow > .Card-sc-1rt6151-0-Component:nth-child(2)")
    private WebElement rusoftRetail;

    @FindBy(css = ".formRow > .Card-sc-1rt6151-0-Component:nth-child(5)")
    private WebElement umesGate;

    @FindBy(css = ".formRow > .Card-sc-1rt6151-0-Component:nth-child(3)")
    private WebElement terminalManager;

    @FindBy(css = ".formRow > .Card-sc-1rt6151-0-Component:nth-child(4)")
    private WebElement rusoftABS;

    @FindBy(css = ".Row-sc-9daufq-0:nth-child(3) > .Card-sc-1rt6151-0-Component:nth-child(1)")
    private WebElement goToGiftCard;

    @FindBy(css = ".Card-sc-1rt6151-0-Component:nth-child(2) > .Card__Column-sc-1rt6151-2:nth-child(2)")
    private WebElement goToVirtualGiftSertificate;

    @FindBy(css = ".Row-sc-9daufq-0:nth-child(3) > .Card-sc-1rt6151-0-Component:nth-child(3)")
    private WebElement goToLoyaltyCard;

    @FindBy(css = ".Row-sc-9daufq-0:nth-child(3) > .Card-sc-1rt6151-0-Component:nth-child(4)")
    private WebElement goToCoalitionPrograms;

    @FindBy(css = ".mpd__list-item:nth-child(1)")
    private WebElement mobilePaymentsText1;

    @FindBy(css = ".SectionMobilePayments__TabRow-sc-19hmbja-1 > .Tab-r7w846-0:nth-child(1)")
    private WebElement mobilePaymentsDescription;

    @FindBy(css = ".SectionMobilePayments__TabRow-sc-19hmbja-1 > .Tab-r7w846-0:nth-child(2)")
    private WebElement mobilePaymentsPayment;

    @FindBy(css = ".SectionMobilePayments__TabRow-sc-19hmbja-1 > .Tab-r7w846-0:nth-child(3)")
    private WebElement mobilePaymentOportunities;

    @FindBy(css = ".SectionMobilePayments__TabRow-sc-19hmbja-1 > .Tab-r7w846-0:nth-child(4)")
    private WebElement mobilePaymentConnectingServices;

    @FindBy(css = ".sfd__list-item:nth-child(1)")
    private WebElement selfServiceDevicesText1;

    @FindBy(css = ".SectionSelfService__TabRow-sc-1txvpzf-1 > .Tab-r7w846-0:nth-child(1)")
    private WebElement selfServiceDevicesDescription;

    @FindBy(css = ".SectionSelfService__TabRow-sc-1txvpzf-1 > .Tab-r7w846-0:nth-child(2)")
    private WebElement selfServiceDevicesEquipmentDelivery;

    @FindBy(css = ".spr__list-item:nth-child(1)")
    private WebElement servicesRuKardText1;

    @FindBy(css = ".SectionServices__TabRow-ki3k56-2 > .Tab-r7w846-0:nth-child(1)")
    private WebElement servicesRuKardFraudGuard;

    @FindBy(css = ".SectionServices__TabRow-ki3k56-2 > .Tab-r7w846-0:nth-child(2)")
    private WebElement servicesRuKardCustomerSupport;

    @FindBy(css = ".SectionServices__TabRow-ki3k56-2 > .Tab-r7w846-0:nth-child(3)")
    private WebElement servicesRuKard3Dsecure;

    @FindBy(css = ".SectionServices__TabRow-ki3k56-2 > .Tab-r7w846-0:nth-child(4)")
    private WebElement servicesRuKardSmsService;

    @FindBy(css = ".menuLink > tspan:nth-child(1)")
    private WebElement menuLeftClassName;

//SUPER DRIVER

    public BanksPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS
    public void giveOfferingIsPresent() {
        assertEquals(String.valueOf(this.closeOfferingCross.getSize()), "(20, 20)", "!Окно поддержки не отображается!");
    }
    public void programsButtonsClick() {
        String[] programButtonsUrls = new String[]{
                "https://rusoft-company.ru/products/front-office-dbo/i-touch",
                "https://rusoft-company.ru/products/card-technologies/rcs-retail",
                "https://rusoft-company.ru/products/abs/umes-gate",
                "https://rusoft-company.ru/products/tsp/terminal-manager",
                "https://rusoft-company.ru/competencies/bk-system"};
        WebElement[] programClick = new WebElement[]{
                this.iTouchButton,
                this.rusoftRetail,
                this.umesGate,
                this.terminalManager,
                this.rusoftABS};
        for (int i = 0; i < programClick.length; i++) {
            programClick[i].click();
            basePage.switchTab();
            softAssert.assertEquals(driver.getCurrentUrl(), programButtonsUrls[i]);
            driver.get("http://www.rucard.ru/banks");
        }
        softAssert.assertAll();
    }
    public void cardsButtonClick() {
        String[] cardButtonsUrls = new String[]{
                "http://rucard.srv.lan/giftcard",
                "http://rucard.srv.lan/virtualcard",
                "http://rucard.srv.lan/loyaltycard",
                "http://rucard.srv.lan/coalition"};
        WebElement[] cardClick = new WebElement[]{
                this.goToGiftCard,
                this.goToVirtualGiftSertificate,
                this.goToLoyaltyCard,
                this.goToCoalitionPrograms};
        for (int i = 0; i < cardClick.length; i++) {
            cardClick[i].click();
            softAssert.assertEquals(driver.getCurrentUrl(), cardButtonsUrls[i], "!URL в адрессе отличается!");
            driver.get("http://www.rucard.ru/banks");
        }
        softAssert.assertAll();
    }
    public String getSelfServiceDevicesText1() {
        this.selfServiceDevicesDescription.click();
        return selfServiceDevicesText1.getText();
    }
    public String getSelfServiceDevicesText2() {
        this.selfServiceDevicesEquipmentDelivery.click();
        return selfServiceDevicesDescription.getText();
    }
    public void textsAssertCheck() {
        WebElement[] paragraphClick = new WebElement[] {
                this.servicesRuKardCustomerSupport,
                this.servicesRuKard3Dsecure,
                this.servicesRuKardSmsService};
        WebElement[] mobileClick = new WebElement[] {
                this.mobilePaymentsPayment,
                this.mobilePaymentOportunities,
                this.mobilePaymentConnectingServices};
        for (int i = 0; i < paragraphClick.length; i++) {
            String etalonText = this.servicesRuKardText1.getText();
            paragraphClick[i].click();
            softAssert.assertNotEquals(this.servicesRuKardText1.getText(), etalonText, "!Тексты одинаковые!");
            driver.get("http://www.rucard.ru/banks");
        }
        for (int i = 0; i < mobileClick.length; i++) {
            String etalonText = this.servicesRuKardText1.getText();
            mobileClick[i].click();
            softAssert.assertNotEquals(this.mobilePaymentsText1.getText(), etalonText, "!Тексты одинаковые!");
            driver.get("http://www.rucard.ru/banks");
        }
        softAssert.assertNotEquals(this.getSelfServiceDevicesText1(), this.getSelfServiceDevicesText2(), "!Тексты одинаковые!");
        softAssert.assertAll();
    }
    public void leftMenuColorScroll() throws InterruptedException {
        String[] leftMenuColors = new String[]{"activeGreen", "activeBlack", ""};
        for (int i =0; i < leftMenuColors.length; i++) {
            softAssert.assertEquals(menuLeftClassName.getAttribute("class"), leftMenuColors[i], "!Цвет в меню при скроле не совпадает с ожидаемым!");
            jse.executeScript("document.getElementById('appViewPort').scrollBy(0,1500)");
            Thread.sleep(1000);
        }
        softAssert.assertAll();
    }
    public void numerationOfBlocks() {
        String jsScript = "return window.getComputedStyle(document.querySelector('%s'),':after').getPropertyValue('content')";
        String[] classesOfBlocks = new String[]{".dGXvLy", ".gtSkkF", ".bwCGmb", ".ibuIwR", ".iWXTkA", ".htMzyR", ".hOEkdK", ".fXhYkQ", ".cNQtcE", ".hKykzT"};
        String[] numerationOfBlocks = new String[]{"\"01\"", "\"02\"", "\"03\"", "\"04\"", "\"05\"", "\"06\"", "\"07\"", "\"08\"", "\"09\"", "\"10\""};
        for (int i = 0; i < classesOfBlocks.length; i++) {
            String curBlockContent = (String) jse.executeScript(String.format(jsScript, classesOfBlocks[i]));
            assertEquals(curBlockContent, numerationOfBlocks[i], "!Нумерация блоков на страенице больше или меньше 10!");
        }
    }
}
