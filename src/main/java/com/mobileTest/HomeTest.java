package com.mobileTest;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;




import com.mobileService.MobileHomePage;

import graphql.Assert;

public class HomeTest extends LoginTest{
	MobileHomePage homepage;
	
	
	
	@Test(priority= 4, enabled = false)
	public void validateUserDetailsDisplayed()
	{
		 homepage = new MobileHomePage(driver);
		 String Username = homepage.isUserDetailsDisplayed();
		 AssertJUnit.assertEquals(Username,"Joe Jacobs" );
	Assert.assertTrue(homepage.isUseronlineStatusDisplayed());
	
		
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
		AssertJUnit.assertTrue(homepage.isLoadingmessagedisplayed());
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
	@Test(priority = 10)
	public void validatadateEventMarker()
	{
		homepage.dateEventMarker("Happy Birthday");
		Assert.assertTrue(homepage.eventAddSuccess());
	}
	@Test(priority = 11)
			public void validateEventDelete()
			{
		homepage.deleteEventMarker();
			}

}
