package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepsDefination", "hooks"}, //It will check the file is present or not during
       // tags = "@smoke", //Tags which you want to run
        plugin = {"pretty", "html: target/MyReports/cucumber-reports.html"} // "json: target/MyReports/report.json","junit: target/MyReports/report.xml"
      //  publish = true  //Cucumber report
       // monochrome = false, //It will give the proper alignment during console printing,
                          // now by default it is there in cucumber and there is no need to write this
        //dryRun = true // it will check the steps having the step defination or not(Mapping between steps and defincation)
                        // but now by default it is there in cucumber and there is no need to write this
        )
public class RunCuke{
}
