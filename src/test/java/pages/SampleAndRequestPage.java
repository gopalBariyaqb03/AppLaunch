package pages;

import io.netty.util.collection.CharObjectMap;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.time.Duration;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SampleAndRequestPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ExpensePage.class);
    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String companyCode = ConfigReader.getCompanyCode();
    String mrName = ConfigReader.getMrName();
    String asmName = ConfigReader.getAsmName();
    String rsmName = ConfigReader.getRsmName();
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    String today = sdf.format(new Date());
    private final Random random = new Random();


    public String SAMPLEANDREQUEST = "//android.view.ViewGroup[@content-desc=\"Sample & Request\"]/android.widget.ImageView";
    public String REUQUESTGIFT = "//android.view.ViewGroup[@content-desc=\"Requested Gift\"]/android.widget.ImageView";
    public String RECEIVEGIFT = "//android.view.ViewGroup[@content-desc=\"Receive Gift\"]/android.widget.ImageView";
    public String ACCEPTGIFT = "//android.view.ViewGroup[@content-desc=\"Accept\"]";
    public String NODATAFOUND = "//android.widget.TextView[@text=\"No Data found!\"]";
    public String ADDGIFTBUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String GIFTNAME = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    //public String GIFTNAMEVAL = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[%d]";
    public String GIFTNAMEVAL = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
    public String GIFTQTY = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String GIFTQTYVAL = "//android.widget.EditText";
    public String BACKBUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView";
    public String ADDBUTTON = "//android.view.ViewGroup[@content-desc=\"Add\"]";
    public String SUBMITBUTTON = "//android.view.ViewGroup[@content-desc=\"Submit\"]/android.widget.ImageView";
    public String ASSERTADDSAMPLE = "//android.widget.TextView[@text=\"Sample request sent successfully...\"]";
    public String ASSERTADDSAMPLEACCPET = "//android.widget.TextView[@text=\"Sample accepted successfully...\"]";
    public String RECEIVEGIFTVALUES = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
    public String AVLBGIFT = "//android.view.ViewGroup[@content-desc=\"Available Gift Stock\"]/android.widget.ImageView";
    public String CLOSEBUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    public String RECGIFTNAME = "//android.view.ViewGroup[@content-desc=\"%d\"]";
    LeavePage leavePage = new LeavePage();

    LoginPage loginPage = new LoginPage();

    private static int stepCounter = 1;

    private void click(String xpath, String message) {
        commonActions.waitForElementToBeVisible(By.xpath(xpath));
        commonActions.waitForElementToBeClickable(By.xpath(xpath));
        commonActions.click(By.xpath(xpath));
        commonActions.logPrint("[Step " + stepCounter++ + " -->] " + message);
//        WebElement pinval = driver.findElement(By.xpath(xpath));
//        commonActions.logPrint("Selected "+ pinval.getText());
    }

    private void type(String xpath, String text) {
        commonActions.clearField(xpath, " Field Cleared");
        commonActions.waitForElementToBeVisible(By.xpath(xpath));
        commonActions.type(By.xpath(xpath), text);
        commonActions.logPrint("[Step " + stepCounter++ + " -->] ");

    }

    public void selectRandomFromDropdown(String xpathPattern) {
        Random random = new Random();
        int i = random.nextInt(5) + 1; // random index between 1–5

        // Replace %d placeholder with i
        String randomXpath = String.format(xpathPattern, i);

        commonActions.waitForElementToBeVisible(By.xpath(randomXpath));
        commonActions.click(By.xpath(randomXpath));

        System.out.println("✅ Selected the option at index: " + i);
        System.out.println("✅ Selected option xpath: " + randomXpath);
    }

    public String randomRatings(){
        Random random  = new Random();
        String i = String.valueOf(random.nextInt(5) + 1);
        return i;

    }

    public static String generatePhoneNumber() {
        Random random = new Random();

        StringBuilder phone = new StringBuilder();
        phone.append(random.nextInt(9) + 1);
        for (int i = 0; i < 9; i++) {
            phone.append(random.nextInt(10));
        }
        return phone.toString();
    }

    public void clickIfPresent(By locator, int waitTimeInSeconds, String stepDescription) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTimeInSeconds));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (element.isDisplayed()) {
                element.click();
                commonActions.logPrint("step:: " + stepDescription + " - clicked successfully");
            }
        } catch (TimeoutException e) {
            commonActions.logPrint("step:: " + stepDescription + " - not displayed, skipping this step");
        } catch (Exception e) {
            commonActions.logPrint("step:: " + stepDescription + " - error: " + e.getMessage());
        }
    }

    public void redirectToSampleAndRequestPage() {
        try {
            By backButtonXpath = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']"
                    + "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"
                    + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"
                    + "/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView");

            WebElement backButton;

            // Try to find the back button
            try {
                backButton = driver.findElement(backButtonXpath);
            } catch (Exception e) {
                backButton = null;
            }

            // If back button is visible, click until it's gone or limit reached
            if (backButton != null && backButton.isDisplayed()) {
                int maxAttempts = 3; // prevent infinite loops
                int attempts = 0;

                while (attempts < maxAttempts) {
                    try {
                        if (driver.findElement(backButtonXpath).isDisplayed()) {
                            driver.findElement(backButtonXpath).click();
                            attempts++;
                            Thread.sleep(1000); // small wait for screen update
                        } else {
                            break;
                        }
                    } catch (Exception ignored) {
                        break; // element not found after navigation
                    }
                }
            } else {
                // Back button not present → navigate to Sample & Request
                commonActions.scrollToElement(By.xpath(SAMPLEANDREQUEST));
            }

        } catch (Exception e) {
            System.err.println("⚠️ Error navigating to Sample and Request page: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void addGift(){
        click(GIFTNAME, "Click on the Add Gift Button");
        commonActions.selectRandom(GIFTNAMEVAL);
        //selectRandomFromDropdown(GIFTNAMEVAL);
        clickIfPresent(By.xpath(CLOSEBUTTON),1,"Click on Close Button");
        click(GIFTQTY, "Clicking on Gift QTY");
        type(GIFTQTYVAL,"5");
        click(ADDBUTTON,"Clicking on add button");
        click(ADDBUTTON,"Clicking on add button");
    }

    public void requestedGift(int gifts){
        click(REUQUESTGIFT, "Click on the Request Gift Module");
        click(ADDGIFTBUTTON, "Click on the Add Gift Button");
        for (int i = 0; i < gifts; i++) {
            addGift();
        }
        click(SUBMITBUTTON,"Clicking on submit button");
        commonActions.assertToaster(ASSERTADDSAMPLE);

    }



    public void receiveGift() {
        redirectToSampleAndRequestPage();
        click(RECEIVEGIFT, "Clicking on the receive gift module");
        commonActions.skipIfDisplayed(NODATAFOUND);
        String randomGift = commonActions.selectRandom(RECEIVEGIFTVALUES);
        System.out.println(" Randomly selected gift: " + randomGift);

        //commonActions.getElements(By.xpath(RECGIFTNAME));
        click(ACCEPTGIFT, "Accepting the Gift");
        commonActions.assertToaster(ASSERTADDSAMPLEACCPET);

        //click(BACKBUTTON, "Clicking on the back button");
        click(AVLBGIFT, "Clicking on the available gift option");

        commonActions.assertGiftPresent("//android.widget.ScrollView/android.view.ViewGroup", randomGift);

    }

}
