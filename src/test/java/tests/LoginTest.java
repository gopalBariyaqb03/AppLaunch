package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    String mrName = ConfigReader.getMrName();
    String asmName = ConfigReader.getAsmName();
    String rsmName = ConfigReader.getMrName();

    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String ASMEmail = ConfigReader.getAsmEmail();
    String ASMPassword = ConfigReader.getAsmPassword();
    String rsmEmail = ConfigReader.getRsmEmail();
    String rsmPassword = ConfigReader.getRsmPassword();

//    @Test
//    public void testLoginPageDisplay() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.loginToApp(ASMEmail, ASMPassword);
//        loginPage.createOneDailyTourPlan();
//        loginPage.createDoctor();
//        loginPage.createChemist();
//        loginPage.createStockiest();
//    }

    @Test
    public void verifyDailyTourPlanCreateAndCompleteTheVisit() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        loginPage.createOneDailyTourPlan();
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(rsmEmail, rsmPassword);
        loginPage.ApproveDTPFromSenior(asmName);
        loginPage.logoutFromTheApp();
    }

//    @Test
//    public void createAnEmailScenario(){
//        LoginPage loginPage = new LoginPage();
//        loginPage.loginToApp(mrEmail, mrPassword);
//        String message = loginPage.createAnEmail(asmName);
//        loginPage.verifyEmailIsShowingInSent(message);
//        loginPage.logoutFromTheApp();
//        loginPage.loginToApp(ASMEmail, ASMPassword);
//        loginPage.verifyEmailIsReceived(message);
//    }
//
//    @Test
//    public void verifyDraftEmailFunctionality(){
//        LoginPage loginPage = new LoginPage();
//        loginPage.loginToApp(mrEmail, mrPassword);
//        String[] draftValue = loginPage.createEmailDraft(mrName);
//        loginPage.verifyEmailIsShowingInTheDraft(draftValue[1]);
//    }

//    @Test
//    public void clearAndSyncTheData(){
//        LoginPage loginPage = new LoginPage();
//        loginPage.loginToApp(mrEmail, mrPassword);
//        loginPage.clearAndSyncTheData();
//    }

    @Test
    public void completeDoctorVisitScenario(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        loginPage.verifyDailyTourPlanIsCreated();
    }

    @Test
    public void doctorNAScenario(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        String doctorName = loginPage.createDoctorNAForSelectedDoctor();
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        loginPage.ApproveDoctorNARequest(doctorName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(mrEmail, mrPassword);
        loginPage.verifyDrIsNotShowingInTheDailyTourPlan(doctorName);
    }

    @Test
    public void verifyDoctorChemistScenario(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        String[] DoctorChemist = loginPage.createDoctorChemistMap();
        loginPage.goToHomePage();
        loginPage.verifyDailyTourPlanIsCreated();
    }

    @Test
    public void verifyDailyTourPlanIsCreateAndCompletedTheVisit(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        loginPage.verifyDailyTourPlanIsCreated();
        loginPage.goToHomePage();
        loginPage.approveDTPIfItsPending();
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        loginPage.ApproveDTPFromSenior(mrName);
    }

    @Test
    public void verifyCRMLoginScenario(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToCRM();
    }

}