package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by hemantjanrao on 12/28/16.
 */
public class AbstractScreen {

    @AndroidFindBy(className = "android.view.View")
    private WebElement androidWebView;

    public AndroidDriver driver;

    public AbstractScreen(AndroidDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public void loadPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void rotateScreen() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        // TODO Auto-generated method stub
    }

    public void switchToWebView() {
        driver.manage()
                .timeouts()
                .implicitlyWait(30,
                        TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,
                30);
        wait.until(ExpectedConditions.visibilityOf(androidWebView));
        driver.manage()
                .timeouts()
                .implicitlyWait(30,
                        TimeUnit.SECONDS);

        Set<String> contextSet = driver.getContextHandles();
        for (String contextName : contextSet) {
            if (!contextName.contains("NATIVE_APP")) {
                driver.context(contextName);
                break;
            }
        }
    }

    public void takeScreenShot(String fileName) {
        // TODO Auto-generated method stub
        File file = new File(fileName + ".png");
        File tmpFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tmpFile, file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
