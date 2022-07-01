package com.mobileTest;


import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import com.mobileService.LoginPage;
import com.propertyDataHandler.PropertyDataHandler;

public class LoginTest extends BaseTest{
	
	 PropertyDataHandler prop = new PropertyDataHandler();
	LoginPage loginpage = new LoginPage(driver);
	@Test(priority = 1)
	public void  validateURL(){
		loginpage = new LoginPage(driver);
		
		System.out.println("Page URL is :- "+loginpage.pageURL());
		String Actual =loginpage.pageURL();
		String Expected ="https://qalegend.com/mobile_service/panel/login";
		
		Assert.assertEquals(Actual, Expected,"Incorrect URL");
		
	}
	@Test(priority = 2)
	public void validateareUsernameAndPasswordFieldsDisplayed()
	{
				
		Assert.assertTrue(loginpage.isUserNamefeildDisplayed(),"Unable to find username feild");
		Assert.assertTrue(loginpage.isPasswordfeildDisplayed(),"Unable to find password feild");
	
	}
	@Test(priority = 3)
	public void validateValidLogin() throws IOException
	{
		Properties allProp = prop.readPropertiesFile("configuration.properties");
		
		loginpage.loginUsername( allProp.getProperty("UserName"));
		loginpage.loginPassword( allProp.getProperty("Password"));
		loginpage.loginButtonandSavePassword();
		Assert.assertTrue(loginpage.isLogSuccessMessageDispalyed(),"Invalid page Loaded");
	}
	

}
