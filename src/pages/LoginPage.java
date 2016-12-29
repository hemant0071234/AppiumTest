package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AbstractScreen;

import java.util.concurrent.TimeUnit;

/**
 * Created by hemantjanrao on 12/23/16.
 */
public class LoginPage extends AbstractScreen {

    public LoginPage(AndroidDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
        loadPage();
    }


    @AndroidFindBy(id = "com.flipkart.android:id/mobile_login_signup_edit_text")
    public WebElement username;

    @AndroidFindBy(id = "com.flipkart.android:id/etPass")
    public WebElement passWord;

    @AndroidFindBy(id = "com.flipkart.android:id/btn_mlogin")
    public WebElement loginButton;

    public void DoLogin(String userName, String password){

        loginButton.click();
        username.sendKeys(userName);
        passWord.sendKeys(password);
        loginButton.click();

    }


}