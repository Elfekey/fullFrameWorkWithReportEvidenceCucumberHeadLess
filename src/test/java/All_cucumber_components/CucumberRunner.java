package All_cucumber_components;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class CucumberRunner {
	
	
	    //in feature we put the feature fil path from src until .feature....
	    //in glue with put the name of page which includes step definition class
	@CucumberOptions(tags = "", features = {"src/test/java/All_cucumber_components/testScenario.feature"}, glue = {"All_cucumber_components"},
	                 plugin = {})
	public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
	    
	}
}

