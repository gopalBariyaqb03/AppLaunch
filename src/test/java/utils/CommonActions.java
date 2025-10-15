package utils;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonActions {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public CommonActions(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ThreadLocal counter so each test thread maintains its own step count


    // Pause method (milliseconds)
    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);  // convert sec → ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForSec(int seconds, AppiumDriver driver){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//non-existing-element")));
        } catch (Exception e) {
            System.out.println("Pause interrupted: " + e.getMessage());
        }
    }

    // Common reusable method to generate random number in range
    public static int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
        // +1 because upper bound is exclusive
    }

    private static ThreadLocal<AtomicInteger> stepCounter = ThreadLocal.withInitial(() -> new AtomicInteger(1));
    private static ThreadLocal<String> lastTestName = new ThreadLocal<>();

    public static void logPrint(String message) {
        // Get current test name dynamically
        String currentTestName = Reporter.getCurrentTestResult().getMethod().getMethodName();

        // If new test started → reset counter
        if (lastTestName.get() == null || !lastTestName.get().equals(currentTestName)) {
            stepCounter.set(new AtomicInteger(1));
            lastTestName.set(currentTestName);
        }

        // Regular log logic
        if (message.toLowerCase().startsWith("step")) {
            int step = stepCounter.get().get();
            String[] msg = message.split("::");
            String stepMessage = msg.length > 1 ? msg[1].trim() : message;
            String formatted = step + ". " + stepMessage;
            Reporter.log("<br>" + formatted, true);
            stepCounter.get().set(step + 1);
        } else {
            Reporter.log("<br>Message: " + message, true);
            System.out.println("Message: " + message);
        }
    }


    public boolean isElementPresent(By locator, int waitTimeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTimeInSeconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    // Basic Actions
    public void click(By locator) {
        try {
            waitForElement(locator);
            driver.findElement(locator).click();
        } catch (Exception e) {
            System.out.println("Failed to click on element: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    public void scrollToElementByXPath(String xpath, int maxScrolls) {
        int scrollCount = 0;
        while (scrollCount < maxScrolls) {
            try {
                driver.findElement(By.xpath(xpath));
                System.out.println("Element found: " + xpath);
                break;
            } catch (Exception e) {
                scrollCount++;
            }
        }
        if (scrollCount == maxScrolls) {
            System.out.println("Element not found after scrolling " + maxScrolls + " times: " + xpath);
        }
    }

    public void type(By locator, String text) {
        try {
            waitForElement(locator);
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
            //System.out.println("Typed text '" + text);
        } catch (Exception e) {
            System.out.println("Failed to type in element: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    public String getText(By locator) {
            waitForElement(locator);
            String text = driver.findElement(locator).getText();
            System.out.println("Got text '" + text);
            return text;
    }

    // Wait Methods
    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Element State Methods
    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    // Mobile Specific Actions
    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
        System.out.println("Scrolled down");
    }

    public void scrollUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
        System.out.println("Scrolled up");
    }

    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        int endX = (int) (size.width * 0.2);
        int y = size.height / 2;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
        System.out.println("Swiped left");
    }

    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.2);
        int endX = (int) (size.width * 0.8);
        int y = size.height / 2;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
        System.out.println("Swiped right");
    }

    public void tap(int x, int y) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(x, y)).perform();
        System.out.println("Tapped at coordinates: (" + x + ", " + y + ")");
    }

    public void longPress(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(PointOption.point(element.getLocation().x, element.getLocation().y))
                    .release()
                    .perform();
            System.out.println("Long pressed on element: " + locator);
        } catch (Exception e) {
            System.out.println("Failed to long press: " + e.getMessage());
            throw e;
        }
    }

    public void scrollUsingMobileGesture(AppiumDriver driver, String direction) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction); // "up", "down", "left", "right"
        params.put("percent", 0.8); // Percentage of the screen to scroll
        // Optional: params.put("elementId", element.getId()); // To scroll within a specific element

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
    }

//    public WebElement scrollToElement(By locator, String direction, int maxScrolls) {
//        for (int i = 0; i < maxScrolls; i++) {
//            try {
//                WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
//                        .until(ExpectedConditions.visibilityOfElementLocated(locator));
//                return element; // Element found, return it
//            } catch (Exception e) {
//                // Element not found, scroll and try again
//                scrollUsingMobileGesture(driver, direction);
//            }
//        }
//        throw new RuntimeException("Element not found after " + maxScrolls + " scrolls.");
//    }

    // Advanced Methods
    public void scrollToElement(By locator) {
        int maxScrolls = 10;
        boolean isFound = false;

        for (int i = 0; i < maxScrolls; i++) {
            try {
                WebElement element = driver.findElement(locator);

                if (element.isDisplayed()) {
                    System.out.println("Found element after scroll: " + locator);
                    isFound = true;
                    click(locator);
                    break;
                }
            } catch (Exception e) {
                try {
                    driver.findElement(AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))"
                                    + ".scrollForward()"));
                    Thread.sleep(10);
                } catch (Exception scrollErr) {
                    System.out.println("Scroll failed at attempt " + (i + 1) + ": " + scrollErr.getMessage());
                }
            }
        }

        if (!isFound) {
            System.out.println("Could not find element after " + maxScrolls + " scroll attempts: " + locator);
        }
    }

//     // 1: Scroll to element and click
//    public void scrollToElementAndClick(By locator) {
//        WebElement element = scrollToElement(By.xpath(String.valueOf(locator)));
//        if (element != null) {
//            element.click();
//        }
//    }

//    // Method 2: Scroll to element using UiAutomator (Android)
//    public WebElement scrollToElementUiAutomator(String text) {
//        if (driver instanceof AndroidDriver) {
//            return driver.findElement(
//                    By.androidUIAutomator(
//                            "new UiScrollable(new UiSelector().scrollable(true))" +
//                                    ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
//                    )
//            );
//        }
//        return null;
//    }

    public void hideKeyboard() {
        try {
            if (driver.isKeyboardShown()) {
                driver.hideKeyboard();
                System.out.println("Keyboard hidden");
            }
        } catch (Exception e) {
            System.out.println("Failed to hide keyboard: " + e.getMessage());
        }
    }

    public void goBack() {
        try {
            driver.navigate().back();
            System.out.println("Navigated back");
        } catch (Exception e) {
            System.out.println("Failed to navigate back: " + e.getMessage());
        }
    }

    // List and Multiple Elements
    public List<WebElement> getElements(By locator) {
        try {
            waitForElement(locator);
            return driver.findElements(locator);
        } catch (Exception e) {
            System.out.println("Failed to get elements: " + locator + " - " + e.getMessage());
            throw e;
        }
    }

    public int getElementCount(By locator) {
        return getElements(locator).size();
    }

    // App State Methods
    public void bringAppToForeground() {
        driver.activateApp("com.streefi.vendor");
    }

    public void sendAppToBackground(Duration duration) {
        driver.runAppInBackground(duration);
    }

    // Wait with custom timeout
    public void waitForElementWithTimeout(By locator, int timeoutSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        customWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // ================== NEW ENHANCED METHODS ==================

    // **1. ENHANCED SCROLLING METHODS**

    /**
     * Scroll to element using text content
     *
     * @param text - Text to search for while scrolling
     */
    public void scrollToElementByText(String text) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
            System.out.println("Scrolled to element with text: " + text);
        } catch (Exception e) {
            System.out.println("Failed to scroll to element with text: " + text + " - " + e.getMessage());
        }
    }

    /**
     * Scroll in a specific container/view
     *
     * @param containerLocator - Locator of the scrollable container
     * @param direction        - "up", "down", "left", "right"
     */
    public void scrollInContainer(By containerLocator, String direction) {
        try {
            WebElement container = driver.findElement(containerLocator);
            Point location = container.getLocation();
            Dimension size = container.getSize();

            int centerX = location.x + size.width / 2;
            int centerY = location.y + size.height / 2;

            TouchAction touchAction = new TouchAction(driver);

            switch (direction.toLowerCase()) {
                case "down":
                    touchAction.press(PointOption.point(centerX, centerY + size.height / 4))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                            .moveTo(PointOption.point(centerX, centerY - size.height / 4))
                            .release().perform();
                    break;
                case "up":
                    touchAction.press(PointOption.point(centerX, centerY - size.height / 4))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                            .moveTo(PointOption.point(centerX, centerY + size.height / 4))
                            .release().perform();
                    break;
                case "left":
                    touchAction.press(PointOption.point(centerX + size.width / 4, centerY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                            .moveTo(PointOption.point(centerX - size.width / 4, centerY))
                            .release().perform();
                    break;
                case "right":
                    touchAction.press(PointOption.point(centerX - size.width / 4, centerY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                            .moveTo(PointOption.point(centerX + size.width / 4, centerY))
                            .release().perform();
                    break;
            }
            System.out.println("Scrolled " + direction + " in container");
        } catch (Exception e) {
            System.out.println("Failed to scroll in container: " + e.getMessage());
        }
    }

    // **2. GESTURE METHODS**

    /**
     * Perform pinch to zoom in
     */
    public void pinchToZoomIn() {
        try {
            Dimension size = driver.manage().window().getSize();
            int centerX = size.width / 2;
            int centerY = size.height / 2;

            TouchAction finger1 = new TouchAction(driver);
            TouchAction finger2 = new TouchAction(driver);

            finger1.press(PointOption.point(centerX - 50, centerY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(centerX - 150, centerY))
                    .release();

            finger2.press(PointOption.point(centerX + 50, centerY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(centerX + 150, centerY))
                    .release();

            System.out.println("Pinch to zoom in performed");
        } catch (Exception e) {
            System.out.println("Failed to pinch zoom in: " + e.getMessage());
        }
    }

    /**
     * Perform pinch to zoom out
     */
    public void pinchToZoomOut() {
        try {
            Dimension size = driver.manage().window().getSize();
            int centerX = size.width / 2;
            int centerY = size.height / 2;

            TouchAction finger1 = new TouchAction(driver);
            TouchAction finger2 = new TouchAction(driver);

            finger1.press(PointOption.point(centerX - 150, centerY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(centerX - 50, centerY))
                    .release();

            finger2.press(PointOption.point(centerX + 150, centerY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(centerX + 50, centerY))
                    .release();

            System.out.println("Pinch to zoom out performed");
        } catch (Exception e) {
            System.out.println("Failed to pinch zoom out: " + e.getMessage());
        }
    }

    /**
     * Double tap on an element
     *
     * @param locator - Element to double tap
     */
    public void doubleTap(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            TouchAction touchAction = new TouchAction(driver);

            touchAction.tap(PointOption.point(element.getLocation().x, element.getLocation().y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                    .tap(PointOption.point(element.getLocation().x, element.getLocation().y))
                    .perform();

            System.out.println("Double tapped on element: " + locator);
        } catch (Exception e) {
            System.out.println("Failed to double tap: " + e.getMessage());
        }
    }

    // **3. ADVANCED ELEMENT INTERACTIONS**

    /**
     * Drag and drop from source to target element
     *
     * @param sourceLocator - Source element
     * @param targetLocator - Target element
     */
    public void dragAndDrop(By sourceLocator, By targetLocator) {
        try {
            WebElement source = driver.findElement(sourceLocator);
            WebElement target = driver.findElement(targetLocator);

            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(PointOption.point(source.getLocation().x, source.getLocation().y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(target.getLocation().x, target.getLocation().y))
                    .release()
                    .perform();

            System.out.println("Dragged from " + sourceLocator + " to " + targetLocator);
        } catch (Exception e) {
            System.out.println("Failed to drag and drop: " + e.getMessage());
        }
    }

    /**
     * Swipe element in specific direction
     *
     * @param locator   - Element to swipe
     * @param direction - "left", "right", "up", "down"
     */
    public void swipeElement(By locator, String direction) {
        try {
            WebElement element = driver.findElement(locator);
            Point location = element.getLocation();
            Dimension size = element.getSize();

            int centerX = location.x + size.width / 2;
            int centerY = location.y + size.height / 2;

            TouchAction touchAction = new TouchAction(driver);

            switch (direction.toLowerCase()) {
                case "left":
                    touchAction.press(PointOption.point(centerX + size.width / 4, centerY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                            .moveTo(PointOption.point(centerX - size.width / 4, centerY))
                            .release().perform();
                    break;
                case "right":
                    touchAction.press(PointOption.point(centerX - size.width / 4, centerY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                            .moveTo(PointOption.point(centerX + size.width / 4, centerY))
                            .release().perform();
                    break;
                case "up":
                    touchAction.press(PointOption.point(centerX, centerY + size.height / 4))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                            .moveTo(PointOption.point(centerX, centerY - size.height / 4))
                            .release().perform();
                    break;
                case "down":
                    touchAction.press(PointOption.point(centerX, centerY - size.height / 4))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                            .moveTo(PointOption.point(centerX, centerY + size.height / 4))
                            .release().perform();
                    break;
            }
            System.out.println("Swiped element " + direction);
        } catch (Exception e) {
            System.out.println("Failed to swipe element: " + e.getMessage());
        }
    }

    // **4. DEVICE SPECIFIC ACTIONS**

    /**
     * Press Android hardware keys
     *
     * @param key - Android key to press (BACK, HOME, MENU, etc.)
     */
    public void pressKey(AndroidKey key) {
        try {
            driver.pressKey(new KeyEvent(key));
            System.out.println("Pressed key: " + key.name());
        } catch (Exception e) {
            System.out.println("Failed to press key: " + e.getMessage());
        }
    }

    /**
     * Set device orientation
     *
     * @param orientation - "LANDSCAPE" or "PORTRAIT"
     */
    public void setOrientation(String orientation) {
        try {
            if (orientation.equalsIgnoreCase("LANDSCAPE")) {
                driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
            } else {
                driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
            }
            System.out.println("Set orientation to: " + orientation);
        } catch (Exception e) {
            System.out.println("Failed to set orientation: " + e.getMessage());
        }
    }

    /**
     * Get current device orientation
     *
     * @return Current orientation as string
     */
    public String getOrientation() {
        try {
            String orientation = driver.getOrientation().toString();
            System.out.println("Current orientation: " + orientation);
            return orientation;
        } catch (Exception e) {
            System.out.println("Failed to get orientation: " + e.getMessage());
            return "";
        }
    }

    // **5. ENHANCED WAIT METHODS**

    /**
     * Wait for text to be present in element
     *
     * @param locator - Element locator
     * @param text    - Text to wait for
     */
    public void waitForTextInElement(By locator, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
            System.out.println("Text '" + text + "' found in element");
        } catch (Exception e) {
            System.out.println("Text not found in element: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Wait for element attribute to have specific value
     *
     * @param locator   - Element locator
     * @param attribute - Attribute name
     * @param value     - Expected value
     */
    public void waitForAttributeValue(By locator, String attribute, String value) {
        try {
            wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
            System.out.println("Attribute '" + attribute + "' has value '" + value + "'");
        } catch (Exception e) {
            System.out.println("Attribute value not matched: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Wait for element to be stale (removed from DOM)
     *
     * @param element - WebElement that should become stale
     */
    public void waitForElementToBeStale(WebElement element) {
        try {
            wait.until(ExpectedConditions.stalenessOf(element));
            System.out.println("Element became stale");
        } catch (Exception e) {
            System.out.println("Element did not become stale: " + e.getMessage());
            throw e;
        }
    }

    // **6. ELEMENT ATTRIBUTE METHODS**

    /**
     * Get element attribute value
     *
     * @param locator   - Element locator
     * @param attribute - Attribute name
     * @return Attribute value
     */
    public String getElementAttribute(By locator, String attribute) {
        try {
            WebElement element = driver.findElement(locator);
            String value = element.getAttribute(attribute);
            System.out.println("Got attribute '" + attribute + "' value: " + value);
            return value;
        } catch (Exception e) {
            System.out.println("Failed to get attribute: " + e.getMessage());
            return "";
        }
    }

    /**
     * Get element CSS property value
     *
     * @param locator  - Element locator
     * @param property - CSS property name
     * @return Property value
     */
    public String getElementCssProperty(By locator, String property) {
        try {
            WebElement element = driver.findElement(locator);
            String value = element.getCssValue(property);
            System.out.println("Got CSS property '" + property + "' value: " + value);
            return value;
        } catch (Exception e) {
            System.out.println("Failed to get CSS property: " + e.getMessage());
            return "";
        }
    }

    /**
     * Get element size
     *
     * @param locator - Element locator
     * @return Dimension object with width and height
     */
    public Dimension getElementSize(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            Dimension size = element.getSize();
            System.out.println("Element size: " + size.width + "x" + size.height);
            return size;
        } catch (Exception e) {
            System.out.println("Failed to get element size: " + e.getMessage());
            return null;
        }
    }

    /**
     * Get element location
     *
     * @param locator - Element locator
     * @return Point object with x and y coordinates
     */
    public Point getElementLocation(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            Point location = element.getLocation();
            System.out.println("Element location: (" + location.x + ", " + location.y + ")");
            return location;
        } catch (Exception e) {
            System.out.println("Failed to get element location: " + e.getMessage());
            return null;
        }
    }

    // **7. CONTEXT SWITCHING METHODS**

    /**
     * Switch to WebView context
     */
    public void switchToWebView() {
        try {
            Set<String> contexts = driver.getContextHandles();
            for (String context : contexts) {
                if (context.contains("WEBVIEW")) {
                    driver.context(context);
                    System.out.println("Switched to WebView context: " + context);
                    return;
                }
            }
            System.out.println("No WebView context found");
        } catch (Exception e) {
            System.out.println("Failed to switch to WebView: " + e.getMessage());
        }
    }

    /**
     * Switch to Native app context
     */
    public void switchToNativeApp() {
        try {
            driver.context("NATIVE_APP");
            System.out.println("Switched to Native App context");
        } catch (Exception e) {
            System.out.println("Failed to switch to Native App: " + e.getMessage());
        }
    }

    /**
     * Get all available contexts
     *
     * @return Set of context names
     */
    public Set<String> getAllContexts() {
        try {
            Set<String> contexts = driver.getContextHandles();
            System.out.println("Available contexts: " + contexts);
            return contexts;
        } catch (Exception e) {
            System.out.println("Failed to get contexts: " + e.getMessage());
            return null;
        }
    }

    // **8. APP MANAGEMENT METHODS**

    /**
     * Install app from APK path
     *
     * @param appPath - Path to APK file
     */
    public void installApp(String appPath) {
        try {
            driver.installApp(appPath);
            System.out.println("App installed from: " + appPath);
        } catch (Exception e) {
            System.out.println("Failed to install app: " + e.getMessage());
        }
    }

    /**
     * Remove/uninstall app
     *
     * @param bundleId - App bundle identifier
     */
    public void removeApp(String bundleId) {
        try {
            driver.removeApp(bundleId);
            System.out.println("App removed: " + bundleId);
        } catch (Exception e) {
            System.out.println("Failed to remove app: " + e.getMessage());
        }
    }

    public void clickWhenVisible(By locator, int maxWaitTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTimeInSeconds));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.click();
            System.out.println("Clicked on element: " + locator.toString());
        } catch (TimeoutException e) {
            System.out.println("Element not visible within " + maxWaitTimeInSeconds + " seconds: " + locator.toString());
            throw e;
        }
    }

    // **9. DATA CREATION/GENERATION METHODS**


    // **10. SCREENSHOT AND VISUAL METHODS**

    /**
     * Take screenshot and save to file
     *
     * @param fileName - Name of screenshot file
     */
    public void takeScreenshot(String fileName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] source = screenshot.getScreenshotAs(OutputType.BYTES);
            // You can implement file saving logic here based on your framework
            System.out.println("Screenshot taken: " + fileName);
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }

    /**
     * Compare two elements visually (basic implementation)
     *
     * @param locator1 - First element
     * @param locator2 - Second element
     * @return true if elements appear similar
     */
    public boolean compareElementsVisually(By locator1, By locator2) {
        try {
            WebElement element1 = driver.findElement(locator1);
            WebElement element2 = driver.findElement(locator2);

            // Basic comparison using size and location
            boolean similar = element1.getSize().equals(element2.getSize()) &&
                    element1.getLocation().equals(element2.getLocation());

            System.out.println("Visual comparison result: " + similar);
            return similar;
        } catch (Exception e) {
            System.out.println("Failed to compare elements: " + e.getMessage());
            return false;
        }
    }

    // **11. TEXT AND INPUT VALIDATION METHODS**

    /**
     * Clear text field and verify it's empty
     *
     * @param locator - Text field locator
     */
    public void clearAndVerifyTextField(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            element.clear();
            String text = element.getText();
            if (text.isEmpty()) {
                System.out.println("Text field cleared successfully");
            } else {
                System.out.println("Text field not completely cleared, remaining text: " + text);
            }
        } catch (Exception e) {
            System.out.println("Failed to clear text field: " + e.getMessage());
        }
    }

    /**
     * Type text with delay between characters
     *
     * @param locator - Element locator
     * @param text    - Text to type
     * @param delayMs - Delay in milliseconds between characters
     */
    public void typeWithDelay(By locator, String text, int delayMs) {
        try {
            WebElement element = driver.findElement(locator);
            element.clear();

            for (char character : text.toCharArray()) {
                element.sendKeys(String.valueOf(character));
                Thread.sleep(delayMs);
            }
            System.out.println("Typed with delay: " + text);
        } catch (Exception e) {
            System.out.println("Failed to type with delay: " + e.getMessage());
        }
    }

    /**
     * Verify element contains expected text
     *
     * @param locator      - Element locator
     * @param expectedText - Expected text
     * @return true if text matches
     */
    public boolean verifyElementText(By locator, String expectedText) {
        try {
            String actualText = getText(locator);
            boolean matches = actualText.contains(expectedText);
            System.out.println("Text verification: " + (matches ? "PASSED" : "FAILED"));
            return matches;
        } catch (Exception e) {
            System.out.println("Failed to verify text: " + e.getMessage());
            return false;
        }
    }

    // **12. ALERT AND POPUP HANDLING**

    /**
     * Handle alert popup - accept or dismiss
     *
     * @param action - "accept" or "dismiss"
     */
    public void handleAlert(String action) {
        try {
            Alert alert = driver.switchTo().alert();
            if (action.equalsIgnoreCase("accept")) {
                alert.accept();
                System.out.println("Alert accepted");
            } else {
                alert.dismiss();
                System.out.println("Alert dismissed");
            }
        } catch (Exception e) {
            System.out.println("No alert present or failed to handle: " + e.getMessage());
        }
    }

    /**
     * Get alert text
     *
     * @return Alert text content
     */
    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            return alertText;
        } catch (Exception e) {
            System.out.println("No alert present: " + e.getMessage());
            return "";
        }
    }

    // **13. DROPDOWN AND SELECTION METHODS**

    /**
     * Select dropdown option by visible text
     *
     * @param dropdownLocator - Dropdown locator
     * @param optionText      - Option text to select
     */
    public void selectDropdownByText(By dropdownLocator, String optionText) {
        try {
            click(dropdownLocator);
            pause(1);

            By optionLocator = AppiumBy.xpath("//*[@text='" + optionText + "']");
            click(optionLocator);
            System.out.println("Selected dropdown option: " + optionText);
        } catch (Exception e) {
            System.out.println("Failed to select dropdown option: " + e.getMessage());
        }
    }

    /**
     * Select dropdown option by index
     *
     * @param dropdownLocator - Dropdown locator
     * @param index           - Index of option to select (0-based)
     */
    public void selectDropdownByIndex(By dropdownLocator, int index) {
        try {
            click(dropdownLocator);
            pause(1);

            List<WebElement> options = driver.findElements(AppiumBy.className("android.widget.TextView"));
            if (index < options.size()) {
                options.get(index).click();
                System.out.println("Selected dropdown option at index: " + index);
            } else {
                System.out.println("Index out of bounds for dropdown options");
            }
        } catch (Exception e) {
            System.out.println("Failed to select dropdown by index: " + e.getMessage());
        }
    }

    // **14. CHECKBOX AND RADIO BUTTON METHODS**

    /**
     * Toggle checkbox state
     *
     * @param locator - Checkbox locator
     */
    public void toggleCheckbox(By locator) {
        try {
            WebElement checkbox = driver.findElement(locator);
            boolean isSelected = checkbox.isSelected();
            checkbox.click();
            System.out.println("Checkbox toggled from " + isSelected + " to " + !isSelected);
        } catch (Exception e) {
            System.out.println("Failed to toggle checkbox: " + e.getMessage());
        }
    }

    /**
     * Select radio button
     *
     * @param locator - Radio button locator
     */
    public void selectRadioButton(By locator) {
        try {
            WebElement radio = driver.findElement(locator);
            if (!radio.isSelected()) {
                radio.click();
                System.out.println("Radio button selected");
            } else {
                System.out.println("ℹRadio button already selected");
            }
        } catch (Exception e) {
            System.out.println("Failed to select radio button: " + e.getMessage());
        }
    }

    /**
     * Get current network connection type
     *
     * @return Connection type as string
     */
    public String getNetworkConnectionType() {
        try {
            Connection connection = (Connection) driver.getConnection();
            System.out.println("Current connection: " + connection.toString());
            return connection.toString();
        } catch (Exception e) {
            System.out.println("Failed to get connection type: " + e.getMessage());
            return "";
        }
    }

    // **16. DEVICE SETTINGS METHODS**

    /**
     * Open device settings
     */
    public void openSettings() {
        try {
            driver.pressKey(new KeyEvent(AndroidKey.HOME));
            pause(1);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Settings']")).click();
            System.out.println("Settings opened");
        } catch (Exception e) {
            System.out.println("Failed to open settings: " + e.getMessage());
        }
    }

    // **17. DATE AND TIME METHODS**

    /**
     * Generate current date in specified format
     *
     * @param format - Date format (e.g., "dd/MM/yyyy", "yyyy-MM-dd")
     * @return Formatted date string
     */
    public String getCurrentDate(String format) {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
            String date = sdf.format(new java.util.Date());
            System.out.println("Generated current date: " + date);
            return date;
        } catch (Exception e) {
            System.out.println("Failed to generate date: " + e.getMessage());
            return "";
        }
    }

    /**
     * Generate future date (days from now)
     *
     * @param daysFromNow - Number of days to add
     * @param format      - Date format
     * @return Future date string
     */
    public String getFutureDate(int daysFromNow, String format) {
        try {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.add(java.util.Calendar.DAY_OF_MONTH, daysFromNow);
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
            String date = sdf.format(cal.getTime());
            System.out.println("Generated future date: " + date);
            return date;
        } catch (Exception e) {
            System.out.println("Failed to generate future date: " + e.getMessage());
            return "";
        }
    }

    // **18. ADVANCED LOCATOR METHODS**

    /**
     * Find element by partial text
     *
     * @param partialText - Partial text to search for
     * @return WebElement
     */
    public WebElement findElementByPartialText(String partialText) {
        try {
            By locator = AppiumBy.xpath("//*[contains(@text,'" + partialText + "')]");
            WebElement element = driver.findElement(locator);
            System.out.println("Found element by partial text: " + partialText);
            return element;
        } catch (Exception e) {
            System.out.println("Failed to find element by partial text: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Find element by content description
     *
     * @param contentDesc - Content description value
     * @return WebElement
     */
    public WebElement findElementByContentDesc(String contentDesc) {
        try {
            By locator = AppiumBy.accessibilityId(contentDesc);
            WebElement element = driver.findElement(locator);
            System.out.println("Found element by content description: " + contentDesc);
            return element;
        } catch (Exception e) {
            System.out.println("Failed to find element by content description: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Find element by multiple attributes
     *
     * @param attributes - Map of attribute-value pairs
     * @return WebElement
     */
    public WebElement findElementByMultipleAttributes(Map<String, String> attributes) {
        try {
            StringBuilder xpathBuilder = new StringBuilder("//*");
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                xpathBuilder.append("[@").append(entry.getKey()).append("='").append(entry.getValue()).append("']");
            }

            By locator = AppiumBy.xpath(xpathBuilder.toString());
            WebElement element = driver.findElement(locator);
            System.out.println("Found element by multiple attributes");
            return element;
        } catch (Exception e) {
            System.out.println("Failed to find element by multiple attributes: " + e.getMessage());
            throw e;
        }
    }

    // **19. PERFORMANCE AND MONITORING METHODS**

    /**
     * Measure action execution time
     *
     * @param action - Runnable action to measure
     * @return Execution time in milliseconds
     */
    public long measureExecutionTime(Runnable action) {
        long startTime = System.currentTimeMillis();
        try {
            action.run();
            long executionTime = System.currentTimeMillis() - startTime;
            System.out.println("Action executed in: " + executionTime + "ms");
            return executionTime;
        } catch (Exception e) {
            long executionTime = System.currentTimeMillis() - startTime;
            System.out.println("Action failed after: " + executionTime + "ms");
            throw e;
        }
    }

    /**
     * Wait for page to load (wait for specific loading indicator to disappear)
     *
     * @param loadingIndicatorLocator - Locator of loading indicator
     */
    public void waitForPageLoad(By loadingIndicatorLocator) {
        try {
            waitForElementToDisappear(loadingIndicatorLocator);
            System.out.println("Page loaded successfully");
        } catch (Exception e) {
            System.out.println("Page load timeout: " + e.getMessage());
        }
    }

    // **20. UTILITY METHODS**

    /**
     * Retry action with specified attempts
     *
     * @param action      - Action to retry
     * @param maxAttempts - Maximum retry attempts
     * @param delayMs     - Delay between retries
     * @return true if action succeeded
     */
    public boolean retryAction(Runnable action, int maxAttempts, int delayMs) {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                action.run();
                System.out.println("Action succeeded on attempt: " + attempt);
                return true;
            } catch (Exception e) {
                System.out.println("Attempt " + attempt + " failed: " + e.getMessage());
                if (attempt < maxAttempts) {
                    try {
                        Thread.sleep(delayMs);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        System.out.println("All retry attempts failed");
        return false;
    }

    /**
     * Execute JavaScript on mobile (for hybrid apps)
     *
     * @param script - JavaScript to execute
     * @return Execution result
     */
    public Object executeJavaScript(String script) {
        try {
            Object result = ((JavascriptExecutor) driver).executeScript(script);
            System.out.println("JavaScript executed successfully");
            return result;
        } catch (Exception e) {
            System.out.println("❌ Failed to execute JavaScript: " + e.getMessage());
            return null;
        }
    }

    /**
     * Get page source
     *
     * @return Page source as string
     */
    public String getPageSource() {
        try {
            String pageSource = driver.getPageSource();
            System.out.println("Page source retrieved");
            return pageSource;
        } catch (Exception e) {
            System.out.println("❌ Failed to get page source: " + e.getMessage());
            return "";
        }
    }

    /**
     * Close app
     */
    public void closeApp() {
        try {
            driver.closeApp();
            System.out.println("App closed");
        } catch (Exception e) {
            System.out.println("❌ Failed to close app: " + e.getMessage());
        }
    }

    /**
     * Launch app
     */
    public void launchApp() {
        try {
            driver.launchApp();
            System.out.println("App launched");
        } catch (Exception e) {
            System.out.println("Failed to launch app: " + e.getMessage());
        }
    }

    /**
     * Reset app (clear app data)
     */
    public void resetApp() {
        try {
            driver.resetApp();
            System.out.println("App reset");
        } catch (Exception e) {
            System.out.println("Failed to reset app: " + e.getMessage());
        }
    }

    // **21. VALIDATION AND ASSERTION METHODS**

    /**
     * Verify element is present
     *
     * @param locator - Element locator
     * @return true if element is present
     */
    public boolean verifyElementPresent(By locator) {
        try {
            driver.findElement(locator);
            System.out.println("Element is present: " + locator);
            return true;
        } catch (Exception e) {
            System.out.println("Element not present: " + locator);
            return false;
        }
    }

    /**
     * Verify element is not present
     *
     * @param locator - Element locator
     * @return true if element is not present
     */
    public boolean verifyElementNotPresent(By locator) {
        try {
            driver.findElement(locator);
            System.out.println("Element is present (expected not present): " + locator);
            return false;
        } catch (Exception e) {
            System.out.println("Element not present as expected: " + locator);
            return true;
        }
    }

    /**
     * Verify element attribute value
     *
     * @param locator        - Element locator
     * @param attributeName  - Attribute name
     * @param expectedValue  - Expected value
     * @return true if attribute matches expected value
     */
    public boolean verifyElementAttribute(By locator, String attributeName, String expectedValue) {
        try {
            String actualValue = getElementAttribute(locator, attributeName);
            boolean matches = expectedValue.equals(actualValue);
            System.out.println("Attribute verification: " + (matches ? "PASSED" : "FAILED"));
            return matches;
        } catch (Exception e) {
            System.out.println("Failed to verify attribute: " + e.getMessage());
            return false;
        }
    }

    // **22. PERMISSIONS HANDLING**

    /**
     * Grant app permission
     *
     * @param permission - Permission to grant (e.g., "android.permission.CAMERA")
     */
    public void grantPermission(String permission) {
        try {
            // This would typically involve ADB commands or specific permission handling
            // Implementation depends on your testing framework setup
            System.out.println("Permission granted: " + permission);
        } catch (Exception e) {
            System.out.println("Failed to grant permission: " + e.getMessage());
        }
    }

    /**
     * Handle runtime permission dialog
     *
     * @param action - "allow" or "deny"
     */
    public void handlePermissionDialog(String action) {
        try {
            By allowButton = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
            By denyButton = AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button");

            if (action.equalsIgnoreCase("allow") && isElementDisplayed(allowButton)) {
                click(allowButton);
                System.out.println("Permission allowed");
            } else if (action.equalsIgnoreCase("deny") && isElementDisplayed(denyButton)) {
                click(denyButton);
                System.out.println("Permission denied");
            }
        } catch (Exception e) {
            System.out.println("Failed to handle permission dialog: " + e.getMessage());
        }
    }

    /**
     * Assert that an element is displayed
     */
    public static void assertElementDisplayed(WebElement element, String elementName) {
        Assert.assertTrue(element.isDisplayed(), elementName + " is not displayed!");
    }

    /**
     * Assert that an element is NOT displayed
     */
    public static void assertElementNotDisplayed(WebElement element, String elementName) {
        try {
            Assert.assertFalse(element.isDisplayed(), elementName + " should not be displayed!");
        } catch (Exception e) {
            // If element is not found, that's fine
            Assert.assertTrue(true);
        }
    }

    /**
     * Assert element text equals expected
     */
    public static void assertTextEquals(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText,
                "Text mismatch"+ ": expected [" + expectedText + "] but found [" + actualText + "]");
    }

    /**
     * Assert element text contains expected
     */
    public static void assertTextContains(WebElement element, String expectedSubstring, String elementName) {
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedSubstring),
                "Text for " + elementName + " does not contain expected substring. Found: [" + actualText + "]");
    }

    /**
     * Assert element is enabled
     */
    public static void assertElementEnabled(WebElement element, String elementName) {
        Assert.assertTrue(element.isEnabled(), elementName + " is not enabled!");
    }

    /**
     * Assert element is disabled
     */
    public static void assertElementDisabled(WebElement element, String elementName) {
        Assert.assertFalse(element.isEnabled(), elementName + " should be disabled!");
    }

    /**
     * Assert element is clickable (enabled + displayed)
     */
    public static void assertElementClickable(WebElement element, String elementName) {
        Assert.assertTrue(element.isDisplayed() && element.isEnabled(),
                elementName + " is not clickable!");
    }

    /**
     * Assert that actual value equals expected value (general use)
     */
    public static void assertValueEquals(String actual, String expected, String valueName) {
        Assert.assertEquals(actual, expected,
                "Value mismatch for " + valueName + ": expected [" + expected + "] but found [" + actual + "]");
    }

    /**
     * Assert that actual value contains expected substring (general use)
     */
    public static void assertValueContains(String actual, String expectedSubstring, String valueName) {
        Assert.assertTrue(actual.contains(expectedSubstring),
                valueName + " does not contain expected substring. Found: [" + actual + "]");
    }

    private static final Faker faker = new Faker(new Locale("en", "IN")); // India locale
    private static final Random random = new Random();

    /**
     * Inner class to hold all test data
     */
    public static class TestData {
        public String name;
        public String firstName;
        public String lastName;
        public String email;
        public String phoneNumber;
        public String address;
        public String city;
        public String state;
        public String pincode;
        public String country;
        public String dateOfBirth;
        public String age;
        public String gender;
        public String specialization;
        public String hospitalName;
        public String medicalLicense;
        public String experience;

        // Constructor
        public TestData() {
            this.country = "India"; // Default country
        }

        @Override
        public String toString() {
            return String.format(
                    "TestData{name='%s', email='%s', phone='%s', city='%s', country='%s'}",
                    name, email, phoneNumber, city, country
            );
        }
    }

    /**
     * Generate complete test data with all fields populated
     * @return TestData object with all generated data
     */
    public static TestData generateTestData() {
        TestData testData = new TestData();

        // Basic personal information
        testData.firstName = faker.name().firstName();
        testData.lastName = faker.name().lastName();
        testData.name = testData.firstName + " " + testData.lastName;
        testData.email = generateEmail(testData.firstName, testData.lastName);
        testData.phoneNumber = generateIndianPhoneNumber();
        testData.dateOfBirth = faker.date().birthday(25, 65).toString();
        testData.age = String.valueOf(faker.number().numberBetween(25, 65));
        testData.gender = faker.options().option("Male", "Female", "Other");

        // Address information (India-specific)
        testData.address = faker.address().streetAddress();
        testData.city = getRandomIndianCity();
        testData.state = getRandomIndianState();
        testData.pincode = generateIndianPincode();

        // Medical/Professional information
        testData.specialization = getRandomMedicalSpecialization();
        testData.hospitalName = generateHospitalName();
        testData.medicalLicense = generateMedicalLicense();
        testData.experience = String.valueOf(faker.number().numberBetween(1, 40)) + " years";

        return testData;
    }

    /**
     * Generate only basic test data (name, email, phone)
     * @return TestData object with basic fields
     */
    public static TestData generateBasicTestData() {
        TestData testData = new TestData();
        testData.firstName = faker.name().firstName();
        testData.lastName = faker.name().lastName();
        testData.name = testData.firstName + " " + testData.lastName;
        testData.email = generateEmail(testData.firstName, testData.lastName);
        testData.phoneNumber = generateIndianPhoneNumber();
        return testData;
    }

    /**
     * Generate doctor-specific test data
     * @return TestData object with doctor-related fields
     */
    public static TestData generateDoctorTestData() {
        TestData testData = generateTestData();
        testData.name = "Dr. " + testData.name;
        return testData;
    }

    // Helper methods

    private static String generateEmail(String firstName, String lastName) {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "rediffmail.com"};
        String domain = domains[random.nextInt(domains.length)];
        return (firstName + "." + lastName + faker.number().numberBetween(1, 999)).toLowerCase() + "@" + domain;
    }

    private static String generateIndianPhoneNumber() {
        // Indian mobile numbers start with 6, 7, 8, or 9 and have 10 digits
        int firstDigit = faker.options().option(6, 7, 8, 9);
        StringBuilder phoneNumber = new StringBuilder("+91");
        phoneNumber.append(firstDigit);
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(faker.number().numberBetween(0, 9));
        }
        return phoneNumber.toString();
    }

    private static String generateIndianPincode() {
        // Indian pincodes are 6 digits
        return String.valueOf(faker.number().numberBetween(100000, 999999));
    }

    private static String getRandomIndianCity() {
        String[] cities = {
                "Mumbai", "Delhi", "Bangalore", "Hyderabad", "Ahmedabad", "Chennai",
                "Kolkata", "Surat", "Pune", "Jaipur", "Lucknow", "Kanpur",
                "Nagpur", "Indore", "Thane", "Bhopal", "Visakhapatnam", "Pimpri-Chinchwad"
        };
        return cities[random.nextInt(cities.length)];
    }

    private static String getRandomIndianState() {
        String[] states = {
                "Maharashtra", "Delhi", "Karnataka", "Telangana", "Gujarat",
                "Tamil Nadu", "West Bengal", "Rajasthan", "Uttar Pradesh",
                "Madhya Pradesh", "Andhra Pradesh", "Kerala", "Punjab", "Haryana"
        };
        return states[random.nextInt(states.length)];
    }

    private static String getRandomMedicalSpecialization() {
        String[] specializations = {
                "Cardiology", "Neurology", "Orthopedics", "Pediatrics", "Gynecology",
                "Dermatology", "Psychiatry", "General Medicine", "Surgery", "Radiology",
                "Anesthesiology", "Emergency Medicine", "Oncology", "Gastroenterology"
        };
        return specializations[random.nextInt(specializations.length)];
    }

    private static String generateHospitalName() {
        String[] hospitalTypes = {"General Hospital", "Medical Center", "Care Hospital", "Health Center", "Clinic"};
        String[] hospitalPrefixes = {"City", "Metro", "Apollo", "Max", "Fortis", "Manipal", "AIIMS"};

        return hospitalPrefixes[random.nextInt(hospitalPrefixes.length)] + " " +
                hospitalTypes[random.nextInt(hospitalTypes.length)];
    }

    private static String generateMedicalLicense() {
        return "MCI/" + faker.number().numberBetween(10000, 99999) + "/IN/" +
                faker.number().numberBetween(2010, 2024);
    }

    public void assertTwoValuesAreEqual(Object value1, Object value2) {
        pause(1);
        Assert.assertEquals(value1, value2);
    }

    public void clearField(String xpath, String message) {
        try {
            By locator = By.xpath(xpath);
            waitForElementToBeVisible(locator);
            driver.findElement(locator).clear();
            logPrint(message);
        } catch (Exception e) {
            logPrint("Unable to clear field: " + xpath + " - " + e.getMessage());
        }
    }

    public void assertToaster(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement toastMsg = (WebElement) wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(value))
            );
            Assert.assertTrue(toastMsg.isDisplayed(), "Toast not displayed!");

            System.out.println("Toast displayed: " + toastMsg.getText());
        } catch (Exception e)
        {
            Assert.fail("Toast did not appear!");

        }
    }

    private String getFormattedDate(int daysToAdd) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        return sdf.format(calendar.getTime());
    }

    // Select Today
    public String selectToday() {
        String today = getFormattedDate(0);
        String todayxpath = "//android.view.View[@content-desc=\"" + today + "\"]";
        System.out.println("Selected Today: " + today);
        return todayxpath;
    }

    // Select Tomorrow
    public String selectTomorrow() {
        String tomorrow = getFormattedDate(1);
        String tomorrowxpath = "//android.view.View[@content-desc=\"" + tomorrow + "\"]";
        System.out.println("Selected Tomorrow: " + tomorrow);
        return tomorrowxpath;
    }

    // Select Day After Tomorrow (+2)
    public String selectDayAfterTomorrow() {
        String dayAfterTomorrow = getFormattedDate(2);
        String dayAfterTomorrowxpath = "//android.view.View[@content-desc=\"" + dayAfterTomorrow + "\"]";
        System.out.println("Selected Day After Tomorrow: " + dayAfterTomorrow);
        return dayAfterTomorrowxpath;
    }

    public void assertElementDisplayed(String locator) {
        waitForElement(By.xpath(locator));
        Assert.assertTrue(isElementDisplayed(By.xpath(locator)));
    }

    public String randomDateAndroid(){

        LocalDate today = LocalDate.now();
        YearMonth currentMonth = YearMonth.from(today);

        int maxDay = currentMonth.lengthOfMonth();
        int minDay = today.getDayOfMonth() + 1;

        // If today is the last day of the month, no future dates remain
        if (minDay > maxDay) {
            throw new IllegalStateException("No future days left in the current month!");
        }

        LocalDate randomDate;

        do {
            int randomDay = ThreadLocalRandom.current().nextInt(minDay, maxDay + 1);
            randomDate = LocalDate.of(today.getYear(), today.getMonth(), randomDay);
        } while (randomDate.getDayOfWeek() == DayOfWeek.SUNDAY);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");

        String formattedDate = randomDate.format(formatter);
        String xpath = "//android.view.View[@content-desc=\"" + formattedDate + "\"]";

        System.out.println("Selected Random Date (this month, not Sunday): " + formattedDate);
        return xpath;
    }

    public void skipIfDisplayed(String xpathVal) {
        By locator = By.xpath(xpathVal);
        List<WebElement> elements = driver.findElements(locator);

        if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
            throw new SkipException("⚠️ No data found. Skipping this test case.");
        }
    }

    public void assertGiftPresent(String scrollViewContainerXpath, String expectedGift) {
        // Create local WebDriverWait (10 sec or adjust as per your framework)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the ScrollView container to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(scrollViewContainerXpath)));

        // Get all descendants inside the ScrollView container
        List<WebElement> allElements = driver.findElements(By.xpath(scrollViewContainerXpath + "//*"));

        boolean found = false;

        for (WebElement el : allElements) {
            String contentDesc = el.getAttribute("content-desc");
            String text = el.getText();

            if ((contentDesc != null && contentDesc.equalsIgnoreCase(expectedGift)) ||
                    (text != null && text.equalsIgnoreCase(expectedGift))) {
                found = true;
                System.out.println("✅ Gift '" + expectedGift + "' found in ScrollView.");
                break;
            }
        }

        // Use TestNG assertion
        Assert.assertTrue(found, "❌ Gift '" + expectedGift + "' not found in ScrollView!");
    }

    public String selectRandom(String containerChildXpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(containerChildXpath)));

        List<WebElement> groups = driver.findElements(By.xpath(containerChildXpath));
        int total = groups.size();
        System.out.println(" Total items found: " + total);

        if (total == 0) {
            System.out.println("️ No groups found to select.");
            return null;
        }

        // Pick a random index
        int index = random.nextInt(total);
        WebElement chosen = groups.get(index);

        wait.until(ExpectedConditions.elementToBeClickable(chosen));
        System.out.println(" Clicking the item at index: " + (index + 1));
        chosen.click();

        // Now look for any child element having content-desc (like "IOXI 30")
        List<WebElement> descElements = chosen.findElements(By.xpath(".//android.view.ViewGroup[@content-desc]"));
        String selectedText = "";

        if (!descElements.isEmpty()) {
            selectedText = descElements.get(0).getAttribute("content-desc");
            System.out.println(" Extracted content-desc: " + selectedText);
        } else {
            // Fallback: if no content-desc found, try getText()
            selectedText = chosen.getText();
            System.out.println(" No content-desc found, fallback text: " + selectedText);
        }

        return selectedText;
    }



}