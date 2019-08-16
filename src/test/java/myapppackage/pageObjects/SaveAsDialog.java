package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SaveAsDialog extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

//  Locators
    private static final By saveAsBrowseLink = By.name("Browse");
    private static final By saveAsDocumentsLink = By.name("Documents");
    private static final String saveAsFileNameFieldAutomationId = "1001";
    private static final By saveAsSaveButton = By.name("Save");


    public SaveAsDialog(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void saveFileWithCtrlPlusS(String filename){
        driver.getKeyboard().sendKeys(Keys.chord(Keys.CONTROL, "s"));
        selectBrowseThenDocuments();
        clearAndTypeFileNameTheSave(filename);
    }

    public void saveFileWithCtrlPlusSWithoutBrowse(String filename){
        driver.getKeyboard().sendKeys(Keys.chord(Keys.CONTROL, "s"));
        Click(saveAsDocumentsLink);
        clearAndTypeFileNameTheSave(filename);
    }

    public void saveFileWithCtrlPlusS(){
        driver.getKeyboard().sendKeys(Keys.chord(Keys.CONTROL, "s"));
    }



    public void clearAndTypeFileNameTheSave(String filename){
        driver.findElementByAccessibilityId(saveAsFileNameFieldAutomationId).clear();
        driver.findElementByAccessibilityId(saveAsFileNameFieldAutomationId).sendKeys(filename);
        Click(saveAsSaveButton);
    }

    public void selectBrowseThenDocuments(){
        Click(saveAsBrowseLink);
        Click(saveAsDocumentsLink);
    }




    }




