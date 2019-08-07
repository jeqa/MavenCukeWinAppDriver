package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.ExcelApp;
import myapppackage.pageObjects.SaveAsDialog;
import org.junit.Assert;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


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

    @When("I enter text into a cell")
    public void i_enter_text_into_a_cell(List<String> list) throws InterruptedException {
        String cell = list.get(0);
        excelApp.enterTextInCell(cell, excelApp.getInitialText());
    }

    @Then("the entered text is retained in the expected cell")
    public void the_entered_text_is_retained_in_the_expected_cell() {
        excelApp.reopenExcel();
        excelApp.openExistingWorkbook(fileName + ".xlsx");
        String expectedText = excelApp.getInitialText() + excelApp.getCellContainingText();
        String actualText = excelApp.getTextFromCell(excelApp.getCellContainingText());
        Assert.assertTrue("Expected text to be '" + expectedText + "'; however, actual text is '" + actualText +"'!",
                expectedText.equalsIgnoreCase(actualText));
    }

    @Given("I have created and saved a Excel Document")
    public void i_have_created_and_saved_a_Excel_Document(List<String> list) throws InterruptedException {
        i_have_opened_a_blank_workbook();
        i_enter_text_into_a_cell(list);
        save_the_workbook();
    }

    @When("I update by entering text into cell DNine")
    public void i_update_by_entering_text_into_cell_DNine() throws InterruptedException {
        excelApp.reopenExcel();
        excelApp.openExistingWorkbook(fileName + ".xlsx");
        excelApp.enterTextInCell("D9", excelApp.getUpdateText());
    }

    @When("I update by entering text into another cell")
    public void i_update_by_entering_text_into_another_cell(List<String> list) throws InterruptedException {
        String cell = list.get(0);
        excelApp.reopenExcel();
        excelApp.openExistingWorkbook(fileName + ".xlsx");
        excelApp.enterTextInCell(cell, excelApp.getUpdateText());
    }

    @Then("the updated text is retained in the expected cell")
    public void the_updated_text_is_retained_in_the_expected_cell() {
        excelApp.reopenExcel();
        excelApp.openExistingWorkbook(fileName + ".xlsx");
        String expectedText = excelApp.getUpdateText() + excelApp.getCellContainingText();
        String actualText = excelApp.getTextFromCell(excelApp.getCellContainingText());
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
