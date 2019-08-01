package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;

public class CalculatorApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;





//  Locators
    private static final By addressBar = By.name("Address and search bar");
    private static final By homeTab = By.name("Welcome to GOV.UK - Google Chrome");
    private static final By targetTab = By.name("Money and tax - GOV.UK - Google Chrome");


    public CalculatorApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }






}




