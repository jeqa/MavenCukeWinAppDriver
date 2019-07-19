package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.ChromeApp;
import myapppackage.pageObjects.PowerpointApp;
import myapppackage.pageObjects.SaveAsDialog;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ChromeStepDefs {

    //private WebDriver driver;
    private WebDriverController webDriverController;
    private ChromeApp chromeApp;

    private String fileName;

    public ChromeStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        chromeApp = new ChromeApp(this.webDriverController);
    }

    @Then("the expected home page is displayed")
    public void the_expected_home_page_is_displayed() {
        Assert.assertTrue("Actual Address is: " + chromeApp.getCurrentUrl(),
                chromeApp.getCurrentUrl().equalsIgnoreCase(chromeApp.getHomeUrl()));
    }

    @When("I attempt to navigate to another site")
    public void i_attempt_to_navigate_to_another_site() {
        chromeApp.navigateToTargetSite();
    }

    @Then("the expected site is displayed")
    public void the_expected_site_is_displayed() {
        Assert.assertTrue("Actual Address is: " + chromeApp.getCurrentUrl(),
                chromeApp.getCurrentUrl().equalsIgnoreCase(chromeApp.getTargetUrl()));
    }

    @Then("Chrome is opened as expected")
    public void chrome_is_opened_as_expected() {
        Assert.assertTrue(chromeApp.isExpectedTabDisplayed());
    }
}
