package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Prajula-50628\\eclipse-workspace\\ProjectCucumber\\src\\main\\resources\\features", glue= {"com.stepdefinitions", "com.utility"}, 
monochrome=true, publish=true, dryRun=false,
plugin="rerun:target/failedScenarios.txt", tags="@mobileSearch")
public class FlipkartTask {

}
