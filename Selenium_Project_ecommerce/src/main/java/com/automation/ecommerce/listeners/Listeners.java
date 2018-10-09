package com.automation.ecommerce.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener{
public WebDriver driver;
	
	public void onTestStart(ITestResult result) {
		Reporter .log("Test case is Started"+result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter .log("Test case is Passed"+result.getMethod().getMethodName());
		Calendar c=Calendar.getInstance();
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss");
		String methodname=result.getName();
		
		if(result.isSuccess()) {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String reportDirectory=(new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/automation/ecommerce/");
			File dest=new File((String)reportDirectory+"/passedScreens/"+methodname+" "+s.format(c.getTime())+".png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.log("<a hef=' "+dest.getAbsolutePath()+" '>"+"<img src=' "+dest.getAbsolutePath()+" 'height='100' width='100'/> </a>");
		}
		
	}

	public void onTestFailure(ITestResult result) {
		Reporter .log("Test case is Failed"+result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		Reporter .log("Test case is Skipped"+result.getMethod().getMethodName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
