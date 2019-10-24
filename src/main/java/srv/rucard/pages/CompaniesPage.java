package srv.rucard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srv.rucard.PageObject;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static srv.rucard.BasePage.jse;
import static srv.rucard.BasePage.softAssert;

public class CompaniesPage extends PageObject {

//LOCATORS

    @FindBy(css = ".Button-sc-1wudyxw-0.gazvzc")
    private WebElement giveOffering;

    @FindBy(css = ".sfd__list-item:nth-child(1)")
    private WebElement selfServiceDevicesText1;

    @FindBy(css = ".SectionSelfService__TabRow-sc-1txvpzf-1 > .Tab-r7w846-0:nth-child(1)")
    private WebElement selfServiceDevicesDescription;

    @FindBy(css = ".SectionSelfService__TabRow-sc-1txvpzf-1 > .Tab-r7w846-0:nth-child(2)")
    private WebElement selfServiceDevicesEquipmentDelivery;

    @FindBy(css = ".Row-sc-9daufq-0:nth-child(3) > .Card-sc-1rt6151-0-Component:nth-child(1)")
    private WebElement goToGiftCard;

    @FindBy(css = ".Card-sc-1rt6151-0-Component:nth-child(2) > .Card__Column-sc-1rt6151-2:nth-child(2)")
    private WebElement goToVirtualGiftSertificate;

    @FindBy(css = ".Row-sc-9daufq-0:nth-child(3) > .Card-sc-1rt6151-0-Component:nth-child(3)")
    private WebElement goToLoyaltyCard;

    @FindBy(css = ".Row-sc-9daufq-0:nth-child(3) > .Card-sc-1rt6151-0-Component:nth-child(4)")
    private WebElement goToCoalitionPrograms;

    @FindBy(css = ".menuLink > tspan:nth-child(1)")
    private WebElement menuLeftClassName;


//SUPER DRIVER

    public CompaniesPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS

    public void giveOfferingOpen() {
        this.giveOffering.click();
        assertEquals(driver.findElements(By.cssSelector(".CloseBtn-kckeqv-0.kfbyhz")).size(), 1);
    }
    public void getSelfServiceDevicesTexts() {
        this.selfServiceDevicesDescription.click();
        String text1 = this.selfServiceDevicesText1.getText();
        this.selfServiceDevicesEquipmentDelivery.click();
        String text2 = this.selfServiceDevicesDescription.getText();
        assertNotEquals(text1, text2);
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
            driver.get("http://rucard.srv.lan/banks");
        }
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
        String[] classesOfBlocks = new String[] {".dGXvLy", ".gtSkkF", ".bwCGmb", ".ibuIwR", ".iWXTkA"};
        String[] numerationOfBlocks = new String[] {"\"01\"", "\"02\"", "\"03\"","\"04\"", "\"05\""};
        for (int i = 0; i < classesOfBlocks.length; i++) {
            String curBlockContent = (String) jse.executeScript(String.format(jsScript, classesOfBlocks[i]));
            assertEquals(curBlockContent, numerationOfBlocks[i]);
        }
    }
}
