package main.java.pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeading(){
        return _common.getText(_myAccountObjects.lblmyAccount);
    }
}
