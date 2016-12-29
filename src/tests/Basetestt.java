package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import utils.AppUtils;

import java.io.IOException;

/**
 * Created by hemantjanrao on 12/28/16.
 */
//@Listeners(utils.TestListners.class)
public class Basetestt {

    public static AndroidDriver driver;
    private static ExtentReports reports;
    ExtentTest test;

    @BeforeClass(alwaysRun = true)
    public void initAutomation() throws IOException {
        AppUtils ap= new AppUtils();
        ap.loadConfigProp("src/config/config_android_settings.properties");
        ap.setCapabilities();
    }

    public static AndroidDriver getDriverr() throws Exception {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = AppUtils.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        driver.quit();
    }

    @BeforeTest
    public void setupTest()throws IOException{

        //Initiate Extent Reports
        reports = new ExtentReports("/Users/hemantjanrao/Documents/JD/1/src/reports/Test.html",true);

        //Declare Start test name
        test = reports.startTest("Verify Home page");
    }

    @AfterTest
    public void clearTest(){
        //Ending the Test
        reports.endTest(test);
        //writing everything to document
        reports.flush();
    }
}
