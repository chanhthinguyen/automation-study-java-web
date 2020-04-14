package steps;

import base.TestBase;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;

public class Hook extends TestBase {

    @BeforeStep
    public void openBrowser(){
        beforeClass();
    }

    @AfterStep
    public void closeBrowser(){
        afterClass();
    }
}