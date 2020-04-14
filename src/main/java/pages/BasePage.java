package main.java.pages;

import main.java.libs.Common;
import main.java.objects.HomeObjects;
import main.java.objects.MyAccountObjects;
import main.java.objects.SignInObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected Common _common;
    protected SignInObjects _signInObjects;
    protected HomeObjects _homeObjects;
    protected MyAccountObjects _myAccountObjects;

    public BasePage(WebDriver driver){
        this.driver = driver;
        _common = new Common(driver);
        _signInObjects = new SignInObjects();
        _homeObjects = new HomeObjects();
        _myAccountObjects = new MyAccountObjects();

        PageFactory.initElements(driver,this);
    }
}
