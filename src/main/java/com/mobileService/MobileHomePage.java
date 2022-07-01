package com.mobileService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webActionHelpers.ActionHelper;
import webActionHelpers.AlertFrameWindowHelper;
import webActionHelpers.MouseAction;
import webActionHelpers.SendkeysActionHelper;

public class MobileHomePage  {
	




	WebDriver driver;
	ActionHelper ab  = new ActionHelper();
	MouseAction ac = new MouseAction();
	SendkeysActionHelper  ad = new SendkeysActionHelper();
	AlertFrameWindowHelper ae = new AlertFrameWindowHelper();
	
	@FindBy(xpath = "//p[contains(.,'Joe Jacobs')]")
	WebElement userDetail;
	@FindBy(xpath = "//a[contains(.,' Online')]")
	WebElement onlineStatus;
	@FindBy(xpath = "//h1[contains(.,'Home')]")
	WebElement HomeFeild;
	@FindBy(xpath = "//b[contains(.,'Service Management')]")
	WebElement ServiceManagement;
	@FindBy(xpath = "//h3[contains(.,'Revenue Chart')]")
	WebElement RevenueChart;
	@FindBy(xpath = "//h3[contains(.,'Stock Chart')]")
	WebElement StockChart;
	@FindBy(xpath = "//h3[contains(.,'Quick Email')]")
	WebElement QuickEmail;
	@FindBy(xpath = "//h3[contains(.,'Quick SMS')]")
	WebElement QuickSMS;
	@FindBy(xpath = "//p[contains(.,'Reparation')]")
	WebElement Reparation;
	@FindBy(xpath = "//p[contains(.,'Client')]")
	WebElement Client;
	@FindBy(xpath = "//p[contains(.,'Inventory Products')]")
	WebElement InventoryProducts;
	@FindBy(xpath = "//input[@id=\"emailto_\"]")
	WebElement EmailId;
	@FindBy(xpath = "//input[@id=\"subject_\"]")
	WebElement EmailSubject;
	@FindBy(xpath = "//textarea[@id=\"body_\"]")
	WebElement EmailMessage1;
	@FindBy(xpath = "//button[contains(.,'Send                ')]")
	WebElement EmailSendButton;
	@FindBy(xpath = "//ul[contains(.,'This value should be a valid email.')]")
	WebElement InvalidEmail;
	@FindBy(xpath = "//div[@id=\"loadingmessage\"]")
	WebElement Loadingmessage;
	@FindBy(xpath = "//input[@id='phone_number']")
	WebElement SMSphoneNo;
	@FindBy(xpath = "//textarea[@id='fastsms']")
	WebElement SMScontent;
	@FindBy(xpath = "//button[@form='send_quicksms']")
	WebElement SMSsendButton;
	@FindBy(xpath = "//div[contains(.,'Quick SMS')]")
	WebElement SMSconformationmsg;
	@FindBy(xpath = "//li[contains(.,'This value is required.')]")
	WebElement EmptySMS;
	@FindBy(xpath = "//td[@data-date=\"2022-06-16\"]")
	WebElement Date;
	@FindBy(xpath = "/html/body/div[12]/div/div/div[2]/div/form/input")
	WebElement EventMsg;
	@FindBy(xpath = "//button[contains(.,'OK')]")
	WebElement EventSubmit;
	@FindBy(xpath = "//div[contains(.,'Added Successfully')]")
	WebElement AddedSucess;
	@FindBy(xpath = "//span[contains(.,'10')]")
	WebElement EventdeleteSelect;
	@FindBy(xpath = "//button[@data-bb-handler=\"confirm\"]")
	WebElement EventdeleteConfirm;
	
	
	public MobileHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	public String homeTitle()
	{
		return ab.getPageTitle(driver);
	}
	
	public String isUserDetailsDisplayed()
	{	
		 return userDetail.getText();
		
	}
	public String isUseronlineStatusDisplayed()
	{	
		 return onlineStatus.getText();
	
		
	}
	public boolean isServiceManagemenDisplayed()
	{
		return ServiceManagement.isDisplayed();
	}
	public boolean isRevenueChartDisplayed()
	{
		return RevenueChart.isDisplayed();
	}
	
	public boolean isStockChartDisplayed()
	{
		return StockChart.isDisplayed();
	}
	
	public boolean isHomeFeildDisplayed()
	{
		return HomeFeild.isDisplayed();
	}

	public boolean isQuickEmailDisplayed()
	{
		return QuickEmail.isDisplayed();
	}

	public boolean isQuickSMSDisplayed()
	{
		return QuickSMS.isDisplayed();
	}
	public boolean isReparationDisplayed()
	{
		return Reparation.isDisplayed();
	}
	public boolean isClientDisplayed()
	{
		return Client.isDisplayed();
	}
	public boolean isInventoryProductsDisplayed()
	{
		return InventoryProducts.isDisplayed();
	}
	public void homeEmailid(String Emailid)
	{
		ad.clearAndsendkeys(driver,EmailId,Emailid);
	}
	public void homeEmailsubject(String Emailsubject)
	{
		ad.clearAndsendkeys(driver,EmailSubject,Emailsubject);
	}
		
	public void homeEmailMessage(String EmailMessage) 
	{
		ad.clearAndsendkeys(driver,EmailMessage1 ,EmailMessage);
		ac.mouseClick(driver, EmailSendButton);
		
	}
	public boolean isValidEmailIddisplayed()
	{
		return InvalidEmail.isDisplayed();
	}
	public boolean isLoadingmessagedisplayed()
	{
		return Loadingmessage.isDisplayed();
	}
	
	public void smsPhoneNo(String phoneNo)
	{
		ad.clearAndsendkeys(driver, SMSphoneNo, phoneNo);
	}
	public void smsContent(String SMSMessage)
	{
		ad.clearAndsendkeys(driver, SMScontent, SMSMessage);
	}
	public void smsSend()
	{
		ac.mouseClick(driver, SMSsendButton);
	}
	public boolean smsConfirm()
	{
		return SMSconformationmsg.isDisplayed();
	}
	public boolean isEmptySMSdisplayed()
	{
		return EmptySMS.isDisplayed();
	}
	public void dateEventMarker(String EventName)
	{
		ac.mouseClick(driver,Date);
		ad.sendkeys(driver, EventMsg, EventName);
		ac.mouseClick(driver, EventSubmit);
		
	}
	public boolean eventAddSuccess()
	{
		return AddedSucess.isDisplayed();
	}
	public void deleteEventMarker()
	{
		ac.mouseClick(driver, EventdeleteSelect);
		ac.mouseClick(driver, EventdeleteConfirm);
	}
	
}
