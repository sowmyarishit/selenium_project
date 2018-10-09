package com.automation.ecommerce.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		IRetryAnalyzer r=annotation.getRetryAnalyzer();
		if(r==null) {
			annotation.setRetryAnalyzer(Retry.class);
		}
	}

}
