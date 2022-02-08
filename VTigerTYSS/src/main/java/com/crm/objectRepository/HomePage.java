package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericFileUtility.WebDriverUtility;

public class HomePage {
	
	public WebDriver driver;
	WebDriverUtility webDriverutility = new WebDriverUtility();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * SignOut
	 */
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private  WebElement followingLead;
	
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement button;
	
	public void signOut() {
		webDriverutility.mouseHover(driver, followingLead);
		webDriverutility.mouseHover(driver, button);
		webDriverutility.doubleClick(driver, button);
	}
	
	/**
	 * 		Lead
	 */
	@FindBy(xpath="(//a[contains(text(),'Leads')])[1]")
	private WebElement clickLead;
	
	public void clickLead() {
		clickLead.click();
	}
	
}