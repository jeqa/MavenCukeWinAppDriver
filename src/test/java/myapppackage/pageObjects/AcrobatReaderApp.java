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
    private WindowsDriver desktopSession;
    WebDriverController webDriverController;



//  Locators
    private static final By signInRequiredText = By.name("Sign In Required");


    public AcrobatReaderApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
        desktopSession = webDriverController.getDesktopSession();
    }

    public void findAcrobatSession() throws MalformedURLException {

        Integer intTopLevelWindowHandle = Integer.parseInt(desktopSession.findElementByName("Adobe Acrobat").getAttribute("NativeWindowHandle"));
        String hexTopLevelWindowHandle = Integer.toHexString(intTopLevelWindowHandle);
        hexTopLevelWindowHandle = "0x" + hexTopLevelWindowHandle.toUpperCase();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appTopLevelWindow", hexTopLevelWindowHandle);
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        Assert.assertNotNull(driver);

        //return desktopSession.findElementByName("Adobe Acrobat").isDisplayed();
    }


    public Boolean isSignInRequiredTextDisplayed(){
        boolean thereOrNot = driver.findElement(signInRequiredText).isDisplayed();
        driver.closeApp();
        return thereOrNot;
        }
}




