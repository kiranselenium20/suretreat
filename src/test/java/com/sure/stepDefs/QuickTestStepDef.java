package com.sure.stepDefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.sure.utils.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuickTestStepDef  {
	
	private static WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	public QuickTestStepDef(TestContext context) {
         driver=context.driver;
	}

	private By emailFld = By.xpath("//input[@id='email']");
	private By pwdFld = By.xpath("//input[@id='password']");
	private By fldValue = By.xpath("//h6[text()=' PH']/following-sibling::div/span");
			
	
	@Given("I Open the suretreat application")
	public void i_Open_the_suretreat_app() {
		try {
	          assertTrue(BaseTest.LaunchApp(driver, "https://suretreat.zodiac-dev.com/en-US"));
		}catch(Exception e) {
	    		driver.quit();
		}		
	}

	@When("I click on {string} button")
	public void i_click_On_Button(String btnName) throws Exception {
		assertTrue(BaseTest.clickButton(driver,By.xpath("//button[text()='"+btnName+"']")));  
	}
	
	@When("I Select {string} Radio button")
	public void i_Select_Radio_Button(String btnName) throws Exception {
		assertTrue(BaseTest.clickButton(driver,By.xpath("//label[contains(text(),'"+btnName+"')]/preceding-sibling::input")));  
	}
	

	@When("I Enter email as {string}")
	public void i_Enter_Email(String email) throws Exception {
		assertTrue(BaseTest.enterValue(driver,emailFld,email));
	}
	
	@When("I Enter password as {string}")
	public void i_Enter_Password(String password) throws Exception {
		assertTrue(BaseTest.enterValue(driver,pwdFld,password));
	}
	
	@And("I Scroll Down")
	public void i_ScrollDown() throws Exception {
		BaseTest.scrollWindow(driver);
	}
	
	@And("I Scroll Down of the page")
	public void i_ScrollDown_Page() throws Exception {
		BaseTest.scrollDownWindowPage(driver);
	}
	
	@And("I Scroll Middle")
	public void i_Scroll_Middle() throws Exception {
		BaseTest.scrollWindowMiddle(driver);
	}
	
	@And("I Scroll Up of the Page")
	public void i_Scroll_Up() throws Exception {
		BaseTest.scrollWindowUp(driver);
	}
	
    @When("I Enter the value {string} in field {string}")
    public void i_Enter_The_Value(String value,String field) throws Exception {
    	assertTrue(BaseTest.enterValue(driver,By.xpath("//label[text()='"+field+"']/following-sibling::div/input"),value));
    }
    
    @Then("I Should see the {string} value as {string}")
    public void i_Should_See_Field_Value(String field,String value) throws Exception {
      try {
           String elementText=BaseTest.elementText(driver, By.xpath("//h6[contains(text(),'"+field+"')]/following-sibling::div/span"));
           if(elementText.equals(value)) {
        	   softAssert.assertTrue(true);
           }else {
        	   ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,"Expected Text not Match",MediaEntityBuilder.createScreenCaptureFromBase64String(BaseTest.takesScreenShotAs(driver)).build());
           }
         //softAssert.assertAll();
      }catch(Exception e) {
    	  e.printStackTrace();
      }
      
    }
    
    
    @And("I Should see below details")
    public void i_Should_See_Below_Details(DataTable dTable) {
    	   List<Map<String, String>> conditionDts=dTable.asMaps();
    	   
    	    for(Map<String, String> conditionMap:conditionDts) {
    	    	List<String> webElementData = new  ArrayList<String>();
    	    	List<String> tableData = new  ArrayList<String>();
    	    	  if(conditionMap.get("Recommendation").contains(",")) {
    	    	   String[] recommData =conditionMap.get("Recommendation").split(",");
    	    	    for(String sepData:recommData) {
    	    	    	tableData.add(sepData.trim());
    	    	      }
    	    	    }else {
    	    	    	tableData.add(conditionMap.get("Recommendation"));
    	    	    }
    	    	    
    	    	    if(conditionMap.get("Product").contains(",")) {
    	    	    	   String[] productData =conditionMap.get("Product").split(",");
    	    	    	    for(String sepData:productData) {
    	    	    	    	tableData.add(sepData.trim());
    	    	    	    }
    	    	    	    }else {
    	    	    	    	 tableData.add(conditionMap.get("Product"));
    	    	    	    }
    	    	  
    	    	List<WebElement> RecommendationList = driver.findElements(By.xpath("//td[text()='"+conditionMap.get("Condition")+"']/following-sibling::td/ul/li"));
    	    	for(WebElement recommValue:RecommendationList) {
    	    		      webElementData.add(recommValue.getText());
    	    	}
    	    	   System.out.println(webElementData.toString());
    	    	   System.out.println(tableData.toString());
    	    		assertEquals(webElementData, tableData, "Data Matched");
    	    }
    }
    
    @After
    public static void quit_Browser() {
    	driver.quit();
    }
    
    @AfterStep
    public void ScreenShot(Scenario scenario) throws IOException {
    	if(scenario.isFailed()) {
    		scenario.attach(BaseTest.takesScreenShot(driver), "image/png", "image");
    	}
    }
    
}
