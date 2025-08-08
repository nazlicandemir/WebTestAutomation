package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.remote.tracing.Tags;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks","BaseFiles", "GeneralFiles"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true

)
public class  TestRunner extends AbstractTestNGCucumberTests {
}
//new commit.
//aysel