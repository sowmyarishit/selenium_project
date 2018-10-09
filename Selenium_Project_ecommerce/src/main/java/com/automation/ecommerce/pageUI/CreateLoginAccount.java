package com.automation.ecommerce.pageUI;


import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automation.ecommerce.basePage.Basepage;

public class CreateLoginAccount extends Basepage{
public static final Logger log=Logger.getLogger(CreateLoginAccount.class.getName());

	@FindBy(linkText="Sign in")
	WebElement signinloc;
	
	@FindBy(name="email_create")
	WebElement emailloc;
	
	@FindBy(xpath="//*[@class='icon-user left']")
	WebElement createaccloc;
	
	@FindBy(id="id_gender2")
	WebElement genderidloc;
	
	@FindBy(name="customer_firstname")
	WebElement firstname;
	
	@FindBy(name="customer_lastname")
	WebElement custlastname;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(name="days")
	WebElement days;
	
	@FindBy(name="months")
	WebElement months;
	
	@FindBy(name="years")
	WebElement years;
	
	@FindBy(name="company")
	WebElement companyloc;
	
	@FindBy(name="address1")
	WebElement addloc;
	
	@FindBy(name="city")
	WebElement cityloc;
	
	@FindBy(name="id_state")
	WebElement stateloc;
	
	@FindBy(name="postcode")
	WebElement postalloc;
	
	@FindBy(name="id_country")
	WebElement countryloc;
	
	@FindBy(name="phone_mobile")
	WebElement phoneloc;
	
	@FindBy(name="alias")
	WebElement aliasloc;
	
	@FindBy(xpath="//*[text()='Register']")
	WebElement regloc;
	
	@FindBy(xpath="//*[text()='Create an account']")
	WebElement createaccount;
	@FindBy(xpath="(//*[text()='My account'])[2]")
	WebElement myaccount;


	public CreateLoginAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createAccount() throws Exception {
		signinloc.click();
		log.info("Clicked on signin button with object: "+signinloc.toString());
		emailloc.sendKeys(getdata("firstname")+getdata("lastname")+randomNumber()+getdata("domainname"));
	   log.info("Entering Email ID:"+emailloc.getAttribute("value")+"Using object"+emailloc.toString());
		createaccloc.click();
		log.info("Clicked on createaccount button with object: "+createaccloc.toString());
		implicitwait(10);
		
		elementvisible(30, createaccount);
		assertEquals("CREATE AN ACCOUNT", createaccount.getText());
		
		log.info("Verify customer info page by using object :"+createaccount.toString());
		genderidloc.click();
		log.info("Clicked on genderid button with object: "+genderidloc.toString());
		firstname.sendKeys(getdata("firstname"));
		log.info("Entering firstname with object: "+firstname.toString());
		custlastname.sendKeys(getdata("lastname"));
		log.info("Entering custlastname with object: "+custlastname.toString());
		password.sendKeys(getdata("password"));
		log.info("Entering password with object: "+password.toString());
		selectOption(days,5);
		log.info("Selecting days with object: "+days.toString());	
		selectOption(months,7);
		log.info("Selecting months with object: "+months.toString());
		selectOption(years,8);	
		log.info("Selecting years with object: "+years.toString());
		companyloc.sendKeys(getdata("company"));
		log.info("Entering company with object: "+companyloc.toString());
		addloc.sendKeys(getdata("address"));
		log.info("Entering address with object: "+addloc.toString());
		cityloc.sendKeys(getdata("city"));
		log.info("Entering city with object: "+cityloc.toString());
		selectOption(stateloc,10);	
		log.info("Selecting state with object: "+stateloc.toString());		
		postalloc.sendKeys(getdata("postalcode"));
		log.info("Entering postal with object: "+postalloc.toString());
		selectOption(countryloc,1);
		log.info("Selecting country with object: "+countryloc.toString());	
		phoneloc.sendKeys(getdata("phonenumber"));
		log.info("Entering phone with object: "+phoneloc.toString());
		regloc.click();
		log.info("Clicked on regloc button with object: "+regloc.toString());	
		implicitwait(10);
		elementvisible(30,myaccount);
		assertEquals("MY ACCOUNT", myaccount.getText());
		log.info("Verify customer info page by using object :"+myaccount.toString());

		
	}




}
