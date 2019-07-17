package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WindowsDriver driver;
    WebDriverController webDriverController;


    public BasePage(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }


    public void Visit(String url){
        driver.get(url);
    }

    public WebElement Find(By locator){
        return driver.findElement(locator);
    }

    public void Click(By locator){
        Find(locator).click();
    }

    protected void ClearAndTypeIntoField(By locator, String inputText){
        Find(locator).clear();
        Find(locator).sendKeys(inputText);
    }

    public void enterTextViaSendKeys(By locator, String inputText){
        Click(locator);
        Find(locator).sendKeys(inputText);
    }

    public void closeApp(){
        driver.closeApp();
    }

    public void launchApp(){
        driver.launchApp();
    }

    

}
