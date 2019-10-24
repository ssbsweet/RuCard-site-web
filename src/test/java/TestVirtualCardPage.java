import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import srv.rucard.BasePage;
import srv.rucard.pages.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestVirtualCardPage extends BasePage {

//BEFORE ANY TEST IN THIS CLASS

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.get("http://rucard.srv.lan/virtualcard");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage = new BasePage();
        this.virtualCardPage = new VirtualCardPage(driver);
        jse = (JavascriptExecutor) driver;
    }

//TESTS

    @Test
    public void backToMainPageCheck() {
        basePage.backToMainPage();
    }
    @Test
    public void numerationOfBlocks() {
        String jsScript = "return window.getComputedStyle(document.querySelector('%s'),':after').getPropertyValue('content')";
        String[] classesOfBlocks = new String[]{".dGXvLy"};
        String[] numerationOfBlocks = new String[]{"\"01\""};
        for (int i = 0; i < classesOfBlocks.length; i++) {
            String curBlockContent = (String) jse.executeScript(String.format(jsScript, classesOfBlocks[i]));
            assertEquals(curBlockContent, numerationOfBlocks[i]);
        }
    }
    @Test
    public void goToYandexMaps() {
        basePage.goToYandexMaps();
        basePage.checkYandexMapsCoordinates();
    }
}
