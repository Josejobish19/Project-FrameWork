package com.mobileTest;



import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.mobileService.LoginPage;
import com.mobileService.MobileClientPage;
import com.mobileService.MobileHomePage;
import com.propertyDataHandler.PropertyDataHand;




public  class ClientTest  extends  BaseTest {
	
	MobileClientPage client ;
	LoginPage loginPage;
	MobileHomePage homepage;
	
	public ClientTest()
	{
		super();
	}
	
	
	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws IOException  {
		driver = launchBrowser(browserType);
		loginPage = new LoginPage(driver);
		homepage = new MobileHomePage(driver);
		client = new MobileClientPage(driver);
		loginPage.login();
		client.clientsbut();
		 
	}                
	
	@Test(priority = 13)
	public void validateClientpage()
	{
		 client.clickClient();
		Assert.assertTrue(client.isCustomersfeildDisplayed());
	}
	
	@Test(priority = 14)
	public void validateClientfields()
	{
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(client.isCustomersfeildDisplayed());
		soft.assertTrue(client.isAddClientButtondisplayed());
		soft.assertTrue(client.isChangecolumnsButtondisplayed());
		soft.assertTrue(client.istableLengthButtondisplayed());
		soft.assertTrue(client.isclientSearchdisplayed());
	 soft.assertAll();
}
	

	@Test(priority = 16)
	public void validateClientTablesize() throws Throwable 
	{
		client.ClientsearchResultText();
				System.out.println("Total size is "+client.tableClientsize1());
	}
	
	@Test(priority = 17)
	public void validateClientSerchResult() throws Throwable  {
		
PropertyDataHand prop = new PropertyDataHand();
		
		Properties allProp = prop.readPropertiesFile("configuration.properties");
		
		client.clientsearchResult(allProp.getProperty("clientSearch"));
		System.out.println(client.ClientsearchResultText());
		Assert.assertTrue(client.isClientsearchResultdisplayed(),"Element is not displayed");
	
		
	}@Test(priority = 18)
	public void validateClientActionbuttonsWork() throws Throwable {
		
		client = new MobileClientPage(driver);
		client.clickClientAction();
		Assert.assertTrue(client.isDeleteSelectedbuttondisplayed(),"Element is not displayed");
		
	}
	@Test(priority = 19)
	public void validateClientActionbuttons() throws InterruptedException {
		
		client.clickClientAction();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(client.isDeleteSelectedbuttondisplayed(),"Element is not displayed");
		soft.assertTrue(client.isclientActionsbuttondisplayed(),"Element is not displayed");
		soft.assertTrue(client.isExporttoExcelfilebuttondisplayed(),"Element is not displayed");
		soft.assertTrue(client.isExporttoPDFfilebuttondisplayed(),"Element is not displayed");
		soft.assertTrue(client.isAddCustomersbyCSVbuttondisplayed(),"Element is not displayed");
		soft.assertAll();
	
		
	}
	@Test(priority = 19)
	public void validateClientAdd() 
	{
		client = new MobileClientPage(driver);
		client.clickClientAdd();
	}
	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	
}
	
}
