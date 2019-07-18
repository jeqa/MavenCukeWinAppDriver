package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.SaveAsDialog;
import org.junit.Assert;
import myapppackage.pageObjects.WordApp;

import java.text.SimpleDateFormat;
import java.util.Date;


public class WordStepDefs {

    //private WebDriver driver;
    WebDriverController webDriverController;
    WordApp wordApp;
    SaveAsDialog saveAsDialog;

    private String fileName;

    public WordStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        wordApp = new WordApp(this.webDriverController);
        saveAsDialog = new SaveAsDialog(this.webDriverController);
    }

    @Given("I have opened Word")
    public void i_have_opened_Word() {
        wordApp.selectBlankDocument();
    }

    @When("I enter text")
    public void i_enter_text() {
        wordApp.enterTextInWordDocument();
    }

    @When("save the document")
    public void save_the_document() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        fileName = "wordfile_" + timestamp;
        saveAsDialog.saveFileWithCtrlPlusS(fileName);
        wordApp.closeWord();
    }

    @Then("the entered text is retained")
    public void the_entered_text_is_retained() {
        wordApp.reopenWord();
        wordApp.openExistingDocument(fileName + ".docx");
        Assert.assertTrue(wordApp.getDocumentText().equalsIgnoreCase(wordApp.getInitialText()));
    }

    @Given("I have created and saved a Word Document")
    public void i_have_created_and_saved_a_Word_Document() {
        i_have_opened_Word();
        i_enter_text();
        save_the_document();
    }

    @When("I update the text")
    public void i_update_the_text() {
        wordApp.reopenWord();
        wordApp.openExistingDocument(fileName + ".docx");
        wordApp.updateTextInWordDocument();
    }

    @When("save the document using existing filename")
    public void save_the_document_using_existing_filename() {
        saveAsDialog.saveFileWithCtrlPlusS();
        wordApp.closeWord();
    }

    @Then("the updated text is retained")
    public void the_updated_text_is_retained() {
        wordApp.reopenWord();
        wordApp.openExistingDocument(fileName + ".docx");
        String allText = wordApp.getInitialText() + " " + wordApp.getUpdateText();
        Assert.assertTrue(wordApp.getDocumentText().equalsIgnoreCase(allText));
    }







}
