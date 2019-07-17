package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;

public class PowerpointApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    private String titleText = "Title of Presentation";
    private String subTitleText = "Subtitle of Presentation";

//  Locators
    private static final By blankDocumentLink = By.name("Blank Presentation");
    private static final By titleTextBox = By.name("Title TextBox");
    private static final By subTitleTextBox = By.name("Subtitle TextBox");



    public PowerpointApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void selectBlankDocument(){
        Click(blankDocumentLink);
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
}




