package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/Features/SearchPage.feature"},
		glue={"stepDefinition","appHooks"},
		plugin= {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread",
				"rerun:target/failedRerun.txt"},
		dryRun=false,
		monochrome=true
		)
public class Runner{
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
}
