package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.Ie11App;
import org.junit.Assert;


public class Ie11StepDefs {

    //private WebDriver driver;
    private WebDriverController webDriverController;
    private Ie11App ie11App;

    private String fileName;

    public Ie11StepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        ie11App = new Ie11App(this.webDriverController);
    }

    @Given("that IE has opened")
    public void that_IE_has_opened() {
        //Handle possible Set Up dialog
        ie11App.handleIeSetUpDialog();
    }

    @Then("the expected home page is displayed in IE")
    public void the_expected_home_page_is_displayed_in_IE() {
        Assert.assertTrue("The expected Tab was not displayed! Actual Tab text is: '" + ie11App.getTabText() + "'. See attached screenshot for more information.",
                ie11App.isExpectedHomeTabDisplayed());
    }

    @When("I attempt to navigate to another site in IE")
    public void i_attempt_to_navigate_to_another_site_in_IE() {
        ie11App.navigateToTargetSite();
    }

    @Then("the expected site is displayed in IE")
    public void the_expected_site_is_displayed_in_IE() {
        Assert.assertTrue("The expected Tab was not displayed! Actual Tab text is: '" + ie11App.getTabText() + "'. See attached screenshot for more information.",
                ie11App.isExpectedTargetTabDisplayed());
    }
}
