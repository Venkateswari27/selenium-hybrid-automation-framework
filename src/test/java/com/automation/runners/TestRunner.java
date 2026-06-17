package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.automation.stepdefinitions",
    plugin = {"pretty",
    		//"html:target/cucumber-report.html",
    		"json:target/cucumber.json",
    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    
    }
  //  tags = "@smoke"
//    tags = "@regression"
//    tags = "@checkout"
//    tags = "@smoke and not @login"
    //tags = "@login"
    
)

public class TestRunner extends AbstractTestNGCucumberTests {

}