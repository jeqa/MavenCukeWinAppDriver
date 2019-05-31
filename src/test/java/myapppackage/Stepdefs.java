package myapppackage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

import static org.junit.Assert.*;

public class Stepdefs {

    private WebDriver driver;

    @Given("I have entered a valid Username")
    public void i_have_entered_a_valid_Username() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/myapppackage/browserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
    }

    @Given("I have entered a valid Password")
    public void i_have_entered_a_valid_Password() {
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    }

    @When("I select SignIn")
    public void i_select_SignIn() {
        driver.findElement(By.className("radius")).click();
    }

    @Then("the Admin Landing Page is displayed")
    public void the_Admin_Landing_Page_is_displayed() {
        String currentUrl =  driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("secure"));
    }

    @Given("I have entered an invalid Password")
    public void i_have_entered_an_invalid_Password() {
        driver.findElement(By.id("password")).sendKeys("WRONG");
    }

    @Then("a login error message is displayed")
    public void a_login_error_message_is_displayed() {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Your password is invalid!"));
    }

    @Given("I have entered a valid username of {string}")
    public void i_have_entered_a_valid_username_of(String username) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/myapppackage/browserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys(username);
    }

    @Given("^I have entered a valid password of \"([^\"]*)\"$")
    public void i_have_entered_a_valid_password_of(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @After
    public void TearDown(){
        driver.quit();
    }

}
