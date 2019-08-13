package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import myapppackage.WebDriverController;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AcrobatReaderApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

//  Locators
    private static final By mainWindow = By.name("Adobe Acrobat");
    private static final By signInRequiredText = By.name("Sign In Required");
    private static final By quitDialog = By.name("Quit");
    private static final By quitDialogYesButton = By.name("Yes");


    public AcrobatReaderApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void createAcrobatSession() throws MalformedURLException {
//        int intTopLevelWindowHandle = Integer.parseInt(Find(mainWindow).getAttribute("NativeWindowHandle"));
//        String hexTopLevelWindowHandle = Integer.toHexString(intTopLevelWindowHandle);
//        hexTopLevelWindowHandle = "0x" + hexTopLevelWindowHandle.toUpperCase();
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("appTopLevelWindow", hexTopLevelWindowHandle);
//        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
//        Assert.assertNotNull(driver);
        driver = getSessionFromRoot(mainWindow);
        webDriverController.setDriver(driver);
        Assert.assertNotNull(driver);
    }

    public Boolean isSignInRequiredTextDisplayed(){
        boolean thereOrNot = Find(signInRequiredText).isDisplayed();
//        driver.closeApp();
//        if (Find(quitDialog).isDisplayed()) {
//            Click(quitDialogYesButton);
//        }
        return thereOrNot;
        }

    public void closeAppWindow(){
        driver.closeApp();
        if (Find(quitDialog).isDisplayed()) {
            Click(quitDialogYesButton);
        }
    }
}




