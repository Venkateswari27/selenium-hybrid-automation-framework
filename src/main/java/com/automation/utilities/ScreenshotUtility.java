package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver,String testName)
    {

        String screenshotPath =
                System.getProperty("user.dir")
                + "Reports/Screenshots/"
                + testName + "_"+ ".png";

        File source =((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destination =new File(screenshotPath);

        try 
        {
            FileUtils.copyFile(source, destination);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved at: " + screenshotPath);
        return screenshotPath;
    }

    
    /*
     * Used by Cucumber Extent Reports
     * Returns screenshot as byte array for scenario.attach()
     */
    public static byte[] captureScreenshotForCucumber(WebDriver driver, String scenarioName) {

        File screenshotFile = takeScreenshot(driver, scenarioName);

        if (screenshotFile != null) {
            try {
                return Files.readAllBytes(screenshotFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    
    
    
    /*
     * Common private method used internally
     * Captures screenshot and saves file physically
     */
    private static File takeScreenshot(WebDriver driver, String name) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String screenshotDir =
                System.getProperty("user.dir")
                + "/reports/screenshots/";

        String screenshotPath =
                screenshotDir
                + name.replace(" ", "_")
                + "_"
                + timestamp
                + ".png";

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destination = new File(screenshotPath);

        try {

            // create folder if missing
            destination.getParentFile().mkdirs();

            // copy screenshot
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot saved at: " + screenshotPath);

            return destination;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
