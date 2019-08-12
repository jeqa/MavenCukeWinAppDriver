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
    private WindowsDriver loadingWindowSession;
    WebDriverController webDriverController;

//  Locators
    private static final By mainSignInWindow = By.name("Microsoft Teams");
    private static final By loadingTeamsWindow = By.name("Loading Microsoft Teams");

    public TeamsApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void createTeamsLoadingSession() throws MalformedURLException {
        int intTopLevelWindowHandle = Integer.parseInt(Find(loadingTeamsWindow).getAttribute("NativeWindowHandle"));
        String hexTopLevelWindowHandle = Integer.toHexString(intTopLevelWindowHandle);
        hexTopLevelWindowHandle = "0x" + hexTopLevelWindowHandle.toUpperCase();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appTopLevelWindow", hexTopLevelWindowHandle);
        loadingWindowSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        Assert.assertNotNull(loadingWindowSession);
    }

    public boolean isTeamSignInMainWindowDisplayed(){
        boolean thereOrNot = Find(mainSignInWindow).isDisplayed();
        loadingWindowSession.closeApp();
        return thereOrNot;
    }


}




