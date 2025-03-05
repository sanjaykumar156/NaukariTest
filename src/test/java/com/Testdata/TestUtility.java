package com.Testdata;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.baseClass.BaseTest;

public class TestUtility extends BaseTest {
	
    public String captureScreenshot(String testName) {
        if (getDriver() == null) {
            System.out.println("Driver is null, cannot take screenshot.");
            return null;
        }
        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
            File source = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            File destination = new File(".//Screenshots//" + testName + "_" + timestamp + ".png");
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
            return destination.getAbsolutePath();
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }
}
