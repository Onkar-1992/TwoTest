package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions"},
//monochrome = true )
//public class TestRunner {

//}

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
//@CucumberOptions(
    //features = {
    //    "src/test/resources/Features/setupBrowser.feature", // first feature file
    //    "src/test/resources/Features/registration.feature" // second feature file
   // },
  //  glue = "StepDefinitions",  // Specify the package where step definitions are located
    		 
  //  plugin = {
   //     "pretty",
   //     "html:target/cucumber-reports.html"  // You can add more report formats as required
   // },
   // monochrome = true
//)
//public class TestRunner {
    // This class will execute the features in the specified order
//}


;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="FirstTest/src/test/resources/Features",glue= {"StepDefinitions"},
				tags = "@setup or @registration",
    plugin = {"pretty", "html:target/cucumber-reports"}
    	//	tags = "@setup and @registration"
  //  monochrome = true
)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING) // This can help control method execution order (not necessary for feature files but useful for step methods)
public class TestRunner {
}

