package myapppackage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    WebDriverController webDriverController;
    public String browserName;
    public String browserVersion;
    public String platform;

    public Hooks(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
    }

    @Before
    public void BeforeTestRun(){
        browserName = getParameter("browser");
        webDriverController.setupController(browserName);
    }

    @After
    public void AfterTestRun(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) webDriverController.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        webDriverController.teardownController();
    }

    private String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            //throw new RuntimeException(name + " is not a parameter!");
            value = "chrome";


        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");


        return value;
    }
}
