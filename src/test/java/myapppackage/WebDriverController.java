package myapppackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverController {
    private WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public void setupController(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/myapppackage/browserDrivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public void teardownController(){
        if (driver != null){
            driver.quit();
        }
    }
}
