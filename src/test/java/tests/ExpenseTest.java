package tests;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExpensePage;
import pages.LeavePage;
import pages.LoginPage;
import utils.ConfigReader;

import java.io.IOException;

public class ExpenseTest extends BaseTest{
    private static final Logger log = LoggerFactory.getLogger(ExpenseTest.class);
    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String companyCode = ConfigReader.getCompanyCode();
    String asmEmail = ConfigReader.getAsmEmail();
    String asmPassword = ConfigReader.getAsmPassword();

    @Test
    public void testLoginPageDisplay() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        LeavePage leavepage = new LeavePage();
        ExpensePage expensePage = new ExpensePage();
        expensePage.addExpense("20 Sep 2025", "1500", "Monthly car fuel", "1.jpg");
        expensePage.addExpense("20 Sep 2025", "2500", "Car", "1.jpg");
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(asmEmail, asmPassword);
        expensePage.approveExpense();
        expensePage.rejectExpense();
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(mrEmail, mrPassword);
        expensePage.veriyFromMR("Monthly car fuel");
    }
}
