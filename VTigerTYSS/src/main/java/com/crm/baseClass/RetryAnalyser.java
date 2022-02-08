package com.crm.baseClass;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	
	int count = 0;
	int resultCount = 3;
	public boolean retry(ITestResult result) {
		while(count<resultCount) {
			count++;
			return true;
		}
		return false;
	}
	
}