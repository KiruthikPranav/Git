package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.fetchFromExternalFile.FetchFromProperty;

public class LoginPage{
	
	FetchFromProperty loginData = new FetchFromProperty();
	
	/**
	 * Create Constructor
	 * Use PageFactory.initElements() to initialize driver
	 */
	public WebDriver driver;	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	public void userName() {
		userName.sendKeys(loginData.fetchFromProperty("username"));
	}
	
	public void password() {
		password.sendKeys(loginData.fetchFromProperty("password"));
	}
	
	public void submitButton() {
		submitButton.click();
	}
	
}
