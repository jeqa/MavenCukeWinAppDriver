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
        webDriverController.setupController();
    }

    @After
    public void AfterTestRun(){
        webDriverController.teardownController();
    }
}
