package srv.rucard.pages;

import org.openqa.selenium.WebDriver;
import srv.rucard.PageObject;

import static srv.rucard.BasePage.jse;
import static srv.rucard.BasePage.softAssert;

public class VirtualCardPage extends PageObject {

//LOCATORS

//SUPER DRIVER

    public VirtualCardPage(WebDriver driver) {
        super(driver);
    }

//OPERATIONS

    public void numerationOfBlocks() {
        String jsScript = "return window.getComputedStyle(document.querySelector('%s'),':after').getPropertyValue('content')";
        String[] classesOfBlocks = new String[]{".dGXvLy"};
        String[] numerationOfBlocks = new String[]{"\"01\""};
        for (int i = 0; i < classesOfBlocks.length; i++) {
            String curBlockContent = (String) jse.executeScript(String.format(jsScript, classesOfBlocks[i]));
            softAssert.assertEquals(curBlockContent, numerationOfBlocks[i]);
        }
        softAssert.assertAll();
    }
}
