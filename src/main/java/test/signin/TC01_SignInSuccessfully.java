package main.java.test.signin;

import main.java.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.java.pages.HomePage;
import main.java.pages.MyAccountPage;
import main.java.pages.SignInPage;

public class TC01_SignInSuccessfully extends TestBase {

    HomePage _homePage = new HomePage(driver);
    @Test
    public void loginSuccessfully(){

        SignInPage _signInPage = _homePage.clickSignIn();
        Assert.assertEquals(_signInPage.getPageHeading(),"AUTHENTICATION");
        MyAccountPage _myAccountPage = _signInPage.login("thihuyennguyen1205@gmail.com","chanhthi1992");
        Assert.assertEquals(_myAccountPage.getPageHeading(),"MY ACCOUNT");

    }
}
