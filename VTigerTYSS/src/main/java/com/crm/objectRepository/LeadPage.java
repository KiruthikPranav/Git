package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericFileUtility.WebDriverUtility;

public class LeadPage {
	
	public WebDriver driver;
	WebDriverUtility webDriverUtility = new WebDriverUtility();
	
	public LeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//a[contains(text(),'Leads')])[2]/following::img[1]")
	private WebElement createLeadImage;
	
	public void clickLeadImage() {
		createLeadImage.click();
	}
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement firstName;
	
	public void firstName() {
		webDriverUtility.selectDropDown("Mr.", firstName);
	}
	
	
}
