package myapppackage.StepDefintions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myapppackage.WebDriverController;
import myapppackage.pageObjects.CalculatorApp;
import myapppackage.pageObjects.ChromeApp;
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


}
