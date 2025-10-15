package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverManager;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;


public class MasterPage extends BasePage {

    //Common xpath
    public String SEARCHFIELDSim = "//android.widget.EditText[@text=\"Search\"]";
    public String doctorAddedSuccessfully = "//android.widget.TextView[@text='Doctor added successfully...']";
    public String doctorUpdateSuccessfully = "//android.widget.TextView[@text='Doctor update successfully...']";
    public String chemistUpdateSuccessfully = "//android.widget.TextView[@text='Chemist update successfully...']";
    public String stockiestUpdateSuccessfully = "//android.widget.TextView[@text='Stockist update successfully...']";
    public String DeleteSuccessful = "//android.widget.TextView[@text='Delete Successful']";
    public String DeleteRequestApprove = "//android.widget.TextView[@text='Delete Request Approved Successfully']";

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
    public String MOBILENOINP = "(//android.widget.TextView[@text=\"Mobile No. *\"]/following-sibling::android.view.ViewGroup/android.widget.EditText)[1]";
    public String SUBMITBTNDTP = "//android.widget.TextView[@text=\"Submit\"]";
    public String PLEASEENTERMOBILENUM = "//android.widget.TextView[@text=\"Please Enter Mobile Number\"]";
    public String SEARCHFIELD = "//android.widget.EditText[@text=\"Search here ....\"]";
    public String MOBILEINPVAL = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]//following-sibling::android.view.ViewGroup//android.widget.TextView[@text=\"Please Enter Mobile Number\"]\n";


    //Chemist page xpath
    public String CHEMISTPAGE = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView";
    public String CHEMISTNAMEINP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText";
    public String CHEMISTCATDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView";
    public String CHEMISTCATFIRSTOP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String CHEMISTTYPEDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView";
    public String CHEMISTTYPEFIRST = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String CHEMISTMOBILEINP = "(//android.widget.TextView[@text='Mobile No *']/following-sibling::android.view.ViewGroup/android.widget.EditText)[1]";

    //Stockiest page
    public String STOCKIESTPAGE = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/com.horcrux.svg.SvgView";
    public String STOCKIESTNAMEINP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText";
    public String STOCKIESTYPEDRP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView";
    public String STOCKIESTFIRSTOP = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String STOCKIESTMOBILEINP = "(//android.widget.TextView[@text='Mobile No *']/following-sibling::android.view.ViewGroup/android.widget.EditText)[1]";

    //Logout xpaths
    public String PROFILEBTN = "//android.view.ViewGroup[@content-desc=\"Profile\"]";
    public String LOGOUTBTN = "//android.view.ViewGroup[@content-desc=\"Logout\"]";
    public String CLEARDATA = "//android.view.ViewGroup[@content-desc=\"Clear Data\"]";

    //Common xpath
    public String HOMEPAGE = "//android.view.ViewGroup[@content-desc=\"Home\"]";
    public String SYNCSTART = "//android.widget.TextView[@text=\"Sync started...\"]";
    public String SYNC100 = "//android.widget.TextView[@text=\"Syncing Data - 100.00%\"]";
    public String HOMEPAGEBTN = "//android.view.ViewGroup[@content-desc=\"Home\"]";

    public String MASTERSYNCBTN = "//android.view.ViewGroup[@content-desc=\"Master Sync\"]";
    public String FIRSTDOCTOR = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
    public String UPDATEBTN = "//android.view.ViewGroup[@content-desc=\"Update\"]";

    //Doctor delete scenario
    public String FIRSTACTIONMENU= "(//android.view.ViewGroup[@clickable='true']/android.widget.ImageView)[5]";
    public String DELETEOPTION = "//android.widget.TextView[@text=\"Delete\"]";
    public String DELETEBTNPOPUP = "//android.view.ViewGroup[@content-desc=\"Delete\"]";

    //Approve DTP
    public String APPROVEMENU = "//android.view.ViewGroup[@content-desc=\"Approvals\"]";
    public String DAILYTOURPLANMENU = "//android.view.ViewGroup[@content-desc=\"Daily Tour Plan\"]";
    public String APPROVEBTN = "//android.view.ViewGroup[@content-desc=\"A, Aagneya Asm, 05 September 2025, 2, 2, 2, 2\"]/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String DOCTORDELETEAPPROVAL = "//android.view.ViewGroup[@content-desc=\"Doctor Delete Approval\"]";
    public String FILTERBUTTONONAPPROVAL = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String SEARCHINPFIL = "//android.widget.EditText[@text=\"Search\"]";
    public String FIRSTRECORDSEARCH = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";
    public String CLOSEBTNFIL = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup";
    public String NODATAFOUND = "//android.widget.TextView[@text=\"No Data Found!\"]";
    public String CHEMISTDELETEAPPROVAL = "//android.view.ViewGroup[@content-desc=\"Chemist Delete Approval\"]/android.widget.ImageView";
    public String STOCKIESTDELETEAPPROVAL = "//android.view.ViewGroup[@content-desc=\"Stockist Delete Approval\"]/android.widget.ImageView";



    public void goToDoctorMasterPage(){

        commonActions.logPrint("Step:: Click on Master button");
        commonActions.waitForElement(By.xpath(MASTERBTN));
        commonActions.click(By.xpath(MASTERBTN));

    }

    public void goToChemistMasterPage(){

        commonActions.logPrint("Step:: Click on Master button");
        commonActions.waitForElement(By.xpath(MASTERBTN));
        commonActions.click(By.xpath(MASTERBTN));

        commonActions.logPrint("Step:: Click on Chemist page button");
        commonActions.waitForElement(By.xpath(CHEMISTPAGE));
        commonActions.click(By.xpath(CHEMISTPAGE));

    }

    public void goToStockiestMasterPage(){

        commonActions.logPrint("Step:: Click on Master button");
        commonActions.waitForElement(By.xpath(MASTERBTN));
        commonActions.click(By.xpath(MASTERBTN));

        commonActions.logPrint("Step:: Click on Stockiest page button");
        commonActions.waitForElement(By.xpath(STOCKIESTPAGE));
        commonActions.click(By.xpath(STOCKIESTPAGE));

    }


    public void verifyEntityIsCreatedAndShowingInTheList(String entityName, String name){

        commonActions.pause(2);

        commonActions.logPrint("Step:: Verify the "+entityName+" is created and showing the list");

        commonActions.logPrint("Step:: Enter the name in searchbar");
        commonActions.waitForElement(By.xpath(SEARCHFIELDSim));
        commonActions.type(By.xpath(SEARCHFIELDSim),name);

        String getNameXpath = "//android.widget.TextView[starts-with(@text,'"+name+"')]";
        commonActions.waitForElement(By.xpath(getNameXpath));
        WebElement element = driver.findElement(By.xpath(getNameXpath));

        commonActions.assertTextEquals(element, name);

        commonActions.logPrint("Search value is showing properly");

    }

    public String createDoctor(){

        commonActions.waitForSec(3, driver);

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

        commonActions.logPrint("Step:: Verify that validation message is showing or not after the doctor is created");
        commonActions.waitForElement(By.xpath(doctorAddedSuccessfully));
        commonActions.isElementDisplayed(By.xpath(doctorAddedSuccessfully));

        verifyEntityIsCreatedAndShowingInTheList("Doctor", doctorName);

        return doctorName;
    }

    public String updateTheDoctor(String DrName){

        commonActions.logPrint("Step:: Click on Master button");
        commonActions.waitForElement(By.xpath(MASTERBTN));
        commonActions.click(By.xpath(MASTERBTN));

        commonActions.logPrint("Step:: Enter the name in searchbar");
        commonActions.waitForElement(By.xpath(SEARCHFIELDSim));
        commonActions.type(By.xpath(SEARCHFIELDSim),DrName);

//        commonActions.logPrint("Step:: Click on the first doctor");
//        commonActions.waitForElement(By.xpath(FIRSTDOCTOR));
//        commonActions.click(By.xpath(FIRSTDOCTOR));

        commonActions.logPrint("Step:: Click on the first doctor");
        commonActions.waitForElement(By.xpath(FIRSTDOCTOR));
        commonActions.click(By.xpath(FIRSTDOCTOR));

        commonActions.logPrint("Step:: Check doctor name is showing properly");
        commonActions.waitForElement(By.xpath(DOCTORNAMEINP));
        String doctorName = commonActions.getText(By.xpath(DOCTORNAMEINP));
        commonActions.assertTwoValuesAreEqual(doctorName.toLowerCase(),DrName.toLowerCase());

        String drName = commonActions.generateTestData().name;
        commonActions.logPrint("Step:: Enter Doctor name");
        commonActions.waitForElement(By.xpath(DOCTORNAMEINP));
        String updatedDrName= "Dr. Update "+drName;
        driver.findElement(By.xpath(DOCTORNAMEINP)).clear();
        commonActions.type(By.xpath(DOCTORNAMEINP), updatedDrName);

        commonActions.hideKeyboard();
        commonActions.waitForSec(1, driver);

        commonActions.logPrint("Step:: Click on the Update button After adding all the information");
        commonActions.waitForElement(By.xpath(UPDATEBTN));
        commonActions.click(By.xpath(UPDATEBTN));

        commonActions.logPrint("Step:: Verify that validation message is showing or not after the doctor is created");
        commonActions.waitForElement(By.xpath(doctorUpdateSuccessfully));
        commonActions.isElementDisplayed(By.xpath(doctorUpdateSuccessfully));

        return updatedDrName;
    }

    public String createChemist() {

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

        return chemistName;
    }

    public String createStockiest() {

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

        commonActions.scrollToElementByText("DL No 1");
        String mobileNum = commonActions.generateTestData().phoneNumber;

        commonActions.logPrint("Step:: Enter Chemist Mobile Number");
        commonActions.waitForElement(By.xpath(STOCKIESTMOBILEINP));
        commonActions.type(By.xpath(STOCKIESTMOBILEINP), mobileNum);

        commonActions.logPrint("Step:: Click on the submit button After adding all the information");
        commonActions.waitForElement(By.xpath(SUBMITBTNDTP));
        commonActions.click(By.xpath(SUBMITBTNDTP));

        verifyEntityIsCreatedAndShowingInTheList("Stockiest", stockiestName1);

        return stockiestName1;
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

    public boolean isElementPresent2(By locator, int waitTimeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(waitTimeInSeconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String updateTheChemist(String chemistName){

        goToChemistMasterPage();

        commonActions.logPrint("Step:: Enter the name in searchbar");
        commonActions.waitForElement(By.xpath(SEARCHFIELDSim));
        commonActions.type(By.xpath(SEARCHFIELDSim),chemistName);

        commonActions.logPrint("Step:: Click on the first Chemist");
        commonActions.waitForElement(By.xpath(FIRSTDOCTOR));
        commonActions.click(By.xpath(FIRSTDOCTOR));

        commonActions.logPrint("Step:: Check chemist name is showing properly");
        commonActions.waitForElement(By.xpath(CHEMISTNAMEINP));
        String doctorName = commonActions.getText(By.xpath(CHEMISTNAMEINP));
        commonActions.assertTwoValuesAreEqual(doctorName.toLowerCase(),chemistName.toLowerCase());

        String chName = commonActions.generateTestData().name;
        String chemistUpdatedName = "Chemist Update " + chName;
        commonActions.logPrint("Step:: Enter Chemist name");
        commonActions.waitForElement(By.xpath(CHEMISTNAMEINP));
        driver.findElement(By.xpath(CHEMISTNAMEINP)).clear();
        commonActions.type(By.xpath(CHEMISTNAMEINP), chemistUpdatedName);

        commonActions.hideKeyboard();
        commonActions.waitForSec(1, driver);

        commonActions.logPrint("Step:: Click on the Update button After adding all the information");
        commonActions.waitForElement(By.xpath(UPDATEBTN));
        commonActions.click(By.xpath(UPDATEBTN));

        commonActions.logPrint("Step:: Verify that validation message is after chemist is updated.");
        commonActions.waitForElement(By.xpath(chemistUpdateSuccessfully));
        commonActions.isElementDisplayed(By.xpath(chemistUpdateSuccessfully));

        return chemistUpdatedName;
    }

    public String updateTheStockiest(String stockiestName){

        goToStockiestMasterPage();

        commonActions.logPrint("Step:: Enter the name in searchbar");
        commonActions.waitForElement(By.xpath(SEARCHFIELDSim));
        commonActions.type(By.xpath(SEARCHFIELDSim),stockiestName);

        commonActions.logPrint("Step:: Click on the first Chemist");
        commonActions.waitForElement(By.xpath(FIRSTDOCTOR));
        commonActions.click(By.xpath(FIRSTDOCTOR));

        commonActions.logPrint("Step:: Check chemist name is showing properly");
        commonActions.waitForElement(By.xpath(STOCKIESTNAMEINP));
        String doctorName = commonActions.getText(By.xpath(STOCKIESTNAMEINP));
        commonActions.assertTwoValuesAreEqual(doctorName.toLowerCase(),stockiestName.toLowerCase());

        String stName = commonActions.generateTestData().name;
        String stockiestUpdatedName = "Stockiest Update " + stName;
        commonActions.logPrint("Step:: Enter Chemist name");
        commonActions.waitForElement(By.xpath(STOCKIESTNAMEINP));
        driver.findElement(By.xpath(STOCKIESTNAMEINP)).clear();
        commonActions.type(By.xpath(STOCKIESTNAMEINP), stockiestUpdatedName);

        commonActions.hideKeyboard();
        commonActions.waitForSec(1, driver);

        commonActions.logPrint("Step:: Click on the Update button After adding all the information");
        commonActions.waitForElement(By.xpath(UPDATEBTN));
        commonActions.click(By.xpath(UPDATEBTN));

        commonActions.logPrint("Step:: Verify that validation message is showing after stockiest is updated");
        commonActions.waitForElement(By.xpath(stockiestUpdateSuccessfully));
        commonActions.isElementDisplayed(By.xpath(stockiestUpdateSuccessfully));

        return stockiestUpdatedName;
    }

    public void deleteDoctor(String name){

        commonActions.logPrint("Step:: Search the name");
        commonActions.waitForElement(By.xpath(SEARCHFIELDSim));
        commonActions.type(By.xpath(SEARCHFIELDSim), name);

        commonActions.waitForSec(2,driver);

        commonActions.logPrint("Step:: Click on the action button");
        commonActions.waitForElement(By.xpath(FIRSTACTIONMENU));
        commonActions.click(By.xpath(FIRSTACTIONMENU));

        commonActions.logPrint("Step:: Click on the Delete button");
        commonActions.waitForElement(By.xpath(DELETEOPTION));
        commonActions.click(By.xpath(DELETEOPTION));

        commonActions.logPrint("Step:: Click on the Delete button on confirmation pop-up");
        commonActions.waitForElement(By.xpath(DELETEBTNPOPUP));
        commonActions.click(By.xpath(DELETEBTNPOPUP));

        commonActions.logPrint("Step:: Verify that validation message is showing after deleted successfully");
        commonActions.waitForElement(By.xpath(DeleteSuccessful));
        commonActions.isElementDisplayed(By.xpath(DeleteSuccessful));

    }

    public void deleteChemist(String name){

        commonActions.logPrint("Step:: Search the name");
        commonActions.waitForElement(By.xpath(SEARCHFIELDSim));
        commonActions.type(By.xpath(SEARCHFIELDSim), name);

        commonActions.waitForSec(2,driver);

        commonActions.logPrint("Step:: Click on the action button");
        commonActions.waitForElement(By.xpath(FIRSTACTIONMENU));
        commonActions.click(By.xpath(FIRSTACTIONMENU));

        commonActions.logPrint("Step:: Click on the Delete button");
        commonActions.waitForElement(By.xpath(DELETEOPTION));
        commonActions.click(By.xpath(DELETEOPTION));

        commonActions.logPrint("Step:: Click on the Delete button on confirmation pop-up");
        commonActions.waitForElement(By.xpath(DELETEBTNPOPUP));
        commonActions.click(By.xpath(DELETEBTNPOPUP));

        commonActions.logPrint("Step:: Verify that validation message is showing after deleted successfully");
        commonActions.waitForElement(By.xpath(DeleteSuccessful));
        commonActions.isElementDisplayed(By.xpath(DeleteSuccessful));

    }

    public void deleteStockiest(String name){

        commonActions.logPrint("Step:: Search the name");
        commonActions.waitForElement(By.xpath(SEARCHFIELDSim));
        commonActions.type(By.xpath(SEARCHFIELDSim), name);

        commonActions.waitForSec(2,driver);

        commonActions.logPrint("Step:: Click on the action button");
        commonActions.waitForElement(By.xpath(FIRSTACTIONMENU));
        commonActions.click(By.xpath(FIRSTACTIONMENU));

        commonActions.logPrint("Step:: Click on the Delete button");
        commonActions.waitForElement(By.xpath(DELETEOPTION));
        commonActions.click(By.xpath(DELETEOPTION));

        commonActions.logPrint("Step:: Click on the Delete button on confirmation pop-up");
        commonActions.waitForElement(By.xpath(DELETEBTNPOPUP));
        commonActions.click(By.xpath(DELETEBTNPOPUP));

        commonActions.logPrint("Step:: Verify that validation message is showing after deleted successfully");
        commonActions.waitForElement(By.xpath(DeleteSuccessful));
        commonActions.isElementDisplayed(By.xpath(DeleteSuccessful));

    }


    public void ApproveDoctorDeleteRequestFromManager(String doctorName, String userName){

        commonActions.logPrint("Step:: Click on the approve menu");
        commonActions.waitForElement(By.xpath(APPROVEMENU));
        commonActions.click(By.xpath(APPROVEMENU));

        commonActions.logPrint("Step:: Click on the Doctor delete approval button");
        commonActions.waitForElement(By.xpath(DOCTORDELETEAPPROVAL));
        commonActions.click(By.xpath(DOCTORDELETEAPPROVAL));

        commonActions.logPrint("Step:: Click on the Filter button");
        commonActions.waitForElement(By.xpath(FILTERBUTTONONAPPROVAL));
        commonActions.click(By.xpath(FILTERBUTTONONAPPROVAL));

        commonActions.logPrint("Step:: Search the user name");
        commonActions.waitForElement(By.xpath(SEARCHINPFIL));
        commonActions.type(By.xpath(SEARCHINPFIL),userName);

        commonActions.logPrint("Step:: Select first user name");
        commonActions.waitForElement(By.xpath(FIRSTRECORDSEARCH));
        commonActions.click(By.xpath(FIRSTRECORDSEARCH));

        commonActions.logPrint("Step:: Click on the close button");
        commonActions.waitForElement(By.xpath(CLOSEBTNFIL));
        commonActions.click(By.xpath(CLOSEBTNFIL));

        //Approve button using an name
        String APPROVEBUTTON = "//android.widget.TextView[@text='"+doctorName+"']/following-sibling::android.view.ViewGroup[1]//android.widget.ImageView";

        commonActions.logPrint("Step:: Click on the Doctor approve button");
        commonActions.waitForElement(By.xpath(APPROVEBUTTON));
        commonActions.click(By.xpath(APPROVEBUTTON));

        commonActions.logPrint("Step:: Verify that validation message is showing or not after the Request is approved from the manager");
        commonActions.waitForElement(By.xpath(DeleteRequestApprove));
        commonActions.isElementDisplayed(By.xpath(DeleteRequestApprove));
    }

    public void ApproveChemistDeleteRequestFromManager(String chemistName, String userName){

        commonActions.logPrint("Step:: Click on the approve menu");
        commonActions.waitForElement(By.xpath(APPROVEMENU));
        commonActions.click(By.xpath(APPROVEMENU));

        commonActions.logPrint("Step:: Click on the Chemist delete approval button");
        commonActions.waitForElement(By.xpath(CHEMISTDELETEAPPROVAL));
        commonActions.click(By.xpath(CHEMISTDELETEAPPROVAL));

        commonActions.logPrint("Step:: Click on the Filter button");
        commonActions.waitForElement(By.xpath(FILTERBUTTONONAPPROVAL));
        commonActions.click(By.xpath(FILTERBUTTONONAPPROVAL));

        commonActions.logPrint("Step:: Search the user name");
        commonActions.waitForElement(By.xpath(SEARCHINPFIL));
        commonActions.type(By.xpath(SEARCHINPFIL),userName);

        commonActions.logPrint("Step:: Select first user name");
        commonActions.waitForElement(By.xpath(FIRSTRECORDSEARCH));
        commonActions.click(By.xpath(FIRSTRECORDSEARCH));

        commonActions.logPrint("Step:: Click on the close button");
        commonActions.waitForElement(By.xpath(CLOSEBTNFIL));
        commonActions.click(By.xpath(CLOSEBTNFIL));

        //Approve button using an name
        String APPROVEBUTTON = "//android.widget.TextView[@text='"+chemistName+"']/following-sibling::android.view.ViewGroup[1]//android.widget.ImageView";

        commonActions.logPrint("Step:: Click on the Doctor approve button");
        commonActions.waitForElement(By.xpath(APPROVEBUTTON));
        commonActions.click(By.xpath(APPROVEBUTTON));

        commonActions.logPrint("Step:: Verify that validation message is showing or not after the Request is approved from the manager");
        commonActions.waitForElement(By.xpath(DeleteRequestApprove));
        commonActions.isElementDisplayed(By.xpath(DeleteRequestApprove));
    }

    public void ApproveStockiestDeleteRequestFromManager(String chemistName, String userName){

        commonActions.logPrint("Step:: Click on the approve menu");
        commonActions.waitForElement(By.xpath(APPROVEMENU));
        commonActions.click(By.xpath(APPROVEMENU));

        commonActions.logPrint("Step:: Click on the Stockiest delete approval button");
        commonActions.waitForElement(By.xpath(STOCKIESTDELETEAPPROVAL));
        commonActions.click(By.xpath(STOCKIESTDELETEAPPROVAL));

        commonActions.logPrint("Step:: Click on the Filter button");
        commonActions.waitForElement(By.xpath(FILTERBUTTONONAPPROVAL));
        commonActions.click(By.xpath(FILTERBUTTONONAPPROVAL));

        commonActions.logPrint("Step:: Search the user name");
        commonActions.waitForElement(By.xpath(SEARCHINPFIL));
        commonActions.type(By.xpath(SEARCHINPFIL),userName);

        commonActions.logPrint("Step:: Select first user name");
        commonActions.waitForElement(By.xpath(FIRSTRECORDSEARCH));
        commonActions.click(By.xpath(FIRSTRECORDSEARCH));

        commonActions.logPrint("Step:: Click on the close button");
        commonActions.waitForElement(By.xpath(CLOSEBTNFIL));
        commonActions.click(By.xpath(CLOSEBTNFIL));

        //Approve button using an name
        String APPROVEBUTTON = "//android.widget.TextView[@text='"+chemistName+"']/following-sibling::android.view.ViewGroup[1]//android.widget.ImageView";

        commonActions.logPrint("Step:: Click on the Doctor approve button");
        commonActions.waitForElement(By.xpath(APPROVEBUTTON));
        commonActions.click(By.xpath(APPROVEBUTTON));

        commonActions.logPrint("Step:: Verify that validation message is showing or not after the Request is approved from the manager");
        commonActions.waitForElement(By.xpath(DeleteRequestApprove));
        commonActions.isElementDisplayed(By.xpath(DeleteRequestApprove));
    }

    public void verifyEntityIsRemovedFromTheList(String doctorName){

        commonActions.logPrint("Step:: Enter the name in searchbar");
        commonActions.waitForElement(By.xpath(SEARCHFIELDSim));
        commonActions.type(By.xpath(SEARCHFIELDSim),doctorName);

        commonActions.logPrint("Verify Entity is not displayed in the list and showing no data found");
        commonActions.waitForElement(By.xpath(NODATAFOUND));
        commonActions.isElementDisplayed(By.xpath(NODATAFOUND));

    }

}