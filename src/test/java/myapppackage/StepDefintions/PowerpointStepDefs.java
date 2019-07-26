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
    private WebDriverController webDriverController;
    private PowerpointApp powerpointApp;
    private SaveAsDialog saveAsDialog;

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
    public void i_enter_text_into_the_Title_box() throws InterruptedException {
        powerpointApp.clickSlide1();
        powerpointApp.enterTitleText();
    }

    @When("I enter text into the subtitle box")
    public void i_enter_text_into_the_subtitle_box() throws InterruptedException {
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
        Assert.assertTrue(powerpointApp.getTitleText().equalsIgnoreCase(powerpointApp.getExpectedTitleText()));
        Assert.assertTrue(powerpointApp.getSubTitleText().equalsIgnoreCase(powerpointApp.getExpectedSubTitleText()));
    }

    @Given("I have created and saved a Powerpoint file")
    public void i_have_created_and_saved_a_Powerpoint_file() throws InterruptedException {
        i_have_opened_Powerpoint();
        i_enter_text_into_the_Title_box();
        save_the_Powerpoint_file();
    }

    @When("I update the Powerpoint file")
    public void i_update_the_Powerpoint_file() throws InterruptedException {
        powerpointApp.launchApp();
        powerpointApp.openExistingPresentation(fileName + ".pptx");
        i_enter_text_into_the_subtitle_box();
    }

    @When("save the Powerpoint file using existing filename")
    public void save_the_Powerpoint_file_using_existing_filename() {
        saveAsDialog.saveFileWithCtrlPlusS();
        powerpointApp.closeApp();
    }

    @Then("the updated slide text is retained")
    public void the_updated_slide_text_is_retained() {
        powerpointApp.launchApp();
        powerpointApp.openExistingPresentation(fileName + ".pptx");
        Assert.assertTrue(powerpointApp.getSubTitleText().equalsIgnoreCase(powerpointApp.getExpectedSubTitleText()));
    }

    @When("I add a slide to the Powerpoint file")
    public void i_add_a_slide_to_the_Powerpoint_file()throws InterruptedException {
        powerpointApp.focusOnMainWindow();
        powerpointApp.addSlide();
    }

    @Then("the added slide is retained")
    public void the_added_slide_is_retained() {
        powerpointApp.launchApp();
        powerpointApp.openExistingPresentation(fileName + ".pptx");
        Assert.assertTrue(powerpointApp.isSlide2ThumbImageDisplayed());
    }

}
