package com.mobileService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webActionHelpers.ActionHelper;
import webActionHelpers.AlertFrameWindowHelper;
import webActionHelpers.GetTableSizeList;
import webActionHelpers.MouseAction;
import webActionHelpers.SendkeysActionHelper;

public class AddClient {
	
	ActionHelper actionhelp  = new ActionHelper();
	MouseAction clickhelp = new MouseAction();
	SendkeysActionHelper  Sendkey = new SendkeysActionHelper();
	AlertFrameWindowHelper Alerthelp = new AlertFrameWindowHelper();
	GetTableSizeList Gettablehelp = new GetTableSizeList();
	
	WebDriver driver;
	@FindBy(xpath = "//button[contains(.,' Add Client    ')]")
	WebElement AddClientButton; 
	@FindBy(xpath = "//input[@id='name1']")
	WebElement AddClientname; 
	@FindBy(xpath = "//input[@id='company1']")
	WebElement AddClientcompany; 
	@FindBy(xpath = "//input[@id='autocomplete']")
	WebElement AddClientlocation; 
	@FindBy(xpath = "//input[@id='route']")
	WebElement AddClientAddress;
	@FindBy(xpath = "//input[@id='locality']")
	WebElement AddClientcity;
	@FindBy(xpath = "//input[@id='telephone']")
	WebElement AddClientphone;
	@FindBy(xpath = "//input[@id='postal_code']")
	WebElement AddClientPincode;
	@FindBy(xpath = "//input[@id='email1']")
	WebElement AddClientemail;
	@FindBy(xpath = "//button[@id='submit']")
	WebElement AddClientsubmitbutton;
	@FindBy(xpath = "//button[contains(.,' Go Back')]")
	WebElement AddClientGoBackbutton;
	
	
	
	
	 public AddClient(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }  
	
	 public void clickAddClientButton() throws Exception
	 {
		
		 clickhelp.mouseClick(driver, AddClientButton);
	 }
	 
	 public boolean isClientnameFeildDisplayed()
	 {
		 return AddClientname.isDisplayed();
	 }
	 public boolean isClientcompanyFeildDisplayed()
	 {
		 return AddClientcompany.isDisplayed();
	 }
	 public boolean isClientlocationFeildDisplayed()
	 {
		 return AddClientlocation.isDisplayed();
	 }
	 public boolean isClientAddressFeildDisplayed()
	 {
		 return AddClientAddress.isDisplayed();
	 }
	 public boolean isClientcityFeildDisplayed()
	 {
		 return AddClientcity.isDisplayed();
	 }
	 public boolean isClientphoneFeildDisplayed()
	 {
		 return AddClientphone.isDisplayed();
	 }
	 public boolean isClientPincodeFeildDisplayed()
	 {
		 return AddClientPincode.isDisplayed();
	 }
	 public boolean isClientemailFeildDisplayed()
	 {
		 return AddClientemail.isDisplayed();
		 
	 }
	 public boolean isClientsubmitbuttonDisplayed()
	 {
		 return AddClientsubmitbutton.isDisplayed();
		 
	 }
	 public boolean isClientGoBackbuttonDisplayed()
	 {
		 return AddClientGoBackbutton.isDisplayed();
		 
	 }
	 public void typeClientnameFeild(String name)
	 {
		  AddClientname.sendKeys();
	 }
	 public void typeClientcompanyFeild(String company)
	 {
		 AddClientcompany.sendKeys();
	 }
	 public void typeClientcityFeild(String city)
	 {
		  AddClientcity.sendKeys();
	 }
	 public void typeClientphoneFeild(int phone)
	 {
		 AddClientphone.sendKeys();
	 }
	 public void typeClientPincodeFeild(int pincode)
	 {
		 AddClientPincode.sendKeys();
	 }
	 public void addClientsubmitbutton()
	 {
		clickhelp.mouseClick(driver, AddClientsubmitbutton);
		 
	 }

}
