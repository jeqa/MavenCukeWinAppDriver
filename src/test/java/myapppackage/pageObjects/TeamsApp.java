package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TeamsApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

//  Locators
    private static final By mainSignInWindow = By.name("Microsoft Teams");

    public TeamsApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void createTeamsSession() throws MalformedURLException {
        driver = getSessionFromRoot(mainSignInWindow);
        webDriverController.setDriver(driver);
        Assert.assertNotNull(driver);
    }

    public boolean isTeamSignInMainWindowDisplayed(){
        return Find(mainSignInWindow).isDisplayed();
    }

    public void closeAppWindow(){
        driver.closeApp();
    }


}




