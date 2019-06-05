package myapppackage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import myapppackage.pageObjects.LoginPage;


public class Stepdefs {

    //private WebDriver driver;
    WebDriverController webDriverController;
    LoginPage loginPage;

    public Stepdefs(WebDriverController webDriverController){
        this.webDriverController = webDriverController;
        loginPage = new LoginPage(this.webDriverController.getDriver());
    }

//    @Before
//    public void StartUp(){
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/myapppackage/browserDrivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("http://the-internet.herokuapp.com/login");
//        loginPage = new LoginPage(driver);
//    }

    @Given("I have entered a valid Username")
    public void i_have_entered_a_valid_Username() {
        loginPage.EnterUsername("tomsmith");
    }

    @Given("I have entered a valid Password")
    public void i_have_entered_a_valid_Password() {
        loginPage.EnterPassword("SuperSecretPassword!");
    }

    @When("I select SignIn")
    public void i_select_SignIn() {
        loginPage.ClickLoginButton();
    }

    @Then("the Admin Landing Page is displayed")
    public void the_Admin_Landing_Page_is_displayed() {
        String currentUrl =  loginPage.GetCurrentUrl();
        Assert.assertTrue("Unexpected URL: " + currentUrl, currentUrl.endsWith("secure"));
    }

    @Given("I have entered an invalid Password")
    public void i_have_entered_an_invalid_Password() {
        loginPage.EnterPassword("WRONG");
    }

    @Then("a login error message is displayed")
    public void a_login_error_message_is_displayed() {
//        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Expected message not displayed", loginPage.IsPasswordInvalidMessageDisplayed());
    }

    @Given("I have entered a valid username of {string}")
    public void i_have_entered_a_valid_username_of(String username) {
        loginPage.EnterUsername(username);
    }

    @Given("^I have entered a valid password of \"([^\"]*)\"$")
    public void i_have_entered_a_valid_password_of(String password) {
        loginPage.EnterPassword(password);
    }

//    @After
//    public void TearDown(){
//        driver.quit();
//    }

}
