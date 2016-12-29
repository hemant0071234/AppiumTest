package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by hemantjanrao on 12/23/16.
 */


public class LoginTest extends Basetestt{

    private LoginPage loginPage;

    @Test
    public void testScrolling() {

        loginPage = new LoginPage(driver);
        loginPage.DoLogin("hemantjanrao@gmail.com", "mangal007");
    }

//    @Test
//    public void testScrolling2() {
//
//        loginPage = new LoginPage(driver);
//        loginPage.DoLogin("hemantjanrao@gmail.com", "mangal007");
//    }
}
