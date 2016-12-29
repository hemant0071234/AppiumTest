//package tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//
///**
// * Created by hemantjanrao on 12/23/16.
// */
//public class BaseTest {
//
//    public RemoteWebDriver driver;
//
//    @BeforeClass
//    public void setUp() throws Exception {
//        // set up appium
//        File appDir = new File("/Users/hemantjanrao/Documents/JD/1/src/apps");
//
//        File app = new File(appDir, "Flipkart.apk");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("device","Android");
//        capabilities.setCapability("VERSION", "5.1.0");
//        capabilities.setCapability("deviceName","Samsung Galaxy S6");
//        capabilities.setCapability("platformName","Android");
//
//        //other caps
//        capabilities.setCapability("app", app.getAbsolutePath());
//
//        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//
//    }
//
//    @AfterClass
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
//
//    @BeforeClass(alwaysRun=true)
//    public void initAutomation() throws IOException{
//        AppUtils.loadConfigProp("config_googlesearch_mobile_web.properties");
//        AppUtils.setCapabilities();
//    }
//
//    @BeforeMethod(alwaysRun = true)
//    public void setUp() throws IOException {
//        driver = AppUtils.getDriver();
//    }
//    @Test
//    public void test_one() {
//        String app_package_name = "com.flipkart.android:id/";
//        //By login_link = By.name("Existing user? Log in");
//        By mobile = By.id(app_package_name + "mobile_login_signup_edit_text");
//        By password = By.id(app_package_name + "etPass");
//        By log_button = By.id(app_package_name + "btn_mlogin");
//
//
//        driver.findElement(By.id("btn_mlogin")).click();
//        driver.findElement(mobile).sendKeys("9769681557");
//        driver.findElement(password).click();
//        driver.findElement(password).sendKeys("mangal007");
//        driver.findElement(log_button).click();
//    };
//}
