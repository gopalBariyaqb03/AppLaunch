package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.EmailPage;
import pages.LoginPage;
import utils.ConfigReader;

public class EmailTest extends BaseTest {

    String mrName = ConfigReader.getMrName();
    String asmName = ConfigReader.getAsmName();
    String rsmName = ConfigReader.getMrName();

    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String ASMEmail = ConfigReader.getAsmEmail();
    String ASMPassword = ConfigReader.getAsmPassword();
    String rsmEmail = ConfigReader.getRsmEmail();
    String rsmPassword = ConfigReader.getRsmPassword();

    @Test
    public void verifyEmailComposeAndSentFunctionality(){
        LoginPage loginPage = new LoginPage();
        EmailPage emailPage = new EmailPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        String message = emailPage.createAnEmail(asmName);
        emailPage.verifyEmailIsShowingInSent(message);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        emailPage.verifyEmailIsReceived(message);
    }

    @Test
    public void verifyDraftEmailFunctionality() {
        LoginPage loginPage = new LoginPage();
        EmailPage emailPage = new EmailPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        String[] draftValue = emailPage.createEmailDraft(mrName);
        emailPage.verifyEmailIsShowingInTheDraft(draftValue[1]);
    }
}