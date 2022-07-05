package com.mobileTest;

import java.io.IOException;
import java.util.Properties;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mobileService.LoginPage;
import com.mobileService.MobileHomePage;
import com.propertyDataHandler.PropertyDataHandler;

public class HomeTest extends LoginTest{
	
	
	MobileHomePage homepage;
	LoginPage loginPage;
		SoftAssert soft = new SoftAssert();

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
		 
	
		 soft.assertTrue(homepage.isUserDetailsDisplayed());
	//soft.assertTrue(homepage.isUseronlineStatusDisplayed());
	
		
	}
	
	@Test(priority= 5)
	public void validateHomePageFeilds()
	{
		homepage = new MobileHomePage(driver);
		 
		soft.assertTrue(homepage.isHomeFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isServiceManagemenDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isClientDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isInventoryProductsDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isQuickEmailDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isQuickSMSDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isReparationDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isRevenueChartDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isStockChartDisplayed(),"Element is not displayed");
		soft.assertAll();
	
	}
	@Test(priority = 6)
	public void validateInvalidEmailidMessage()
	{
		homepage.homeEmailid("jaaoaoaopa");
		homepage.homeEmailsubject("Hello world");
		homepage.homeEmailMessage("Welcome to obsqura");
		soft.assertTrue(homepage.isValidEmailIddisplayed(),"Element is not displayed");
	}
	@Test(priority = 7)
	public void validatevalidEmailidMessage()
	{
		homepage.homeEmailid("josejobish19@gmail.com");
		homepage.homeEmailsubject("Hello world");
		homepage.homeEmailMessage("Welcome to obsqura");
		soft.assertTrue(homepage.isLoadingmessagedisplayed(),"Element is not displayed");
	}
	
	@Test(priority = 8)
	public void validateEmptySMS()
	{
		homepage.smsPhoneNo(" ");
		homepage.smsContent(" ");
		homepage.smsSend();
		soft.assertTrue(homepage.isEmptySMSdisplayed(),"Element is not displayed");
	}
	@Test(priority = 9)
	public void validateSMS()
	{
		homepage.smsPhoneNo("+918893247037");
		homepage.smsContent("Hello Friends");
		homepage.smsSend();
		soft.assertTrue(homepage.smsConfirm(),"Element is not displayed");
	}
	@Test(priority = 10,enabled = false)
	public void validatadateEventMarker()
	{
		homepage.dateEventMarker("Happy Birthday");
		soft.assertTrue(homepage.eventAddSuccess(),"Element is not displayed");
	}
	@Test(priority = 11,enabled = false)
			public void validateEventDelete()
			{
		homepage.deleteEventMarker();
			}
	@Test(priority = 12)
	public void validateMainNavigationFields()
	{
		soft.assertTrue(homepage.isMAINNAVIGATIONDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isActivityLogDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isHomeDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isClientsDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isInventoryDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isPOSDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isPurchasesDisplayed(),"Element is not displayed");
		soft.assertTrue(homepage.isSystemSettingLogDisplayed(),"Element is not displayed");
		soft.assertAll();
		}
	
@AfterMethod


	public void Close()
	{

		//loginpage.loggout();
	}
	
}



