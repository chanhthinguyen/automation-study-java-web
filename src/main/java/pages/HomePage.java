package pages;

import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignInPage clickSignIn (){
        _common.clickObject(_homeObjects.signInButton);
        return new SignInPage(driver);
    }
}
