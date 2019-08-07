package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;

public class ExcelApp extends BasePage {

    private WindowsDriver driver;
    WebDriverController webDriverController;

    private String cellContainingText = "";
    private String initialText = "Initial Text in ";
    private String updateText = "Update Text in ";

    public void setCellContainingText(String cellContainingText) {
        this.cellContainingText = cellContainingText;
    }

    public String getCellContainingText() {
        return cellContainingText;
    }

//  Locators
    private static final By fileMenuTab = By.name("File Tab");
    private static final By newMenuOption = By.name("New");
    private static final By openMenuOption = By.name("Open");
    private static final By blankDocumentLink = By.name("Blank workbook");


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
        setCellContainingText(cell);
        Click(By.name(cell));
        enterTextViaSendKeys(By.name(cell), text + cell);
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

    public String getInitialText(){
        return initialText;
    }

    public String getUpdateText(){
        return updateText;
    }




    }




