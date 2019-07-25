package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;

public class NotepadApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;



//  Locators
    private static final By textEditor = By.name("Text Editor");

    private String initialText = "This is the initial text.";
    private String updateText = "This is an update!";


    public NotepadApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void enterInitialText(){
        enterTextViaSendKeys(textEditor, initialText);
    }






}




