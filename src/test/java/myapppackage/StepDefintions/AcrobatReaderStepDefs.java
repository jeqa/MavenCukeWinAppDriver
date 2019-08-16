package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.AcrobatReaderApp;
import org.junit.Assert;
import java.net.MalformedURLException;


public class AcrobatReaderStepDefs {

    //private WebDriver driver;
    private WebDriverController webDriverController;
    private AcrobatReaderApp acrobatReaderApp;


    public AcrobatReaderStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        acrobatReaderApp = new AcrobatReaderApp(this.webDriverController);
    }

    @Given("that Acrobat Reader has opened")
    public void that_Acrobat_Reader_has_opened() throws MalformedURLException {
        acrobatReaderApp.createAcrobatSession();
    }

    @Then("the Sign In dialog is displayed")
    public void the_Sign_In_dialog_is_displayed() {
        Assert.assertTrue("Fail! The sign in dialog has not been displayed!", acrobatReaderApp.isSignInRequiredTextDisplayed());
        acrobatReaderApp.closeAppWindow();
    }


}
