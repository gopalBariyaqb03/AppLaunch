package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.ConfigReader;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class LeavePage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(LeavePage.class);
    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String companyCode = ConfigReader.getCompanyCode();
    String mrName = ConfigReader.getMrName();
    String asmName = ConfigReader.getAsmName();
    String rsmName = ConfigReader.getRsmName();

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    String today = sdf.format(new Date());

    public String UTILITY ="//android.view.ViewGroup[@content-desc=\"Utility\"]";
    public String LEAVE ="//android.view.ViewGroup[@content-desc=\"Leave\"]/android.widget.ImageView";
    public String ADDBUTTON ="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String HALFDAY ="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String FULLDAY ="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String MULTIPLEDAY ="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]";
    public String LEAVETYPE ="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]";
    public String SICKLEAVE ="//android.widget.TextView[@text=\"Sick Leave\"]";
    public String CASUALLEAVE ="//android.widget.TextView[@text=\"Casual Leave\"]";
    public String PRIVILAGELEAVE ="//android.widget.TextView[@text=\"Privilege Leave\"]";
    public String EMERGENCYLEAVE ="//android.widget.TextView[@text=\"Emergency Leave\"]";
    public String MEDICALEMERGENCYLEAVE ="//android.widget.TextView[@text=\"Medical Emergency \"]";
    public String FROMDATE ="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView";
    public String TODATE ="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]";
    public String FROMDATEVAL = "//android.view.View[@content-desc=\"" + today + "\"]";
    public String OKBUTTON = "//android.widget.Button[@resource-id=\"android:id/button1\"]";
    public String REASON = "//android.widget.EditText";
    public String SUBMIT = "//android.view.ViewGroup[@content-desc=\"Submit\"]";
    public String LEAVEALREAYADDED = "//android.widget.TextView[@text=\"Leave already added in this date\"]";
    public String LEAVEADDEDSUCCESS = "//android.widget.TextView[@text=\"Leave added successfully...\"]";
    public String BACKBUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView";
    public String DELETECONFIRM = "//android.widget.TextView[@text=\"Delete\"]";
    public String DELETE = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView";
    public String APPROVALBUTTON = "//android.view.ViewGroup[@content-desc=\"Approvals\"]";
    public String LEAVEAPPROVALMENU = "//android.view.ViewGroup[@content-desc=\"Leave Approval\"]";
    public String APPROVEBUTTON = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]";
    public String REJECTBUTTON = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView";
    public String APPROVEDOPTION = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.TextView/com.horcrux.svg.TSpanView";
    public String REJECTEDOPTION = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/com.horcrux.svg.SvgView";
    public String FILTER = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String SEARCHBAR = "//android.widget.EditText[@text=\"Search\"]";
    public String LEAVEAPPROVETOASTER = "//android.widget.TextView[@text=\"Leave approved successfully\"]";
    public String LEAVEREJECTTOASTER = "//android.widget.TextView[@text=\"Leave rejected successfully\"]";
    public String SELECTSEARCH = "(//android.view.ViewGroup[@content-desc])[1]";
    public String CLOSEBUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    public String REJECTAPPROVE = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup";
    public String REJECTREASON = "//android.widget.EditText[@text=\"Add reason\"]";
    public String REJECTSUBMIT = "//android.widget.TextView[@text=\"Confirm\"]";
    public String REJECTCANCEL = "//android.widget.TextView[@text=\"Cancel\"]";


    public void leaveAddedTest() {
        int maxRetries = 10;
        int attempt = 0;
        boolean success = false;

        while (attempt < maxRetries && !success) {
            attempt++;
            commonActions.logPrint("Step:: Attempt #" + attempt + " to add leave...");

            commonActions.waitForElement(By.xpath(FROMDATE));
            commonActions.click(By.xpath(FROMDATE));
            commonActions.click(By.xpath(commonActions.randomDateAndroid()));

            commonActions.waitForElement(By.xpath(OKBUTTON));
            commonActions.click(By.xpath(OKBUTTON));

            commonActions.waitForElement(By.xpath(SUBMIT));
            commonActions.click(By.xpath(SUBMIT));

            List<WebElement> successMessages = driver.findElements(By.xpath(LEAVEADDEDSUCCESS));
            if (!successMessages.isEmpty() && successMessages.get(0).isDisplayed()) {
                commonActions.logPrint("Leave added successfully on attempt #" + attempt);
                success = true;
                assertLeaveAddedSuccess(LEAVEADDEDSUCCESS);
            } else {
                commonActions.waitForElement(By.xpath(SUBMIT));
                commonActions.click(By.xpath(SUBMIT));
                List<WebElement> alreadyAddedMsgs = driver.findElements(By.xpath(LEAVEALREAYADDED));
                if (!alreadyAddedMsgs.isEmpty() && alreadyAddedMsgs.get(0).isDisplayed()) {
                    commonActions.logPrint("Leave already added for selected date. Retrying with new date...");
                } else {
                    commonActions.waitForElement(By.xpath(SUBMIT));
                    commonActions.click(By.xpath(SUBMIT));
                    commonActions.logPrint("Leave not added. Retrying...");
                }
            }
        }

        if (!success) {
            throw new RuntimeException("Failed to add leave after " + maxRetries + " attempts.");
        }
    }

    public void multipleDayTest() {
        int maxRetries = 10;
        int attempt = 0;
        boolean success = false;

        while (attempt < maxRetries && !success) {
            attempt++;
            System.out.println("Attempt #" + attempt + " to add leave...");

            commonActions.waitForElement(By.xpath(FROMDATE));
            commonActions.click(By.xpath(FROMDATE));
            commonActions.click(By.xpath(commonActions.randomDateAndroid()));

            commonActions.waitForElement(By.xpath(OKBUTTON));
            commonActions.click(By.xpath(OKBUTTON));

            commonActions.waitForElement(By.xpath(TODATE));
            commonActions.click(By.xpath(TODATE));
            commonActions.click(By.xpath(commonActions.randomDateAndroid()));

            commonActions.waitForElement(By.xpath(OKBUTTON));
            commonActions.click(By.xpath(OKBUTTON));

            commonActions.waitForElement(By.xpath(SUBMIT));
            commonActions.click(By.xpath(SUBMIT));

            List<WebElement> successMessages = driver.findElements(By.xpath(LEAVEADDEDSUCCESS));
            if (!successMessages.isEmpty() && successMessages.get(0).isDisplayed()) {
                System.out.println("Leave added successfully on attempt #" + attempt);
                success = true;
                assertLeaveAddedSuccess(LEAVEADDEDSUCCESS);
            } else {
                commonActions.waitForElement(By.xpath(SUBMIT));
                commonActions.click(By.xpath(SUBMIT));
                List<WebElement> alreadyAddedMsgs = driver.findElements(By.xpath(LEAVEALREAYADDED));
                if (!alreadyAddedMsgs.isEmpty() && alreadyAddedMsgs.get(0).isDisplayed()) {
                    System.out.println("Leave already added for selected date. Retrying with new date...");
                } else {
                    commonActions.waitForElement(By.xpath(SUBMIT));
                    commonActions.click(By.xpath(SUBMIT));
                    System.out.println("Leave not added. Retrying...");
                }
            }
        }

        if (!success) {
            throw new RuntimeException("Failed to add leave after " + maxRetries + " attempts.");
        }
    }

    public void assertLeaveAddedSuccess(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toastMsg = (WebElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(value))
        );
        Assert.assertTrue(toastMsg.isDisplayed(), "Toast not displayed!");
        System.out.println("Toast displayed: " + toastMsg.getText());
    }

    public String randomLeave(){
        List<String> leaves = Arrays.asList(
                SICKLEAVE,
                CASUALLEAVE,
                PRIVILAGELEAVE,
                EMERGENCYLEAVE
        );
        Random random = new Random();
        int index = random.nextInt(leaves.size());
        return leaves.get(index);
    }

    public void addHalfDayLeave(){
        commonActions.scrollToElement(By.xpath(UTILITY));
        commonActions.waitForElement(By.xpath(LEAVE));
        commonActions.click(By.xpath(LEAVE));

        commonActions.waitForElement(By.xpath(ADDBUTTON));
        commonActions.click(By.xpath(ADDBUTTON));

        commonActions.waitForElement(By.xpath(HALFDAY));
        commonActions.click(By.xpath(HALFDAY));

        commonActions.waitForElement(By.xpath(LEAVETYPE));
        commonActions.click(By.xpath(LEAVETYPE));

        String randomLeave = randomLeave();
        System.out.println("Randomly Selected Leave: " + randomLeave);

        commonActions.waitForElement(By.xpath(randomLeave));
        commonActions.click(By.xpath(randomLeave));

        commonActions.waitForElement(By.xpath(FROMDATE));
        commonActions.click(By.xpath(FROMDATE));
        commonActions.click(By.xpath(commonActions.selectToday()));

        commonActions.waitForElement(By.xpath(OKBUTTON));
        commonActions.click(By.xpath(OKBUTTON));

        commonActions.waitForElement(By.xpath(REASON));
        commonActions.type(By.xpath(REASON), randomLeave);

        commonActions.waitForElement(By.xpath(SUBMIT));
        commonActions.click(By.xpath(SUBMIT));

        List<WebElement> successMessages = driver.findElements(By.xpath(LEAVEADDEDSUCCESS));
        if (!successMessages.isEmpty() && successMessages.get(0).isDisplayed()) {
            System.out.println(" Leave added successfully.");
        } else {
            // If not successful, click submit again and call leaveAddedTest()
            commonActions.waitForElement(By.xpath(SUBMIT));
            commonActions.click(By.xpath(SUBMIT));

            leaveAddedTest();

            System.out.println("️ Initial leave add failed. Retried via leaveAddedTest().");
        }

        System.out.println(" addHalfDayLeave() flow completed.");
    }

    public void addFullDayLeave() {
        String randomLeave = randomLeave();
        commonActions.scrollToElement(By.xpath(UTILITY));
        commonActions.waitForElement(By.xpath(LEAVE));
        commonActions.click(By.xpath(LEAVE));

        commonActions.waitForElement(By.xpath(ADDBUTTON));
        commonActions.click(By.xpath(ADDBUTTON));

        commonActions.waitForElement(By.xpath(FULLDAY));
        commonActions.click(By.xpath(FULLDAY));

        commonActions.waitForElement(By.xpath(LEAVETYPE));
        commonActions.click(By.xpath(LEAVETYPE));

        System.out.println("Randomly Selected Leave: " + randomLeave);

        commonActions.waitForElement(By.xpath(randomLeave));
        commonActions.click(By.xpath(randomLeave));

        commonActions.waitForElement(By.xpath(FROMDATE));
        commonActions.click(By.xpath(FROMDATE));
        commonActions.click(By.xpath(commonActions.selectTomorrow()));

        commonActions.waitForElement(By.xpath(OKBUTTON));
        commonActions.click(By.xpath(OKBUTTON));

        commonActions.waitForElement(By.xpath(REASON));
        commonActions.type(By.xpath(REASON), randomLeave);

        commonActions.waitForElement(By.xpath(SUBMIT));
        commonActions.click(By.xpath(SUBMIT));

        List<WebElement> successMessages = driver.findElements(By.xpath(LEAVEADDEDSUCCESS));
        if (!successMessages.isEmpty() && successMessages.get(0).isDisplayed()) {
            System.out.println("Leave added successfully.");
        } else {
            // If not successful, click submit again and call leaveAddedTest()
            commonActions.waitForElement(By.xpath(SUBMIT));
            commonActions.click(By.xpath(SUBMIT));

            leaveAddedTest();

            System.out.println("Initial leave add failed. Retried via leaveAddedTest().");
        }

        System.out.println("addHalfDayLeave() flow completed.");

        System.out.println("addFullDayLeave() flow completed.");
    }

    public void addMultipleDayLeave() {
        String randomLeave = randomLeave();
        commonActions.scrollToElement(By.xpath(UTILITY));
        commonActions.waitForElement(By.xpath(LEAVE));
        commonActions.click(By.xpath(LEAVE));

        commonActions.waitForElement(By.xpath(ADDBUTTON));
        commonActions.click(By.xpath(ADDBUTTON));

        commonActions.waitForElement(By.xpath(MULTIPLEDAY));
        commonActions.click(By.xpath(MULTIPLEDAY));

        commonActions.waitForElement(By.xpath(LEAVETYPE));
        commonActions.click(By.xpath(LEAVETYPE));

        System.out.println("Randomly Selected Leave: " + randomLeave);

        commonActions.waitForElement(By.xpath(randomLeave));
        commonActions.click(By.xpath(randomLeave));

        commonActions.waitForElement(By.xpath(FROMDATE));
        commonActions.click(By.xpath(FROMDATE));
        commonActions.click(By.xpath(commonActions.selectToday()));

        commonActions.waitForElement(By.xpath(OKBUTTON));
        commonActions.click(By.xpath(OKBUTTON));

        commonActions.waitForElement(By.xpath(TODATE));
        commonActions.click(By.xpath(TODATE));
        commonActions.click(By.xpath(commonActions.randomDateAndroid()));

        commonActions.waitForElement(By.xpath(OKBUTTON));
        commonActions.click(By.xpath(OKBUTTON));

        commonActions.waitForElement(By.xpath(REASON));
        commonActions.type(By.xpath(REASON), randomLeave);

        commonActions.waitForElement(By.xpath(SUBMIT));
        commonActions.click(By.xpath(SUBMIT));

        List<WebElement> successMessages = driver.findElements(By.xpath(LEAVEADDEDSUCCESS));
        if (!successMessages.isEmpty() && successMessages.get(0).isDisplayed()) {
            System.out.println("Leave added successfully.");
        } else {
            // If not successful, click submit again and call leaveAddedTest()
            commonActions.waitForElement(By.xpath(SUBMIT));
            commonActions.click(By.xpath(SUBMIT));

            multipleDayTest();

            System.out.println("Initial leave add failed. Retried via leaveAddedTest().");
        }

        System.out.println("addHalfDayLeave() flow completed.");


        System.out.println("Add Multiple Day flow completed.");
    }

    public void clickFirstDeleteButton() {
        List<WebElement> deleteButtons = driver.findElements(By.xpath(DELETE));

        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
            System.out.println("🗑️ Clicked on the first delete button.");

            commonActions.waitForElement(By.xpath(DELETECONFIRM));
            commonActions.click(By.xpath(DELETECONFIRM));
        } else {
            System.out.println("No delete button found!");
        }
    }

    public void approveLeave(){

        commonActions.scrollToElement(By.xpath(APPROVALBUTTON));
        commonActions.logPrint("Step :: Clicking on the Approval module");
        commonActions.waitForElementToBeClickable(By.xpath(APPROVALBUTTON));
        commonActions.click(By.xpath(APPROVALBUTTON));

        commonActions.logPrint("Step :: Clicking on the Leave Approval menu");
        commonActions.waitForElementToBeClickable(By.xpath(LEAVEAPPROVALMENU));
        commonActions.click(By.xpath(LEAVEAPPROVALMENU));

        commonActions.logPrint("Step :: Clicking on the Approve");
        commonActions.waitForElementToBeClickable(By.xpath(APPROVEBUTTON));
        commonActions.click(By.xpath(APPROVEBUTTON));

        assertLeaveAddedSuccess(LEAVEAPPROVETOASTER);

//        commonActions.waitForElementToBeClickable(By.xpath(REJECTBUTTON));
//        commonActions.click(By.xpath(REJECTBUTTON));

        commonActions.logPrint("Step :: Click on Approved Tab");
        commonActions.waitForElementToBeClickable(By.xpath(APPROVEDOPTION));
        commonActions.click(By.xpath(APPROVEDOPTION));

//        commonActions.logPrint("Step :: Click on Rejected Tab");
//        commonActions.waitForElementToBeClickable(By.xpath(REJECTEDOPTION));
//        commonActions.click(By.xpath(REJECTEDOPTION));

        commonActions.logPrint("Step :: Click on Filter");
        commonActions.waitForElementToBeClickable(By.xpath(FILTER));
        commonActions.click(By.xpath(FILTER));

        commonActions.logPrint("Step :: Click on Search");
        commonActions.waitForElementToBeClickable(By.xpath(SEARCHBAR));
        commonActions.click(By.xpath(SEARCHBAR));

        commonActions.logPrint("Step :: Typing in the Search bar");
        commonActions.type(By.xpath(SEARCHBAR), mrName);

        commonActions.logPrint("Step :: Selecting the searched MR");
        commonActions.waitForElementToBeClickable(By.xpath(SELECTSEARCH));
        commonActions.click(By.xpath(SELECTSEARCH));

        LoginPage loginPage  = new LoginPage();
        loginPage.clickIfPresent(By.xpath(CLOSEBUTTON), 4, "Clicking the close button if required");

//        commonActions.logPrint("Step :: Clicking the Close button");
//        commonActions.waitForElementToBeClickable(By.xpath(CLOSEBUTTON));
//        commonActions.click(By.xpath(CLOSEBUTTON));

    }

    public void rejectLeave(){

        commonActions.scrollToElement(By.xpath(APPROVALBUTTON));
        commonActions.logPrint("Step :: Clicking on the Approval module");
        commonActions.waitForElementToBeClickable(By.xpath(APPROVALBUTTON));
        commonActions.click(By.xpath(APPROVALBUTTON));

        commonActions.logPrint("Step :: Clicking on the Leave Approval menu");
        commonActions.waitForElementToBeClickable(By.xpath(LEAVEAPPROVALMENU));
        commonActions.click(By.xpath(LEAVEAPPROVALMENU));

//        commonActions.logPrint("Step :: Clicking on the Approve");
//        commonActions.waitForElementToBeClickable(By.xpath(APPROVEBUTTON));
//        commonActions.click(By.xpath(APPROVEBUTTON));

        commonActions.waitForElementToBeClickable(By.xpath(REJECTBUTTON));
        commonActions.click(By.xpath(REJECTBUTTON));

        commonActions.waitForElementToBeVisible(By.xpath(REJECTREASON));
        commonActions.type(By.xpath(REJECTREASON), "Testing");

        commonActions.logPrint("Step :: Clicking on the Cancel Button");
        commonActions.waitForElementToBeVisible(By.xpath(REJECTCANCEL));
        commonActions.click(By.xpath(REJECTCANCEL));

        commonActions.waitForElementToBeClickable(By.xpath(REJECTBUTTON));
        commonActions.click(By.xpath(REJECTBUTTON));

        commonActions.waitForElementToBeVisible(By.xpath(REJECTREASON));
        commonActions.type(By.xpath(REJECTREASON), "Testing");


        commonActions.logPrint("Step :: Clicking on Confirm Button");
        commonActions.waitForElementToBeClickable(By.xpath(REJECTSUBMIT));
        commonActions.click(By.xpath(REJECTSUBMIT));

        assertLeaveAddedSuccess(LEAVEREJECTTOASTER);

        commonActions.logPrint("Step :: Click on Rejected Tab");
        commonActions.waitForElementToBeClickable(By.xpath(REJECTEDOPTION));
        commonActions.click(By.xpath(REJECTEDOPTION));

        commonActions.logPrint("Step :: Click on Filter");
        commonActions.waitForElementToBeClickable(By.xpath(FILTER));
        commonActions.click(By.xpath(FILTER));

        commonActions.logPrint("Step :: Click on Search");
        commonActions.waitForElementToBeClickable(By.xpath(SEARCHBAR));
        commonActions.click(By.xpath(SEARCHBAR));

        commonActions.logPrint("Step :: Typing in the Search bar");
        commonActions.type(By.xpath(SEARCHBAR), mrName);

        commonActions.logPrint("Step :: Selecting the searched MR");
        commonActions.waitForElementToBeClickable(By.xpath(SELECTSEARCH));
        commonActions.click(By.xpath(SELECTSEARCH));

        commonActions.logPrint("Step :: Clicking the Close button");
        commonActions.waitForElementToBeClickable(By.xpath(CLOSEBUTTON));
        commonActions.click(By.xpath(CLOSEBUTTON));

    }
}
