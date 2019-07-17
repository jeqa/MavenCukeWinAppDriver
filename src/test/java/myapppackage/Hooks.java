package myapppackage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    WebDriverController webDriverController;
    private String browserName;
    public String browserVersion;
    public String platform;
    private String value;

    public Hooks(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
    }

    @Before
//    public void BeforeTestRun(){
//        browserName = getParameter("browser");
//        webDriverController.setupController(browserName);
//    }
    public void BeforeTestRun(Scenario scenario){
        String appId = "";
        String appArg = "";

        if (scenario.getName().contains("Word")){
            appId = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.exe";
            appArg = "/q";
        }
        else if (scenario.getName().contains("Excel")){
            appId = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.exe";
            appArg = "/e";
        }


        webDriverController.setupController(appId, appArg);
    }

    @After
    public void AfterTestRun(Scenario scenario){
//        if (scenario.isFailed()){
//            final byte[] screenshot = ((TakesScreenshot) webDriverController.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot, "image/png");
//            scenario.write("Scenario Failed on Browser Type: " + value.toUpperCase());
//        }
        webDriverController.teardownController();
    }

    private String getParameter(String name) {
        value = System.getProperty(name);
        if (value == null)
            //throw new RuntimeException(name + " is not a parameter!");
            value = "chrome";

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        return value;
    }
}
