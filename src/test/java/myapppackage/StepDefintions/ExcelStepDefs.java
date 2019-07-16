package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.ExcelApp;
import myapppackage.pageObjects.SaveAsDialog;
import myapppackage.pageObjects.WordApp;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ExcelStepDefs {

    //private WebDriver driver;
    WebDriverController webDriverController;
    ExcelApp excelApp;
    SaveAsDialog saveAsDialog;

    public String fileName;

    public ExcelStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        excelApp = new ExcelApp(this.webDriverController);
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
        excelApp.closeWord();
    }

    @Then("the entered text is retained")
    public void the_entered_text_is_retained() {
        excelApp.reopenWord();
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
        excelApp.reopenWord();
        wordApp.openExistingDocument(fileName + ".docx");
        wordApp.updateTextInWordDocument();
    }

    @When("save the document using existing filename")
    public void save_the_document_using_existing_filename() {
        saveAsDialog.saveFileWithCtrlPlusS();
        excelApp.closeWord();
    }

    @Then("the updated text is retained")
    public void the_updated_text_is_retained() {
        excelApp.reopenWord();
        wordApp.openExistingDocument(fileName + ".docx");
        String allText = wordApp.getInitialText() + " " + wordApp.getUpdateText();
        Assert.assertTrue(wordApp.getDocumentText().equalsIgnoreCase(allText));
    }





}
