package MyRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

    @RunWith(Cucumber.class)
	@CucumberOptions(
			features="C://kalpana123//vinisha//ClearLabs//src//main//java//Features//search.feature",
			glue="StepDefinations"		
			)
	public class TestRunner {	
	
	
	

}
