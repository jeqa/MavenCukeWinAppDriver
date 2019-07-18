package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ChromeApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    private String targetUrl = "https://www.bbc.com/news";

//  Locators
    private static final By addressBar = By.name("Address and search bar");


    public ChromeApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void navigateToTargetSite(){
        ClearAndTypeIntoField(addressBar, targetUrl);
        Find(addressBar).sendKeys(Keys.ENTER);
    }

    public boolean isExpectedTabDisplayed(){
        return driver.findElementByName("New Tab - Google Chrome").isDisplayed();
    }


}




