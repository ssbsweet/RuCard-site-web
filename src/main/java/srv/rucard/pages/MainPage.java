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
import static srv.rucard.BasePage.*;

public class MainPage extends PageObject {

    BasePage basePage = new BasePage();

//LOCATORS

    @FindBy(css = ".Navigation-sc-19uf0n0-0 > li:nth-child(1) > a")
    private WebElement banksButton;

    @FindBy(css = ".Navigation-sc-19uf0n0-0 > li:nth-child(2) > a")
    private WebElement companiesButton;

    @FindBy(css = ".Button-sc-1wudyxw-0.Header__StyledButton-q5on0p-2.ixOUiN")
    private WebElement consultationButton;

    @FindBy(css = ".eGTceI > .styled-components__InputWrapper-sc-2zttte-0.cHBETQ:nth-child(1) > .styled-components__InputMask-sc-2zttte-2.bencRp")
    private WebElement consultationFormNameField;

    @FindBy(css = ".eGTceI > .styled-components__InputWrapper-sc-2zttte-0.cHBETQ:nth-child(2) > .styled-components__InputMask-sc-2zttte-2.bencRp")
    private WebElement consultationFormEmailField;

    @FindBy(css = ".eGTceI > .styled-components__InputWrapper-sc-2zttte-0.cHBETQ:nth-child(3) > .styled-components__InputMask-sc-2zttte-2.bencRp")
    private WebElement consultationFormPhoneField;

    @FindBy(css = ".eGTceI > .styled-components__InputWrapper-sc-2zttte-0.cHBETQ:nth-child(4) > .styled-components__Input-sc-2zttte-3.cZWuFp")
    private WebElement consultationFormCommentField;

    @FindBy(css = ".Row-sc-9daufq-0 > .Button-sc-1wudyxw-0")
    private WebElement consultationFormSend;

    @FindBy(css = ".Button-sc-1wudyxw-0-Component:nth-child(2)")
    private WebElement moreInfoButton;

    @FindBy(css = ".ScrollDownBtn__ScrollDown-keratc-0")
    private WebElement downArrow;

    @FindBy(css = ".Button-sc-1wudyxw-0.loyWea")
    private WebElement callculateButton;

    @FindBy(css = ".Buttons__Prev-zho2mv-1")
    private WebElement iDonWantWriteAnything;

    @FindBy(css = ".Buttons__Next-zho2mv-2")
    private WebElement nextButton;

    @FindBy(css = ".second .cvOvIf:nth-child(2) > i")
    private WebElement individualTariffPlanRadioButton1;

    @FindBy(css = ".SectionCalculate__Column-sc-1ofn4h0-2:nth-child(2) > .CheckBox-nlcz3s-0:nth-child(2) > i")
    private WebElement individualTariffPlanCheckBox1;

    @FindBy(css = ".SectionCalculate__Column-sc-1ofn4h0-2:nth-child(3) > .CheckBox-nlcz3s-0:nth-child(2) > i")
    private WebElement individualTariffPlanCheckBox2;

    @FindBy(css = ".Tags-sc-1h2ebty-0 > li:nth-child(1)")
    private WebElement individualTariffPlanRadioButtonIsSelected;

    @FindBy(css = ".Tags-sc-1h2ebty-0 > li:nth-child(2)")
    private WebElement individualTariffPlanCheckBox1isSelected;

    @FindBy(css = ".Tags-sc-1h2ebty-0 > li:nth-child(3)")
    private WebElement individualTariffPlanCheckBox2isSelected;

    @FindBy(css = ".Tags-sc-1h2ebty-0 > li:nth-child(4)")
    public WebElement individualTariffPlanCheckBox3isSelected;

    @FindBy(css = ".SectionCalculate__Column-sc-1ofn4h0-2:nth-child(1) .input-range__slider")
    private WebElement individualTariffPlanScrollLine1;

    @FindBy(css = ".SectionCalculate__Column-sc-1ofn4h0-2:nth-child(2) .input-range__slider")
    private WebElement individualTariffPlanScrollLine2;

    @FindBy(css = ".SectionCalculate__Column-sc-1ofn4h0-2:nth-child(3) .input-range__slider")
    private WebElement individualTariffPlanScrollLine3;

    @FindBy(css = ".SectionCalculate__Column-sc-1ofn4h0-2:nth-child(1) > .SectionCalculate__CheckBoxLarge-sc-1ofn4h0-6 > i")
    private WebElement individualTariffPlanCheckBox2isSelected1;

    @FindBy(css = ".SectionCalculate__Column-sc-1ofn4h0-2:nth-child(2) > .SectionCalculate__CheckBoxLarge-sc-1ofn4h0-6 > i")
    private WebElement individualTariffPlanCheckBox2isSelected2;

    @FindBy(css = ".SectionCalculate__Column-sc-1ofn4h0-2:nth-child(3) > .SectionCalculate__CheckBoxLarge-sc-1ofn4h0-6 > i")
    private WebElement individualTariffPlanCheckBox2isSelected3;

    @FindBy(css = ".SectionCalculate__Column-sc-1ofn4h0-2:nth-child(4) > .SectionCalculate__CheckBoxLarge-sc-1ofn4h0-6 > i")
    private WebElement individualTariffPlanCheckBox2isSelected4;

    @FindBy(css = "#scrollToCalc > div > div.Slider-oeda1j-0.hTCAbS > div.first.Slider__Item-oeda1j-1.iIkuPP > div.SectionCalculate__Row-sc-1ofn4h0-4.cnwIQr > div > label:nth-child(1) > i")
    private WebElement radioButtonOne;

    @FindBy(css = "#scrollToCalc > div > div.Slider-oeda1j-0.hTCAbS > div.first.Slider__Item-oeda1j-1.iIkuPP > div.SectionCalculate__Row-sc-1ofn4h0-4.cnwIQr > div > label:nth-child(2) > i")
    private WebElement radioButtonTwo;

    @FindBy(css = "#scrollToCalc > div > ul > li")
    private WebElement getRadioButtonOneACTIVE;

    @FindBy(css = "#scrollToCalc > div > ul > li")
    private WebElement getRadioButtonTwoACTIVE;

    @FindBy(css = ".styled-components__InputWrapper-sc-2zttte-0:nth-child(1) > .styled-components__InputMask-sc-2zttte-2")
    private WebElement nameInTarifField;

    @FindBy(css = ".styled-components__InputWrapper-sc-2zttte-0:nth-child(2) > .styled-components__InputMask-sc-2zttte-2")
    private WebElement emailInTarifField;

    @FindBy(css = ".styled-components__InputWrapper-sc-2zttte-0:nth-child(3) > .styled-components__InputMask-sc-2zttte-2")
    private WebElement phoneInTarifField;

    @FindBy(css = ".Button-sc-1wudyxw-0:nth-child(2)")
    private WebElement sendTarifForm;

    @FindBy(css = ".iIkuPP > .BreadCrumbs-sc-1q18x12-0")
    public WebElement nothingHereWrite;

    @FindBy(css = ".SectionRucardNumbers__Dates-n7h689-2 > li:nth-child(1) > p")
    public WebElement rucardInNumbersBlock;

    @FindBy(css = ".disabled.Button-sc-1wudyxw-0.gazvzc")
    private WebElement consultationForm;

    @FindBy(css =".MenuBtn-sc-1rkj2p3-0 > span")
    private WebElement menuButton;

    @FindBy(css = ".Container-sc-1h40quz-0.MainMenu__MenuContainer-h873zn-0.bzUkKw")
    private WebElement menuForm;

    @FindBy(css = ".SectionTechnologies__Nav-sc-16232n6-0 > li:nth-child(1)")
    private WebElement iTouchButton;

    @FindBy(css = ".SectionTechnologies__Nav-sc-16232n6-0 > li:nth-child(2)")
    private WebElement rusoftRetail;

    @FindBy(css = ".SectionTechnologies__Nav-sc-16232n6-0 > li:nth-child(3)")
    private WebElement umesGate;

    @FindBy(css = ".SectionTechnologies__Nav-sc-16232n6-0 > li:nth-child(4)")
    private WebElement terminalManager;

    @FindBy(css = ".SectionTechnologies__Nav-sc-16232n6-0 > li:nth-child(5)")
    private WebElement rusoftABS;

    @FindBy(css = ".invAis > .Button-sc-1wudyxw-0-Component")
    private WebElement moreAboutTechnology;

//SUPER DRIVER

    public MainPage(WebDriver driver) {
        super(driver);
    }


//OPERATIONS

    public void moreInfoButton() {
        this.moreInfoButton.click();
        assertEquals(driver.getCurrentUrl(),"http://rucard.srv.lan/banks#");
    }
    public void downArrowButton() {
        this.downArrow.click();
        Long scrollYposittion = (Long) jse.executeScript("return document.getElementById('appViewPort').scrollTop");
        assertTrue(scrollYposittion != 0);
    }
    public void banksButtonClick() {
        this.banksButton.click();
        assertEquals(driver.getCurrentUrl(),"http://rucard.srv.lan/banks");
    }
    public void companiesButtonClick() {
        this.companiesButton.click();
        assertEquals(driver.getCurrentUrl(),"http://rucard.srv.lan/companies");
    }
    public void consultationButtonClick() {
        this.consultationButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".disabled.Button-sc-1wudyxw-0.gazvzc")));
        assertTrue(this.consultationForm.isDisplayed());
    }
    public void consultationButtonClickAndFullForm() throws InterruptedException {
        this.consultationButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".disabled.Button-sc-1wudyxw-0.gazvzc")));
        this.consultationFormInputTextInFields("test QA", "a" + System.currentTimeMillis() + "@mail.com", "" + System.currentTimeMillis(), "tesq QA, don't answer");
        this.consultationFormSend.click();
        Thread.sleep(1000);
        assertEquals(driver.findElement(By.cssSelector(".Modal__Wrapper-xpwccw-0.knAmpL")).getText(), "Заявка отправлена!\n" + "В ближайшее время мы свяжемся с Вами!");
    }
    public void consultationFormInputTextInFields(String name, String email, String phone, String comment) {
        this.consultationFormNameField.sendKeys(name);
        this.consultationFormEmailField.sendKeys(email);
        this.consultationFormPhoneField.sendKeys(phone);
        this.consultationFormCommentField.sendKeys(comment);
    }
    public void menuButtonClick() {
        this.menuButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Contacts__Address-r5jmow-1.bRSzOS")));
        assertEquals(this.menuForm.isDisplayed(),true);
    }
    public void menuButtonClickAndWait() {
        this.menuButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Contacts__Address-r5jmow-1.bRSzOS")));
        this.banksButtonClick();
        basePage.backToMainPage();
        assertTrue(this.menuForm.isDisplayed());
    }
    public void calcullateButtonClick() {
        this.callculateButton.click();
        Long scrollYposittion = (Long) jse.executeScript("return document.getElementById('appViewPort').scrollTop");
        assertTrue(scrollYposittion != 0);
    }
    public void iDonWantWriteAnything() {
        this.iDonWantWriteAnything.click();
        assertEquals(driver.findElements(By.cssSelector(".Buttons__Prev-zho2mv-1.cOrStK.Button-sc-1wudyxw-0.gazvzc")).size(), 1);
    }
    public void nextButtonClick() {
        this.nextButton.click();
        assertEquals(driver.findElements(By.cssSelector(".Tags-sc-1h2ebty-0 > li")).size(), 0);
    }
    public void RadioButtons() {
        WebElement[] radiobuttons = new WebElement[] {
                this.radioButtonOne,
                this.radioButtonTwo};
        WebElement[] radiobuttonsActive = new WebElement[] {
                this.getRadioButtonOneACTIVE,
                this.getRadioButtonTwoACTIVE};
        for (int i =0; i < radiobuttons.length; i++) {
            radiobuttons[i].click();
            softAssert.assertNotEquals(radiobuttonsActive[i].getSize(), 0);
        }
        softAssert.assertAll();
    }
    public void programsButtonsClick() throws InterruptedException {
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
            this.moreAboutTechnology.click();
            basePage.switchTab();
            softAssert.assertEquals(driver.getCurrentUrl(), programButtonsUrls[i]);
            driver.get("http://rucard.srv.lan/");
        }
        softAssert.assertAll();
    }
    public void individualTariffPlanSelectVariants() {
        this.individualTariffPlanRadioButton1.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Tags-sc-1h2ebty-0 > li:nth-child(1)")));
        this.individualTariffPlanCheckBox1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Tags-sc-1h2ebty-0 > li:nth-child(2)")));
        this.individualTariffPlanCheckBox2.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Tags-sc-1h2ebty-0 > li:nth-child(3)")));
    }
    public void individualTariffPlanCheckBox2MultiSelect() {
        WebElement[] individualTariffPlanCheckBoxes = new WebElement[]{
                this.individualTariffPlanCheckBox2isSelected1,
                this.individualTariffPlanCheckBox2isSelected2,
                this.individualTariffPlanCheckBox2isSelected3,
                this.individualTariffPlanCheckBox2isSelected4};
        for (int i = 1; i < individualTariffPlanCheckBoxes.length; i++) {
            individualTariffPlanCheckBoxes[i].click();
        }

    }
    public void tariffFormFields(String name, String email, String phone) {
        this.nameInTarifField.sendKeys(name);
        this.emailInTarifField.sendKeys(email);
        this.phoneInTarifField.sendKeys(phone);
    }
    public void tarifCompleteForm() {
        for (int i = 0; i < 4; i++) {
            this.nextButton.click();
        }
        this.tariffFormFields("testQa", "a" + System.currentTimeMillis() + "@mail.com", "" + System.currentTimeMillis());
        this.sendTarifForm.click();
        assertEquals(driver.findElement(By.cssSelector(".SectionCalculate__Form-sc-1ofn4h0-8 > div")).getText(), "Заявка отправлена!\n" + "В ближайшее время мы свяжемся с Вами!");
    }
    public void individualTariffCheckboxIsDisplayed2() {
        for (int i = 0; i < 3; i++) {
            this.nextButton.click();
        }
        this.individualTariffPlanCheckBox2MultiSelect();
        WebElement[] TariffPlanCheckBox2AllSelected = new WebElement[] {
                this.individualTariffPlanRadioButtonIsSelected,
                this.individualTariffPlanCheckBox1isSelected,
                this.individualTariffPlanCheckBox2isSelected,
                this.individualTariffPlanCheckBox2isSelected
        };
        for (int i = 0; i < TariffPlanCheckBox2AllSelected.length; i++) {
            softAssert.assertEquals(TariffPlanCheckBox2AllSelected[i].isDisplayed(), true);
        }
        softAssert.assertAll();
    }
    public void individualTariffPlanScrollLinesChangesValue() {
        this.nextButton.click();
        this.individualTariffPlanSelectVariants();
        this.nextButton.click();
        WebElement[] TariffPlanScrollLines = new WebElement[] {
                this.individualTariffPlanScrollLine1,
                this.individualTariffPlanScrollLine2,
                this.individualTariffPlanScrollLine3};
        for (int i = 0; i < TariffPlanScrollLines.length; i++) {
            actions.clickAndHold(TariffPlanScrollLines[i]).moveByOffset(100,0).release().perform();
        }
        String[] exeptedValueOfScrolls = new String[] {"31967", "3126", "3123"};
        for (int i = 0; i < TariffPlanScrollLines.length; i++) {
            softAssert.assertEquals(TariffPlanScrollLines[i].getAttribute("aria-valuenow"), exeptedValueOfScrolls[i]);
        }
        softAssert.assertAll();
    }
    public void numerationOfBlocks() {
        String jsScript = "return window.getComputedStyle(document.querySelector('%s'),':after').getPropertyValue('content')";
        String[] classesOfBlocks = new String[] {".dGXvLy", ".gtSkkF", ".bwCGmb", ".ibuIwR", ".iWXTkA"};
        String[] numerationOfBlocks = new String[] {"\"01\"", "\"02\"", "\"03\"","\"04\"", "\"05\""};
        for (int i = 0; i < classesOfBlocks.length; i++) {
            String curBlockContent = (String) jse.executeScript(String.format(jsScript, classesOfBlocks[i]));
            softAssert.assertEquals(curBlockContent, numerationOfBlocks[i]);
        }
        softAssert.assertAll();
    }
    public void individualTariffPlanCheckboxIsDisplayed() {
        this.nextButton.click();
        this.individualTariffPlanSelectVariants();
        WebElement[] individualTariffPlan = new WebElement[] {
                this.individualTariffPlanRadioButtonIsSelected,
                this.individualTariffPlanCheckBox1isSelected,
                this.individualTariffPlanCheckBox2isSelected
        };
        for (int i = 0; i < individualTariffPlan.length; i++) {
            softAssert.assertEquals(individualTariffPlan[i].isDisplayed(), true);
        }
        softAssert.assertAll();
    }
}
