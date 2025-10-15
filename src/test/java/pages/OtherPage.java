package pages;

import org.openqa.selenium.WebElement;
import utils.ConfigReader;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OtherPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ExpensePage.class);
    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String companyCode = ConfigReader.getCompanyCode();
    String mrName = ConfigReader.getMrName();
    String asmName = ConfigReader.getAsmName();
    String rsmName = ConfigReader.getRsmName();
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    String today = sdf.format(new Date());

    public String OTHERMENU = "//android.view.ViewGroup[@content-desc=\"Other\"]/android.widget.ImageView";
    public String VENDORMENU = "//android.view.ViewGroup[@content-desc=\"Vendor\"]/android.widget.ImageView";
    public String ADDOPTION = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ImageView";
    public String VENDORNAME = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText";
    public String VENDORSERVICETYPE = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String VENDORSERVICETYPEVAL = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String PHONENUMBER = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText";
    public String PHONENUMBER2 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText";
    public String RATINGS = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.EditText";
    public String REMARKS = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.EditText";
    public String AL1 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.EditText";
    public String AREA = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.EditText";
    public String CITY = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView";
    public String CITYVAL = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String PINCODE = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.TextView";
    public String PINCODEVAL = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String PINCODEVAL1 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String SUBMITBUTTON = "//android.view.ViewGroup[@content-desc=\"Submit\"]";
    public String VENDORSUCCESSASSERT = "//android.widget.TextView[@text=\"Vendor added successfully...\"]";
    public String VENDORFAILASSERT = "//android.widget.TextView[@text=\"Company Vendor Service Name is already exists\"]";
    public String TOUCHSIDE = "//android.widget.TextView[@text=\"Rating *\"]";
    public String SCROLLTO = "//android.widget.TextView[@text=\"QA 0807 VENDOR \"]";
    public String SCROLLTO2 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";
    public String SCROLLTO3 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]";

    public String SEARCH = "//android.widget.EditText[@text=\"Search\"]";
    public String SPECIALDAYMENU = "//android.view.ViewGroup[@content-desc=\"Special Days\"]";
    public String FIRSTVENDOR = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]";
    public String UPDATEBTN = "//android.view.ViewGroup[@content-desc=\"Update\"]";
    public String vendorUpdateSuccessfully = "//android.widget.TextView[@text='Vendor update successfully...']";

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

    public void redirectToVendorPage(){

        commonActions.logPrint("Step:: Click on the other menu");
        commonActions.scrollToElement(By.xpath(OTHERMENU));
        //commonActions.click(By.xpath(OTHERMENU));

        commonActions.logPrint("Step:: Click on the Vendor menu");
        commonActions.waitForElement(By.xpath(VENDORMENU));
        commonActions.click(By.xpath(VENDORMENU));
    }

    public void redirectToSpecialDayPage(){

        commonActions.logPrint("Step:: Click on the other menu");
        commonActions.scrollToElement(By.xpath(OTHERMENU));
        //commonActions.click(By.xpath(OTHERMENU));

        commonActions.logPrint("Step:: Click on the Special day menu");
        commonActions.waitForElement(By.xpath(SPECIALDAYMENU));
        commonActions.click(By.xpath(SPECIALDAYMENU));
    }

    public String addVendor(){
        redirectToVendorPage();

        commonActions.logPrint("Step:: Click on the Add button");
        commonActions.waitForElement(By.xpath(ADDOPTION));
        commonActions.click(By.xpath(ADDOPTION));

        String vendorName = commonActions.generateTestData().firstName;
        commonActions.logPrint("Step:: Enter the vendor name");
        commonActions.waitForElement(By.xpath(VENDORNAME));
        commonActions.type(By.xpath(VENDORNAME), vendorName);

        commonActions.logPrint("Step:: Click on the vendor service dropdown");
        commonActions.waitForElement(By.xpath(VENDORSERVICETYPE));
        commonActions.click(By.xpath(VENDORSERVICETYPE));

        commonActions.logPrint("Step:: Select the first value");
        commonActions.waitForElement(By.xpath(VENDORSERVICETYPEVAL));
        commonActions.click(By.xpath(VENDORSERVICETYPEVAL));

        String phoneNumber = commonActions.generateTestData().phoneNumber.substring(3);
        commonActions.logPrint("Step:: Select the first value");
        commonActions.waitForElement(By.xpath(PHONENUMBER));
        commonActions.type(By.xpath(PHONENUMBER), phoneNumber);

        String phoneNumber2 = commonActions.generateTestData().phoneNumber.substring(3);
        commonActions.logPrint("Step:: Select the first value");
        commonActions.waitForElement(By.xpath(PHONENUMBER2));
        commonActions.type(By.xpath(PHONENUMBER2), phoneNumber2);
        commonActions.logPrint("Entered mobile number is: "+ phoneNumber2);

        commonActions.logPrint("Step:: Enter the ratings");
        commonActions.waitForElement(By.xpath(RATINGS));
        commonActions.type(By.xpath(RATINGS), "2");

        String addressLine1 = commonActions.generateTestData().address;
        commonActions.logPrint("Step:: Enter the Address line 1");
        commonActions.waitForElement(By.xpath(AL1));
        commonActions.type(By.xpath(AL1), addressLine1);

        String areaName = commonActions.generateTestData().city;
        commonActions.logPrint("Step:: Enter the area name");
        commonActions.waitForElement(By.xpath(AREA));
        commonActions.type(By.xpath(AREA), areaName);

        commonActions.logPrint("Step:: Click on the City dropdown");
        commonActions.scrollToElement(By.xpath(CITY));
        //commonActions.click(By.xpath(CITY));

        commonActions.logPrint("Step:: Select the first value");
        commonActions.waitForElement(By.xpath(CITYVAL));
        commonActions.click(By.xpath(CITYVAL));

        commonActions.logPrint("Step:: Click on the Pincode dropdown");
        commonActions.waitForElement(By.xpath(PINCODE));
        commonActions.click(By.xpath(PINCODE));

        commonActions.logPrint("Step:: Select the first value");
        commonActions.waitForElement(By.xpath(PINCODEVAL));
        commonActions.click(By.xpath(PINCODEVAL));

        commonActions.logPrint("Step:: Click on the submit button");
        commonActions.waitForElement(By.xpath(SUBMITBUTTON));
        commonActions.click(By.xpath(SUBMITBUTTON));

        commonActions.logPrint("Step:: Verify that validation message is showing or not after the Request is approved from the manager");
        commonActions.waitForElement(By.xpath(VENDORSUCCESSASSERT));
        commonActions.isElementDisplayed(By.xpath(VENDORSUCCESSASSERT));

        return vendorName;
    }

    public void verifyVendorIsShowingInTheAsmUser(String vendorName){

        commonActions.logPrint("Step:: Enter the vendor name in search field");
        commonActions.waitForElement(By.xpath(SEARCH));
        commonActions.type(By.xpath(SEARCH), vendorName);

        String name = "//android.widget.TextView[@text="+vendorName+"]";

        commonActions.logPrint("Step:: verify vendor is displayed");
        commonActions.isElementDisplayed(By.xpath(name));
    }

    public String updateTheVendorDetail(String vendorName){

        commonActions.logPrint("Step:: Enter the vendor name in search field");
        commonActions.waitForElement(By.xpath(SEARCH));
        commonActions.type(By.xpath(SEARCH), vendorName);

        String firstVendor = "//android.widget.TextView[@text=\"" + vendorName + "\"]";

        commonActions.logPrint("Step:: Click on the first vendor");
        commonActions.waitForElement(By.xpath(firstVendor));
        commonActions.click(By.xpath(firstVendor));

        String vendorUpdatedName = commonActions.generateTestData().firstName;
        commonActions.logPrint("Step:: Update the vendor name");
        commonActions.waitForElement(By.xpath(VENDORNAME));
        driver.findElement(By.xpath(VENDORNAME)).clear();
        commonActions.type(By.xpath(VENDORNAME), vendorUpdatedName);

        commonActions.logPrint("Step:: Click on the update button");
        commonActions.waitForElement(By.xpath(UPDATEBTN));
        commonActions.click(By.xpath(UPDATEBTN));

        commonActions.logPrint("Step:: Verify success pop-up is showing after the update");
        commonActions.waitForElement(By.xpath(vendorUpdateSuccessfully));
        commonActions.isElementDisplayed(By.xpath(vendorUpdateSuccessfully));

        return vendorUpdatedName;
    }

    public void createOneSpecialDay(){

        redirectToSpecialDayPage();

    }

}
