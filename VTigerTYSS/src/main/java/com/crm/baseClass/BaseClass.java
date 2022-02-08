package com.crm.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.crm.fetchFromExternalFile.FetchFromProperty;
import com.crm.fetchFromExternalFile.IPathConstants;
import com.crm.genericFileUtility.JavaUtilities;
import com.crm.genericFileUtility.WebDriverUtility;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver staticDriver;
	public WebDriverUtility webDriverutility = new WebDriverUtility();
	public JavaUtilities javaUtility = new JavaUtilities();
	FetchFromProperty propertyData = new FetchFromProperty();
	LoginPage loginPage;
	HomePage homePage;
	
	/*
	@BeforeClass
	public void browserOpen() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiruthik Pranav\\git\\Git\\VTigerTYSS\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propertyData.fetchFromProperty("url"));
		//staticDriver = driver;
	}*/
	
	
	@Parameters(value="browser")
	@BeforeClass(groups= {"Smoke","Full Regression"})
	public void browserOpen(String browser) {
		if(browser.equalsIgnoreCase("chrome")){
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiruthik Pranav\\git\\Git\\VTigerTYSS\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(propertyData.fetchFromProperty("url"));
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kiruthik Pranav\\git\\Git\\VTigerTYSS\\src\\main\\resources\\chromedriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(propertyData.fetchFromProperty("url"));
		}
		else
			System.out.println("Check Browser Initialized ot Not");
		staticDriver = driver;
	}
	
	@BeforeMethod(groups= {"Smoke","Full Regression"})
	public void login() {
		webDriverutility.implicitWait(driver, IPathConstants.waitingTime);
		loginPage = new LoginPage(driver);
		loginPage.userName();
		loginPage.password();
		loginPage.submitButton();
	}
	
	@AfterMethod(groups= {"Smoke","Full Regression"})
	public void logout() {
		homePage = new HomePage(driver);
		webDriverutility.implicitWait(driver, IPathConstants.waitingTime);
		homePage.signOut();
	}
	
	@AfterClass(groups= {"Smoke","Full Regression"})
	public void browserClose() {
		driver.close();
	}
	
}
