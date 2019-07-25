package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.NotepadApp;
import myapppackage.pageObjects.SaveAsDialog;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;


public class NotepadStepDefs {

    //private WebDriver driver;
    private WebDriverController webDriverController;
    private NotepadApp notepadApp;
    SaveAsDialog saveAsDialog;
    private String fileName;


    public NotepadStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
            notepadApp = new NotepadApp(this.webDriverController);
            saveAsDialog = new SaveAsDialog((this.webDriverController));
    }

    @Given("I have opened Notepad")
    public void i_have_opened_Notepad() {

    }

    @When("I enter text into the text file")
    public void i_enter_text_into_the_text_file() {
        notepadApp.enterInitialText();
    }

    @When("save the text file")
    public void save_the_text_file() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        fileName = "wordfile_" + timestamp;
        saveAsDialog.saveFileWithCtrlPlusSWithoutBrowse(fileName);
    }

    @Then("the entered text is retained in the text file")
    public void the_entered_text_is_retained_in_the_text_file() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


}
