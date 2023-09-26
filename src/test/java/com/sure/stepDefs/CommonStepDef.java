package com.sure.stepDefs;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sure.utils.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonStepDef {

	private static WebDriver driver;

	private By emailFld = By.xpath("//input[@id='email']");
	private By pwdFld = By.xpath("//input[@id='password']");
	private By loginBtn = By.xpath("//button[text()=' Log In ']");

	public CommonStepDef(TestContext context) {
		driver = context.driver;
	}

	@And("I logout of the application")
	public void i_Logout_App() throws Exception {
		assertTrue(BaseTest.clickButton(driver, By.xpath("(//a[@id='language'])[3]")));
		assertTrue(BaseTest.clickButton(driver, By.xpath("//a[text()='Logout']")));
		assertTrue(BaseTest.clickButton(driver, By.xpath("//button[text()='LOG OUT']")));
	}

	@Given("I Login with email as {string} and Password as {string}")
	public void i_Login_With_Email_And_Password(String email, String pwd) {
		try {
			BaseTest.LaunchApp(driver, "https://suretreat.zodiac-dev.com/en-US");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			BaseTest.clickButton(driver,loginBtn);
			BaseTest.enterValue(driver, emailFld, email);
			BaseTest.enterValue(driver, pwdFld, pwd);
		} catch (Exception e) {

		}
	}
	
	    public void i_Should_See_Below_Details(DataTable table) {
	    	List<WebElement> conditionsList = driver.findElements(By.xpath("//div[starts-with(@class,'datatable-row-center')]//div/span/span"));
	    	List<Map<String, String>> conditionDts=table.asMaps();
	    	    for(Map<String, String> conditionMap:conditionDts) {
	    	    	List<WebElement> RecommendationList = driver.findElements(By.xpath("//td[text()='"+conditionMap.get("Condition")+"']/following-sibling::td/ul/li"));
	    	    	for(WebElement recommValue:RecommendationList) {
	    	    		System.out.println(recommValue.getText());
	    	    		System.out.println("--"+conditionMap.get("Recommendation"));
	    	    		//assertEquals(recommValue.getText(),conditionMap.get("Recommendation"));
	    	    	}
	    	    }
	    }
}
