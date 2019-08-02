package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.swing.table.TableCellRenderer;

public class FirefoxApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    public String getTargetUrl() {
        return targetUrl;
    }



    private String targetUrl = "https://www.gov.uk/browse/tax";

//  Locators
    private static final By mainWindow = By.name("Welcome to GOV.UK - Mozilla Firefox");
    private static final By homeTab = By.name("Welcome to GOV.UK");
    private static final By targetTab = By.name("Mney and tax - GOV.UK");
    private static final By tabLocator = By.tagName("TabItem");


    public FirefoxApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public String getTabText(){
        return Find(tabLocator).getText();
    }

    public void navigateToTargetSite(){
        Click(mainWindow);
        driver.getKeyboard().sendKeys(Keys.chord(Keys.ALT, "d"));
        driver.getKeyboard().sendKeys(targetUrl);
        driver.getKeyboard().sendKeys(Keys.ENTER);
    }

    public boolean isExpectedHomeTabDisplayed(){
        return isElementDisplayed(homeTab);
    }

    public boolean isExpectedTargetTabDisplayed(){
        return isElementDisplayed(targetTab);
    }


}




