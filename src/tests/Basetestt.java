package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.AppUtils;
import utils.TestListners;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hemantjanrao on 12/28/16.
 */
@Listeners(utils.TestListners.class)
public class Basetestt {

    public static AndroidDriver driver;


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
}
