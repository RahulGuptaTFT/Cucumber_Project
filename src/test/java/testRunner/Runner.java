package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/features/"},
        dryRun = true,
        monochrome = true,
        glue = {"stepDefinition","Hooks"},git
        plugin = {"html:src/Reports/Reports.html"}
//        tags = "@smoke"
)
public class Runner extends AbstractTestNGCucumberTests {

}
