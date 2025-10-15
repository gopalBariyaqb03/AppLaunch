package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DailyTourPlanPage;
import pages.LoginPage;
import pages.MasterPage;
import utils.ConfigReader;

public class DailyTourPlanTest extends BaseTest {

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
    public void testLoginPageDisplay() {
        DailyTourPlanPage dailyTourPlanPage = new DailyTourPlanPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        dailyTourPlanPage.createOneDailyTourPlan();
    }

    @Test
    public void dailyTourPlanCreateAndCompleteTheVisit() {
        LoginPage loginPage = new LoginPage();
        DailyTourPlanPage dailyTourPlanPage = new DailyTourPlanPage();
        loginPage.loginToApp(mrEmail, ASMPassword);
        dailyTourPlanPage.createOneDailyTourPlan();
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(ASMEmail, rsmPassword);
        dailyTourPlanPage.ApproveDTPFromSenior();
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(mrEmail, ASMPassword);
    }

    //Consider this methods for the daily tour plan scenarios
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
    public void completeDoctorVisitScenario(){
        LoginPage loginPage = new LoginPage();
        DailyTourPlanPage dailyTourPlanPage = new DailyTourPlanPage();
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

}