package com.sure.stepDefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sure.utils.DriverManager;
import com.sure.utils.TestContext;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks  {
	
//	private static WebDriver driver;
//	
//	public Hooks(DriverManager dManager) {
//		driver=dManager.getDriver();
//	}
//	
//	@AfterAll
//	public static void quitDriver() {
//	 driver.quit();
//	}
//	
//    @AfterStep
//    public static void tearDown(Scenario scenario) {
//         if(scenario.isFailed()) {
//            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName()); 
//        }   
//    }
    
    
}
