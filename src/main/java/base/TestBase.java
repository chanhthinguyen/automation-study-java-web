package main.java.base;

import main.java.libs.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class TestBase {

    protected static WebDriver driver;

    /**
     * Constructor of TestBase to: Set Driver + Render all elements on All pages
     */
    public TestBase() {

        String runMode = System.getProperty("mode", "local");
        TestBase.driver = setDriver(runMode);
    }

    public WebDriver setDriver(String runMode){

        if(runMode.equals("grid")){
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            String Node = Config.getConfig("node_url");
            try {
                TestBase.driver = new RemoteWebDriver(new URL(Node), cap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            String browser = Config.getConfig("browser");
            if(browser.equalsIgnoreCase("CHROME")){
                System.setProperty(Config.getConfig("chrome.key"),Config.getConfig("chrome.path"));
                TestBase.driver = new ChromeDriver();
            }else if(browser.equalsIgnoreCase("FIREFOX")){
                System.setProperty(Config.getConfig("firefox.key"),Config.getConfig("firefox.path"));
                TestBase.driver = new FirefoxDriver();
            }

        }

        return driver;

    }


    @BeforeClass
    public void beforeClass(){
        TestBase.driver.manage().window().maximize();
        TestBase.driver.navigate().to(Config.getConfig("baseUrl"));

    }

    @AfterClass
    public void afterClass(){
        TestBase.driver.quit();
    }



}
