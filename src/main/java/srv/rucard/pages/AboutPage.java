package srv.rucard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srv.rucard.PageObject;

import static org.testng.Assert.assertEquals;
import static srv.rucard.BasePage.jse;

public class AboutPage extends PageObject {

//LOCATORS

    @FindBy(css = "a[href='/privacy_policy_rucard.pdf']")
    private WebElement policyForTheProcessingAndProtectionOfPersonalDataPdf;

//SUPER DRIVER

    public AboutPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS

    public void goToPolicyForTheProcessingAndProtectionOfPersonalDataPdf() {
        this.policyForTheProcessingAndProtectionOfPersonalDataPdf.click();
    }
    public void numerationOfBlocks() {
        String jsScript = "return window.getComputedStyle(document.querySelector('%s'),':after').getPropertyValue('content')";
        String[] classesOfBlocks = new String[] {".dGXvLy", ".gtSkkF", ".bwCGmb", ".ibuIwR"};
        String[] numerationOfBlocks = new String[] {"\"01\"", "\"02\"", "\"03\"","\"04\""};
        for (int i = 0; i < classesOfBlocks.length; i++) {
            String curBlockContent = (String) jse.executeScript(String.format(jsScript, classesOfBlocks[i]));
            assertEquals(curBlockContent, numerationOfBlocks[i], "!Нумерация блоков на страенице больше или меньше 4х!");
        }
    }
    public void giftCardsUrlCheck() {
        assertEquals(driver.getCurrentUrl(), "http://rucard.srv.lan/privacy_policy_rucard.pdf", "!URL отличается от ожидаемого!");
    }
}
