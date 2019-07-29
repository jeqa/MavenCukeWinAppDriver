package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class NotepadApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;



//  Locators
    private static final By textEditor = By.name("Text Editor");


    private String initialText = "This is the initial text.";
    private String updateText = "This is an update!";

    public String getInitialText() {
        return initialText;
    }

    public String getUpdateText() {
        return updateText;
    }

    public NotepadApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void enterText() throws InterruptedException {
        enterTextViaSendKeys(textEditor, initialText);
    }

    public String getNotepadText() {
        return Find(textEditor).getText();
    }

    public void openSavedTextFileInNotepad(String filename){
        Find(textEditor).sendKeys(Keys.chord(Keys.CONTROL, "o"));
        driver.findElementByName("Documents").click();
        driver.findElementByAccessibilityId("1148").clear();
        driver.findElementByAccessibilityId("1148").sendKeys(filename + ".txt");
        driver.findElementByAccessibilityId("1").click();
    }

    public void updateTextinTextFile() throws InterruptedException {
        Find(textEditor).sendKeys(Keys.END);
        enterTextViaSendKeys(textEditor, updateText);
    }

}




