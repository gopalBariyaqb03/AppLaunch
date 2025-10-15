package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;
import utils.ConfigReader;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        try {
            // Read platform configuration
            String platform = ConfigReader.getProperty("platform.name").toLowerCase();
            String appiumServerUrl = ConfigReader.getAppiumServerUrl();
            int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicit.wait"));

            System.out.println("=".repeat(50));
            System.out.println("Platform: " + platform.toUpperCase());
            System.out.println("=".repeat(50));

            AppiumDriver driver;

            // Platform-based configuration
            if (platform.equals("android")) {
                driver = setupAndroid(appiumServerUrl);
            } else if (platform.equals("ios")) {
                driver = setupIOS(appiumServerUrl);
            } else {
                throw new IllegalArgumentException("Invalid platform: " + platform + ". Use 'android' or 'ios'");
            }

            // Set implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
            DriverManager.setDriver((AndroidDriver) driver);

            System.out.println("✓ App launched successfully on " + platform.toUpperCase() + "!");

        } catch (Exception e) {
            System.out.println("✗ Failed to launch app: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Setup Android capabilities and driver
     */
    private AndroidDriver setupAndroid(String appiumServerUrl) throws Exception {
        String deviceName = ConfigReader.getDeviceName();
        String platformVersion = ConfigReader.getPlatformVersion();
        String automationName = ConfigReader.getProperty("automation.name");
        String appPackage = ConfigReader.getAppPackage();
        String appActivity = ConfigReader.getAppActivity();
        String appPath = ConfigReader.getAppPath();

        boolean noReset = Boolean.parseBoolean(ConfigReader.getNoReset());
        boolean fullReset = Boolean.parseBoolean(ConfigReader.getFullReset());

        // Log reset configuration
        System.out.println("Reset Configuration:");
        System.out.println("noReset = " + noReset);
        System.out.println("fullReset = " + fullReset);

        // Warn about conflicting configuration
        if (noReset && fullReset) {
            System.out.println("WARNING: Both noReset and fullReset are true!");
            System.out.println("Appium will prioritize fullReset (app will be reinstalled)");
        } else if (noReset && !fullReset) {
            System.out.println("✓ App state/data will be PRESERVED");
        } else if (!noReset && !fullReset) {
            System.out.println("✓ App data will be CLEARED (fresh start, no reinstall)");
        } else if (!noReset && fullReset) {
            System.out.println("✓ App will be REINSTALLED (fresh install)");
        }
        System.out.println("=".repeat(50));

        // Set Android capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:platformVersion", platformVersion);
        caps.setCapability("appium:automationName", automationName);
        caps.setCapability("appium:appPackage", appPackage);
        caps.setCapability("appium:appActivity", appActivity);
        caps.setCapability("appium:app", appPath);
        caps.setCapability("ignoreHiddenApiPolicyError", true);
        caps.setCapability("skipServerInstallation", false);
        caps.setCapability("noReset", noReset);
        caps.setCapability("fullReset", fullReset);
        // caps.setCapability("autoGrantPermissions", true);

        return new AndroidDriver(new URL(appiumServerUrl), caps);
    }

    /**
     * Setup iOS capabilities and driver
     */
    private IOSDriver setupIOS(String appiumServerUrl) throws Exception {
        String deviceName = ConfigReader.getIOSDeviceName();
        String platformVersion = ConfigReader.getIOSPlatformVersion();
        String automationName = ConfigReader.getIOSAutomationName();
        String bundleId = ConfigReader.getIOSBundleId();
        String appPath = ConfigReader.getIOSAppPath();
        String udid = ConfigReader.getIOSUdid();

        boolean noReset = Boolean.parseBoolean(ConfigReader.getIOSNoReset());
        boolean fullReset = Boolean.parseBoolean(ConfigReader.getIOSFullReset());

        // Log reset configuration
        System.out.println("Reset Configuration:");
        System.out.println("noReset = " + noReset);
        System.out.println("fullReset = " + fullReset);

        if (noReset && !fullReset) {
            System.out.println("✓ App state/data will be PRESERVED");
        } else if (!noReset && !fullReset) {
            System.out.println("✓ App data will be CLEARED (fresh start)");
        } else if (!noReset && fullReset) {
            System.out.println("✓ App will be REINSTALLED (fresh install)");
        }
        System.out.println("=".repeat(50));

        // Set iOS capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:platformVersion", platformVersion);
        caps.setCapability("appium:automationName", automationName); // XCUITest
        caps.setCapability("appium:app", appPath);
        caps.setCapability("appium:bundleId", bundleId);
        caps.setCapability("noReset", noReset);
        caps.setCapability("fullReset", fullReset);

        // Optional: For real device testing
        if (udid != null && !udid.isEmpty()) {
            caps.setCapability("appium:udid", udid);
        }

        return new IOSDriver(new URL(appiumServerUrl), caps);
    }

    @AfterMethod
    public void tearDown() {
        try {
            if (DriverManager.getDriver() != null) {
                DriverManager.getDriver().quit();
                System.out.println("✓ Driver quit successfully!");
            }
        } catch (Exception e) {
            System.out.println("✗ Error closing app: " + e.getMessage());
        }
    }
}