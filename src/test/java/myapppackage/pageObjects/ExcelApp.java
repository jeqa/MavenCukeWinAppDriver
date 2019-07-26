package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ExcelApp extends BasePage {

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



    public ExcelApp(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void selectBlankDocument() throws InterruptedException {
        Thread.sleep(2000);
        Click(fileMenuTab);
        Click(newMenuOption);
        Click(blankDocumentLink);
    }

    public void enterTextInCell(String cell, String text) throws InterruptedException {
        Click(By.name(cell));
        enterTextViaSendKeys(By.name(cell), text);
    }

    public void closeExcel(){
        closeApp();
    }

    public void reopenExcel(){
        launchApp();
    }

    public void openExistingWorkbook(String filename){
        Click(fileMenuTab);
        Click(openMenuOption);
        Click(By.name(filename));
    }

    public String getTextFromCell(String cell){
        return Find(By.name(cell)).getText();
    }

    public String getB4InitialText(){
        return b4InitialText;
    }

    public String getD9UpdateText(){
        return d9UpdateText;
    }




    }




