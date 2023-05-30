package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
		 "src/main/java/features/Login.feature", 
		 "src/main/java/features/CreateLead.feature"  }, 
			glue = "steps", 
		 monochrome = true, publish = true)
// dryRun=false)
//					tags="not @sanity",
//	tags="@Sanity or @Smoke")
public class Runner extends AbstractTestNGCucumberTests {

	/*
	 * @DataProvider(parallel=true) public Object[][] scenarios() {
	 * 
	 * return super.scenarios();
	 * 
	 * }
	 */

}
