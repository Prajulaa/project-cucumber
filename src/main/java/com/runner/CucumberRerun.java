package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="@target/rerun.txt", 
glue= {"com.stepdefinitions", "com.utility"}, 
monochrome=true, publish=true, dryRun=false, plugin="rerun:target/failedScenarios.txt")
public class CucumberRerun {

}
