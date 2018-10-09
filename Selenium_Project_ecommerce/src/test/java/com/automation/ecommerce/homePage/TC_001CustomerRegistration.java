package com.automation.ecommerce.homePage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.ecommerce.basePage.Basepage;
import com.automation.ecommerce.pageUI.CreateLoginAccount;

public class TC_001CustomerRegistration extends Basepage {
	public static final Logger log=Logger.getLogger(TC_001CustomerRegistration.class.getName());
  
  @BeforeTest
  public void SetUp() throws Exception {
	browserlaunch(getdata("browser"),getdata("url"));
	
  }
 
@Test
  public void CustomerRegistration() throws Exception {
	log.info("____________TC001 _Test is started___________");
	CreateLoginAccount login=new CreateLoginAccount(driver);
	 login.createAccount();
	log.info("_______________TC001_Test is End___________");

  }

  @AfterTest
  public void close() {
	  
  }

}
