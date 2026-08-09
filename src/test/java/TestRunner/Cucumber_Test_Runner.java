package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",   // Path to your .feature files
        glue = {"StepDefinitions"},                 // Package with step definition classes
        plugin = {
                "pretty",                           // Console output
                "html:target/cucumber-reports.html",// HTML report
                "json:target/cucumber.json",        // JSON report
                "junit:target/cucumber.xml"         // JUnit XML report
        },
        monochrome = true,                          // Cleaner console output
        tags = "@SmokeTest"                         // Run scenarios with this tag
)
public class Cucumber_Test_Runner extends AbstractTestNGCucumberTests {

    // Enables parallel execution of scenarios with TestNG
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

