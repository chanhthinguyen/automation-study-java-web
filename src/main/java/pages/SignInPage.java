package pages;


import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeading(){
        return _common.getText(_signInObjects.lblSignInPage);
    }

    public MyAccountPage login(String email, String password) {
        _common.setText(_signInObjects.emailTextInput,email);
        _common.setText(_signInObjects.passwordTextInput, password);
        _common.clickObject(_signInObjects.submitButton);
        return new MyAccountPage(driver);
    }
}
