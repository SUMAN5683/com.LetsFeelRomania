package com.tms.LetsFeelRomania.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzerimpClass implements IRetryAnalyzer{
	int count=0;
	int upperlimit=4;
	public boolean retry(ITestResult result) {
		if(count<upperlimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
