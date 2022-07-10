package com.mobileService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webActionHelpers.ActionHelper;
import webActionHelpers.AlertFrameWindowHelper;
import webActionHelpers.MouseAction;
import webActionHelpers.SendkeysActionHelper;

public class MobileHomePage {
	



	WebDriver driver;
	ActionHelper actionhelp  = new ActionHelper();
	MouseAction clickhelp = new MouseAction();
	SendkeysActionHelper  Sendkey = new SendkeysActionHelper();
	AlertFrameWindowHelper Alerthelp = new AlertFrameWindowHelper();
	
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
	@FindBy(xpath = "//form//input[@class=\"bootbox-input bootbox-input-text form-control\"]")
	WebElement EventMsg;
	@FindBy(xpath = "//button[contains(.,'OK') and @class=\"btn btn-primary\"]")
	WebElement EventSubmit;
	@FindBy(xpath = "//div[contains(.,'Added Successfully')]")
	WebElement AddedSucess;
	@FindBy(xpath = "//span[contains(.,'10')]")
	WebElement EventdeleteSelect;
	@FindBy(xpath = "//button[@data-bb-handler=\"confirm\"]")
	WebElement EventdeleteConfirm;
	@FindBy(xpath = "//li[contains(.,'MAIN NAVIGATION')]")
	WebElement MAINNAVIGATION;
	@FindBy(xpath = "//span[contains(.,'Home')]")
	WebElement Home;
	@FindBy(xpath = "//span[contains(.,'Reparations')]")
	WebElement Reparations;
	@FindBy(xpath = "//span[contains(.,'Clients')]")
	WebElement Clients;
	@FindBy(xpath = "//span[contains(.,'Stock/Inventory')]")
	WebElement Inventory;
	@FindBy(xpath = "//span[contains(.,'POS')]")
	WebElement POS;
	@FindBy(xpath = "//span[contains(.,'Purchases')]")
	WebElement Purchases;
	@FindBy(xpath = "//span[contains(.,'Reports')]")
	WebElement Reports;
	@FindBy(xpath = "//span[contains(.,'Activity Log')]")
	WebElement ActivityLog;
	@FindBy(xpath = "//span[contains(.,'System Setting')]")
	WebElement SystemSetting;
	@FindBy(xpath = "//span[contains(.,'Joe Jacobs')]")
	WebElement joelogoutDrop;
	@FindBy(xpath = "//input[@name=\"identity\"]")
	WebElement username;
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	@FindBy(xpath = "//input[@name=\"submit\"]")
	WebElement passSubmit;
	@FindBy(xpath = "//div[@class=\"modal-body\"]")
	WebElement framemodal;
	
	
	public MobileHomePage(WebDriver driver)
	{
	this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	public String homeTitle()
	{
		return actionhelp.getPageTitle(driver);
	}
	
	public boolean isUserDetailsDisplayed()
	{	
		 return joelogoutDrop.isDisplayed();
		
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
		Sendkey.clearAndsendkeys(driver,EmailId,Emailid);
	}
	public void homeEmailsubject(String Emailsubject)
	{
		Sendkey.clearAndsendkeys(driver,EmailSubject,Emailsubject);
	}
		
	public void homeEmailMessage(String EmailMessage) 
	{
		Sendkey.clearAndsendkeys(driver,EmailMessage1 ,EmailMessage);
		clickhelp.mouseClick(driver, EmailSendButton);
		
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
		Sendkey.clearAndsendkeys(driver, SMSphoneNo, phoneNo);
	}
	public void smsContent(String SMSMessage)
	{
		Sendkey.clearAndsendkeys(driver, SMScontent, SMSMessage);
	}
	public void smsSend()
	{
		clickhelp.mouseClick(driver, SMSsendButton);
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
		
		clickhelp.mouseClick(driver,Date);
		driver.switchTo().frame(framemodal);
		Sendkey.sendkeys(driver, EventMsg, EventName);
		clickhelp.mouseClick(driver, EventSubmit);
		
	}
	public boolean eventAddSuccess()
	{
		return AddedSucess.isDisplayed();
	}
	public void deleteEventMarker()
	{
		clickhelp.mouseClick(driver, EventdeleteSelect);
		clickhelp.mouseClick(driver, EventdeleteConfirm);
	}
	
	public boolean isMAINNAVIGATIONDisplayed()
	{
		return MAINNAVIGATION.isDisplayed();
	}
	public boolean isHomeDisplayed()
	{
		return Home.isDisplayed();
	}
	public boolean isReparationsDisplayed()
	{
		return Reparations.isDisplayed();
	}
	public boolean isClientsDisplayed()
	{
		return  Clients.isDisplayed();
	}
	
	public boolean isInventoryDisplayed()
	{
		return  Inventory.isDisplayed();
	}
	public boolean isPOSDisplayed()
	{
		return  POS.isDisplayed();
	}
	public boolean isPurchasesDisplayed()
	{
		return  Purchases.isDisplayed();
	}
	public boolean isActivityLogDisplayed()
	{
		return   ActivityLog.isDisplayed();
	}
	public boolean isSystemSettingLogDisplayed()
	{
		return   SystemSetting.isDisplayed();
	}
	
	
	public  MobileClientPage clientpageclick()
	{
		Clients.click();
		
		return new MobileClientPage(driver);
	}
}
