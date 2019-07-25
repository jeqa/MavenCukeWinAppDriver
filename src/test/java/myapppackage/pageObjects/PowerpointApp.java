package myapppackage.pageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import java.security.Key;

public class PowerpointApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    private String titleText = "Title of Presentation";
    private String subTitleText = "Subtitle of Presentation";

//  Locators
    private static final By blankDocumentLink = By.name("Blank Presentation");
    private static final By titleTextBox = By.name("Title TextBox");
    private static final By subTitleTextBox = By.name("Subtitle TextBox");
    private static final By slide = By.name("Presentation1 - PowerPoint");
    private static final By mainWindow = By.name("Presentation1 - PowerPoint");
    private static final By slide2Image = By.name("Slide 2");
    private static final String slide2ImageAutomationId = "Slide257Image";



    public PowerpointApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void selectBlankDocument(){
        Click(blankDocumentLink);
    }

    public void clickSlide1() throws InterruptedException {
        Thread.sleep(2000);
        Click(slide);
    }

    public void focusOnMainWindow(){
        Click(mainWindow);
    }

    public void addSlide() throws InterruptedException{
        driver.getKeyboard().sendKeys(Keys.chord(Keys.CONTROL, "m"));
        //Thread.sleep(5000);
        //driver.findElementByName("Workspace").click();
       // clickSlide1();
        driver.getKeyboard().sendKeys(Keys.TAB);
        driver.getKeyboard().sendKeys("2");
        //driver.findElementByName("Slide 2").click();
        //enterTextViaSendKeys(titleTextBox, "2");
    }


    public void enterTitleText() {enterTextViaSendKeys(titleTextBox, titleText);
    }

    public void enterSubTitleText() {
        enterTextViaSendKeys(subTitleTextBox, subTitleText);
    }

    public void openExistingPresentation(String filename) {
        Click(By.name(filename));
    }

    public String getTitleText() {
        return Find(titleTextBox).getText().replace("\r", "");
    }

    public String getSubTitleText() {
        return Find(subTitleTextBox).getText().replace("\r", "");
    }

    public  String getExpectedTitleText(){
        return titleText;
    }

    public  String getExpectedSubTitleText(){
        return subTitleText;
    }

    public boolean isSlide2ThumbImageDisplayed(){
        try {
            driver.findElementByName("Slide 2").isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}




