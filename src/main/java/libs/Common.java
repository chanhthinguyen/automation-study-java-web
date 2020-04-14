package libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Common {

    private WebDriver driver;

    public Common (WebDriver driver){
        this.driver = driver;
    }


    public static WebElement waitForElementPresent (WebDriver driver, final By by, int timeOutInSeconds){

        WebElement element;

        try{

            //nullify implicitlyWait
            driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);

            WebDriverWait  wait = new WebDriverWait(driver,timeOutInSeconds);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

            //reset implicitlyWait()

            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

            return element;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    public boolean setText(By by,String text){

        WebElement element = waitForElementPresent(driver,by,5000);

        if(element != null){
            element.sendKeys(text);

            return true;
        }

        return false;
    }

    public String getText(By by){

        WebElement element = waitForElementPresent(driver,by,5000);

        return element.getText();
    }


    public boolean clickObject(By by) {

        WebElement element = waitForElementPresent(driver,by,5000);

        if(element != null){
            element.click();
            return true;
        }

        return false;

    }
}
