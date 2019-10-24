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

public class GiftCardPage extends PageObject {

//LOCATORS

    @FindBy(css = ".Button-sc-1wudyxw-0.loyWea")
    private WebElement consultationFooterButton;

    @FindBy(css = ".disabled.Button-sc-1wudyxw-0.gazvzc")
    private WebElement consultationForm;


    public GiftCardPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS

    public void consultationFooterButtonClick() {
        this.consultationFooterButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".disabled.Button-sc-1wudyxw-0.gazvzc")));
        assertTrue(this.consultationForm.isDisplayed());
    }
    public void numerationOfBlocks() {
        String jsScript = "return window.getComputedStyle(document.querySelector('%s'),':after').getPropertyValue('content')";
        String[] classesOfBlocks = new String[] {".dGXvLy", ".gtSkkF"};
        String[] numerationOfBlocks = new String[] {"\"01\"", "\"02\""};
        for (int i = 0; i < classesOfBlocks.length; i++) {
            String curBlockContent = (String) jse.executeScript(String.format(jsScript, classesOfBlocks[i]));
            assertEquals(curBlockContent, numerationOfBlocks[i], "!Нумерация блоков на страенице больше или меньше 2x!");
        }
    }
}
