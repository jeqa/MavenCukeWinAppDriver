package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.EdgeApp;
import myapppackage.pageObjects.FirefoxApp;
import org.junit.Assert;


public class FirefoxStepDefs {

    //private WebDriver driver;
    private WebDriverController webDriverController;
    private FirefoxApp firefoxApp;

    private String fileName;

    public FirefoxStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        firefoxApp = new FirefoxApp(this.webDriverController);
    }

    @Given("that Firefox has opened")
    public void that_Firefox_has_opened() {
    }

    @Then("the expected home page is displayed in Firefox")
    public void the_expected_home_page_is_displayed_in_Edge() {
        Assert.assertTrue(firefoxApp.isExpectedHomeTabDisplayed());
    }

    @When("I attempt to navigate to another site in Firefox")
    public void i_attempt_to_navigate_to_another_site_in_Firefox() {
        firefoxApp.navigateToTargetSite();
    }

    @Then("the expected site is displayed in Firefox")
    public void the_expected_site_is_displayed_in_Firefox() {
        Assert.assertTrue(firefoxApp.isExpectedTargetTabDisplayed());
    }
}
