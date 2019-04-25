package com.test.automation.orderPlacinginKateSpade;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer 

{
	private int retryCount =1 ;
	private int maxRetryCount = 20;
	
	public boolean retry(ITestResult result)
	{
	if(retryCount<maxRetryCount)
	{
		retryCount++;
		return true;
	}
		return false;
	}

}
