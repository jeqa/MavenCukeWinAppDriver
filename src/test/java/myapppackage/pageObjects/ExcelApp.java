package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ExcelApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    private String initialText = "This is the initial text.";
    private String updateText = "This is an update!";

//  Locators
    private static final By blankDocumentLink = By.name("Blank document");
    private static final By document = By.className("_WwG");
    private static final By wordSaveAsBrowseLink = By.name("Browse");
    private static final By wordSaveAsDocumentsLink = By.name("Documents");
    private static final String wordSaveAsFileNameFieldAutomationId = "1001";
    private static final By wordSaveAsSaveButton = By.name("Save");


    public ExcelApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void selectBlankDocument(){
        Click(blankDocumentLink);
    }

    public void enterTextInWordDocument(){
        enterTextViaSendKeys(document, initialText);
    }

//    public void saveWordFileToDocuments(String filename){
//        Find(document).sendKeys(Keys.chord(Keys.CONTROL, "s"));
//        saveAsDialog.selectBrowseThenDocuments();
//        saveAsDialog.clearAndTypeFileNameTheSave(filename);
////        Click(wordSaveAsBrowseLink);
////        Click(wordSaveAsDocumentsLink);
////        driver.findElementByAccessibilityId(wordSaveAsFileNameFieldAutomationId).clear();
////        driver.findElementByAccessibilityId(wordSaveAsFileNameFieldAutomationId).sendKeys(filename);
////        Click(wordSaveAsSaveButton);
//    }
//
//    public void saveWordFileToDocuments(){
//        Find(document).sendKeys(Keys.chord(Keys.CONTROL, "s"));
//    }

    public void closeWord(){
        closeApp();
    }

    public void reopenWord(){
        launchApp();
    }

    public void openExistingDocument(String filename){
        Click(By.name(filename));
    }

    public String getDocumentText(){
        return Find(document).getText().replace("\r", "");
    }

    public String getInitialText(){
        return initialText;
    }

    public String getUpdateText(){
        return updateText;
    }

    public void updateTextInWordDocument(){
        Click(document);
        Find(document).sendKeys(Keys.SPACE);
        enterTextViaSendKeys(document, updateText);
    }


    }




