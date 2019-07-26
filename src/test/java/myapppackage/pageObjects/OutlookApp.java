package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

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

    public void composeEmail(String mailText, String subjectText, String toText ) throws InterruptedException, MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Root");
        driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capabilities);

        Thread.sleep(2000);
        WebElement emailAddressInput = driver.findElementByName("To");
        WebElement mailContent = driver.findElementByName("Page 1 content");
        WebElement subjectInput = driver.findElementByAccessibilityId("4101");

        Actions performAct = new Actions(driver);
        performAct.sendKeys(mailContent, mailText).build().perform();
        performAct.sendKeys(emailAddressInput, toText).build().perform();
        performAct.sendKeys(subjectInput, subjectText).build().perform();

    }


    public void pressSend() {

        driver.getKeyboard().sendKeys(Keys.chord(Keys.ALT, "s"));

    }

    public String asserNewEmail() {
        String getEMailBody = driver.findElementByName("Page 1 content").getText().replace("\r", "");
        return getEMailBody;

    }

    public void deleteEmail(){
        driver.getKeyboard().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.getKeyboard().sendKeys(Keys.chord(Keys.DELETE));
    }


    }
