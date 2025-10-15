package pages;

import org.openqa.selenium.By;

public class DailyTourPlanPage extends BasePage {

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
    public String SUBMITBTNDTP = "//android.widget.TextView[@text=\"Submit\"]";
    public String REVIEWBTN = "//android.view.ViewGroup[@content-desc=\"Review\"]";
    public String SUBMITBTN = "//android.widget.TextView[@text=\"Submit\"]";

    //Approve DTP
    public String APPROVEMENU = "//android.view.ViewGroup[@content-desc=\"Approvals\"]";
    public String DAILYTOURPLANMENU = "//android.view.ViewGroup[@content-desc=\"Daily Tour Plan\"]";
    public String APPROVEBTN = "//android.view.ViewGroup[@content-desc=\"A, Aagneya Asm, 05 September 2025, 2, 2, 2, 2\"]/android.view.ViewGroup/android.view.ViewGroup[2]";

    //DCR Xpaths
    public String DCRMENU = "//android.view.ViewGroup[@content-desc=\"DCR\"]/android.widget.ImageView";
    public String PLEASEPLANYOURDAY = "//android.widget.TextView[@text=\"Please plan your day \"]";
    public String HOMEPAGE = "//android.view.ViewGroup[@content-desc=\"Home\"]";
    public String NEXTBTN = "//android.widget.TextView[@text=\"Next\"]";


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

    public void ApproveDTPFromSenior(){

        commonActions.logPrint("Step:: Click on the approve menu");
        commonActions.waitForElement(By.xpath(APPROVEMENU));
        commonActions.click(By.xpath(APPROVEMENU));

        commonActions.logPrint("Step:: Click on the Daily tour plan sub-menu");
        commonActions.waitForElement(By.xpath(DAILYTOURPLANMENU));
        commonActions.click(By.xpath(DAILYTOURPLANMENU));

        commonActions.logPrint("Step:: Click on the approve button");
        commonActions.waitForElement(By.xpath(APPROVEBTN));
        commonActions.click(By.xpath(APPROVEBTN));
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



}
