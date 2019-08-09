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
        boolean maximizeFlag = false;

        if (scenario.getName().contains("Word")){
//            appId = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.exe";
            appId = "C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.exe";
            appArg = "/q";
            maximizeFlag = true;
        } else if (scenario.getName().contains("Excel")){
//            appId = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.exe";
            appId = "C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.exe";
            appArg = "/e";
            maximizeFlag = true;
        } else if (scenario.getName().contains("Outlook")){
            appId = "C:\\Program Files\\Microsoft Office\\root\\Office16\\OUTLOOK.EXE";
            maximizeFlag = true;
        }
        else if (scenario.getName().contains("Powerpoint")){
//            appId = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\POWERPNT.exe";
            appId = "C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.exe";
            appArg = "/s";
            maximizeFlag = true;
        }
        else if (scenario.getName().contains("Chrome")){
            appId = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
            appArg = "--start-maximized";
            maximizeFlag = false;
        }
        else if (scenario.getName().contains("IE11")){
            appId = "C:\\Program Files\\internet explorer\\iexplore.exe";
            maximizeFlag = true;
        }
        else if (scenario.getName().contains("Edge")){
            appId = "Microsoft.MicrosoftEdge_8wekyb3d8bbwe!MicrosoftEdge";
            maximizeFlag = true;
        }
        else if (scenario.getName().contains("Acrobat")){
//            appId = "C:\\Program Files (x86)\\Adobe\\Acrobat Reader DC\\Reader\\AcroRd32.exe";
            appId = "C:\\Program Files (x86)\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe";
            maximizeFlag = true;
        }
        else if (scenario.getName().contains("Notepad")){
            appId = "C:\\Windows\\System32\\notepad.exe";
            maximizeFlag = true;
        }
        else if (scenario.getName().contains("Calculator")){
            appId = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";
            maximizeFlag = true;
        }
        else if (scenario.getName().contains("Firefox")){
            appId = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
            maximizeFlag = true;
        }

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
