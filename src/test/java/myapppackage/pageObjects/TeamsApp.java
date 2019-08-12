package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

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
        int intTopLevelWindowHandle = Integer.parseInt(Find(mainSignInWindow).getAttribute("NativeWindowHandle"));
        String hexTopLevelWindowHandle = Integer.toHexString(intTopLevelWindowHandle);
        hexTopLevelWindowHandle = "0x" + hexTopLevelWindowHandle.toUpperCase();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appTopLevelWindow", hexTopLevelWindowHandle);
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
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




