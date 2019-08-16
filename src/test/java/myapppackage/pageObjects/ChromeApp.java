package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ChromeApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    public String getTargetUrl() {
        return targetUrl;
    }

    private String targetUrl = "https://www.gov.uk/browse/tax";

//  Locators
    private static final By addressBar = By.name("Address and search bar");
    private static final By homeTab = By.name("Welcome to GOV.UK - Google Chrome");
    private static final By targetTab = By.name("Money and tax - GOV.UK - Google Chrome");
    private static final By tabClass = By.className("Chrome_WidgetWin_1");


    public ChromeApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public String getTabText(){
        return Find(tabClass).getText();
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

    public boolean isExpectedTargetTabDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        return isElementDisplayed(targetTab);
    }


}




