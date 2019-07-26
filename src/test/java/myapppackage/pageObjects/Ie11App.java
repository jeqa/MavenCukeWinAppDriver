package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Ie11App extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    public String getTargetUrl() {
        return targetUrl;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    private String targetUrl = "https://www.bbc.com/news";
    private String homeUrl = "https://www.bbc.co.uk/";

//  Locators
    private static final By addressBar = By.name("Address and search using Bing");
    private static final By setUpDialogDontUseRadioButton = By.name("Don’t use recommended settings");
    private static final By setUpDialogOkButton = By.name("OK");
    private static final By homeTab = By.name("BBC - Homepage");
    private static final By targetTab = By.name("Home - BBC News");


    public Ie11App(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void handleIeSetUpDialog(){
        try {
            if (driver.findElement(setUpDialogDontUseRadioButton).isDisplayed()){
                Click(setUpDialogDontUseRadioButton);
                Click(setUpDialogOkButton);
            }
        } catch (Exception e){

        }
    }

    public void navigateToTargetSite(){
        navigateToSiteViaAddressBar(addressBar, targetUrl);
    }

    public String getCurrentUrl(){
        return getCurrentUrlFromAddressBar(addressBar);
    }

    public boolean isExpectedHomeTabDisplayed(){
        return isElementDisplayed(homeTab);
    }

    public boolean isExpectedTargetTabDisplayed(){
        return isElementDisplayed(targetTab);
    }


}




