package com.mobileTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mobileService.LoginPage;
import com.mobileService.MobileClientPage;
import com.mobileService.POSpage;

public class POSTest extends BaseTest
{
	MobileClientPage client ;
	LoginPage loginPage;
	POSpage pospage;
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
		loginPage.login();
		pospage.clickPOS();
		
		 
	}   
	@Test(priority =0,enabled = true)
	public void validatePOSfeilds()
	{
		Assert.assertTrue(pospage.isScanSerchFeildDisplayed());
		Assert.assertTrue(pospage.isSelectClientFeildDisplayed());
	
		
	}
	@Test(priority =1,enabled = true)
	public void validateSelectFeild() throws Exception
	{
		pospage.selectClient();
		Assert.assertTrue(pospage.isSelectClientnameDisplayed());
	
	}
	@Test(priority =2,enabled = true)
	public void validatePOSpurchaseClearSale() throws Exception
	{
		pospage.selectClient();
		Assert.assertTrue(pospage.isSelectClientnameDisplayed());
		pospage.selectPurchase();
		pospage.clearPurchase();
	}
	
	@Test(priority =3,enabled = true)
	public void validateProductAddeddisplayed() throws Exception
	{
		pospage.selectClient();
		Assert.assertTrue(pospage.isSelectClientnameDisplayed());
		pospage.selectPurchase();
		Assert.assertTrue(pospage.isProductaddedDisplayed());
	}
	@Test(priority =4,enabled = true)
	public void validateProductAddedWithoutSelectclient() throws Exception
	{
		
		pospage.selectPurchase();
		Assert.assertTrue(pospage.isProductaddedDisplayed());
		pospage.submitPurchase();
		pospage.purchaseAlertOkay();
	}
	
	@Test(priority =5,enabled = true)
	public void validatePOSpurchase() throws Exception
	{
		pospage.selectClient();
		Assert.assertTrue(pospage.isSelectClientnameDisplayed());
		pospage.selectPurchase();
		Assert.assertTrue(pospage.isaddclientalrtdDisplayed());
		pospage.purchaseAlertOkay();
	}
	
		
	

}
