package com.automation.stepdefinitions;

import com.automation.base.DriverManager;
import com.automation.context.TestContext;
import com.automation.utilities.ConfigReader;
import com.automation.utilities.ScreenshotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static ConfigReader config;

    @Before
    public void setup() {
    	DriverManager.initializeDriver();
        config = new ConfigReader();
        DriverManager.getDriver().get(config.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
    	 // capture screenshot only on failure
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtility.captureScreenshotForCucumber(
                    DriverManager.getDriver(),
                    scenario.getName()
            );

            // attach screenshot to cucumber + extent report
            if (screenshot != null) {
                scenario.attach(
                        screenshot,
                        "image/png",
                        scenario.getName()
                );
            }
        }
    	TestContext.clear();   // reset context
    	DriverManager.quitDriver();
    }
}