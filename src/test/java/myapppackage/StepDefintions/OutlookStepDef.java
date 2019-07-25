package myapppackage.StepDefintions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.OutlookApp;
import myapppackage.pageObjects.SaveAsDialog;

import java.net.MalformedURLException;

public class OutlookStepDef {

    WebDriverController webDriverController;
    OutlookApp outlookApp;
    SaveAsDialog saveAsDialog;

    public OutlookStepDef(WebDriverController webDriverController) throws MalformedURLException {
        this.webDriverController = webDriverController;
        outlookApp = new OutlookApp(this.webDriverController);
        saveAsDialog = new SaveAsDialog(this.webDriverController);
    }


    @Given("I have opened Outlook")
    public void iHaveOpenedOutlook() {

    }

    @When("I click the New Email button")
    public void iClickTheNewEmailButton() throws InterruptedException, MalformedURLException {
        outlookApp.clickNewEmail();
    }

    @And("A User Enters some text into an email")
    public void aUserEntersSomeTextIntoAnEmail() throws InterruptedException, MalformedURLException {
        outlookApp.enterText("Demo text");
    }


    @Then("the User can send the e-mail the recipient")
    public void theUserCanSendTheEMailTheRecipient() {
        outlookApp.enterSubject();
        outlookApp.enterEmailAddress();
        outlookApp.pressSend();

    }
}
