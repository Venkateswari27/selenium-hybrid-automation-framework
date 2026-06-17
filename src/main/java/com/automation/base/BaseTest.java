package com.automation.base;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.utilities.ConfigReader;
import com.automation.utilities.ScreenshotUtility;

public class BaseTest {
	public static WebDriver driver;
	public ConfigReader config;
	@BeforeMethod
	public void setup()
	{
		DriverManager.initializeDriver();
		driver = DriverManager.getDriver();
        config = new ConfigReader();

        driver.get(config.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		 if(result.getStatus() == ITestResult.FAILURE)
		    {
		        ScreenshotUtility.captureScreenshot(driver,result.getName());
		    }
		 
		 DriverManager.quitDriver();
	}
	
}
