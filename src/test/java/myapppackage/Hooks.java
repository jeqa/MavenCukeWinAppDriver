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
    AppConfig app;

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
        boolean maximizeFlag = false;

        if (scenario.getName().contains("Word")){
            app = AppConfig.word;
        }
        else if (scenario.getName().contains("Excel")){
            app = AppConfig.excel;
        }
        else if (scenario.getName().contains("Outlook")){
            app = AppConfig.outlook;
        }
        else if (scenario.getName().contains("Powerpoint")){
            app = AppConfig.powerpoint;
        }
        else if (scenario.getName().contains("Chrome")){
            app = AppConfig.chrome;
        }
        else if (scenario.getName().contains("IE11")){
            app = AppConfig.ie11;
        }
        else if (scenario.getName().contains("Edge")){
            app = AppConfig.edge;
        }
        else if (scenario.getName().contains("Acrobat")){
            app = AppConfig.acrobat;
        }
        else if (scenario.getName().contains("Notepad")){
            app = AppConfig.notepad;
        }
        else if (scenario.getName().contains("Calculator")){
            app = AppConfig.calculator;
        }
        else if (scenario.getName().contains("Firefox")){
            app = AppConfig.firefox;
        }
        else if (scenario.getName().contains("Teams")){
            app = AppConfig.teams;
        }

        appId = app.getAppId();
        appArg = app.getAppArg();
        maximizeFlag = app.isMaximizeFlag();

        webDriverController.setupController(appId, appArg, maximizeFlag);
    }

    @After
    public void AfterTestRun(Scenario scenario){
        try {
            if (scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot) webDriverController.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
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
