package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;

public class PowerpointApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    private String b4InitialText = "Initial Text in B4";
    private String d9UpdateText = "Update Text in D9";

//  Locators
    private static final By fileMenuTab = By.name("File Tab");
    private static final By newMenuOption = By.name("New");
    private static final By openMenuOption = By.name("Open");
    private static final By blankDocumentLink = By.name("Blank workbook");
    private static final By cellB4 = By.name("B4");
    private static final By cellD9 = By.name("D9");



    public PowerpointApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }




    }




