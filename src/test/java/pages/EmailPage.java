package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmailPage extends BasePage {

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






}
