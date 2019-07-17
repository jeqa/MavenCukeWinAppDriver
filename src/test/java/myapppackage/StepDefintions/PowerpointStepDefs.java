package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.ExcelApp;
import myapppackage.pageObjects.PowerpointApp;
import myapppackage.pageObjects.SaveAsDialog;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;


public class PowerpointStepDefs {

    //private WebDriver driver;
    WebDriverController webDriverController;
    PowerpointApp powerpointApp;
    SaveAsDialog saveAsDialog;

    private String fileName;

    public PowerpointStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        powerpointApp = new PowerpointApp(this.webDriverController);
        saveAsDialog = new SaveAsDialog(this.webDriverController);
    }

    @Given("I have opened Powerpoint")
    public void i_have_opened_Powerpoint() {
        powerpointApp.selectBlankDocument();
    }

    @When("I enter text into the Title box")
    public void i_enter_text_into_the_Title_box() {
        powerpointApp.enterTitleText();
    }

    @When("I enter text into the subtitle box")
    public void i_enter_text_into_the_subtitle_box() {
        powerpointApp.enterSubTitleText();
    }

    @When("save the Powerpoint file")
    public void save_the_Powerpoint_file() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        fileName = "ppfile_" + timestamp;
        saveAsDialog.saveFileWithCtrlPlusS(fileName);
        powerpointApp.closeApp();
    }

    @Then("the entered slide text is retained")
    public void the_entered_slide_text_is_retained() {
        powerpointApp.launchApp();
        powerpointApp.openExistingPresentation(fileName + ".pptx");
        powerpointApp.getTitleText();
        Assert.assertTrue(powerpointApp.getTitleText().equalsIgnoreCase(powerpointApp.getExpectedTitleText()));
        Assert.assertTrue(powerpointApp.getSubTitleText().equalsIgnoreCase(powerpointApp.getExpectedSubTitleText()));
    }

}
