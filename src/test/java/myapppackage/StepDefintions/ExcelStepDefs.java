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

    @Given("I have opened a blank workbook")
    public void i_have_opened_a_blank_workbook() {
        excelApp.selectBlankDocument();
    }

    @When("I enter text into cell BFour")
    public void i_enter_text_into_cell_BFour(){
        excelApp.enterTextInCell("B4");
    }

    @Then("the entered text is retained in cell BFour")
    public void the_entered_text_is_retained_in_cell_BFour() {
        excelApp.reopenExcel();
        excelApp.openExistingWorkbook(fileName + ".xlsx");
        excelApp.getTextFromCell("B4");
        Assert.assertTrue(excelApp.getTextFromCell("B4").equalsIgnoreCase(excelApp.getB4InitialText()));
    }

    @Given("I have created and saved a Excel Document")
    public void i_have_created_and_saved_a_Excel_Document() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I update by entering text into cell D{int}")
    public void i_update_by_entering_text_into_cell_D(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the updated text is retained in Cell D{int}")
    public void the_updated_text_is_retained_in_Cell_D(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
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
