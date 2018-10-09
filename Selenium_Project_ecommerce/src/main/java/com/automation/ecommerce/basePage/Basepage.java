package com.automation.ecommerce.basePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Basepage {
	  public  static WebDriver driver;
	  public static final String path="./config.properties";
	  public String log4jpath="log4j.properties";

	  
	  public String getdata(String key ) throws Exception {
		  File f=new File(path);
		  FileInputStream fi=new FileInputStream(f);
		  Properties p=new Properties();
		  p.load(fi);
		 return  p.getProperty(key);
		  
		  }
	  public int randomNumber() {
		  Random rad = new Random();
		  int random=  rad.nextInt(9999);
	      return random ; 
	  }
		public void selectOption(WebElement element, int option) {
			Select s=new Select(element);
			s.selectByIndex(option);
			
		}
		public void elementvisible(int timevalue, WebElement element) {
			WebDriverWait w=new WebDriverWait(driver,timevalue);
			w.until(ExpectedConditions.visibilityOf(element));
		}
		public void implicitwait(long time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
	  
	  public void browserlaunch(String browser,String url) {
		  if(browser.equalsIgnoreCase("chrome")) {
			  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			  driver=new ChromeDriver();
		 }else if(browser.equalsIgnoreCase("firefox")){
			  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			  driver=new FirefoxDriver();
		 }else if(browser.equalsIgnoreCase("ie")) {
			 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			  driver=new InternetExplorerDriver();
		 }else {
			 System.out.println("invalid browser name");
		 }
		  driver.get(url);
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();	 
		 PropertyConfigurator.configure(log4jpath);

	  }
	  

}
