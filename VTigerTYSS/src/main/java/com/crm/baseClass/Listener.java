package com.crm.baseClass;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends BaseClass implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " is started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " is success");
		try {
			webDriverutility.takeScreenShot(BaseClass.staticDriver,
					"I:\\Selenium\\1 Selenium Class\\2 Month\\Own Learn 1",
					result.getName() + " " + javaUtility.getSystemDate(), ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result.getName() + " ScreenShot taken");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " is failed");
		System.out.println("Started screenshot in TestFailure");

		try {
			webDriverutility.takeScreenShot(BaseClass.staticDriver,
					"I:\\Selenium\\1 Selenium Class\\2 Month\\Own Learn 1",
					result.getName() + " " + javaUtility.getSystemDate(), ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result.getName() + " ScreenShot taken");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	/*
	 * ExtentReports report; ExtentTest test;
	 * 
	 * 
	 * public void onTestStart(ITestResult result) {
	 * System.out.println(result.getName()+" is started");
	 * test=report.createTest(result.getMethod().getMethodName()); }
	 * 
	 * public void onTestSuccess(ITestResult result) {
	 * System.out.println(result.getName()+" is success"); try {
	 * webDriverutility.takeScreenShot(BaseClass.staticDriver,
	 * "I:\\Selenium\\1 Selenium Class\\2 Month\\Own Learn 1",
	 * result.getName()+" "+javaUtility.getSystemDate(), ".png"); } catch
	 * (IOException e) { e.printStackTrace(); }
	 * System.out.println(result.getName()+" ScreenShot taken");
	 * 
	 * test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	 * 
	 * //test.log(Status.PASS, result.getMethod().getMethodName()+" is failed");
	 * test.log(Status.PASS, result.getThrowable()); try { String path
	 * ="I:\\Selenium\\1 Selenium Class\\2 Month\\Own Learn 1"+
	 * result.getName()+" "+javaUtility.getSystemDate()+ ".png";
	 * test.addScreenCaptureFromPath(path); } catch (Throwable e) {
	 * e.printStackTrace(); }
	 * System.out.println(result.getName()+" Screenshot Added in Extent"); }
	 * 
	 * public void onTestFailure(ITestResult result) {
	 * System.out.println(result.getName()+" is failed");
	 * System.out.println("Started screenshot in TestFailure");
	 * 
	 * try { webDriverutility.takeScreenShot(BaseClass.staticDriver,
	 * "I:\\Selenium\\1 Selenium Class\\2 Month\\Own Learn 1",
	 * result.getName()+" "+javaUtility.getSystemDate(), ".png"); } catch
	 * (IOException e) { e.printStackTrace(); }
	 * System.out.println(result.getName()+" ScreenShot taken");
	 * 
	 * test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
	 * test.log(Status.FAIL, result.getThrowable()); try { String path
	 * ="I:\\Selenium\\1 Selenium Class\\2 Month\\Own Learn 1"+
	 * result.getName()+" "+javaUtility.getSystemDate()+ ".png";
	 * test.addScreenCaptureFromPath(path); } catch (Throwable e) {
	 * e.printStackTrace(); }
	 * System.out.println(result.getName()+" Screenshot Added in Extent");
	 * 
	 * }
	 * 
	 * public void onTestSkipped(ITestResult result) {
	 * System.out.println(result.getName()+" is skipped"); test.log(Status.SKIP,
	 * result.getMethod().getMethodName()+" is skipped"); test.log(Status.SKIP,
	 * result.getThrowable());
	 * 
	 * }
	 * 
	 * public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	 * 
	 * 
	 * }
	 * 
	 * public void onStart(ITestContext context) { ExtentHtmlReporter htmlReport=new
	 * ExtentHtmlReporter(new
	 * File(".\\ExtentReport\\report "+javaUtility.getSystemDate()+".html"));
	 * htmlReport.config().setDocumentTitle("Extent Report");
	 * htmlReport.config().setTheme(Theme.STANDARD);
	 * htmlReport.config().setReportName("Functional Test"); report=new
	 * com.aventstack.extentreports.ExtentReports();
	 * report.attachReporter(htmlReport); report.setSystemInfo("TestURL",
	 * "https://example.com"); report.setSystemInfo("Platform", "Windows 10");
	 * report.setSystemInfo("Reporter Name", "Kiruthik Pranav"); }
	 * 
	 * public void onFinish(ITestContext context) { report.flush(); }
	 */
}