package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.CalculatorApp;
import org.junit.Assert;


public class CalculatorStepDefs {

    //private WebDriver driver;
    private WebDriverController webDriverController;
    private CalculatorApp calculatorApp;

    private String fileName;

    public CalculatorStepDefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        calculatorApp = new CalculatorApp(this.webDriverController);
    }

    @Given("I have opened Calculator")
    public void i_have_opened_Calculator() {

    }

    @When("I select {int}")
    public void i_select(Integer number) {
        calculatorApp.selectNumber(number);
    }

    @When("I select Plus")
    public void i_select_Plus() {
        calculatorApp.selectPlusButton();
    }

    @When("I select Divide")
    public void i_select_Divide() {
        calculatorApp.selectDivideByButton();
    }

    @When("I select Minus")
    public void i_select_Minus() {
        calculatorApp.selectMinusButton();
    }

    @When("I select Multiply")
    public void i_select_Multiply() {
        calculatorApp.selectMultiplyByButton();
    }

    @When("I select Equals")
    public void i_select_Equals() {
        calculatorApp.selectEqualsButton();
    }

    @Then("the expected answer is {int}")
    public void the_expected_answer_is(Integer number) {
        String actualResult = calculatorApp.getResult();
        Assert.assertTrue("", actualResult.equalsIgnoreCase(number.toString()));
    }

}
