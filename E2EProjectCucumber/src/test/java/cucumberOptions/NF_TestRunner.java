package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
		  features = "src/test/java/NF_features",
		    glue="NF_stepDefinations")

public class NF_TestRunner extends AbstractTestNGCucumberTests{



}
