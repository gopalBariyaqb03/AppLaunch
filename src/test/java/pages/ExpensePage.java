package pages;
import base.BaseTest;
import org.openqa.selenium.devtools.v85.io.IO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeavePage;
import pages.LoginPage;
import utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.CommonActions;
import utils.ConfigReader;
import utils.DriverManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.time.Duration;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ExpensePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ExpensePage.class);
    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String companyCode = ConfigReader.getCompanyCode();
    String mrName = ConfigReader.getMrName();
    String asmName = ConfigReader.getAsmName();
    String rsmName = ConfigReader.getRsmName();

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    String today = sdf.format(new Date());

    public String UTILITY = "//android.view.ViewGroup[@content-desc=\"Utility\"]";
    public String EXPENSE = "//android.view.ViewGroup[@content-desc=\"Expense\"]";
    public String ADDBUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String EXPENSEDATE = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String EXPENSETYPE = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String EXPENSETYPEVALUES = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[\" + i + \"]\"";
    public String EXPENSEAMOUNT = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText";
    public String EXPENSENOTE = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText";
    public String EXPENSEIMAGE = "//android.view.ViewGroup[@content-desc=\"Click to upload files, Max file size is 500KB. Supported file types are .pdf, .jpg and .png.\"]";
    public String EXPENSEIMAGEPHOTO = "//android.view.ViewGroup[@content-desc=\"Photo Library\"]";
    public String EXPESNSESUBMIT = "//android.view.ViewGroup[@content-desc=\"Submit\"]";
    public String BACKBUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView";
    public String PROFILEBUTTON = "//android.view.ViewGroup[@content-desc=\"Profile\"]/android.widget.ImageView";
    public String LOGOUTBUTTON = "//android.widget.TextView[@text=\"Logout\"]";
    public String APPROVALS = "//android.view.ViewGroup[@content-desc=\"Approvals\"]/android.widget.ImageView";
    public String SEARCH = "//android.widget.EditText[@text=\"Search\"]";
    public String SELECTSEARCHED = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    //    public String FROMDATEVAL = "//android.view.View[@content-desc=\"" + today + "\"]";
    public String CLOSEBUTTON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    public String EXPENSEAPPROVALS = "//android.view.ViewGroup[@content-desc=\"Expense Approval\"]/android.widget.ImageView";
    public String APPROVEBUTTON = "//android.view.ViewGroup[@content-desc]/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String REJECTBUTTON = "//android.view.ViewGroup[@content-desc]/android.view.ViewGroup/android.view.ViewGroup[3]";
    public String REJECTREASON = "//android.widget.EditText[@text=\"Add reason\"]";
    public String REJECTCANCEL = "//android.view.ViewGroup[@content-desc=\"Cancel\"]";
    public String REJECTCONFIRM = "//android.view.ViewGroup[@content-desc=\"Confirm\"]";
    public String APPROVEDTOAST = "//android.widget.TextView[@text=\"Expense approved successfully\"]";
    public String REJECTTOAST = "//android.widget.TextView[@text=\"Expense rejected successfully\"]";
    public String MAINSEARCH = "//android.widget.EditText[@text=\"Search\"]";
    public String EXPENSERESULT = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String PENDINGSTATUS = "//android.widget.TextView[@text=\"Pending\"]";
    public String REJECTEDSTATUS = "(//android.widget.TextView[@text=\"Rejected\"])";
    public String APPROVEDSTATUS = "(//android.widget.TextView[@text=\"Approved\"])";

    public String EXPENSEHEADER = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.TextView/com.horcrux.svg.TSpanView";
    public String FILTER = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String APPROVEDOPTION = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.TextView/com.horcrux.svg.TSpanView";
    public String REJECTEDOPTION = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/com.horcrux.svg.SvgView";
    public String PENDINGOPTION = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.TextView/com.horcrux.svg.TSpanView";

    LeavePage leavePage = new LeavePage();
    LoginPage loginPage = new LoginPage();

    private static int stepCounter = 1;

    private void click(String xpath, String message) {
        commonActions.waitForElementToBeVisible(By.xpath(xpath));
        commonActions.waitForElementToBeClickable(By.xpath(xpath));
        commonActions.click(By.xpath(xpath));
        commonActions.logPrint("[Step " + stepCounter++ + " -->] " + message);
    }

    private void type(String xpath, String text) {
        commonActions.clearField(xpath, " Field Cleared");
        commonActions.waitForElementToBeVisible(By.xpath(xpath));
        commonActions.type(By.xpath(xpath), text);
        commonActions.logPrint("[Step " + stepCounter++ + " -->] ");

    }

    private void selectDate(String dateText) {

        click(EXPENSEDATE, "Clicking on Expense Date");
        String dateXpath = "//android.view.View[@content-desc='"+dateText+"']";

        loginPage.clickIfPresent(By.xpath(dateXpath), 3, "Click on Datetext if visible");


        String okButtonXpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]";
        if (commonActions.isElementPresent(By.xpath(okButtonXpath),4)) {
            loginPage.clickIfPresent(By.xpath(okButtonXpath), 3, "Click on okButtonXpath if visible");
        }
    }

    private void selectExpenseType() {

        Random random = new Random();
        int i = random.nextInt(5) + 1;

        String randomXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[" + i + "]";

        commonActions.waitForElementToBeVisible(By.xpath(randomXpath));
        commonActions.click(By.xpath(randomXpath));

        System.out.println("Selected Expense Type option at index: " + i);

    }

    public void uploadExpenseImage(String fileName) throws IOException {

        String filePath = System.getProperty("user.dir") + "/test-data/" + fileName;
        commonActions.logPrint("📂 File path: " + filePath);

        File file = new File(filePath);
        byte[] fileContent = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        commonActions.logPrint("✅ File loaded, size: " + fileContent.length + " bytes");

        try {
            driver.pushFile("/sdcard/Download/" + fileName, fileContent);
            commonActions.logPrint("📂 File pushed to /sdcard/Download/");
        } catch (Exception e) {
            commonActions.logPrint("⚠️ Failed to push to /sdcard/Download, trying /data/local/tmp/");
            driver.pushFile("/data/local/tmp/" + fileName, fileContent);
        }
    }

    public void selectUploadedImage(String fileName) {

        commonActions.click(By.xpath(EXPENSEIMAGEPHOTO));

        try {
            commonActions.click(By.xpath("//android.widget.TextView[@text='Downloads']"));
            commonActions.click(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text='" + fileName + "']"));
            return;
        } catch (Exception ex) {
            commonActions.logPrint("⚠️ Could not select from Downloads, check app’s file picker.");
        }
        try {
            commonActions.click(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View"));
            commonActions.click(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View"));

        } catch (Exception exp) {
            commonActions.logPrint("Could not select from gallery ");
        }
    }

    public void addExpense(String date, String amount, String note, String image) throws IOException {

        try{
            WebElement expenseheaders = driver.findElement(By.xpath(EXPENSEHEADER));
            commonActions.waitForElementToBeVisible(By.xpath(EXPENSEHEADER));

            if(expenseheaders.isDisplayed()){

                click(ADDBUTTON, " Step :: Clicking on the Add Button");

                selectDate(date);

                click(EXPENSETYPE,"Step :: Clicking on the Expense Type");
                selectExpenseType();

                type(EXPENSEAMOUNT, amount);
                type(EXPENSENOTE, note);

                click(EXPENSEIMAGE, " Step :: Clicking on the Expense Image upload");
                uploadExpenseImage(image);

                click(EXPESNSESUBMIT, " Step :: Clicking on the Submit Button");
                return;}
        }
        catch(Exception e){
            commonActions.logPrint("Not in the Expense Menu");
        }

        commonActions.scrollToElement(By.xpath(UTILITY));
        click(UTILITY, " Step :: Clicking on the Utility Module");
        click(EXPENSE, " Step :: clicking on the Expense Module");
        click(ADDBUTTON, " Step :: Clicking on the Add Button");

        selectDate(date);

        click(EXPENSETYPE,"Step :: Clicking on the Expense Type");
        selectExpenseType();

        type(EXPENSEAMOUNT, amount);
        type(EXPENSENOTE, note);

        click(EXPENSEIMAGE, " Step :: Clicking on the Expense Image upload");
        uploadExpenseImage(image);
        selectUploadedImage(image);

        click(EXPESNSESUBMIT, " Step :: Clicking on the Submit Button");

    }

    public void approveExpense() throws IOException {

        click(APPROVALS, "Step :: Clicking on Approval Button");
        click(EXPENSEAPPROVALS,"Step :: Clicking on Expense Approval Button");
        click(FILTER, "Step :: Clicking on Employee Filter");
        commonActions.clearField(SEARCH, "Search Filed Cleared");
        click(SEARCH,"Step :: Clicking on the Search Bar");
        type(SEARCH,mrName);
        click(SELECTSEARCHED, " Step :: Selecting the Searched User");
        loginPage.clickIfPresent(By.xpath(CLOSEBUTTON),3, "Clicking the close button");
        click(APPROVEBUTTON, " Step :: Clicking the Approve Button");
        commonActions.assertToaster(APPROVEDTOAST);
        click(APPROVEDOPTION, "Step :: Clicking on the Approved option");
    }

    public void rejectExpense() {
        try{
            WebElement expenseheader = driver.findElement(By.xpath(EXPENSEHEADER));
            commonActions.waitForElementToBeVisible(By.xpath(EXPENSEHEADER));
            if(expenseheader.isDisplayed()){
                click(PENDINGOPTION, " Clicking the Approved option");
                click(FILTER, " Clicking on Employee Filter");
                commonActions.clearField(SEARCH, "Search Filed Cleared");
                click(SEARCH," Clicking on the Search Bar");
                type(SEARCH,mrName);
                click(SELECTSEARCHED, "  Selecting the Searched User");
                loginPage.clickIfPresent(By.xpath(CLOSEBUTTON),3, "Clicking the close button");
                click(REJECTBUTTON, " Clicking on the Reject Button");
                click(REJECTREASON, " Giving the reason for rejecting ");
                type(REJECTREASON, "Too Much");
                click(REJECTCANCEL, "  Clicking on the cancel expense reject button");
                click(REJECTBUTTON, " Clicking on the Reject Button ");
                click(REJECTREASON, " Giving the reason for rejecting ");
                type(REJECTREASON, "Too Much");
                click(REJECTCONFIRM, " Clicking on the Reject Confirm Button");
                commonActions.assertToaster(REJECTTOAST);
                click(REJECTEDOPTION, "  Clicking on the Rejected option");
                return;

            }
        }catch(Exception e){
            commonActions.logPrint("Not in the Expense Approval menu");
        }
        click(APPROVALS, " Clicking on Approval Button");
        click(EXPENSEAPPROVALS," Clicking on Expense Approval Button");
        click(FILTER, " Clicking on Employee Filter");
        commonActions.clearField(SEARCH, "Search Filed Cleared");
        click(SEARCH," Clicking on the Search Bar");
        type(SEARCH,mrName);
        click(SELECTSEARCHED, "  Selecting the Searched User");
        loginPage.clickIfPresent(By.xpath(CLOSEBUTTON),3, "Clicking the close button");
        click(REJECTBUTTON, " Clicking on the Reject Button");
        click(REJECTREASON, " Giving the reason for rejecting ");
        type(REJECTREASON, "Too Much");
        click(REJECTCANCEL, "  Clicking on the cancel expense reject button");
        click(REJECTBUTTON, " Clicking on the Reject Button ");
        click(REJECTREASON, " Giving the reason for rejecting ");
        type(REJECTREASON, "Too Much");
        click(REJECTCONFIRM, " Clicking on the Reject Confirm Button");
        commonActions.assertToaster(REJECTTOAST);
        click(REJECTEDOPTION, "  Clicking on the Rejected option");
    }

    public void veriyFromMR(String givenNote){

        click(UTILITY, " Step :: Clicking on the Utility Module");
        click(EXPENSE, " Step :: clicking on the Expense Module");
        click(MAINSEARCH, ": Searching the Given Note");
        type(MAINSEARCH, givenNote);
        commonActions.logPrint("[Step " + stepCounter++ + " --> Searched]" );

        try{
            WebElement expenseResults = driver.findElement(By.xpath(EXPENSERESULT));
            if(expenseResults.isDisplayed())
            {
                commonActions.logPrint("Checking if Pending Status got changed");
//                WebElement pendingStatus = driver.findElement(By.xpath(PENDINGSTATUS));
                WebElement rejectedStatus = driver.findElement(By.xpath(REJECTEDSTATUS));
                WebElement approvedStatus = driver.findElement(By.xpath(APPROVEDSTATUS));
                if(rejectedStatus.isDisplayed() || approvedStatus.isDisplayed()){
                    commonActions.logPrint("Expense updated Successfully");
                    return;
                }

            }
        }catch (Exception e){
            commonActions.logPrint("Expense Wasn't updated");
        }

    }
}


