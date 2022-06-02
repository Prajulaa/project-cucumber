package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="C:\\Users\\Prajula-50628\\eclipse-workspace\\ProjectCucumber\\src\\main\\resources\\features", glue= {"com.stepdefinitions", "com.utility"}, 
monochrome=true, publish=true, dryRun=false,
plugin="rerun:target/failedScenarios.txt", tags="@flightBooking")
public class TestngRunner extends AbstractTestNGCucumberTests{

}
