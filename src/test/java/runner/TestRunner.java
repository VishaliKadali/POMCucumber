package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { /*
								 * "src/test/java/features/getIncidents.feature",
								 * "src/test/java/features/getIncidentswithQP.feature",
								 * "src/test/java/features/getIncidentswithQP2.feature",
								 * "src/test/java/features/CreateIncidentwithShort_descCategory.feature",
		 						 * "src/test/java/features/WK4createIncWithScenarioOutline.feature" 
								 */
		
		 
		  }, 
								glue = "steps", 
								monochrome = true, 
								publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
