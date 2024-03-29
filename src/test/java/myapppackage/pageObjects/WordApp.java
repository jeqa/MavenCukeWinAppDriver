package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class WordApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    private String initialText = "This is the initial text.";
    private String updateText = "This is an update!";

//  Locators
    private static final By blankDocumentLink = By.name("Blank document");
    private static final By document = By.className("_WwG");


    public WordApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void selectBlankDocument(){
        Click(blankDocumentLink);
    }

    public void enterTextInWordDocument() throws InterruptedException {
        enterTextViaSendKeys(document, initialText);
    }

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

    public void updateTextInWordDocument() throws InterruptedException {
        Click(document);
        Find(document).sendKeys(Keys.SPACE);
        enterTextViaSendKeys(document, updateText);
    }


    }




