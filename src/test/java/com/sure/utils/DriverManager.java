package com.sure.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	public static String browser;
    public static WebDriver driver;
	
	public static WebDriver getDriver() {
		browser=System.getProperty("browser.name");
		//browser="Chrome";
        if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Pool\\Lib\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }else if(browser.equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.firefox.driver", "C:\\Users\\Admin\\eclipse-workspace\\Pool\\Lib\\chromedriver.exe");
        	WebDriverManager.firefoxdriver().setup();
        	driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }else if(browser.equalsIgnoreCase("Edge")) {
			//System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\eclipse-workspace\\Pool\\Lib\\chromedriver.exe");
        	WebDriverManager.edgedriver().setup();
        	driver = new EdgeDriver();
	        driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       
        }
        return driver;
 
	}
     
}
