package myapppackage;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;

public class WebDriverController {
    private WindowsDriver driver;
    public String browserType;

    public WindowsDriver getDriver(){
        return driver;
    }

    public void setDriver(WindowsDriver driver){
        this.driver = driver;
    }

    public void setupController(String appIdentifier, String appArgument){
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", appIdentifier);
            if (appArgument.length() > 0){
                capabilities.setCapability("appArguments", appArgument);}
            this.driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            Assert.assertNotNull(driver);
            if (!appIdentifier.contains("chrome")){
                this.driver.manage().window().maximize();}
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            Thread.sleep(5000);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }

    }



//    public void setupController(String browserName){
//
//        switch (browserName){
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "src/test/resources/myapppackage/browserDrivers/chromedriver.exe");
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("start-maximized", "disable-extensions");
//                this.driver = new ChromeDriver(chromeOptions);
//                break;
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "src/test/resources/myapppackage/browserDrivers/geckodriver.exe");
//                this.driver = new FirefoxDriver();
//                this.driver.manage().window().maximize();
//                break;
//        }
//    }

    public void teardownController(){
        if (driver != null){
            driver.quit();
        }
    }

    public Capabilities GetDriverCapabilites(){
        Capabilities capabilites = ((RemoteWebDriver)driver).getCapabilities();
        return capabilites;
    }
}
