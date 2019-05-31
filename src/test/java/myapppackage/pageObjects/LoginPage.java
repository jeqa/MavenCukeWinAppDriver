package myapppackage.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private static By usernameField = By.id("username");
    private static By passwordField = By.id("password");
    private static By loginButton = By.className("radius");

    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }



    public void EnterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void EnterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void ClickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String GetCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public Boolean IsPasswordInvalidMessageDisplayed(){
        return driver.findElement(By.tagName("body")).getText().contains("Your password is invalid!");
    }



}
