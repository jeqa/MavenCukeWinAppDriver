package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OutlookApp extends BasePage {


    private static final By newEmailButton = By.name("New Email");


    private WindowsDriver driver;
    WebDriverController webDriverController;


    public OutlookApp(WebDriverController webDriverController) throws MalformedURLException {
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void clickNewEmail() throws InterruptedException {
        Thread.sleep(10000);
        ClickWithSplashScreen(newEmailButton);
    }

    public void enterText(String text) throws InterruptedException, MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Root");
        driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capabilities);


        WebElement mailContent = driver.findElementByName("Page 1 content");
        Actions performAct = new Actions(driver);
        performAct.sendKeys(mailContent, text).build().perform();
    }

    public void enterEmailAddress() {
        WebElement emailAddressInput = driver.findElementByName("To");
        Actions performAct = new Actions(driver);
        performAct.sendKeys(emailAddressInput, "testuser1@erslabs.onmicrosoft.com").build().perform();

    }

    public void enterSubject() {
        WebElement subjectInput = driver.findElementByAccessibilityId("4101");
        Actions performAct = new Actions(driver);
        performAct.sendKeys(subjectInput, "Demo").build().perform();

    }

    public void pressSend() {

        driver.getKeyboard().sendKeys(Keys.chord(Keys.ALT, "s"));

    }

    public void asserNewEmail() {
        
    }







    }
