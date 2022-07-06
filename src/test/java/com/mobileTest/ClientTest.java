package com.mobileTest;



import java.io.IOException;
import java.util.List;
import java.util.Properties;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mobileService.LoginPage;
import com.mobileService.MobileClient;
import com.mobileService.MobileHomePage;
import com.propertyDataHandler.PropertyDataHandler;




public  class ClientTest  extends  HomeTest{
	
	MobileClient client ;
	MobileHomePage homepage;
	LoginPage loginPage;
	SoftAssert soft = new SoftAssert();
	
	
	@BeforeMethod
	public void setup() throws IOException {
		
		homepage = new MobileHomePage(driver);
		loginpage = new LoginPage(driver);
		 client = new MobileClient(driver) ;
		
		/*PropertyDataHandler prop = new PropertyDataHandler();
		Properties allProp = prop.readPropertiesFile("configuration.properties");
	
	 client =  client.login (allProp.getProperty("UserName"), allProp.getProperty("Password"));
	 
	  */
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
	   Assert.assertTrue(client.isCustomersfeildDisplayed());
	   Assert.assertTrue(client.isAddClientButtondisplayed());
	   Assert.assertTrue(client.isChangecolumnsButtondisplayed());
	   Assert.assertTrue(client.istableLengthButtondisplayed());
	   Assert.assertTrue(client.isclientSearchdisplayed());
	 
}
	@Test(priority = 15, enabled = false)
	public void validateClientDetails()
	{
	
		int rowtext  = driver.findElements(By.xpath("//*[@id=\"dynamic-table\"]/tbody/tr")).size();
	System.out.println("Size of table is "+rowtext);
	
	List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"dynamic-table\"]/tbody/tr[1]"));
	String row1 =  ((WebElement) row).getText();
	System.out.println(row1);
	}
	
	@Test(priority = 16)
	public void validateClientTablesize() throws Exception
	{
		client.ClientsearchResultText();
				System.out.println("Total size is "+client.tableClientsize1());
	}
	
	@Test(priority = 17)
	public void validateClientSerchResult() throws Exception {
		
PropertyDataHandler prop = new PropertyDataHandler();
		
		Properties allProp = prop.readPropertiesFile("configuration.properties");
		
		client.clientsearchResult(allProp.getProperty("clientSearch"));
		System.out.println(client.ClientsearchResultText());
		soft.assertTrue(client.isClientsearchResultdisplayed(),"Element is not displayed");
	
		
	}@Test(priority = 18)
	public void validateClientActionbuttonsWork() throws Exception {
		
		
		client.clickClientAction();
		client.clickClientAction();
		soft.assertTrue(client.isDeleteSelectedbuttondisplayed(),"Element is not displayed");
		
	}
	@Test(priority = 19)
	public void validateClientActionbuttons() throws InterruptedException {
		
		soft.assertTrue(client.isDeleteSelectedbuttondisplayed(),"Element is not displayed");
		soft.assertTrue(client.isclientActionsbuttondisplayed(),"Element is not displayed");
		soft.assertTrue(client.isExporttoExcelfilebuttondisplayed(),"Element is not displayed");
		soft.assertTrue(client.isExporttoPDFfilebuttondisplayed(),"Element is not displayed");
		soft.assertTrue(client.isAddCustomersbyCSVbuttondisplayed(),"Element is not displayed");
		soft.assertAll();
	
		
	}
	
}
