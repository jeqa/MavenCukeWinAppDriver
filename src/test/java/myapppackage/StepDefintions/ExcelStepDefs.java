package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.ExcelApp;
import myapppackage.pageObjects.SaveAsDialog;
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

    @Given("I have opened a blank workbook")
    public void i_have_opened_a_blank_workbook() throws InterruptedException {
        excelApp.selectBlankDocument();
    }

    @When("I enter text into cell BFour")
    public void i_enter_text_into_cell_BFour(String cell) throws InterruptedException {
        //excelApp.enterTextInCell("B4", excelApp.getInitialText());
        excelApp.enterTextInCell(cell, excelApp.getInitialText());
    }

    @Then("the entered text is retained in cell BFour")
    public void the_entered_text_is_retained_in_cell_BFour() {
        excelApp.reopenExcel();
        excelApp.openExistingWorkbook(fileName + ".xlsx");
        String expectedText = excelApp.getInitialText();
        String actualText = excelApp.getTextFromCell("B4");
        Assert.assertTrue("Expected text to be '" + expectedText + "'; however, actual text is '" + actualText +"'!",
                expectedText.equalsIgnoreCase(actualText));
    }

    @Given("I have created and saved a Excel Document")
    public void i_have_created_and_saved_a_Excel_Document(String cell) throws InterruptedException {
        i_have_opened_a_blank_workbook();
        i_enter_text_into_cell_BFour(cell);
        save_the_workbook();
    }

    @When("I update by entering text into cell DNine")
    public void i_update_by_entering_text_into_cell_DNine() throws InterruptedException {
        excelApp.reopenExcel();
        excelApp.openExistingWorkbook(fileName + ".xlsx");
        excelApp.enterTextInCell("D9", excelApp.getUpdateText());
    }

    @Then("the updated text is retained in Cell DNine")
    public void the_updated_text_is_retained_in_Cell_DNine() {
        excelApp.reopenExcel();
        excelApp.openExistingWorkbook(fileName + ".xlsx");
        String expectedText = excelApp.getUpdateText();
        String actualText = excelApp.getTextFromCell("D9");
        Assert.assertTrue("Expected text to be '" + expectedText + "'; however, actual text is '" + actualText +"'!",
                expectedText.equalsIgnoreCase(actualText));
    }

    @When("save the workbook")
    public void save_the_workbook() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        fileName = "excelfile_" + timestamp;
        saveAsDialog.saveFileWithCtrlPlusS(fileName);
        excelApp.closeExcel();
    }

    @When("save the workbook using existing filename")
    public void save_the_workbook_using_existing_filename() {
        saveAsDialog.saveFileWithCtrlPlusS();
        excelApp.closeExcel();
    }







}
