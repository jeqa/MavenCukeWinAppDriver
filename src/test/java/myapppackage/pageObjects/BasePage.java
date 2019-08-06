package myapppackage.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import myapppackage.WebDriverController;
import org.junit.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BasePage {

    WindowsDriver driver;
    WebDriverController webDriverController;
    public WebElement CurrentFrame;
    protected WebDriverWait wait;


    public BasePage(WebDriverController webDriverController) {
        this.webDriverController = webDriverController;
        driver = webDriverController.getDriver();
        this.wait = new WebDriverWait(driver, 15);
    }


    public WebElement Find(By locator) {
        driver.getWindowHandles().contains("");

        return driver.findElement(locator);
    }

    public WebElement SplashScreenFind(By locator) {
        switchWindows();
        return driver.findElement(locator);
    }

    private void switchWindows() {
        try {
            Thread.sleep(10000);

            for (String winHandle : driver.getWindowHandles()) {

                driver.switchTo().window(winHandle);
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

    public void name() {
        wait = new DefaultWait<WindowsDriver<WindowsElement>>(_session)
        {
            Duration timeout = Duration.ofSeconds(30);,
            PollingInterval = TimeSpan.FromSeconds(1)
        };
        wait.IgnoreExceptionTypes(typeof(InvalidOperationException));

        WindowsElement mainWindow = null;

        wait.Until(driver =>
                {
                        driver.SwitchTo().Window(driver.WindowHandles[0]);

        mainWindow = driver.FindElementByAccessibilityId("MainWindow");

        return mainWindow != null;
        });
    }

    public void ClickTest(By inviteIntendeesButton) {
    }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        WindowsDriver foo = (WindowsDriver) wait.until(new Function<WebDriver, WebElement>() {

                                                           public WindowsElement apply(WebDriver driver) {
                                                               return (WindowsElement) driver.findElement(By.name(String.valueOf(foo)));
                                                           }
                                                       });


//    public void ClickTest(By element) throws InterruptedException {
//        boolean clicked = false;
//        int attempts = 0;
//        while (!clicked && attempts < 200) {
//            try {
//                this.wait.until(element)).click();
//                System.out.println("Successfully clicked on the WebElement: " + "<" + element + ">");
//                clicked = true;
//            } catch (Exception e) {
//                System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
//                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
//            }
//            attempts++;
//        }
//    }

        public void sendKeysTest (By selector, String value){
            WebElement element = getElement(selector);
            element.click();
            clearField(element);
            try {
                waitUntilTheElementIsVisible(selector);
                element.sendKeys(value);
            } catch (Exception e) {
                throw new WebDriverException("Error in sending " + value + " to element " + selector.toString());
            }
        }

        public void ClickWithSplashScreen (By locator){
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

    public void closeApp() {
        driver.closeApp();
    }

    public void launchApp() {

        switchWindows();
        driver.launchApp();
    }


    public void waitUntilTheFrameIsVisibleAndSwitch(WebElement element) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 120, 1000);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
            setCurrentFrame(element);
        } catch (Exception e) {
            throw new Exception("Unable to find the frame" + e.getMessage());
        }
    }


    public void waitUntilTheElementIsPresent(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 120, 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void waitUntilTheElementIsVisible1(String type, String Value) throws Exception {
        if (type.equalsIgnoreCase("id")) {
            WebDriverWait wait = new WebDriverWait(driver, 120, 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Value)));
        } else if (type.equalsIgnoreCase("xpath")) {
            WebDriverWait wait = new WebDriverWait(driver, 120, 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Value)));
        } else {
            throw new Exception("Unable to find element type");
        }


    }

    public void waitUntilTheElementIsVisible(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 120, 1000);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            if (e.getMessage().contains("Cannot find context with specified id")) {
                Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        }
    }

    public void waitUntilAsyncWebElementIsVisible(String xpath) {
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS).ignoring(WebDriverException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                .equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            // throw new Exception("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void setCurrentFrame(WebElement currentFrame) {
        CurrentFrame = currentFrame;
    }

    public boolean isElementDisplayed(By locator){
        try {
            Find(locator).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

//    Browsers

    public String getCurrentUrlFromAddressBar(By locator){
        return Find(locator).getText();
    }
    public void navigateToSiteViaAddressBar(By locator, String url){
        ClearAndTypeIntoField(locator, url);
        Find(locator).sendKeys(Keys.ENTER);
    }

}
