package myapppackage;


import org.junit.Assert;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;

public class WebDriverController {
    private WindowsDriver driver;

    public WindowsDriver getDriver(){
        return driver;
    }

    public void setDriver(WindowsDriver driver){
        this.driver = driver;
    }

    public void setupController(String appIdentifier, String appArgument, Boolean toBeMaximised){
        Assert.assertFalse("WARNING: Unable to start session as Application was not determined from Scenario!!!", appIdentifier.isEmpty());
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", appIdentifier);

            if (appArgument.length() > 0){
                capabilities.setCapability("appArguments", appArgument);}

            this.driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            Assert.assertNotNull(driver);
            //if (!appIdentifier.contains("chrome")){
            if (toBeMaximised){
                this.driver.manage().window().maximize();}
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            Thread.sleep(5000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void teardownController(){
        if (driver != null){
            driver.quit();
        }
    }

}
