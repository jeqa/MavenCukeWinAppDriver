package myapppackage;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    WebDriverController webDriverController;

    public Hooks(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
    }

    @Before
    public void BeforeTestRun(){
        String browserName = getParameter("browser");
        webDriverController.setupController(browserName);
    }

    @After
    public void AfterTestRun(){
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
