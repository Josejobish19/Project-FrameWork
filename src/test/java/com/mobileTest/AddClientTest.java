package com.mobileTest;



import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mobileService.AddClient;
import com.mobileService.LoginPage;
import com.mobileService.MobileClient;
import com.mobileService.MobileHomePage;
import com.propertyDataHandler.PropertyDataHandler;

public class AddClientTest extends ClientTest {
	
	AddClient addclientpage;
	SoftAssert soft = new  SoftAssert();
	@BeforeMethod
	public void setup()
	{
		addclientpage = new AddClient(driver) ;
		homepage = new MobileHomePage(driver);
		loginpage = new LoginPage(driver);
		 client = new MobileClient(driver) ;
		
	}
	@Test(priority = 20)
	public void validateAddClientFieldsDisplayed() throws Exception
	{
		Thread.sleep(5000);
		
		addclientpage.clickAddClientButton();
		
		soft.assertTrue(addclientpage.isClientAddressFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientcityFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientcityFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientcompanyFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientemailFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientGoBackbuttonDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientlocationFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientnameFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientphoneFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientPincodeFeildDisplayed(),"Element is not displayed");
		soft.assertTrue(addclientpage.isClientsubmitbuttonDisplayed(),"Element is not displayed");
		soft.assertAll();
	
	}
/*
	@Test(priority = 21 ,dataProvider="Credentials")
	public void validateAllclientdetails(String name ,String company , String City, int postcode,int phone) throws InterruptedException {
		
		addclientpage.typeClientnameFeild(name);
		addclientpage.typeClientcompanyFeild(company);
		addclientpage.typeClientcityFeild (City);
		addclientpage.typeClientPincodeFeild(postcode);
		addclientpage.typeClientphoneFeild (phone);
		
	addclientpage.addClientsubmitbutton();

		
		
	
		
	}
	@DataProvider(name="Credentials")
	public Object[][] getData() throws IOException{
PropertyDataHandler prop = new PropertyDataHandler();
		
		Properties allProp = prop.readPropertiesFile("configuration.properties");
	Object[][] data = new Object[0][5];
	
	data[0][0]=allProp.getProperty("Name");
	data[0][1]=allProp.getProperty("Name");
	data[0][2]=allProp.getProperty("Name");
	data[0][3]=allProp.getProperty("Name");
	data[0][4]=allProp.getProperty("Name");
	data[0][5]=allProp.getProperty("Name");
	
	return data;
		
	}
*/

}
