package srv.rucard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import srv.rucard.BasePage;
import srv.rucard.PageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactsPage extends PageObject {

    BasePage basePage = new BasePage();

//LOCATORS

    @FindBy(css = ".links > li:nth-child(1) > a")
    private WebElement informationReveal;

    @FindBy(css = ".links > li:nth-child(2) > a")
    private WebElement insideInformationReveal;

    @FindBy(css = ".links > li:nth-child(3) > a")
    private WebElement reporting;

    @FindBy(css = "a[href='/position-about-insider-information.pdf']")
    private WebElement insideInformationForm;

    @FindBy(css = "a[href='/az-fsfo-group-rucard-2018.pdf']")
    private WebElement reportingForm;

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS

    public void goToInformationReveal() {
        this.informationReveal.click();
        basePage.switchTab();
        assertEquals(driver.getCurrentUrl(), "http://www.e-disclosure.ru/portal/company.aspx?id=37100", "!Пользователь не в информационном центре!");
    }
    public void insideInformationFormReveal() throws InterruptedException {
        this.insideInformationReveal.click();
        Thread.sleep(1000);
        assertTrue(this.insideInformationForm.isDisplayed(), "!Форма не отображается!");
    }
    public void reportingFormReveal() {
        this.reporting.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/az-fsfo-group-rucard-2018.pdf']")));
        assertTrue(this.reportingForm.isDisplayed(), "!PDF файл не найден!");
    }
}
