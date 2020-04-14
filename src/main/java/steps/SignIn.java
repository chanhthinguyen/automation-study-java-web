package steps;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;


public class SignIn extends TestBase {

    HomePage _homePage;
    SignInPage _signInPage;
    MyAccountPage _myAccountPage;

    @Given("User navigate to Home Page")
    public void navigateToHomePage (){
        _homePage = new HomePage(driver);
    }

    @When("User sign in with username and password")
    public void signInWithUserNameAndPassword (){
        _signInPage = _homePage.clickSignIn();
        _myAccountPage = _signInPage.login("thihuyennguyen1205@gmail.com","chanhthi1992");
    }

    @Then("User in My Account page")
    public void navigateToMyAccountPage (){
        Assert.assertEquals(_myAccountPage.getPageHeading(),"MY ACCOUNT");
    }




}
