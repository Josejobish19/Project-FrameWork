package com.mobileTest;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mobileService.AddClient;
import com.mobileService.LoginPage;
import com.mobileService.MobileClientPage;
import com.mobileService.MobileHomePage;
import com.mobileService.POSpage;

public class POSTest extends BaseTest
{
	MobileClientPage client ;
	LoginPage loginPage;
	POSpage pospage;
	MobileHomePage homepage;
	AddClient addclientpage;
	public POSTest ()
	{
		super();
	}
	@BeforeMethod
	@Parameters("browserType")
	public void setup(String browserType) throws IOException {
		driver = launchBrowser(browserType);
		loginPage = new LoginPage(driver);
		pospage = new POSpage(driver);
		homepage = new MobileHomePage(driver);
		client = new MobileClientPage(driver);
		loginPage.login();
		pospage.clickPOS();
		
		 
	}   
	@Test(priority =24,enabled = true)
	public void validatePOSfeilds()
	{
		pospage = new POSpage(driver);
		Assert.assertTrue(pospage.isScanSerchFeildDisplayed());
		Assert.assertTrue(pospage.isSelectClientFeildDisplayed());
	
		
	}
	@Test(priority =25,enabled = true)
	public void validateSelectFeild() throws Exception
	{
		pospage = new POSpage(driver);
		pospage.selectClient();
		Assert.assertTrue(pospage.isSelectClientnameDisplayed());
	
	}
	@Test(priority =26,enabled = true)
	public void validatePOSpurchaseClearSale() throws Exception
	{
		pospage = new POSpage(driver);
		pospage.selectClient();
		Assert.assertTrue(pospage.isSelectClientnameDisplayed());
		pospage.selectPurchase();
		pospage.clearPurchase();
	}
	
	@Test(priority =27,enabled = true)
	public void validateProductAddeddisplayed() throws Exception
	{
		pospage = new POSpage(driver);
		pospage.selectClient();
		Assert.assertTrue(pospage.isSelectClientnameDisplayed());
		pospage.selectPurchase();
		Assert.assertTrue(pospage.isProductaddedDisplayed());
	}
	@Test(priority =28,enabled = true)
	public void validateProductAddedWithoutSelectclient() throws Exception
	{
		pospage = new POSpage(driver);
		
		pospage.selectPurchase();
		Assert.assertTrue(pospage.isProductaddedDisplayed());
		pospage.submitPurchase();
		pospage.purchaseAlertOkay();
	}
	
	@Test(priority =29,enabled = true)
	public void validatePOSpurchase() throws Exception
	{
		pospage = new POSpage(driver);
		pospage.selectClient();
		Assert.assertTrue(pospage.isSelectClientnameDisplayed());
		pospage.selectPurchase();
		Assert.assertTrue(pospage.isaddclientalrtdDisplayed());
		pospage.purchaseAlertOkay();
	}
	
	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	
}
		
	

}
