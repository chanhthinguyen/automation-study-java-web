package main.java.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue="main.java.steps",features = "src/main/resources/features",plugin={"pretty","html:target/site/cucumber-pretty",
        "json:target/cucumber.json"})
public class TestRunner {

}