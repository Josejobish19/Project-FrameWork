package com.mobileTest;




import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mobileService.AddClient;
import com.mobileService.LoginPage;
import com.mobileService.MobileClientPage;
import com.mobileService.MobileHomePage;
import com.propertyDataHandler.ExcelHandler;



public class AddClientTest extends BaseTest  {
	
	
	MobileClientPage client;
	LoginPage loginpage;
	AddClient addclientpage;
	MobileHomePage homepage;
	ExcelHandler excelobject = new 	ExcelHandler();
	
	
	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws IOException  {
		driver = launchBrowser(browserType);
		loginpage = new LoginPage(driver);
		homepage = new MobileHomePage(driver);
		client = new MobileClientPage(driver);
		addclientpage = new AddClient(driver);
		loginpage.login();
		client.clientsbut();
		
		 
	}                
	
	@Test(priority = 20,enabled = false)
	public void validateAddClientFieldsDisplayed() throws Exception 
	{
		
		
		addclientpage.clickAddClientButton();
		SoftAssert soft = new  SoftAssert();
		soft.assertTrue(addclientpage.isClientAddressFeildDisplayed(),"AddressFeild Element is not displayed");
		soft.assertTrue(addclientpage.isClientcityFeildDisplayed(),"cityFeild Element is not displayed");
		soft.assertTrue(addclientpage.isClientcompanyFeildDisplayed(),"companyFeild Element is not displayed");
		soft.assertTrue(addclientpage.isClientemailFeildDisplayed(),"emailFeild Element is not displayed");
		soft.assertTrue(addclientpage.isClientlocationFeildDisplayed(),"locationFeild Element is not displayed");
		soft.assertTrue(addclientpage.isClientnameFeildDisplayed(),"nameFeild Element is not displayed");
		soft.assertTrue(addclientpage.isClientphoneFeildDisplayed(),"phoneFeild Element is not displayed");
		soft.assertTrue(addclientpage.isClientPincodeFeildDisplayed(),"PincodeFeild Element is not displayed");
		soft.assertTrue(addclientpage.isClientsubmitbuttonDisplayed(),"submitbutton Element is not displayed");
		soft.assertAll();
	
	}
	@Test(priority = 20,enabled = false)
	public void validateClientdetailsEmptySubmision() throws Exception
	{
		addclientpage.clickAddClientButton();
		addclientpage.addClientnameedata("");
		addclientpage.addClientcompanydata("");
		addclientpage.addClientAddressdata("");
		addclientpage.addClientsubmit();
		Assert.assertTrue(addclientpage.isEmptyclientdetailsubmitdisplayed());
		
	}
	@Test(priority = 21,enabled = false)
	public void validateAddclientDetails() throws Exception
	{
		addclientpage.clickAddClientButton();
		ExcelHandler excelobject = new 	ExcelHandler();
		excelobject .setExcelFileSheet("client");
		addclientpage.addClientnameedata(excelobject.getCellData(1, 0));
		addclientpage.addClientcompanydata(excelobject.getCellData(1,1));
		addclientpage.addClientAddressdata(excelobject.getCellData(1, 2));
		addclientpage.addClientcitydata(excelobject.getCellData(1,3));
		addclientpage.addClientphonedata(excelobject.getCellData(1, 4));
		addclientpage.addClientemaildata(excelobject.getCellData(1,5));
		addclientpage.addClientsubmit();
		Assert.assertTrue(addclientpage.isclientdetailsubmiconfrmtdisplayed(),"client is not submited");
	
		
	}
	@Test(priority = 22,enabled = true)
	public void ValidateclientDelete(){
		addclientpage.enterdeleteSerch("zacmike");
		addclientpage.clickclientdelete();
		
	}
	
	

	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	
}
}
