package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;

public class AcrobatReaderApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;



//  Locators
    private static final By signInRequiredText = By.name("Sign In Required");


    public AcrobatReaderApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

public Boolean isSignInRequiredTextDisplayed(){
        return isElementDisplayed(signInRequiredText);
}




}




