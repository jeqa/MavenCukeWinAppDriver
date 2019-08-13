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
    private static final By calendarButton = By.name("Calendar");
    private static final By newAppointmentButton = By.name ("New Appointment");
    private static final By sendButton = By.name ("Send");
    private static final By sendAnywayButton = By.name("Send Anyway");
    private static final By inviteAttendees = By.name("Invite Attendees");
    private static final By toInput = By.name("To");


    private WindowsDriver driver;

    WebDriverController webDriverController;


    public OutlookApp(WebDriverController webDriverController) throws MalformedURLException {
        super(webDriverController);
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }

    public void clickNewEmail() throws InterruptedException {
        Thread.sleep(5000);
        ClickWithSplashScreen(newEmailButton);
    }

    public void clickNewAppointmentButton() throws InterruptedException {
        ClickWithWait(newAppointmentButton);


    }

    public void composeCalendarEntry(String bodyText, String subjectText, String locationText, String toText) throws InterruptedException, MalformedURLException {

        driver = createRootSession();

        switchWindows();
        ClickWithWait(inviteAttendees);

        WebElement emailAddressInput = driver.findElementByName("To");
        WebElement subjectInput = driver.findElementByAccessibilityId("4100");
        WebElement locationInput = driver.findElementByAccessibilityId("4102");
        WebElement calendarBodyInput = driver.findElementByAccessibilityId("Body");

        Actions performAct = new Actions(driver);
        performAct.sendKeys(emailAddressInput, toText).build().perform();
        performAct.sendKeys(subjectInput, subjectText).build().perform();
        performAct.sendKeys(locationInput, locationText).build().perform();
        performAct.sendKeys(calendarBodyInput, bodyText).build().perform();

        ClickWithWait(sendButton);
        ClickWithWait(sendAnywayButton);


    }


    public void composeEmail(String mailText, String subjectText, String toText) throws InterruptedException, MalformedURLException {

        driver = createRootSession();

        FluentWait(toInput);

        WebElement emailAddressInput = driver.findElementByName("To");
        WebElement mailContent = driver.findElementByName("Page 1 content");
        WebElement subjectInput = driver.findElementByAccessibilityId("4101");

        Actions performAct = new Actions(driver);
        performAct.sendKeys(mailContent, mailText).build().perform();
        performAct.sendKeys(emailAddressInput, toText).build().perform();
        performAct.sendKeys(subjectInput, subjectText).build().perform();

    }

    private void newSession() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Root");
        driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
    }


    public void pressSend() {

        driver.getKeyboard().sendKeys(Keys.chord(Keys.ALT, "s"));

    }

    public String assertNewEmail() throws InterruptedException {
        Thread.sleep(5000);
        return Find(By.name("Page 1 content")).getText().replace("\r", "");
    }

    public void deleteEmail() {
        driver.getKeyboard().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.getKeyboard().sendKeys(Keys.chord(Keys.DELETE));
    }

    public void clickCalendar() throws InterruptedException {
        Thread.sleep(5000);
        ClickWithSplashScreen(calendarButton);
    }


}
