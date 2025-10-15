package tests;
import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeavePage;
import pages.LoginPage;
import pages.SampleAndRequestPage;
import utils.ConfigReader;

public class SampleAndRequestTest extends BaseTest
{
    private static final Logger log = LoggerFactory.getLogger(ExpenseTest.class);
    String mrEmail = ConfigReader.getMrEmail();
    String mrPassword = ConfigReader.getMrPassword();
    String companyCode = ConfigReader.getCompanyCode();
    String asmEmail = ConfigReader.getAsmEmail();
    String asmPassword = ConfigReader.getAsmPassword();

    @Test
    public void testSampleAndRequestPage()

    {

        LoginPage loginPage = new LoginPage();
        loginPage.loginToApp(mrEmail, mrPassword);
        SampleAndRequestPage sampleAndRequestPage = new SampleAndRequestPage();
//        sampleAndRequestPage.redirectToSampleAndRequestPage();
//        sampleAndRequestPage.requestedGift(1);
        sampleAndRequestPage.receiveGift();

    }
}
