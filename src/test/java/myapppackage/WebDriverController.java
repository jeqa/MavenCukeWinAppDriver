package myapppackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverController {
    private WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public void setupController(){

        switch ("firefox"){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/myapppackage/browserDrivers/chromedriver.exe");
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/myapppackage/browserDrivers/geckodriver.exe");
                this.driver = new FirefoxDriver();
                break;
        }
    }

    public void teardownController(){
        if (driver != null){
            driver.quit();
        }
    }
}
