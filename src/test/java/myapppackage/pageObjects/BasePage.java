package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import myapppackage.WebDriverController;
import org.openqa.selenium.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;
import java.util.Set;


public class BasePage {

    WindowsDriver driver;
    WebDriverController webDriverController;
    public WebElement CurrentFrame;
    protected WebDriverWait wait;


    public BasePage(WebDriverController webDriverController) {
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
    }


    public WebElement Find(By locator) {
        //switchWindows();

        return driver.findElement(locator);
    }

    public WebElement SplashScreenFind(By locator) {
        switchWindows();
        return driver.findElement(locator);
    }

    public void switchWindows() {
        try {
            Thread.sleep(10000);

            for (String winHandle : driver.getWindowHandles()) {

                driver.switchTo().window(winHandle);
                break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void windowSwitcherEmail() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Root");
        driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capabilities);

    }


    public void Click(By locator) {
        Find(locator).click();
    }


    public void ClickWithWait(By element) {
        switchWindows();
        FluentWait(element);

    }

    public void FluentWait(By element) {
        try {


            Wait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(7000))
                    .pollingEvery(Duration.ofSeconds(5000))
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.elementToBeClickable(Find(element)));

            if (Find(element).isDisplayed()) {
                Find(element).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void ClickWithSplashScreen(By locator) {
        SplashScreenFind(locator).click();
    }

    protected void ClearAndTypeIntoField(By locator, String inputText) {
        Find(locator).clear();
        Find(locator).sendKeys(inputText);
    }


    public WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (Exception e) {
            System.out.println("The element" + selector.toString() + " could not be found");
        }
        return null;
    }

    public void clearField(WebElement element) {
        try {
            element.clear();
            waitForElementTextToBeEmpty(element);
        } catch (Exception e) {
            System.out.println("The element " + element.toString() + " could not be cleared");
        }
    }

    public void waitForElementTextToBeEmpty(WebElement element) {
        String text;
        try {
            text = element.getText();
            int maxRetries = 3;
            int retry = 0;
            while ((text.length() >= 1) || (retry < maxRetries)) {
                retry++;
                text = element.getText();
            }
        } catch (Exception e) {
            System.out.println("The element " + element.toString() + " was not cleared");
        }
    }

    public void sendKeys(By selector, String value) {
        WebElement element = getElement(selector);
        element.click();
        clearField(element);
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new WebDriverException("Error in sending " + value + " to element " + selector.toString());
        }
    }

    public void enterTextViaSendKeys(By locator, String inputText) throws InterruptedException {
        Thread.sleep(5000);
        Click(locator);
        Find(locator).sendKeys(inputText);
    }

    public void enterTextViaSendKeysSplashScreen(By locator, String inputText) {
        SplashScreenFind(locator).sendKeys(inputText);
    }

    public WindowsDriver getSessionFromRoot(By locatorInTopLevelWindow) throws MalformedURLException {
        WindowsDriver rootSession;
        if (!driver.getCapabilities().getCapability("app").toString().equals("Root")){
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("app", "Root");
//            rootSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            rootSession =  createRootSession();
        } else {
            rootSession = driver;
        }
        assert rootSession != null;
        int intTopLevelWindowHandle = Integer.parseInt(rootSession.findElement(locatorInTopLevelWindow).getAttribute("NativeWindowHandle"));
        String hexTopLevelWindowHandle = Integer.toHexString(intTopLevelWindowHandle);
        hexTopLevelWindowHandle = "0x" + hexTopLevelWindowHandle.toUpperCase();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appTopLevelWindow", hexTopLevelWindowHandle);
        return new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    public WindowsDriver createRootSession() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Root");
        return new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    public void closeApp() {
        driver.closeApp();
    }

    public void launchApp() {

        switchWindows();
        driver.launchApp();
    }


    public boolean isElementDisplayed(By locator) {
        try {
            Find(locator).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

//    Browsers

    public String getCurrentUrlFromAddressBar(By locator) {
        return Find(locator).getText();
    }

    public void navigateToSiteViaAddressBar(By locator, String url) {
        ClearAndTypeIntoField(locator, url);
        Find(locator).sendKeys(Keys.ENTER);
    }

}
