package myapppackage.StepDefintions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.OutlookApp;
import myapppackage.pageObjects.SaveAsDialog;
import org.junit.Assert;

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
        Thread.sleep(8000);
        outlookApp.clickNewEmail();
    }

    @And("The user composes the E-mail")
    public void theUserComposesTheEmail() throws InterruptedException, MalformedURLException {
        outlookApp.composeEmail("Demo text","Demo","testuser1@erslabs.onmicrosoft.com");
    }


    @Then("the User can send the e-mail to the recipient and confirm the email has been received")
    public void theUserCanSendTheEMailTheRecipient() throws InterruptedException {
        outlookApp.pressSend();
        Thread.sleep(2000);
        Assert.assertTrue(outlookApp.assertNewEmail().equalsIgnoreCase("Demo text"));
        outlookApp.deleteEmail();


    }

    @When("I click the Calendar button")
    public void iClickTheCalendarButton() throws InterruptedException {
        outlookApp.clickCalendar();
    }

    @And("the user completes the calendar invite")
    public void theUserCompletesTheCalendarInvite() throws MalformedURLException, InterruptedException {

        outlookApp.composeCalendarEntry("Calendar body text", "Calendar Text", "Glasgow", "testuser1@erslabs.onmicrosoft.com");
    }

    @And("I click the new appointment button")
    public void iClickTheNewAppointmentButton() throws MalformedURLException, InterruptedException {
        outlookApp.clickNewAppointmentButton();
    }
}
