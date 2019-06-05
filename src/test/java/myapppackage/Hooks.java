package myapppackage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriverController webDriverController;
    WebDriver driver;

    public Hooks(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
    }

    @Before
    public void BeforeTestRun(){
        webDriverController.setupController();
        driver = webDriverController.getDriver();
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @After
    public void AfterTestRun(){
        webDriverController.teardownController();
    }
}
