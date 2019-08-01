package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;

public class CalculatorApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

//  Locators
    private static final By plusButton = By.name("Plus");
    private static final By divideButton = By.name("Divide by");
    private static final By multiplyButton = By.name("Multiply by");
    private static final By minusButton = By.name("Minus");
    private static final By equalsButton = By.name("Equals");


    public CalculatorApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void selectNumber(Integer intNumber){
        Click(By.name(getNumberWordString(intNumber)));
    }

    public void selectEqualsButton(){
        Click(equalsButton);
    }

    public void selectMinusButton(){
        Click(minusButton);
    }

    public void selectPlusButton(){
        Click(plusButton);
    }

    public void selectDivideByButton(){
        Click(divideButton);
    }

    public void selectMultiplyByButton(){
        Click(multiplyButton);
    }

    public String getResult(){
        return driver.findElementByAccessibilityId("CalculatorResults")
                .getText().replace("Display is ", "");
    }

    private String getNumberWordString(Integer number){
        String stringToReturn;
        stringToReturn = null;
        switch (number) {
            case 1:
                stringToReturn = "One";
                break;
            case 2:
                stringToReturn =  "Two";
                break;
            case 3:
                stringToReturn =  "Three";
                break;
            case 4:
                stringToReturn =  "Four";
                break;
            case 5:
                stringToReturn =  "Five";
                break;
            case 6:
                stringToReturn =  "Six";
                break;
            case 7:
                stringToReturn =  "Seven";
                break;
            case 8:
                stringToReturn =  "Eight";
                break;
            case 9:
                stringToReturn =  "Nine";
                break;
            case 0:
                stringToReturn =  "Zero";
        }
        return stringToReturn;
    }






}




