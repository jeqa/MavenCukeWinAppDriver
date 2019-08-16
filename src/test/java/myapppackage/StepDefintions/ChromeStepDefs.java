package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.ChromeApp;
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
        Assert.assertTrue(
                "The expected Tab was not displayed! Actual Tab text is: '" + chromeApp.getTabText() + "'. See attached screenshot for more information.",
                chromeApp.isExpectedHomeTabDisplayed());
    }

    @When("I attempt to navigate to another site")
    public void i_attempt_to_navigate_to_another_site() {
        chromeApp.navigateToTargetSite();
    }

    @Then("the expected site is displayed")
    public void the_expected_site_is_displayed() throws InterruptedException {
        Assert.assertTrue(
                "The expected Tab was not displayed! Actual Tab text is: '" + chromeApp.getTabText() + "'. See attached screenshot for more information." ,
                chromeApp.isExpectedTargetTabDisplayed());
    }

    @Given("that Chrome has opened")
    public void that_Chrome_has_opened() {
        // Empty method for readability of scenario
    }
}
