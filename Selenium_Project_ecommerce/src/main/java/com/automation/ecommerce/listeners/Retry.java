package com.automation.ecommerce.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.model.Log;

public class Retry implements IRetryAnalyzer{
	int retrycount;
	int maxretrycount;
	@Override
	public boolean retry(ITestResult result) {
	
		if(retrycount<maxretrycount)
		{
			log("Retrying test"+result.getName()+"with status"+getresultstatusname(result.getStatus())+"for the"+(retrycount+1)+"times");
		retrycount++;
			return true;

		}
		return false;
	}
	private void log(String string) {
		// TODO Auto-generated method stub
		Reporter.log(string);
	}
	private String getresultstatusname(int status) {
		String resultname=null;
		if(status==1)
			resultname="SUCCESS";
		if(status==2)
			resultname="FAIL";
		if(status==3)
			resultname="SKIP";
		return resultname;
	}

}
