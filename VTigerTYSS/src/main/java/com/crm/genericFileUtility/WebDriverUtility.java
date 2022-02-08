package com.crm.genericFileUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility{
	/**
	 * Explicit Wait Method work for the element to be visible till timeout 
	 * @param driver			- get the WebDirver reference Variable as input
	 * @param timeOutInSeconds	- get the number as input to wait
	 * @param element			- get the WebElement to wait till its Visible 
	 */
	public void explicittWaitElementVisibilty(WebDriver driver,int timeOutInSeconds,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	/**
	 * Implicit wait method 
	 * @param driver	- get WebDriver reference variable as input
	 * @param time		- get number and wait for seconds
	 */
	public void implicitWait(WebDriver driver,int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	/**
	 * PageLoad Method wait till the page to load before it throws NoSuchElement Exception
	 * @param driver 	- get WebDriver reference variable as input
	 * @param time		- get number and wait for seconds
	 */
	public void pageLoadWait(WebDriver driver,int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	
		/**		SelectDropDown 
		 * 		Method OverLoading for selectDropDown has different arguments
		 */
	/**
	 * This method is useful for selectByVisibleText
	 * @param element	- get the WebElement as Input to locate
	 * @param text		- get text from where dropdown list has the value 
	 */
	public void selectDropDown(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * This method is useful for selectByIndex
	 * @param element	- get the WebElement as Input to locate
	 * @param index		- get the index in int
	 */
	public void selectDropDown(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method is useful for selectByValue
	 * @param value		- get the value as String
	 * @param element	- get the WebElement as Input to locate
	 */
	public void selectDropDown(String value,WebElement element) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**			Actions
	 * 
	 */
	/**
	 * MouseHover method useful to move to element
	 * @param driver 	- get WebDriver reference variable as input
	 * @param target	- WebElement accepts target in WebElement for moveToElement
	 */
	public void mouseHover(WebDriver driver,WebElement target) {
		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
	}
	
	/**
	 * DoubleClick method useful for double click
	 * @param driver 	- get WebDriver reference variable as input
	 * @param target	- WebElement accepts target in WebElement for double click
	 */
	public void doubleClick(WebDriver driver,WebElement target) {
		Actions act = new Actions(driver);
		act.doubleClick(target).build().perform();
	}
	
	/**
	 * RightClick method useful for right click
	 * @param driver 	- get WebDriver reference variable as input
	 * @param target	- WebElement accepts target in WebElement for right click
	 */
	public void rightClick(WebDriver driver,WebElement target) {
		Actions act = new Actions(driver);
		act.contextClick(target).build().perform();
	}
	
	/**		Handling Window
	 * Switch tab used switch from one Window to another Window
	 * @param driver 	- get WebDriver reference variable as input
	 * @param index 	- index as int to switch from one Window to another Window
	 */
	public void switchWindow(WebDriver driver,int index) {
		ArrayList<String> arr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(arr.get(index));
	}
	
	/**
	 * Accepts Alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	/**
	 *  Cancel Alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	/**
	 * Sent Value into Alert
	 * @param driver
	 * @param promptValue 	- Accepts in String. Which value is sent into Alert
	 */
	public void promptAlert(WebDriver driver,String promptValue) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(promptValue);
	}
	
	/**
	 * Get the Alert Text and return the text
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();		// returns alert text
	}
	
	/**
	 * Takes Screenshot
	 * @param driver
	 * @throws IOException will be handle when it calls
	 */
	public void takeScreenShot(WebDriver driver,String fileLocation, String fileName,String fileExtension) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(fileLocation+"\\"+fileName+fileExtension));
	}
}
