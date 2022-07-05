package com.mobileTest;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobileService.LoginPage;
import com.mobileService.MobileHomePage;
import com.propertyDataHandler.PropertyDataHandler;

public class HomeTest extends LoginTest{
	
	
	MobileHomePage homepage;
	LoginPage loginPage;

	@BeforeMethod
	public void setup() throws IOException {
		
		homepage = new MobileHomePage(driver);
		loginpage = new LoginPage(driver);
		
		/*
		 * PropertyDataHandler prop = new PropertyDataHandler();
		
		Properties allProp = prop.readPropertiesFile("configuration.properties");
	
		homepage =  homepage.login (allProp.getProperty("UserName"), allProp.getProperty("Password"));
		 */
	}
	
	@Test(priority= 4)
	public void validateUserDetailsDisplayed() 
	{
		
		homepage = new MobileHomePage(driver);
		 
	
		 Assert.assertTrue(homepage.isUserDetailsDisplayed());
	//Assert.assertTrue(homepage.isUseronlineStatusDisplayed());
	
		
	}
	
	@Test(priority= 5)
	public void validateHomePageFeilds()
	{
		homepage = new MobileHomePage(driver);
		 
		Assert.assertTrue(homepage.isHomeFeildDisplayed());
		Assert.assertTrue(homepage.isServiceManagemenDisplayed());
		Assert.assertTrue(homepage.isClientDisplayed());
		Assert.assertTrue(homepage.isInventoryProductsDisplayed());
		Assert.assertTrue(homepage.isQuickEmailDisplayed());
		Assert.assertTrue(homepage.isQuickSMSDisplayed());
		Assert.assertTrue(homepage.isReparationDisplayed());
		Assert.assertTrue(homepage.isRevenueChartDisplayed());
		Assert.assertTrue(homepage.isStockChartDisplayed());
	
	}
	@Test(priority = 6)
	public void validateInvalidEmailidMessage()
	{
		homepage.homeEmailid("jaaoaoaopa");
		homepage.homeEmailsubject("Hello world");
		homepage.homeEmailMessage("Welcome to obsqura");
		Assert.assertTrue(homepage.isValidEmailIddisplayed());
	}
	@Test(priority = 7)
	public void validatevalidEmailidMessage()
	{
		homepage.homeEmailid("josejobish19@gmail.com");
		homepage.homeEmailsubject("Hello world");
		homepage.homeEmailMessage("Welcome to obsqura");
		Assert.assertTrue(homepage.isLoadingmessagedisplayed());
	}
	
	@Test(priority = 8)
	public void validateEmptySMS()
	{
		homepage.smsPhoneNo(" ");
		homepage.smsContent(" ");
		homepage.smsSend();
		Assert.assertTrue(homepage.isEmptySMSdisplayed());
	}
	@Test(priority = 9)
	public void validateSMS()
	{
		homepage.smsPhoneNo("+918893247037");
		homepage.smsContent("Hello Friends");
		homepage.smsSend();
		Assert.assertTrue(homepage.smsConfirm());
	}
	@Test(priority = 10,enabled = false)
	public void validatadateEventMarker()
	{
		homepage.dateEventMarker("Happy Birthday");
		Assert.assertTrue(homepage.eventAddSuccess());
	}
	@Test(priority = 11,enabled = false)
			public void validateEventDelete()
			{
		homepage.deleteEventMarker();
			}
	@Test(priority = 12)
	public void validateMainNavigationFields()
	{
		Assert.assertTrue(homepage.isMAINNAVIGATIONDisplayed());
		Assert.assertTrue(homepage.isActivityLogDisplayed());
		Assert.assertTrue(homepage.isHomeDisplayed());
		Assert.assertTrue(homepage.isClientsDisplayed());
		Assert.assertTrue(homepage.isInventoryDisplayed());
		Assert.assertTrue(homepage.isPOSDisplayed());
		Assert.assertTrue(homepage.isPurchasesDisplayed());
		Assert.assertTrue(homepage.isSystemSettingLogDisplayed());
		}
	
@AfterMethod


	public void Close()
	{

		//loginpage.loggout();
	}
	
}



