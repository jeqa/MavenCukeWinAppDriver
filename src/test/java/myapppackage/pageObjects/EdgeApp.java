package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;

public class EdgeApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    public String getTargetUrl() {
        return targetUrl;
    }



    private String targetUrl = "https://www.gov.uk/browse/tax";

//  Locators
    private static final By addressBar = By.name("Search or enter web address");
    private static final By homeTab = By.name("Welcome to GOV.UK tab");
    private static final By targetTab = By.name("Money and tax - GOV.UK tab");


    public EdgeApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
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




