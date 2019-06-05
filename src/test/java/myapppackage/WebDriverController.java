package myapppackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverController {
    private WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public void setupController(String browserName){

        switch (browserName){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/myapppackage/browserDrivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized", "disable-extensions");
                this.driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/myapppackage/browserDrivers/geckodriver.exe");
                this.driver = new FirefoxDriver();
                this.driver.manage().window().maximize();
                break;
        }
    }

    public void teardownController(){
        if (driver != null){
            driver.quit();
        }
    }
}
