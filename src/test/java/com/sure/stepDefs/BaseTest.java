package com.sure.stepDefs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BaseTest {

	public static boolean clickButton(WebDriver driver, By ele) throws Exception {
		if (waitForCondition(driver, "Clickable", ele)) {
			FindAnElement(driver, ele).click();
			return true;
		}
		return false;
	}

	public static void clickButtonUsingJS(WebDriver driver, By ele) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", FindAnElement(driver, ele));
	}

	public static boolean LaunchApp(WebDriver driver, String url) {
		driver.get(url);
		if (waitForCondition(driver, "PageLoad", null)) {
			return true;
		}
		return false;
	}

	public static boolean enterValue(WebDriver driver, By ele, String text) throws Exception {
		if (waitForCondition(driver, "Visibility", ele)) {
			FindAnElement(driver, ele).clear();
			FindAnElement(driver, ele).sendKeys(text);
			return true;
		}
		return false;
	}
	
	public static String elementText(WebDriver driver, By ele) throws Exception {
		if (waitForCondition(driver, "Visibility", ele)) {
			String text=FindAnElement(driver, ele).getText();
			return text;
		}
		return "";
	}

	public static void scrollWindow(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 3000)");
		Thread.sleep(2000);
	}

	public static void scrollDownWindowPage(WebDriver driver) throws Exception {
		Actions a = new Actions(driver);
		a.moveToElement(FindAnElement(driver, By.xpath("//label[text()='Sanitizers*']"))).click().build().perform();
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
	}

	public static void scrollWindowMiddle(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 550)");
		Thread.sleep(2000);
	}
	
	public static void scrollWindowUp(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)");
		Thread.sleep(2000);
	}

	public static WebElement FindAnElement(WebDriver driver, By by) throws Exception {
		return driver.findElement(by);
	}

	public static boolean waitForCondition(WebDriver driver, String TypeOfWait, By by) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
			switch (TypeOfWait) {
			case "PageLoad":
				wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
				return true;
			case "Clickable":
				wait.until(ExpectedConditions.elementToBeClickable(FindAnElement(driver, by)));
				return true;
			case "Presence":
				wait.until(ExpectedConditions.presenceOfElementLocated(by));
				return true;
			case "Visibility":
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				return true;
			case "NotPresent":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
				return true;
			default:
				Thread.sleep(3 * 1000);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("wait For Condition \"" + TypeOfWait + "\" isn't supported.");
		}
		return false;
	}
	
	public static byte[] takesScreenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		 byte[] fileContent = FileUtils.readFileToByteArray(scrFile);
		 return fileContent;
	}

	public static String takesScreenShotAs(WebDriver driver) throws IOException {
		
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		
	}
}
