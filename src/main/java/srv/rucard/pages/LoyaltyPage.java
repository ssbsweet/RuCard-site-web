package srv.rucard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import srv.rucard.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static srv.rucard.BasePage.jse;

public class LoyaltyPage extends PageObject {

//LOCATORS

    @FindBy(css = ".Button-sc-1wudyxw-0.Header__StyledButton-q5on0p-2.ixOUiN")
    private WebElement consultationButton;

    @FindBy(css = ".Button-sc-1wudyxw-0.loyWea")
    private WebElement consultationFooterButton;

    @FindBy(css = ".disabled.Button-sc-1wudyxw-0.gazvzc")
    private WebElement consultationForm;

    @FindBy(css = ".Card-sc-1rt6151-0-Component:nth-child(1)")
    private WebElement goToGiftCard;

    @FindBy(css = ".Card-sc-1rt6151-0-Component:nth-child(2)")
    private WebElement goToVirtualGiftSertificate;

    @FindBy(css = ".Card-sc-1rt6151-0-Component:nth-child(3)")
    private WebElement goToLoyaltyCard;

    @FindBy(css = ".Card-sc-1rt6151-0-Component:nth-child(4)")
    private WebElement goToCoalitionPrograms;

//SUPER DRIVER

    public LoyaltyPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS

    public void consultationButtonClick() {
        this.consultationButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".disabled.Button-sc-1wudyxw-0.gazvzc")));
        assertTrue(this.consultationForm.isDisplayed());
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
            assertEquals(driver.getCurrentUrl(), cardButtonsUrls[i], "!URL в адрессе отличается!");
            driver.get("http://rucard.srv.lan/loyalty");
        }
    }
    public void consultationFooterButtonClick() {
        this.consultationFooterButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".disabled.Button-sc-1wudyxw-0.gazvzc")));
        assertTrue(this.consultationForm.isDisplayed());
    }
    public void numerationOfBlocks() {
        String jsScript = "return window.getComputedStyle(document.querySelector('%s'),':after').getPropertyValue('content')";
        String[] classesOfBlocks = new String[] {".dGXvLy", ".gtSkkF", ".bwCGmb", ".ibuIwR",};
        String[] numerationOfBlocks = new String[] {"\"01\"", "\"02\"", "\"03\"","\"04\""};
        for (int i = 0; i < classesOfBlocks.length; i++) {
            String curBlockContent = (String) jse.executeScript(String.format(jsScript, classesOfBlocks[i]));
            assertEquals(curBlockContent, numerationOfBlocks[i]);
        }
    }
}
