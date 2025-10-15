package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeavePage;
import pages.LoginPage;
import utils.ConfigReader;

public class LeaveTest extends BaseTest {

    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String companyCode = ConfigReader.getCompanyCode();
    String asmEmail = ConfigReader.getAsmEmail();
    String asmPassword = ConfigReader.getAsmPassword();

    @Test
    public void testLoginPageDisplay() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        LeavePage leavePage = new LeavePage();
        leavePage.addHalfDayLeave();
        leavePage.addFullDayLeave();
        leavePage.addMultipleDayLeave();
        leavePage.clickFirstDeleteButton();
    }

    @Test
    public void verifyToTestAddHalfLeaveFunctionality(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        LeavePage leavePage = new LeavePage();
        leavePage.addHalfDayLeave();
    }

    @Test
    public void verifyToTestAddFullLeaveFunctionality(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        LeavePage leavePage = new LeavePage();
        leavePage.addFullDayLeave();
    }

    @Test
    public void verifyToTestAddMultipleLeaveFunctionality(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        LeavePage leavePage = new LeavePage();
        leavePage.addMultipleDayLeave();
    }

    @Test
    public void approveLeave() {
        LoginPage loginPage = new LoginPage();
        LeavePage leavePage = new LeavePage();
//        loginPage.loginToApp(mrEmail, mrPassword);
//        leavePage.addHalfDayLeave();
//       // leavePage.addFullDayLeave();
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(asmEmail, asmPassword);
        leavePage.approveLeave();
        leavePage.rejectLeave();
    }
}
