package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MasterPage;
import utils.ConfigReader;

import javax.swing.*;

public class MasterTest extends BaseTest {

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
    public void verifyDoctorCreation() {
        LoginPage loginPage = new LoginPage();
        MasterPage masterPage = new MasterPage();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        String doctorName = masterPage.createDoctor();
    }

    @Test
    public void verifyDoctorUpdateScenario() {
        LoginPage loginPage = new LoginPage();
        MasterPage masterPage = new MasterPage();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        String doctorName = masterPage.createDoctor();
        loginPage.goToHomePage();
        String updatedName = masterPage.updateTheDoctor(doctorName);
        loginPage.goToHomePage();
        masterPage.goToDoctorMasterPage();
        masterPage.verifyEntityIsCreatedAndShowingInTheList("Doctor", updatedName);
    }

    @Test
    public void verifyDoctorDelete() {
        LoginPage loginPage = new LoginPage();
        MasterPage masterPage = new MasterPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        String doctorName = masterPage.createDoctor();
        loginPage.goToHomePage();
        masterPage. goToDoctorMasterPage();
        masterPage.deleteDoctor(doctorName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        masterPage.ApproveDoctorDeleteRequestFromManager(doctorName, mrName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(mrEmail, mrPassword);
        masterPage.goToDoctorMasterPage();
        masterPage.verifyEntityIsRemovedFromTheList(doctorName);
    }

    @Test
    public void verifyChemistCreation() {
        LoginPage loginPage = new LoginPage();
        MasterPage masterPage = new MasterPage();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        masterPage.createChemist();
        loginPage.goToHomePage();
    }

    @Test
    public void verifyUpdateChemistScenario() {
        LoginPage loginPage = new LoginPage();
        MasterPage masterPage = new MasterPage();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        String chemistName = masterPage.createChemist();
        loginPage.goToHomePage();
        String updatedName = masterPage.updateTheChemist(chemistName);
        loginPage.goToHomePage();
        masterPage.goToChemistMasterPage();
        masterPage.verifyEntityIsCreatedAndShowingInTheList("Chemist", updatedName);
    }

    @Test
    public void verifyChemistDelete() {
        LoginPage loginPage = new LoginPage();
        MasterPage masterPage = new MasterPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        String chemistName = masterPage.createChemist();
        loginPage.goToHomePage();
        masterPage. goToChemistMasterPage();
        masterPage.deleteChemist(chemistName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        masterPage.ApproveChemistDeleteRequestFromManager(chemistName, mrName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(mrEmail, mrPassword);
        masterPage.goToChemistMasterPage();
        masterPage.verifyEntityIsRemovedFromTheList(chemistName);
    }

    @Test
    public void verifyStockiestCreation() {
        LoginPage loginPage = new LoginPage();
        MasterPage masterPage = new MasterPage();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        masterPage.createStockiest();
    }

    @Test
    public void verifyUpdateStockiestScenario() {
        LoginPage loginPage = new LoginPage();
        MasterPage masterPage = new MasterPage();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        String stockiestName = masterPage.createStockiest();
        loginPage.goToHomePage();
        String updatedName = masterPage.updateTheStockiest(stockiestName);
        loginPage.goToHomePage();
        masterPage.goToStockiestMasterPage();
        masterPage.verifyEntityIsCreatedAndShowingInTheList("Stockiest", updatedName);
    }

    @Test
    public void verifyStockiestDelete() {
        LoginPage loginPage = new LoginPage();
        MasterPage masterPage = new MasterPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        String stockiestName = masterPage.createStockiest();
        loginPage.goToHomePage();
        masterPage. goToStockiestMasterPage();
        masterPage.deleteStockiest(stockiestName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(ASMEmail, ASMPassword);
        masterPage.ApproveStockiestDeleteRequestFromManager(stockiestName, mrName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(mrEmail, mrPassword);
        masterPage.goToStockiestMasterPage();
        masterPage.verifyEntityIsRemovedFromTheList(stockiestName);
    }

    @Test
    public void clearAndSyncTheData(){
        LoginPage loginPage = new LoginPage();
        MasterTest masterTest = new MasterTest();
        loginPage.loginToApp(mrEmail, mrPassword);
        loginPage.clearAndSyncTheData();
    }
}