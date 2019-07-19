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

    public String getHomeUrl() {
        return homeUrl;
    }

    private String targetUrl = "https://www.bbc.co.uk/news";
    private String homeUrl = "https://www.bbc.co.uk";


//  Locators
    private static final By addressBar = By.name("Address and search bar");
    private static final By homeTab = By.name("BBC - Home - Google Chrome");
    private static final By targetTab = By.name("Home - BBC News - Google Chrome");


    public ChromeApp(WebDriverController webDriverController){
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




