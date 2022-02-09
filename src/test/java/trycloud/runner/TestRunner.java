package trycloud.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( features ="src/test/resources/features",
        glue = "trycloud/step_defs",
        plugin = {"pretty", "html:target/cucumber.html",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "me.jvt.cucumber.report.PrettyReports:target"
        }
        // ,dryRun = false
        ,tags = "@feature1"
)
public class TestRunner extends AbstractTestNGCucumberTests {


}
