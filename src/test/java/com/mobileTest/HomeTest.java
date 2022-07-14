package com.mobileTest;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mobileService.LoginPage;
import com.mobileService.MobileHomePage;
import com.propertyDataHandler.PropertyDataHand;

import automationBase.AutomationBase;

public class HomeTest extends AutomationBase {
	
	
	MobileHomePage homepage;
	LoginPage loginPage;
		
	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws IOException {
		driver = launchBrowser(browserType);
		homepage = new MobileHomePage(driver);
		loginPage = new LoginPage(driver);
			
			loginPage.login();
		}
	
	@Test(priority= 4)
	public void validateUserDetailsDisplayed() 
	{
		
		homepage = new MobileHomePage(driver);
		 
	
		 Assert.assertTrue(homepage.isUserDetailsDisplayed());
	//soft.assertTrue(homepage.isUseronlineStatusDisplayed());
	
		
	}
	
	@Test(priority= 5)
	public void validateHomePageFeilds()
	{
		homepage = new MobileHomePage(driver);
		SoftAssert soft = new SoftAssert();
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
		Assert.assertTrue(homepage.isValidEmailIddisplayed(),"Element is not displayed");
	}
	@Test(priority = 7)
	public void validatevalidEmailidMessage()
	{
		homepage.homeEmailid("josejobish19@gmail.com");
		homepage.homeEmailsubject("Hello world");
		homepage.homeEmailMessage("Welcome to obsqura");
		Assert.assertTrue(homepage.isLoadingmessagedisplayed(),"Element is not displayed");
	}
	
	@Test(priority = 8)
	public void validateEmptySMS()
	{
		homepage.smsPhoneNo(" ");
		homepage.smsContent(" ");
		homepage.smsSend();
		Assert.assertTrue(homepage.isEmptySMSdisplayed(),"Element is not displayed");
	}
	
	@Test(priority = 9,dataProvider="Credentials")
	public void validateSMSUsingDataProvider(String phone , String content) throws InterruptedException {
		homepage.smsPhoneNo(phone);
		homepage.smsContent(content);
		
		homepage.smsSend();
		
		Assert.assertTrue(homepage.smsConfirm(),"Element is not displayed");
		
	}
	@DataProvider(name="Credentials")
	public Object[][] getData() throws IOException{
PropertyDataHand prop = new PropertyDataHand();
		
		Properties allProp = prop.readPropertiesFile("configuration.properties");
	Object[][] data = new Object[1][2];
	
	data[0][0]=allProp.getProperty("PHONE");
	data[0][1]=allProp.getProperty("MessageContent");

	
	return data;
		
	}
	@Test(priority = 10)
	public void validateMainNavigationFields()
	{
		SoftAssert soft = new SoftAssert();
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
	
	@Test(priority = 11)
	public void validatadateEventMarker()
	{
		homepage.dateEventMarker("Happy Birthday");
		Assert.assertTrue(homepage.eventAddSuccess(),"Element is not displayed");
	}
	@Test(priority = 12)
			public void validateEventDelete()
			{
		homepage.deleteEventMarker();
		
			}

	
@AfterMethod
	public void Close()
	{

	driver.quit();
	}
	
}



