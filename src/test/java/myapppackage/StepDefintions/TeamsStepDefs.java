package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.TeamsApp;
import org.junit.Assert;

import java.net.MalformedURLException;


public class TeamsStepDefs {

    private WebDriverController webDriverController;
    private TeamsApp teamsApp;


    public TeamsStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        teamsApp = new TeamsApp(this.webDriverController);
    }

    @Given("that Teams has opened")
    public void that_Teams_has_opened() throws MalformedURLException, InterruptedException {
        Thread.sleep(5000);
        teamsApp.createTeamsSession();
    }

    @Then("the Teams Sign In dialog is displayed")
    public void the_Sign_In_dialog_is_displayed() {
        Assert.assertTrue(teamsApp.isTeamSignInMainWindowDisplayed());
        teamsApp.closeAppWindow();
    }

}
