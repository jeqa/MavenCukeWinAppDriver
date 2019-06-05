package myapppackage.pageObjects;

import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver;
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

}
