package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.EdgeApp;
import myapppackage.pageObjects.Ie11App;
import org.junit.Assert;


public class EdgeStepDefs {

    //private WebDriver driver;
    private WebDriverController webDriverController;
    private EdgeApp edgeApp;

    private String fileName;

    public EdgeStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        edgeApp = new EdgeApp(this.webDriverController);
    }

    @Given("that Edge has opened")
    public void that_Edge_has_opened() {
    }

    @Then("the expected home page is displayed in Edge")
    public void the_expected_home_page_is_displayed_in_Edge() {
        Assert.assertTrue("The expected Tab was not displayed! Actual Tab text is: '" + edgeApp.getTabText() + "'. See attached screenshot for more information.",
                edgeApp.isExpectedHomeTabDisplayed());
    }

    @When("I attempt to navigate to another site in Edge")
    public void i_attempt_to_navigate_to_another_site_in_Edge() {
        edgeApp.navigateToTargetSite();
    }

    @Then("the expected site is displayed in Edge")
    public void the_expected_site_is_displayed_in_Edge() {
        boolean boolTargetTab = edgeApp.isExpectedTargetTabDisplayed();
        Assert.assertTrue("The expected Tab was not displayed! Actual Tab text is: '" + edgeApp.getTabText() + "'. See attached screenshot for more information.",
                boolTargetTab);
    }
}
