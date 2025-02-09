
package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"@target/failedRerun.txt"},
		glue={"stepDefinition","appHooks"},
		plugin= {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread",
				"rerun:target/failedRerun.txt"},
		dryRun=false,
		monochrome=true
		)
public class FailRunner{
}
