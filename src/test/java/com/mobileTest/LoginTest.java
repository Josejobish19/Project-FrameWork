package com.mobileTest;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;


import com.mobileService.LoginPage;

import com.propertyDataHandler.PropertyDataHand;

import webActionHelpers.GetTableSizeList;

public class LoginTest extends BaseTest{
	
	 PropertyDataHand prop = new PropertyDataHand();
	LoginPage loginpage;
	GetTableSizeList ts = new GetTableSizeList();

	public LoginTest()
	{
		super();
	}

@BeforeMethod
@Parameters("browserType")
public void setup(String browserType) {
	driver = launchBrowser(browserType);
		loginpage = new LoginPage(driver);
			}


@Parameters("browserType")
@BeforeGroups(groups = "sanity")
public void grouping(String browserType) {
	driver = launchBrowser(browserType);
		loginpage = new LoginPage(driver);
		
			}

	@Test(priority = 1,groups = "sanity")
	public void  validateURL(){
		
	
		System.out.println("Page URL is :- "+loginpage.pageURL());
		String Actual =loginpage.pageURL();
		String Expected ="https://qalegend.com/mobile_service/panel/login";
		
         Assert.assertEquals(Actual, Expected,"Incorrect URL");
			}
	@Test(priority = 2,groups = "sanity")
	public void validateareUsernameAndPasswordFieldsDisplayed() throws Exception
	{
		
		Assert.assertTrue(loginpage.isUserNamefeildDisplayed(),"Unable to find username feild");
		Assert.assertTrue(loginpage.isPasswordfeildDisplayed(),"Unable to find password feild");
	
	}
	@Test(priority = 3,groups = "sanity")
	public void validateValidLogin() throws IOException
	{
		Properties allProp = prop.readPropertiesFile("configuration.properties");
		
		loginpage.loginUsername( allProp.getProperty("UserName"));
		loginpage.loginPassword( allProp.getProperty("Password"));
		loginpage.loginButtonandSavePassword();
		Assert.assertTrue(loginpage.isLogSuccessMessageDispalyed(),"Invalid page Loaded");
	}
	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	
}
	

}
