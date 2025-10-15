package tests;
import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OtherPage;
import utils.ConfigReader;

public class OtherTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(ExpenseTest.class);
    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String companyCode = ConfigReader.getCompanyCode();
    String asmEmail = ConfigReader.getAsmEmail();
    String asmPassword = ConfigReader.getAsmPassword();
    String directorEmail = ConfigReader.getDirectorEmail();
    String directorPass = ConfigReader.getDirectorPass();

    @Test
    public void verifyVendorCreationFunctionality(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        OtherPage otherPage = new OtherPage();
        String vendorName = otherPage.addVendor();
        otherPage.verifyVendorIsShowingInTheAsmUser(vendorName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(asmEmail,asmPassword);
        otherPage.redirectToVendorPage();
        otherPage.verifyVendorIsShowingInTheAsmUser(vendorName);
    }

    @Test
    public void verifyVendorUpdateFunctionality(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        OtherPage otherPage = new OtherPage();
        String vendorName = otherPage.addVendor();
        otherPage.verifyVendorIsShowingInTheAsmUser(vendorName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(asmEmail,asmPassword);
        otherPage.redirectToVendorPage();
        otherPage.verifyVendorIsShowingInTheAsmUser(vendorName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(mrEmail, mrPassword);
        otherPage.redirectToVendorPage();
        String updatedName = otherPage.updateTheVendorDetail(vendorName);
        loginPage.goToHomePage();
        otherPage.redirectToVendorPage();
        otherPage.verifyVendorIsShowingInTheAsmUser(updatedName);
        loginPage.logoutFromTheApp();
        loginPage.loginToApp(asmEmail,asmPassword);
        otherPage.redirectToVendorPage();
        otherPage.verifyVendorIsShowingInTheAsmUser(updatedName);
    }

    @Test
    public void verifySpecialDayCreationFunctionality(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(directorEmail, directorPass);
        OtherPage otherPage = new OtherPage();
        otherPage.createOneSpecialDay();
    }

}
