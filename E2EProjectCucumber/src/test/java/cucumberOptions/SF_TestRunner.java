package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
		  features = "src/test/java/SF_features",
		    glue="SF_stepDefinations")

public class SF_TestRunner extends AbstractTestNGCucumberTests{



}
