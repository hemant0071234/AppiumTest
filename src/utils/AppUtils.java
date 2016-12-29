package utils;

/**
 * Created by hemantjanrao on 12/28/16.
 */
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.SystemClock;

public class AppUtils {

    private static Properties prop = new Properties();
    public static int EXPLICIT_WAIT_TIME;
    public static int IMPLICIT_WAIT_TIME;
    public static int DEFAULT_WAIT_TIME;
    public static String APPLICATION_NAME;
    public static String BASE_PKG;
    public static String APP_ACTIVITY;
    public static String APP_PASSWORD;
    private static String APPIUM_PORT;
    public static String AUTOMATION_INSTRUMENTATION;
    public static String BROWSER_NAME;
    public static String PLATFORM_NAME;
    public static String NEW_COMMAND_TIMEOUT;
    public static String PLATFORM_VERSION;
    public static String DEVICE_READY_TIMEOUT;
    public static String DEVICE_NAME;
    private static String PERFORMANCE_LOGGING;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static URL serverUrl;
    public static AndroidDriver driver;
    private static String WAIT_ACTIVITY;

    public void loadConfigProp(String propertyFileName) throws IOException {

        prop.load(new FileInputStream(propertyFileName));
        EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
        IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
        DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
        APPLICATION_NAME = prop.getProperty("application.path");
        BASE_PKG = prop.getProperty("base.pkg");
        APP_ACTIVITY = prop.getProperty("application.activity");
        WAIT_ACTIVITY = prop.getProperty("wait.activity");
        APPIUM_PORT = prop.getProperty("appium.server.port");
        AUTOMATION_INSTRUMENTATION = prop.getProperty("automation.instumentation");
        DEVICE_NAME = prop.getProperty("device.name");
        BROWSER_NAME = prop.getProperty("browser.name");
        PLATFORM_NAME = prop.getProperty("platform.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");
        NEW_COMMAND_TIMEOUT = prop.getProperty("new.command.timeout");
        DEVICE_READY_TIMEOUT = prop.getProperty("device.ready.timeout");
        PERFORMANCE_LOGGING = prop.getProperty("enablePerformanceLogging");
    }

    public static void setCapabilities() {
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, AppUtils.BROWSER_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, AppUtils.PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, AppUtils.PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, AppUtils.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AppUtils.AUTOMATION_INSTRUMENTATION);
        capabilities.setCapability(MobileCapabilityType.APP,AppUtils.APPLICATION_NAME);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, AppUtils.NEW_COMMAND_TIMEOUT);
    }

    public static AndroidDriver getDriver() throws MalformedURLException {
        serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
        driver = new AndroidDriver(serverUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }
}
