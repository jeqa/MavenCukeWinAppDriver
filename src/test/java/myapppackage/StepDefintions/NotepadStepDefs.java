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

    
    private WebDriverController webDriverController;
    private NotepadApp notepadApp;
    private SaveAsDialog saveAsDialog;
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
    public void i_enter_text_into_the_text_file() throws InterruptedException {
        notepadApp.enterText();
    }

    @When("save the text file")
    public void save_the_text_file() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        fileName = "textfile_" + timestamp;
        saveAsDialog.saveFileWithCtrlPlusSWithoutBrowse(fileName);
        notepadApp.closeApp();
    }

    @Then("the entered text is retained in the text file")
    public void the_entered_text_is_retained_in_the_text_file() {
        notepadApp.launchApp();
        notepadApp.openSavedTextFileInNotepad(fileName);
        String expectedText = notepadApp.getInitialText();
        String notepadText = notepadApp.getNotepadText();
        Assert.assertTrue("Expected text '" + expectedText + "' was not matched with '" + notepadText,
                expectedText.equalsIgnoreCase(notepadText));
    }

    @Given("I have created and saved a text file")
    public void i_have_created_and_saved_a_text_file() throws InterruptedException {
        i_enter_text_into_the_text_file();
        save_the_text_file();
    }

    @When("I update the text file")
    public void i_update_the_text_file() throws InterruptedException {
        notepadApp.launchApp();
        notepadApp.openSavedTextFileInNotepad(fileName);
        notepadApp.updateTextinTextFile();
    }

    @When("save the text file using existing filename")
    public void save_the_text_file_using_existing_filename() {
        saveAsDialog.saveFileWithCtrlPlusS();
        notepadApp.closeApp();
    }

    @Then("the updated text is retained in the text file")
    public void the_updated_text_is_retained_in_the_text_file() {
        notepadApp.launchApp();
        notepadApp.openSavedTextFileInNotepad(fileName);
        String expectedText = notepadApp.getInitialText() + notepadApp.getUpdateText();
        String notepadText = notepadApp.getNotepadText();
        Assert.assertTrue("Expected text '" + expectedText + "' was not matched with '" + notepadText +"'!",
                expectedText.equalsIgnoreCase(notepadText));
    }




}
