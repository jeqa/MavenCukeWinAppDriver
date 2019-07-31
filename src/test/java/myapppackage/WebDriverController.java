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

    public WindowsDriver setupController(String appIdentifier, String appArgument){
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", appIdentifier);

            if (appArgument.length() > 0){
                capabilities.setCapability("appArguments", appArgument);}

            this.driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            Assert.assertNotNull(driver);
            if (!appIdentifier.contains("chrome") && (!appIdentifier.contains("OUTLOOK"))){
                this.driver.manage().window().maximize();}
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            Thread.sleep(5000);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }

        return null;
    }


    public void teardownController(){
        if (driver != null){
            driver.quit();
        }
    }

}
