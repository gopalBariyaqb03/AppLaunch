package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverManager;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;


public class LoginPage extends BasePage {

    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String ASMEmail = ConfigReader.getAsmEmail();
    String ASMPassword = ConfigReader.getAsmPassword();
    String companyCode = ConfigReader.getCompanyCode();

    //Common xpath
    public String HOMEPAGE = "//android.view.ViewGroup[@content-desc=\"Home\"]";
    public String SYNCSTART = "//android.widget.TextView[@text=\"Sync started...\"]";
    public String SYNC100 = "//android.widget.TextView[@text=\"Syncing Data - 100.00%\"]";
    public String HOMEPAGEBTN = "//android.view.ViewGroup[@content-desc=\"Home\"]";


    //Location setup xpath
    public String WHILEUSINGTHEAPP = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]";
    public String ALLOWBTN = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]";
    public String ALLOWALLBTN = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_all_button\"]";
    public String WHILEUSINGAPP = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]";
    public String ALLOWALLTHETIMERADIO = "//android.widget.RadioButton[@resource-id=\"com.android.permissioncontroller:id/allow_always_radio_button\"]";
    public String BACKBTNLOCATION = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    public String SUBMITBTNDTP = "//android.widget.TextView[@text=\"Submit\"]";
    public String REVIEWBTN = "//android.view.ViewGroup[@content-desc=\"Review\"]";
    public String MASTERSYNCBTN = "//android.view.ViewGroup[@content-desc=\"Master Sync\"]";

    //Login Page
    public String COMPANYCODEINP = "//android.widget.EditText[@text=\"Company Code\"]";
    public String SUBMITBTN = "//android.widget.TextView[@text=\"Submit\"]";
    public String NEXTBTN = "//android.widget.TextView[@text=\"Next\"]";
    public String GETSTARTEDBTN = "//android.widget.TextView[@text=\"Get Started\"]";
    public String EMAILINP = "//android.widget.EditText[@text=\"E-mail\"]";
    public String PASSWORDINP = "//android.widget.EditText[@text=\"Password\"]";
    public String SIGNUPBTN = "//android.widget.TextView[@text=\"Sign In\"]";

    //Logout xpaths
    public String PROFILEBTN = "//android.view.ViewGroup[@content-desc=\"Profile\"]";
    public String LOGOUTBTN = "//android.view.ViewGroup[@content-desc=\"Logout\"]";
    public String CLEARDATA = "//android.view.ViewGroup[@content-desc=\"Clear Data\"]";

    //Daily tour plan locators
    public String DAILYTOURPLANBTN = "//android.view.ViewGroup[@content-desc=\"Daily Tour Plan\"]";
    public String PLEASECREATEADAILYTOURPLAN = "//android.widget.TextView[@text=\"Please create a daily tour plan\"]";
    public String PLUSHICON = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String ROUTDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String FIRSTROUT = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String CLOSEBTN = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    public String SUBROUTEDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]";
    public String FIRSTSUBROUT = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
    public String CLOSEBTNSUBROUT = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    public String NEXTBTNDTP = "//android.view.ViewGroup[@content-desc=\"Next\"]";
    public String SELECTFIRSTDCTR = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String SELECTSECONDDCTR = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String SELECTTHIRDDCTR = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]";
    public String SLECTFIRSTCHEMIST = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String SELECTSECONDCHEMIST = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String SLECTFIRSTSTOCKIEST = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String SLECTSECONDSTOCKIEST = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String SELECTFIRSTHOS = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String SELECTSECONDHOS = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String FIRSTRAWDTP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
    public String PENDINGSTATUS = "//android.widget.TextView[@text=\"Pending\"]";
    public String SEARCHFIELD = "//android.widget.EditText[@text=\"Search here ....\"]";
    public String NODATEFOUND = "//android.widget.TextView[@text=\"No Data Found!\"]";
    public String NODOCTORISSELECTED = "//android.widget.TextView[@text='0 Doctor(s) Selected']";
//    public String = "";
//    public String = "";
//    public String = "";
//    public String = "";
//    public String = "";

    //Master xpaths
    public String MASTERBTN = "//android.view.ViewGroup[@content-desc=\"Master\"]";
    public String PLUSHUBTNMSTR= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]";
    public String DOCTORNAMEINP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText";
    public String CATEGORYDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView";
    public String CATEGORYFIRSTOPTION = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String SPECIALITYDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView";
    public String SPECIALITYFIRSTOPT = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String QUALIFICATIONDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView";
    public String QAULIFICATIONFIRSTOPT = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String CLOSEBTNMST = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    public String MOBILENOINP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText";

    //Chemist page xpath
    public String CHEMISTPAGE = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView";
    public String CHEMISTNAMEINP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText";
    public String CHEMISTCATDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView";
    public String CHEMISTCATFIRSTOP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String CHEMISTTYPEDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView";
    public String CHEMISTTYPEFIRST = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String CHEMISTMOBILEINP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.EditText";

    //Stockiest page
    public String STOCKIESTPAGE = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/com.horcrux.svg.SvgView";
    public String STOCKIESTNAMEINP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText";
    public String STOCKIESTYPEDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView";
    public String STOCKIESTFIRSTOP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String STOCKIESTMOBILEINP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText";

    //Search page xpath in master
    public String SEARCHFIELDDAILY = "//android.widget.EditText[@text=\"Search here ....\"]";

    //DCR XPaths
    public String DCRMENU = "//android.view.ViewGroup[@content-desc=\"DCR\"]/android.widget.ImageView";
    public String FIRSTDCTR = "((//android.view.ViewGroup[contains(@content-desc,\"D, Expected Date & Time\")])[1]//android.widget.ImageView)[1]\n";
    public String NEXTBTNDCR = "//android.view.ViewGroup[@content-desc=\"Next\"]";
    public String PLUSHBTNDCR = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String DECRIPTIONINP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText";
    public String VAUPLOADDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]";
    public String VAUPLOADDRPOPTION1 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String CLOSEBTNVAUPLOAD = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    public String SUBMITBTNVA = "//android.view.ViewGroup[@content-desc=\"Submit\"]";
    public String PLEASEPLANYOURDAY = "//android.widget.TextView[@text=\"Please plan your day \"]";
    public String CHEMISTMENUDCR = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView";
    public String STOCKIESTMENU = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[3]";
    public String HOSPITALMENUDCR = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[4]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.TextView/com.horcrux.svg.TSpanView";

    //Approve DCR Xpaths
    public String STATUSOFDAILYTOURPLAN = "//android.widget.TextView[@text=\"Pending\"]";
    public String DATEOFDAILYTOURPLAN = "(//android.widget.TextView[@text])[8]";
//    public String = "";
//    public String = "";
//    public String = "";
//    public String = "";

    //Complete Doctor Visit Xpaths
    public String FIRSTDOCTOR = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String GETFIRSTDOCTORNAME = "//android.widget.TextView[@text]";

    //Approve DTP
    public String APPROVEMENU = "//android.view.ViewGroup[@content-desc=\"Approvals\"]";
    public String DAILYTOURPLANMENU = "//android.view.ViewGroup[@content-desc=\"Daily Tour Plan\"]";
    public String APPROVEBTN = "//android.view.ViewGroup[@content-desc=\"A, Aagneya Asm, 05 September 2025, 2, 2, 2, 2\"]/android.view.ViewGroup/android.view.ViewGroup[2]";

    //Email
    public String EMAILMENU = "//android.view.ViewGroup[@content-desc=\"Email\"]";
    public String PLUSHICONEMAIL = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String TOEMAIL = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView";
    public String FIRSTEMAIL = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String CLOSEICONTOFIELD = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
    public String SUBJECTINP = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText";
    public String MESSAGEINP = "//android.widget.EditText[@resource-id=\"content\"]";
    public String SENDBUTTON = "//android.view.ViewGroup[@content-desc=\"Send\"]";
    public String SEARCHFIELDTOEMAIL = "//android.widget.EditText[@text=\"Search...\"]";
    public String FIRSTEMAILONINBOX = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String GETEMAILMESSAGE = "(//android.view.ViewGroup[@resource-id=\"div\"])[2]";
    public String ADDTOCRAFTBTN = "//android.view.ViewGroup[@content-desc=\"Add to draft\"]";
    public String DRAFTSECTION = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView";
    public String FIRSTEMAILONDRAFT = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
    public String MESSAGEGETTEXT = "//android.webkit.WebView";
    public String SENTITEMSECTION = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView";
    public String FIRSTEMAILSENT = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String GETMAILVALUE = "(//android.view.ViewGroup[@resource-id=\"div\"])[2]";

    //Utility - Doctor NA
    public String UTILITYMENU = "//android.widget.TextView[@text=\"Utility\"]";
    public String DOCTORNAMENU = "//android.view.ViewGroup[@content-desc=\"Doctor N/A\"]/android.widget.ImageView";
    public String PLUSHICONDrNA = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String DOCTORDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView";
    public String STARTDATE = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView";
    public String ENDDATE = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView";
    public String OKBUTTON = "//android.widget.Button[@resource-id=\"android:id/button1\"]";
    public String DOCTORSEARCH = "//android.widget.EditText[@text=\"Search...\"]";
    public String FIRSTDRDrNA = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String SUBMITBTNDrNA = "//android.view.ViewGroup[@content-desc=\"Submit\"]";

    //Approval page
    public String APPROVALMENU = "//android.view.ViewGroup[@content-desc=\"Approvals\"]/android.widget.ImageView";
    public String DOCTORAVAILABILITYMENU = "//android.view.ViewGroup[@content-desc=\"Doctor Availability\"]";

    //Mapping xpaths
    public String MAPPINGMENU = "//android.view.ViewGroup[@content-desc=\"Mapping\"]/android.widget.ImageView";
    public String PLUSHICONMAPPING = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String DOCTORDRPDOWN = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView";
    public String CHEMISTDROPDOWN = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String CLOSEICONMAP = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String SUBMITBTNMAPPING = "//android.view.ViewGroup[@content-desc=\"Submit\"]";


    public void locationSetup(){

        commonActions.logPrint("step:: Click on the next button");

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

    public boolean isElementPresent2(By locator, int waitTimeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTimeInSeconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void loginToApp(String email, String password) {

        commonActions.logPrint("step:: Starting login flow...");

        // 1️⃣ Check if already logged in
        if (isElementPresent2(By.xpath(MASTERSYNCBTN), 3)) {
            commonActions.logPrint("step:: Already logged in, skipping login flow");
            return;
        }

        // 2️⃣ Check if app starts directly with NEXT button (logout case)
        if (isElementPresent2(By.xpath(NEXTBTN), 3)) {
            commonActions.logPrint("step:: App started with Next button, skipping permissions");
        }
        // 3️⃣ Otherwise, handle permission dialogs (fresh install case)
        else if (isElementPresent2(By.xpath(WHILEUSINGTHEAPP), 3)) {
            clickIfPresent(By.xpath(WHILEUSINGTHEAPP), 4, "Click on 'While using the app' button");
            clickIfPresent(By.xpath(ALLOWBTN), 2, "Click on 'Allow' button");
            clickIfPresent(By.xpath(ALLOWALLBTN), 2, "Click on 'Allow All' button");
            clickIfPresent(By.xpath(WHILEUSINGAPP), 2, "Click on 'While using app' button");
            clickIfPresent(By.xpath(ALLOWALLTHETIMERADIO), 2, "Select 'Allow all the time' radio option");
            clickIfPresent(By.xpath(BACKBTNLOCATION), 2, "Click on back button from Location settings");
        }

        // 4️⃣ Handle Next → Get Started screens
        clickIfPresent(By.xpath(NEXTBTN), 5, "Click on the next button");
        clickIfPresent(By.xpath(NEXTBTN), 5, "Click on the next button");
        clickIfPresent(By.xpath(NEXTBTN), 5, "Click on the next button");
        clickIfPresent(By.xpath(GETSTARTEDBTN), 5, "Click on the Get Started button");

        // 5️⃣ Handle Login form (only if visible)
        if (isElementPresent2(By.xpath(COMPANYCODEINP), 5)) {
            commonActions.logPrint("step:: Enter the company code");
            commonActions.type(By.xpath(COMPANYCODEINP), companyCode);

            commonActions.logPrint("step:: Click on the Submit button");
            commonActions.waitForElement(By.xpath(SUBMITBTN));
            commonActions.click(By.xpath(SUBMITBTN));
        }

        if (isElementPresent2(By.xpath(EMAILINP), 5)) {
            commonActions.logPrint("step:: Enter the email");
            commonActions.type(By.xpath(EMAILINP), email);

            commonActions.logPrint("step:: Enter the password");
            commonActions.type(By.xpath(PASSWORDINP), password);

            commonActions.logPrint("step:: Click on the Sign In button");
            commonActions.click(By.xpath(SIGNUPBTN));

            // After sign in → wait for Get Started again (sometimes appears)
            clickIfPresent(By.xpath(GETSTARTEDBTN), 60, "Click on the Get Started button after Sign In");
        }

        commonActions.logPrint("step:: Login flow completed ✅");
    }

    public void logoutFromTheApp() {
        commonActions.logPrint("Step:: Navigating back until Profile button is visible");

        // Keep going back until Profile button appears
        int maxTries = 5; // To avoid infinite loop
        int attempts = 0;

        while (attempts < maxTries) {
            try {
                if (isElementPresent2(By.xpath(PROFILEBTN), 3)) {
                    commonActions.logPrint("Profile button is visible");
                    break;
                } else {
                    commonActions.logPrint("Profile button not visible, pressing back");
                    commonActions.goBack();
                }
            } catch (Exception e) {
                commonActions.logPrint("Exception while checking Profile button, pressing back");
                commonActions.goBack();
            }
            attempts++;
        }

        commonActions.waitForElementToBeVisible(By.xpath(PROFILEBTN));
        commonActions.click(By.xpath(PROFILEBTN));

        commonActions.logPrint("Step:: Click on the Logout button");
        commonActions.waitForElementToBeVisible(By.xpath(LOGOUTBTN));
        commonActions.click(By.xpath(LOGOUTBTN));
    }


    public void goToHomePage() {
        commonActions.logPrint("Step:: Navigating back until Home button is visible");

        By APPBACKBTN = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView");

        int maxTries = 5; // safety limit
        for (int i = 0; i < maxTries; i++) {
            if (!driver.findElements(APPBACKBTN).isEmpty()) {
                commonActions.logPrint("App back button is visible → tapping it");
                driver.findElement(APPBACKBTN).click();
            } else if (!driver.findElements(By.xpath(HOMEPAGE)).isEmpty()) {
                commonActions.logPrint("✅ Profile button is visible");
                break;
            } else {
                commonActions.logPrint("⚠️ Neither back button nor profile found. Trying native back.");
                driver.navigate().back();
            }
        }

        commonActions.waitForElementToBeVisible(By.xpath(HOMEPAGE));
        commonActions.click(By.xpath(HOMEPAGE));

        commonActions.logPrint("Dashboard button is visible");
    }


    public void createOneDailyTourPlan(){

        commonActions.pause(10);

        commonActions.logPrint("step:: Click on the Daily tour plan button");
        commonActions.waitForElementToBeVisible(By.xpath(DAILYTOURPLANBTN));
        commonActions.click(By.xpath(DAILYTOURPLANBTN));

        commonActions.logPrint("step:: Click on the plush button");
        commonActions.waitForElement(By.xpath(PLUSHICON));
        commonActions.click(By.xpath(PLUSHICON));

        commonActions.logPrint("step:: Click on the Rout dropdown");
        commonActions.waitForElement(By.xpath(ROUTDRP));
        commonActions.click(By.xpath(ROUTDRP));

        commonActions.logPrint("step:: Click on the first rout dropdown");
        commonActions.waitForElement(By.xpath(FIRSTROUT));
        commonActions.click(By.xpath(FIRSTROUT));

//        commonActions.logPrint("step:: Click on the close button");
//        commonActions.waitForElement(By.xpath(CLOSEBTN));
//        commonActions.click(By.xpath(CLOSEBTN));

        commonActions.logPrint("step:: Click on the Sub-rout button");
        commonActions.waitForElement(By.xpath(SUBROUTEDRP));
        commonActions.click(By.xpath(SUBROUTEDRP));

        commonActions.logPrint("step:: Select the first sub-rout");
        commonActions.waitForElement(By.xpath(FIRSTSUBROUT));
        commonActions.click(By.xpath(FIRSTSUBROUT));

//        commonActions.logPrint("step:: Click on the close button");
//        commonActions.waitForElement(By.xpath(CLOSEBTNSUBROUT));
//        commonActions.click(By.xpath(CLOSEBTNSUBROUT));

        commonActions.logPrint("step:: Click on the Next button");
        commonActions.waitForElement(By.xpath(NEXTBTNDTP));
        commonActions.click(By.xpath(NEXTBTNDTP));

        commonActions.logPrint("Step:: Select the doctor from the list");
        commonActions.waitForElement(By.xpath(SELECTFIRSTDCTR));
        commonActions.click(By.xpath(SELECTFIRSTDCTR));

        commonActions.logPrint("Step:: Click on the submit button on time confirm time");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        commonActions.logPrint("Step:: Select the second doctor");
        commonActions.waitForElement(By.xpath(SELECTSECONDDCTR));
        commonActions.click(By.xpath(SELECTSECONDDCTR));

        commonActions.logPrint("Step:: Click on the submit button on time confirm time");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        commonActions.logPrint("Click on the Next button");
        commonActions.waitForElement(By.xpath(NEXTBTNDTP));
        commonActions.click(By.xpath(NEXTBTNDTP));

        commonActions.logPrint("Step:: Select the Chemist from the list");
        commonActions.waitForElement(By.xpath(SLECTFIRSTCHEMIST));
        commonActions.click(By.xpath(SLECTFIRSTCHEMIST));

        commonActions.logPrint("Step:: Click on the submit button on time confirm time");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        commonActions.logPrint("Step:: Select the second Chemist from the list");
        commonActions.waitForElement(By.xpath(SELECTSECONDCHEMIST));
        commonActions.click(By.xpath(SELECTSECONDCHEMIST));

        commonActions.logPrint("Step:: Click on the submit button on time confirm time");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        commonActions.logPrint("Click on the Next button");
        commonActions.waitForElement(By.xpath(NEXTBTNDTP));
        commonActions.click(By.xpath(NEXTBTNDTP));

        commonActions.logPrint("Step:: Select the Stockiest from the list");
        commonActions.waitForElement(By.xpath(SLECTFIRSTSTOCKIEST));
        commonActions.click(By.xpath(SLECTFIRSTSTOCKIEST));

        commonActions.logPrint("Step:: Click on the submit button on time confirm time");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        commonActions.logPrint("Step:: Select the second Stockiest from the list");
        commonActions.waitForElement(By.xpath(SLECTSECONDSTOCKIEST));
        commonActions.click(By.xpath(SLECTSECONDSTOCKIEST));

        commonActions.logPrint("Step:: Click on the submit button on time confirm time");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        commonActions.logPrint("Click on the Next button");
        commonActions.waitForElement(By.xpath(NEXTBTNDTP));
        commonActions.click(By.xpath(NEXTBTNDTP));

        commonActions.logPrint("Step:: Select the First hospital from the list");
        commonActions.waitForElement(By.xpath(SELECTFIRSTHOS));
        commonActions.click(By.xpath(SELECTFIRSTHOS));

        commonActions.logPrint("Step:: Click on the submit button on time confirm time");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        commonActions.logPrint("Step:: Select the second Hospital from the list");
        commonActions.waitForElement(By.xpath(SELECTSECONDHOS));
        commonActions.click(By.xpath(SELECTSECONDHOS));

        commonActions.logPrint("Step:: Click on the submit button on time confirm time");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        commonActions.logPrint("Click on the Review button");
        commonActions.waitForElement(By.xpath(REVIEWBTN));
        commonActions.click(By.xpath(REVIEWBTN));

        commonActions.logPrint("Step:: Click on the submit button After adding all the information");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));
    }

    public void verifyEntityIsCreatedAndShowingInTheList(String entityName, String name){

        commonActions.pause(2);

        commonActions.logPrint("Step:: Verify the "+entityName+" is created and showing the list");

        commonActions.logPrint("Step:: Enter the name in searchbar");
        commonActions.waitForElement(By.xpath(SEARCHFIELD));
        commonActions.type(By.xpath(SEARCHFIELD),name);

        String getNameXpath = "//android.widget.TextView[starts-with(@text,'"+name+"')]";
        commonActions.waitForElement(By.xpath(getNameXpath));
        WebElement element = driver.findElement(By.xpath(getNameXpath));

        commonActions.assertTextEquals(element, name);

        commonActions.logPrint("Search value is showing properly");

    }

    public void createDoctor(){

        commonActions.pause(10);

        commonActions.logPrint("Step:: Click on Master button");
        commonActions.waitForElement(By.xpath(MASTERBTN));
        commonActions.click(By.xpath(MASTERBTN));

        commonActions.logPrint("Step:: Click on Plus button in Master");
        commonActions.waitForElement(By.xpath(PLUSHUBTNMSTR));
        commonActions.click(By.xpath(PLUSHUBTNMSTR));

        String drName = commonActions.generateTestData().name;
        commonActions.logPrint("Step:: Enter Doctor name");
        commonActions.waitForElement(By.xpath(DOCTORNAMEINP));
        String doctorName= "Dr. Auto "+drName;
        commonActions.type(By.xpath(DOCTORNAMEINP), doctorName);

        commonActions.logPrint("Step:: Select Category");
        commonActions.waitForElement(By.xpath(CATEGORYDRP));
        commonActions.click(By.xpath(CATEGORYDRP));
        commonActions.waitForElement(By.xpath(CATEGORYFIRSTOPTION));
        commonActions.click(By.xpath(CATEGORYFIRSTOPTION));

        commonActions.logPrint("Step:: Select Speciality");
        commonActions.waitForElement(By.xpath(SPECIALITYDRP));
        commonActions.click(By.xpath(SPECIALITYDRP));
        commonActions.waitForElement(By.xpath(SPECIALITYFIRSTOPT));
        commonActions.click(By.xpath(SPECIALITYFIRSTOPT));

        commonActions.logPrint("Step:: Close Speciality form");
        commonActions.waitForElement(By.xpath(CLOSEBTNMST));
        commonActions.click(By.xpath(CLOSEBTNMST));

        commonActions.logPrint("Step:: Select Qualification");
        commonActions.waitForElement(By.xpath(QUALIFICATIONDRP));
        commonActions.click(By.xpath(QUALIFICATIONDRP));
        commonActions.waitForElement(By.xpath(QAULIFICATIONFIRSTOPT));
        commonActions.click(By.xpath(QAULIFICATIONFIRSTOPT));

        commonActions.logPrint("Step:: Close Qualification form");
        commonActions.waitForElement(By.xpath(CLOSEBTNMST));
        commonActions.click(By.xpath(CLOSEBTNMST));

        commonActions.scrollToElementByText("Mobile No.");
        String mobileNum = commonActions.generateTestData().phoneNumber;
        commonActions.logPrint("Step:: Enter Mobile Number");
        commonActions.waitForElement(By.xpath(MOBILENOINP));
        commonActions.type(By.xpath(MOBILENOINP), mobileNum);

        commonActions.logPrint("Step:: Click on the submit button After adding all the information");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        commonActions.logPrint("Step:: Verify that validation message is comming or not after the doctor is created");
        commonActions.waitForElement(By.xpath("//android.widget.TextView[@text='Doctor added successfully...']"));
        commonActions.isElementDisplayed(By.xpath("//android.widget.TextView[@text='Doctor added successfully...']"));

        verifyEntityIsCreatedAndShowingInTheList("Doctor", doctorName);

    }

    public void createChemist() {

        commonActions.pause(10);

        commonActions.logPrint("Step:: Click on Master button");
        commonActions.waitForElement(By.xpath(MASTERBTN));
        commonActions.click(By.xpath(MASTERBTN));

        commonActions.logPrint("Step:: Click on Chemist page button");
        commonActions.waitForElement(By.xpath(CHEMISTPAGE));
        commonActions.click(By.xpath(CHEMISTPAGE));

        commonActions.logPrint("Step:: Click on Plus button in Master for Chemist");
        commonActions.waitForElement(By.xpath(PLUSHUBTNMSTR));
        commonActions.click(By.xpath(PLUSHUBTNMSTR));

        String chName = commonActions.generateTestData().name;
        String chemistName = "Chemist Auto " + chName;
        commonActions.logPrint("Step:: Enter Chemist name");
        commonActions.waitForElement(By.xpath(CHEMISTNAMEINP));
        commonActions.type(By.xpath(CHEMISTNAMEINP), chemistName);

        commonActions.logPrint("Step:: Select Chemist Category");
        commonActions.waitForElement(By.xpath(CHEMISTCATDRP));
        commonActions.click(By.xpath(CHEMISTCATDRP));
        commonActions.waitForElement(By.xpath(CHEMISTCATFIRSTOP));
        commonActions.click(By.xpath(CHEMISTCATFIRSTOP));

        commonActions.logPrint("Step:: Select Chemist Type");
        commonActions.waitForElement(By.xpath(CHEMISTTYPEDRP));
        commonActions.click(By.xpath(CHEMISTTYPEDRP));
        commonActions.waitForElement(By.xpath(CHEMISTTYPEFIRST));
        commonActions.click(By.xpath(CHEMISTTYPEFIRST));

        commonActions.scrollToElementByText("Mobile");
        String mobileNum = commonActions.generateTestData().phoneNumber;

        commonActions.logPrint("Step:: Enter Chemist Mobile Number");
        commonActions.waitForElement(By.xpath(CHEMISTMOBILEINP));
        commonActions.type(By.xpath(CHEMISTMOBILEINP), mobileNum);

        commonActions.logPrint("Step:: Click on the submit button After adding all the information");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        verifyEntityIsCreatedAndShowingInTheList("Chemist", chemistName);
    }

    public void createStockiest() {

        commonActions.pause(10);

        commonActions.logPrint("Step:: Click on Master button");
        commonActions.waitForElement(By.xpath(MASTERBTN));
        commonActions.click(By.xpath(MASTERBTN));

        commonActions.logPrint("Step:: Click on stockiest");
        commonActions.waitForElement(By.xpath(STOCKIESTPAGE));
        commonActions.click(By.xpath(STOCKIESTPAGE));

        commonActions.logPrint("Step:: Click on Plus button in Master for Chemist");
        commonActions.waitForElement(By.xpath(PLUSHUBTNMSTR));
        commonActions.click(By.xpath(PLUSHUBTNMSTR));

        String stockiestName = commonActions.generateTestData().name;
        String stockiestName1 = "Stockiest Auto " + stockiestName;
        commonActions.logPrint("Step:: Enter stockiest name");
        commonActions.waitForElement(By.xpath(STOCKIESTNAMEINP));
        commonActions.type(By.xpath(STOCKIESTNAMEINP), stockiestName1);

        commonActions.logPrint("Step:: Select stockiest Category");
        commonActions.waitForElement(By.xpath(STOCKIESTYPEDRP));
        commonActions.click(By.xpath(STOCKIESTYPEDRP));
        commonActions.waitForElement(By.xpath(STOCKIESTFIRSTOP));
        commonActions.click(By.xpath(STOCKIESTFIRSTOP));

        commonActions.scrollToElementByText("Mobile");
        String mobileNum = commonActions.generateTestData().phoneNumber;
        commonActions.logPrint("Step:: Enter Chemist Mobile Number");
        commonActions.waitForElement(By.xpath(STOCKIESTMOBILEINP));
        commonActions.type(By.xpath(STOCKIESTMOBILEINP), mobileNum);

        commonActions.logPrint("Step:: Click on the submit button After adding all the information");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        verifyEntityIsCreatedAndShowingInTheList("Stockiest", stockiestName1);
    }

    public void ApproveDTPFromSenior(String userName){

        commonActions.logPrint("Step:: Click on the approve menu");
        commonActions.waitForElement(By.xpath(APPROVEMENU));
        commonActions.click(By.xpath(APPROVEMENU));

        commonActions.logPrint("Step:: Click on the Daily tour plan sub-menu");
        commonActions.waitForElement(By.xpath(DAILYTOURPLANMENU));
        commonActions.click(By.xpath(DAILYTOURPLANMENU));

        String APPROVEBTN = "//android.widget.TextView[@text='"+userName+"']/following-sibling::android.view.ViewGroup[1]";

        commonActions.logPrint("Step:: Click on the approve button");
        commonActions.waitForElement(By.xpath(APPROVEBTN));
        commonActions.click(By.xpath(APPROVEBTN));
    }

    public void completeTheDCR(){

    }

    public String createAnEmail(String ToEmail){

        commonActions.logPrint("Step:: Click on the Email menu");
        commonActions.waitForElement(By.xpath(EMAILMENU));
        commonActions.click(By.xpath(EMAILMENU));

        commonActions.logPrint("Step:: Click on the plush button");
        commonActions.waitForElement(By.xpath(PLUSHICONEMAIL));
        commonActions.click(By.xpath(PLUSHICONEMAIL));

        commonActions.logPrint("Step:: Click on the TO dropdown");
        commonActions.waitForElement(By.xpath(TOEMAIL));
        commonActions.click(By.xpath(TOEMAIL));

        commonActions.logPrint("Step:: Search the email using an name");
        commonActions.waitForElement(By.xpath(SEARCHFIELDTOEMAIL));
        commonActions.type(By.xpath(SEARCHFIELDTOEMAIL),ToEmail);

        commonActions.logPrint("Step:: Select the first email from the dropdown");
        commonActions.waitForElement(By.xpath(FIRSTEMAIL));
        commonActions.click(By.xpath(FIRSTEMAIL));

        commonActions.logPrint("Step:: Click on the close icon");
        commonActions.waitForElement(By.xpath(CLOSEICONTOFIELD));
        commonActions.click(By.xpath(CLOSEICONTOFIELD));

        commonActions.logPrint("Step:: Enter the subject in search field");
        commonActions.waitForElement(By.xpath(SUBJECTINP));
        String emailSubject = commonActions.generateTestData().email;
        commonActions.type(By.xpath(SUBJECTINP), emailSubject);

        String emailMessage = commonActions.generateTestData().email;

        commonActions.logPrint("Step:: Enter the message");
        commonActions.waitForElement(By.xpath(MESSAGEINP));
        commonActions.click(By.xpath(MESSAGEINP));
        String content = emailMessage+"test tes test ts ttsts";
        commonActions.type(By.xpath(MESSAGEINP),content);

        commonActions.pressKey(AndroidKey.BACKSLASH);
        commonActions.pressKey(AndroidKey.A);
        commonActions.pressKey(AndroidKey.DEL);

        String messageContent = commonActions.getText(By.xpath(MESSAGEINP));
        commonActions.logPrint("Entered text is: "+messageContent);

        commonActions.hideKeyboard();

        commonActions.logPrint("Step:: Click on the send button");
        commonActions.waitForElement(By.xpath(SENDBUTTON));
        commonActions.click(By.xpath(SENDBUTTON));

        commonActions.logPrint("Step:: Verify that validation message is comming or not after the email is sent");
        commonActions.waitForElement(By.xpath("//android.widget.TextView[@text='Email added successfully...']"));
        commonActions.isElementDisplayed(By.xpath("//android.widget.TextView[@text='Eamil added successfully...']"));

        return messageContent;

    }

    public void verifyEmailIsReceived(String value){

        commonActions.logPrint("Step:: Click on the Email menu");
        commonActions.waitForElement(By.xpath(EMAILMENU));
        commonActions.click(By.xpath(EMAILMENU));

        commonActions.logPrint("Step:: Select first email");
        commonActions.waitForElement(By.xpath(FIRSTEMAILONINBOX));
        commonActions.click(By.xpath(FIRSTEMAILONINBOX));

        WebElement emailElement = driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id='div'])[2]//android.widget.TextView"));

        String email = emailElement.getText();
        System.out.println("Captured Email: " + email);

        commonActions.assertTwoValuesAreEqual(email, value);
    }

    public String[] createEmailDraft(String ToEmail){

        commonActions.logPrint("Step:: Click on the Email menu");
        commonActions.waitForElement(By.xpath(EMAILMENU));
        commonActions.click(By.xpath(EMAILMENU));

        commonActions.logPrint("Step:: Click on the plush button");
        commonActions.waitForElement(By.xpath(PLUSHICONEMAIL));
        commonActions.click(By.xpath(PLUSHICONEMAIL));

        commonActions.logPrint("Step:: Click on the TO dropdown");
        commonActions.waitForElement(By.xpath(TOEMAIL));
        commonActions.click(By.xpath(TOEMAIL));

        commonActions.logPrint("Step:: Search the email using an name");
        commonActions.waitForElement(By.xpath(SEARCHFIELDTOEMAIL));
        commonActions.type(By.xpath(SEARCHFIELDTOEMAIL),ToEmail);

        commonActions.logPrint("Step:: Select the first email from the dropdown");
        commonActions.waitForElement(By.xpath(FIRSTEMAIL));
        commonActions.click(By.xpath(FIRSTEMAIL));

        commonActions.logPrint("Step:: Click on the close icon");
        commonActions.waitForElement(By.xpath(CLOSEICONTOFIELD));
        commonActions.click(By.xpath(CLOSEICONTOFIELD));

        commonActions.logPrint("Step:: Enter the subject in search field");
        commonActions.waitForElement(By.xpath(SUBJECTINP));
        String emailSubject = commonActions.generateTestData().email;
        String emailSub = "Automation test "+emailSubject;
        commonActions.type(By.xpath(SUBJECTINP), emailSub);

        String emailMessage = commonActions.generateTestData().email;

        commonActions.logPrint("Step:: Enter the message");
        commonActions.waitForElement(By.xpath(MESSAGEINP));
        commonActions.click(By.xpath(MESSAGEINP));
        String messageInp = emailMessage+" test tes test ts ttsts";
        commonActions.type(By.xpath(MESSAGEINP),messageInp);

        commonActions.pressKey(AndroidKey.BACKSLASH);
        commonActions.pressKey(AndroidKey.A);

        commonActions.hideKeyboard();

        commonActions.logPrint("Step:: Click on the Add to Draft button");
        commonActions.waitForElement(By.xpath(ADDTOCRAFTBTN));
        commonActions.click(By.xpath(ADDTOCRAFTBTN));

        commonActions.logPrint("Step:: Verify that validation message is comming or not after the email is sent");
        commonActions.waitForElement(By.xpath("//android.widget.TextView[@text='Email added successfully...']"));
        commonActions.isElementDisplayed(By.xpath("//android.widget.TextView[@text='Eamil added successfully...']"));

        return new String[] {messageInp,emailSub};
    }

    public void verifyEmailIsShowingInTheDraft(String emailMessage){

        commonActions.logPrint("Step:: Click on the Draft section");
        commonActions.waitForElement(By.xpath(DRAFTSECTION));
        commonActions.click(By.xpath(DRAFTSECTION));

        commonActions.logPrint("Step:: Click on the first email on Draft section");
        commonActions.waitForElement(By.xpath(FIRSTEMAILONDRAFT));
        commonActions.click(By.xpath(FIRSTEMAILONDRAFT));

        commonActions.pause(2);

        commonActions.logPrint("Step:: Verify email subject is showing properly");
        String subject = commonActions.getText(By.xpath(SUBJECTINP));

        System.out.println("Captured Email: " + subject);

        commonActions.assertTwoValuesAreEqual(subject, emailMessage);

        commonActions.logPrint("Both text are compared and showing properly");
    }

    public void verifyEmailIsShowingInSent(String value){

        commonActions.logPrint("Step:: Click on the Sent section");
        commonActions.waitForElement(By.xpath(SENTITEMSECTION));
        commonActions.click(By.xpath(SENTITEMSECTION));

        commonActions.logPrint("Step:: Click on the first email on sent section");
        commonActions.waitForElement(By.xpath(FIRSTEMAILSENT));
        commonActions.click(By.xpath(FIRSTEMAILSENT));

//        commonActions.logPrint("Step:: Verify email contact is showing properly");
//        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='"+value+"']"));
//        String emailGetText = element.getAttribute("contentDescription");
//        commonActions.logPrint(emailGetText);
        //commonActions.waitForElement(By.xpath(GETMAILVALUE));
        //String emailGetText = commonActions.getText(By.xpath(GETMAILVALUE));

        WebElement emailElement = driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id='div'])[2]//android.widget.TextView"));
        String email = emailElement.getText();
        System.out.println("Captured Email: " + email);

        commonActions.assertTwoValuesAreEqual(email, value);
    }

    public void clearAndSyncTheData(){

        commonActions.logPrint("Step:: Click on the profile menu");
        commonActions.waitForElement(By.xpath(PROFILEBTN));
        commonActions.click(By.xpath(PROFILEBTN));

        commonActions.logPrint("Step:: Click on the Clear data");
        commonActions.waitForElement(By.xpath(CLEARDATA));
        commonActions.click(By.xpath(CLEARDATA));

        commonActions.logPrint("Step:: Verify that validation message is showing for the clear data");
        commonActions.waitForElement(By.xpath("//android.widget.TextView[@text='Your master data has been cleared']"));
        commonActions.isElementDisplayed(By.xpath("//android.widget.TextView[@text='Your master data has been cleared']"));

        commonActions.logPrint("Step:: Click on the Home page");
        commonActions.waitForElement(By.xpath(HOMEPAGE));
        commonActions.click(By.xpath(HOMEPAGE));

        commonActions.logPrint("Step:: Click on the Master sync");
        commonActions.waitForElement(By.xpath(MASTERSYNCBTN));
        commonActions.click(By.xpath(MASTERSYNCBTN));

        commonActions.logPrint("Step:: Verify sync is started");
        commonActions.waitForElement(By.xpath(SYNCSTART));
        commonActions.isElementDisplayed(By.xpath(SYNCSTART));

        commonActions.logPrint("Step:: Verify sync is completed and percentage showing as 100%");
        isElementPresent2(By.xpath(SYNC100),60);
        commonActions.isElementDisplayed(By.xpath(SYNC100));
    }

    public void createDailyTourPlan() {
        // Step 1: Go to Daily Tour Plan menu
        commonActions.logPrint("Step:: Go to the Daily Tour Plan menu");
        commonActions.waitForElement(By.xpath(DAILYTOURPLANBTN));
        commonActions.click(By.xpath(DAILYTOURPLANBTN));

        // Step 2: Click Plus (+) icon to create a new plan
        commonActions.logPrint("Step:: Click on the Plus (+) icon to create a new plan");
        commonActions.waitForElement(By.xpath(PLUSHICON));
        commonActions.click(By.xpath(PLUSHICON));

        // Step 3: Check if "Please create a daily tour plan" text is displayed
        commonActions.logPrint("Step:: Check if 'Please create a daily tour plan' text is displayed");
        if (commonActions.isElementDisplayed(By.xpath(PLEASECREATEADAILYTOURPLAN))) {
            commonActions.logPrint("'Please create a daily tour plan' message is displayed. Clicking on Plus button again.");
            commonActions.click(By.xpath(PLUSHICON));
        }

        // Step 4: Click Next button
        commonActions.logPrint("Step:: Click on Next button");
        commonActions.waitForElement(By.xpath(NEXTBTN));
        commonActions.click(By.xpath(NEXTBTN));

        // Step 5: Check for Route/Subroute validation
        if (commonActions.isElementDisplayed(By.xpath("//android.widget.TextView[@text='Please select route']"))) {
            commonActions.logPrint("Validation message displayed -> Selecting Route & Sub Route now.");

            // Select Route
            commonActions.logPrint("Step:: Select Route");
            commonActions.waitForElement(By.xpath(ROUTDRP));
            commonActions.click(By.xpath(ROUTDRP));
            commonActions.waitForElement(By.xpath(FIRSTROUT));
            commonActions.click(By.xpath(FIRSTROUT));

            // Select Sub Route
            commonActions.logPrint("Step:: Select Sub Route");
            commonActions.waitForElement(By.xpath(SUBROUTEDRP));
            commonActions.click(By.xpath(SUBROUTEDRP));
            commonActions.waitForElement(By.xpath(FIRSTSUBROUT));
            commonActions.click(By.xpath(FIRSTSUBROUT));

            // Click Next again after selection
            commonActions.logPrint("Step:: Click on Next button after route selection");
            commonActions.waitForElement(By.xpath(NEXTBTN));
            commonActions.click(By.xpath(NEXTBTN));
        }

        // Step 6: If plan exists but no entities are selected
        if (commonActions.isElementDisplayed(By.xpath(NODOCTORISSELECTED))) {
            commonActions.logPrint("Plan exists but no entities selected. Selecting Doctors, Chemists, Stockiest, and Hospitals...");

            // --- Doctor selection ---
            commonActions.waitForElement(By.xpath(SELECTFIRSTDCTR));
            commonActions.click(By.xpath(SELECTFIRSTDCTR));

            commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
            commonActions.click(By.xpath(SUBMITBTNDTP));

            commonActions.waitForElement(By.xpath(SELECTSECONDDCTR));
            commonActions.click(By.xpath(SELECTSECONDDCTR));

            commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
            commonActions.click(By.xpath(SUBMITBTNDTP));

            commonActions.waitForElement(By.xpath(NEXTBTNDTP));
            commonActions.click(By.xpath(NEXTBTNDTP));

            // --- Chemist selection ---
            commonActions.waitForElement(By.xpath(SLECTFIRSTCHEMIST));
            commonActions.click(By.xpath(SLECTFIRSTCHEMIST));

            commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
            commonActions.click(By.xpath(SUBMITBTNDTP));

            commonActions.waitForElement(By.xpath(SELECTSECONDCHEMIST));
            commonActions.click(By.xpath(SELECTSECONDCHEMIST));

            commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
            commonActions.click(By.xpath(SUBMITBTNDTP));

            commonActions.waitForElement(By.xpath(NEXTBTNDTP));
            commonActions.click(By.xpath(NEXTBTNDTP));

            // --- Stockiest selection ---
            commonActions.waitForElement(By.xpath(SLECTFIRSTSTOCKIEST));
            commonActions.click(By.xpath(SLECTFIRSTSTOCKIEST));

            commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
            commonActions.click(By.xpath(SUBMITBTNDTP));

            commonActions.waitForElement(By.xpath(SLECTSECONDSTOCKIEST));
            commonActions.click(By.xpath(SLECTSECONDSTOCKIEST));

            commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
            commonActions.click(By.xpath(SUBMITBTNDTP));

            commonActions.waitForElement(By.xpath(NEXTBTNDTP));
            commonActions.click(By.xpath(NEXTBTNDTP));

            // --- Hospital selection ---
            commonActions.waitForElement(By.xpath(SELECTFIRSTHOS));
            commonActions.click(By.xpath(SELECTFIRSTHOS));

            commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
            commonActions.click(By.xpath(SUBMITBTNDTP));

            commonActions.waitForElement(By.xpath(SELECTSECONDHOS));
            commonActions.click(By.xpath(SELECTSECONDHOS));

            commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
            commonActions.click(By.xpath(SUBMITBTNDTP));
        }

        // Step 7: Review and Submit
        commonActions.logPrint("Step:: Click on the Review button");
        commonActions.waitForElement(By.xpath(REVIEWBTN));
        commonActions.click(By.xpath(REVIEWBTN));

        commonActions.logPrint("Step:: Click on the Submit button");
        commonActions.waitForElement(By.xpath(SUBMITBTN));
        commonActions.click(By.xpath(SUBMITBTN));

        // Step 8: Validate success message
        if (commonActions.isElementDisplayed(By.xpath("//android.widget.TextView[@text='Tour Plan added successfully...']"))) {
            commonActions.logPrint("✅ Daily Tour Plan created successfully!");
        } else {
            commonActions.logPrint("❌ Failed to create Daily Tour Plan.");
        }
    }

    public void verifyDailyTourPlanIsCreated() {
        commonActions.logPrint("Step:: Go to the DCR menu");
        commonActions.waitForElement(By.xpath(DCRMENU));
        commonActions.click(By.xpath(DCRMENU));

        commonActions.waitForSec(5, driver);
        commonActions.logPrint("Step:: Check if 'Please plan your day' text is displayed");
        if (commonActions.isElementDisplayed(By.xpath(PLEASEPLANYOURDAY))) {
            commonActions.logPrint("Daily tour plan is NOT created. Proceeding to create a new one...");
            goToHomePage();
            createDailyTourPlan();
        } else {
            commonActions.logPrint("Daily tour plan already exists. No need to create a new one.");
        }
    }

    public String createDoctorNAForSelectedDoctor(){

        commonActions.logPrint("Step:: Click on the Utility menu");
        commonActions.scrollToElement(By.xpath(UTILITYMENU));
        commonActions.click(By.xpath(UTILITYMENU));

        commonActions.logPrint("Step:: Click on the Doctor NA menu");
        commonActions.waitForElement(By.xpath(DOCTORNAMENU));
        commonActions.click(By.xpath(DOCTORNAMENU));

        commonActions.logPrint("Step:: Click on the plush button");
        commonActions.waitForElement(By.xpath(PLUSHICONDrNA));
        commonActions.click(By.xpath(PLUSHICONDrNA));

        commonActions.logPrint("Step:: Click on the Doctor dropdown");
        commonActions.waitForElement(By.xpath(DOCTORDRP));
        commonActions.click(By.xpath(DOCTORDRP));

        int number = commonActions.generateRandomNumber(1,7);
        String doctorXpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup["+number+"]";
        commonActions.logPrint("Created number is: "+ number);

        commonActions.logPrint("Step:: Select the first doctor from the list");
        commonActions.waitForElement(By.xpath(doctorXpath));
        commonActions.click(By.xpath(doctorXpath));

        commonActions.logPrint("Step:: Get doctor name from the dropdown");
        commonActions.waitForElement(By.xpath(DOCTORDRP));
        String getDoctorName = commonActions.getText(By.xpath(DOCTORDRP));
        commonActions.logPrint("Step:: Selected doctor name is: "+ getDoctorName);

        commonActions.logPrint("Step:: Click on the start date");
        commonActions.waitForElement(By.xpath(STARTDATE));
        commonActions.click(By.xpath(STARTDATE));

        commonActions.logPrint("Step:: Click on the ok button");
        commonActions.waitForElement(By.xpath(OKBUTTON));
        commonActions.click(By.xpath(OKBUTTON));

        commonActions.logPrint("Step:: Click on the End date");
        commonActions.waitForElement(By.xpath(ENDDATE));
        commonActions.click(By.xpath(ENDDATE));

        commonActions.logPrint("Step:: Click on the ok button");
        commonActions.waitForElement(By.xpath(OKBUTTON));
        commonActions.click(By.xpath(OKBUTTON));

        commonActions.logPrint("Step:: Click on the submit button");
        commonActions.waitForElement(By.xpath(SUBMITBTNDrNA));
        commonActions.click(By.xpath(SUBMITBTNDrNA));

        commonActions.logPrint("Step:: Verify that validation message is comming or not after the doctor is created");
        commonActions.waitForElement(By.xpath("//android.widget.TextView[@text='Doctor N/A added successfully...']"));
        commonActions.isElementDisplayed(By.xpath("//android.widget.TextView[@text='Doctor N/A added successfully...']"));

        return getDoctorName;
    }

    public void ApproveDoctorNARequest(String doctorName){

        String xpathForDrApproveButton = "(//android.widget.TextView[@text='"+ doctorName +"']/following-sibling::android.view.ViewGroup/android.widget.ImageView)[1]";
        commonActions.logPrint("Step:: Click on the approval menu");
        commonActions.waitForElement(By.xpath(APPROVALMENU));
        commonActions.click(By.xpath(APPROVALMENU));

        commonActions.logPrint("Step:: Click on the Doctor NA menu");
        commonActions.waitForElement(By.xpath(DOCTORAVAILABILITYMENU));
        commonActions.click(By.xpath(DOCTORAVAILABILITYMENU));

        commonActions.logPrint("Step:: Click on the Approve button on doctor name");
        commonActions.waitForElement(By.xpath(xpathForDrApproveButton));
        commonActions.click(By.xpath(xpathForDrApproveButton));

        commonActions.logPrint("Step:: Verify that validation message is comming or not after the doctor is created");
        commonActions.waitForElement(By.xpath("//android.widget.TextView[@text='Doctor availability approved successfully.']"));
        commonActions.isElementDisplayed(By.xpath("//android.widget.TextView[@text='Doctor availability approved successfully.']"));
    }

    public void verifyDrIsNotShowingInTheDailyTourPlan(String drName){

        commonActions.logPrint("Step:: Click on the Daily tour plan");
        commonActions.waitForElement(By.xpath(DAILYTOURPLANMENU));
        commonActions.click(By.xpath(DAILYTOURPLANMENU));

        commonActions.logPrint("step:: Click on the plush button");
        commonActions.waitForElement(By.xpath(PLUSHICON));
        commonActions.click(By.xpath(PLUSHICON));

        commonActions.logPrint("step:: Click on the Rout dropdown");
        commonActions.waitForElement(By.xpath(ROUTDRP));
        commonActions.click(By.xpath(ROUTDRP));

        commonActions.logPrint("step:: Click on the first rout dropdown");
        commonActions.waitForElement(By.xpath(FIRSTROUT));
        commonActions.click(By.xpath(FIRSTROUT));

        commonActions.logPrint("step:: Click on the Sub-rout button");
        commonActions.waitForElement(By.xpath(SUBROUTEDRP));
        commonActions.click(By.xpath(SUBROUTEDRP));

        commonActions.logPrint("step:: Select the first sub-rout");
        commonActions.waitForElement(By.xpath(FIRSTSUBROUT));
        commonActions.click(By.xpath(FIRSTSUBROUT));

        commonActions.logPrint("step:: Click on the Next button");
        commonActions.waitForElement(By.xpath(NEXTBTNDTP));
        commonActions.click(By.xpath(NEXTBTNDTP));

        commonActions.logPrint("step:: Search the doctor name");
        commonActions.waitForElement(By.xpath(SEARCHFIELDDAILY));
        commonActions.type(By.xpath(SEARCHFIELDDAILY), drName);

        commonActions.logPrint("step:: Verify no data found is displayed");
        commonActions.waitForElement(By.xpath(NODATEFOUND));
        commonActions.isElementDisplayed(By.xpath(NODATEFOUND));

        commonActions.logPrint("Scenario is completed and doctor is not displayed on the particular date");
    }

    public String[] createDoctorChemistMap(){

        commonActions.logPrint("step:: Click on the Utility button");
        commonActions.scrollToElement(By.xpath(UTILITYMENU));

        commonActions.logPrint("step:: Click on the Mapping menu");
        commonActions.waitForElement(By.xpath(MAPPINGMENU));
        commonActions.click(By.xpath(MAPPINGMENU));

        commonActions.logPrint("step:: Click on the plush icon");
        commonActions.waitForElement(By.xpath(PLUSHICONMAPPING));
        commonActions.click(By.xpath(PLUSHICONMAPPING));

        commonActions.logPrint("step:: Click on the Doctor dropdown");
        commonActions.waitForElement(By.xpath(DOCTORDRPDOWN));
        commonActions.click(By.xpath(DOCTORDRPDOWN));

        int numberDoctor = commonActions.generateRandomNumber(1,4);
        String xpathDoctor = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup["+numberDoctor+"]";

        commonActions.logPrint("step:: Select the Doctor from the list");
        commonActions.scrollToElement(By.xpath(xpathDoctor));
        //commonActions.click(By.xpath(xpathDoctor));

        String getDocName = commonActions.getText(By.xpath(DOCTORDRPDOWN));
        commonActions.logPrint("Selected doctor is: "+ getDocName);

        int numberChemist = commonActions.generateRandomNumber(1,4);
        String xpathChemmist = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup["+numberChemist+"]";

        commonActions.logPrint("step:: Click on the Chemist dropdown");
        commonActions.waitForElement(By.xpath(CHEMISTDROPDOWN));
        commonActions.click(By.xpath(CHEMISTDROPDOWN));

        commonActions.logPrint("step:: Select Chemist from the dropdown");
        commonActions.scrollToElement(By.xpath(xpathChemmist));
        //commonActions.click(By.xpath(xpathChemmist));

        commonActions.logPrint("step:: Click on the close button");
        commonActions.scrollToElement(By.xpath(CLOSEICONMAP));
        commonActions.click(By.xpath(CLOSEICONMAP));

        WebElement getChemistName = driver.findElement(By.xpath("(//android.widget.TextView[@text])[5]"));
        String getChemName = getChemistName.getText();
        //String getChemName = commonActions.getText(By.xpath("//android.view.ViewGroup[@content-desc]"));
        commonActions.logPrint("Selected Chemist is: "+ getChemName);

        commonActions.logPrint("step:: Click on the submit button");
        commonActions.scrollToElement(By.xpath(SUBMITBTNMAPPING));
        //commonActions.click(By.xpath(SUBMITBTNMAPPING));

        commonActions.logPrint("Step:: Verify that validation message is comming or not after the doctor is created");
        commonActions.waitForElement(By.xpath("//android.widget.TextView[@text='Doctor chemist mapping added successfully.']"));
        commonActions.isElementDisplayed(By.xpath("//android.widget.TextView[@text='Doctor chemist mapping added successfully.']"));

        return new String[] {getDocName, getChemName};
    }

    public void approveDTPIfItsPending() {

        commonActions.logPrint("Step:: Go to the Daily tour plan");
        commonActions.waitForElement(By.xpath(DAILYTOURPLANBTN));
        commonActions.click(By.xpath(DAILYTOURPLANBTN));

        commonActions.logPrint("Step:: Get status from the daily tour plan");
        commonActions.waitForElement(By.xpath(STATUSOFDAILYTOURPLAN));
        String status = commonActions.getText(By.xpath(STATUSOFDAILYTOURPLAN));

        commonActions.logPrint("Step:: Get Date from the Daily tour plan");
        commonActions.waitForElement(By.xpath(DATEOFDAILYTOURPLAN));
        String planDate = commonActions.getText(By.xpath(DATEOFDAILYTOURPLAN));

        // Format today's date
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String today = sdf.format(new Date());

        commonActions.logPrint("Today's date is: " + today);
        commonActions.logPrint("Plan Date is: " + planDate);
        commonActions.logPrint("Plan Status is: " + status);

        // Check condition
        if (planDate.equals(today) && status.equalsIgnoreCase("Pending")) {
            commonActions.logPrint("Condition matched -> Calling approveDailyTourPlan()");
            approveDailyTourPlan();
        } else {
            commonActions.logPrint("Condition NOT matched -> No action taken");
        }
    }

    public void approveDailyTourPlan(){

        commonActions.logPrint("Step:: Click on the approve menu");
        commonActions.waitForElement(By.xpath(APPROVEMENU));
        commonActions.click(By.xpath(APPROVEMENU));


    }

    public void verifyDoctorIsMapWithChemist(){

    }

    public void completedTheDoctorVisit(){

        commonActions.logPrint("step:: Click on the DCR menu");
        commonActions.waitForElement(By.xpath(DCRMENU));
        commonActions.click(By.xpath(DCRMENU));

        commonActions.logPrint("Step:: Get the Doctor name");
        commonActions.waitForElement(By.xpath(GETFIRSTDOCTORNAME));
        String getFirstDoctorName = commonActions.getText(By.xpath(GETFIRSTDOCTORNAME));
        commonActions.logPrint("Selected doctor name is: "+ getFirstDoctorName);

        commonActions.logPrint("step:: Click on the First doctor menu");
        commonActions.waitForElement(By.xpath(FIRSTDOCTOR));
        commonActions.click(By.xpath(FIRSTDOCTOR));
    }

    public void longPressElement(AndroidDriver driver, WebElement element) {
        // Create touch input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Get element center coordinates
        int centerX = element.getRect().getX() + element.getRect().getWidth() / 2;
        int centerY = element.getRect().getY() + element.getRect().getHeight() / 2;

        // Build the long press action
        Sequence longPress = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofSeconds(2)))  // Hold for 2 seconds
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(longPress));
    }

    //Xpaths for the CRM login
    public String ALLOWALLBTNCRM = "com.android.permissioncontroller:id/permission_allow_all_button";
    public String email = "//android.widget.EditText[@text=\"Enter username\"]";
    public String password = "//android.widget.EditText[@text=\"••••••••••\"]";
    public String logIn = "//android.view.ViewGroup[@content-desc=\"Log In\"]/android.view.View";
    public String okButton = "//android.widget.Button[@resource-id=\"android:id/button1\"]";
    public String plushIcon = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]";
    public String customerService = "//android.view.ViewGroup[@content-desc=\"Customer Service Hub, System, Modified: 1 weeks ago\"]";
    public String mainMenu = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String Account = "//android.view.ViewGroup[@content-desc=\"Account\"]";
   // public String firstDataID = "accountscreen-accountfield_name-adventure_works_cycles";
    public String backButton = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String moreAction = "//android.widget.Button[@content-desc=\"More action\"]/com.horcrux.svg.SvgView";
//    public String email = "";
//    public String email = "";
//    public String email = "";
//    public String email = "";

    public void loginToCRM(){

        commonActions.logPrint("step:: Enter the email");
        commonActions.waitForElement(By.xpath(email));
        commonActions.type(By.xpath(email),"admin@gmail.com");

        commonActions.logPrint("step:: Enter the email");
        commonActions.waitForElement(By.xpath(password));
        commonActions.type(By.xpath(password),"admin");

        commonActions.logPrint("step:: Click on the login button");
        commonActions.waitForElement(By.xpath(logIn));
        commonActions.click(By.xpath(logIn));

        commonActions.logPrint("step:: Click on the OK button");
        commonActions.waitForElement(By.xpath(okButton));
        commonActions.click(By.xpath(okButton));

        commonActions.logPrint("step:: Click on the CRM button");
        commonActions.waitForElement(By.xpath(customerService));
        commonActions.click(By.xpath(customerService));

        commonActions.logPrint("step:: Click on the main menu");
        commonActions.waitForElement(By.xpath(mainMenu));
        commonActions.click(By.xpath(mainMenu));

        commonActions.logPrint("step:: Click on the Account button");
        commonActions.waitForElement(By.xpath(Account));
        commonActions.click(By.xpath(Account));

//        commonActions.logPrint("step:: Select first record");
//        commonActions.waitForElement(By.id("accountscreen-accountfield_name-adventure_works_cycles"));
//        WebElement firstDataID = driver.findElement(By.id("accountscreen-accountfield_name-adventure_works_cycles"));
//        longPressElement(driver, firstDataID);

        commonActions.logPrint("step:: Click on the delete button");
        commonActions.waitForElement(AppiumBy.accessibilityId("Refresh action"));
        commonActions.click(AppiumBy.accessibilityId("Refresh action"));
        
    }
}