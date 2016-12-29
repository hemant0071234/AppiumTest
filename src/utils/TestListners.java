package utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.Basetestt;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import static utils.AppUtils.*;

/**
 * Created by hemantjanrao on 12/28/16.
 */
public class TestListners extends Basetestt implements ITestListener {

//    private AndroidDriver driver;
//
//    public TestListners(AndroidDriver driver) {
//        // TODO Auto-generated constructor stub
//        this.driver = driver;
//    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        File file = new File("Test.png");
        File tmpFile = null;
        try {
            //WebDriver driver = getDriver();

           // tmpFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileUtils.copyFile(tmpFile, file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish");
    }
}
