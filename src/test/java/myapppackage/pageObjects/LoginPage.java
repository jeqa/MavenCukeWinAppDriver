package myapppackage.pageObjects;

import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private WebDriver driver;
    WebDriverController webDriverController;

    private static By usernameField = By.id("username");
    private static By passwordField = By.id("password");
    private static By loginButton = By.className("radius");

//    public LoginPage(WebDriver driver) {
//        super(driver);
//        this.driver = driver;
//    }
    public LoginPage(WebDriverController webDriverController){
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void NavigateToLoginPage(){
        driver.get("http://the-internet.herokuapp.com/login");
    }

    public void EnterUsername(String username){
        ClearAndTypeIntoField(usernameField,username);
    }

    public void EnterPassword(String password){
        ClearAndTypeIntoField(passwordField, password);
    }

    public void ClickLoginButton(){
        Click(loginButton);
    }

    public String GetCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public Boolean IsPasswordInvalidMessageDisplayed(){
        return driver.findElement(By.tagName("body")).getText().contains("Your password is invalid!");
    }



}
