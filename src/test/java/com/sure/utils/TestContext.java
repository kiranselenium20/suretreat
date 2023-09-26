package com.sure.utils;

import org.openqa.selenium.WebDriver;

public class TestContext {

	public WebDriver driver;
	
	public TestContext() {
		this.driver=DriverManager.getDriver();
	}

}
