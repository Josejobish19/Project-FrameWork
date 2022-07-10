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

public class POSpage {
	
	WebDriver driver;
	ActionHelper actionhelp  = new ActionHelper();
	MouseAction clickhelp = new MouseAction();
	SendkeysActionHelper  Sendkey = new SendkeysActionHelper();
	AlertFrameWindowHelper Alerthelp = new AlertFrameWindowHelper();
	GetTableSizeList Gettablehelp = new GetTableSizeList();
	
	public POSpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[contains(.,'POS')]")
	WebElement POSPage;
	@FindBy(xpath = "//input[@id=\"add_pos_item\"]")
	WebElement ScanSerchFeild ;
	@FindBy(xpath = "//select[@id=\"poscustomer\"]//option[@value=\"59\"]")
	WebElement SelectClient;
	@FindBy(xpath = "//select[@id=\"poscustomer\"]")
	WebElement SelectClientFeild ;
	@FindBy(xpath = "//span[@title=\"Jobish \"]")
	WebElement SelectClientnamedisplay ;
	@FindBy(xpath = "//button[contains(.,'BabyProduct')]")
	WebElement babyproduct ;
	@FindBy(xpath = "//button[contains(.,'my product')]")
	WebElement myproduct ;
	@FindBy(xpath = "//button[contains(.,' Clear Sale ')]")
	WebElement clearSale ;
	@FindBy(xpath = "//*[@id=\"tpitems\"]")
	WebElement productadded ;
	@FindBy(xpath = "//button[contains(.,\"  Payment  \")]")
	WebElement submitpurchasebutton ;
	@FindBy(xpath = "//body/div[12]/div/div/div[1]/div")
	WebElement addClientAlert ;
	@FindBy(xpath = "html/body/div[12]/div/div/div[2]/button")
	WebElement addClientAlertOkay ;
	
	
	
	
	public void pospage()
	{
		clickhelp.mouseClick(driver, POSPage);
	}
	
	public POSpage clickPOS() 
	{
		POSPage.click();
		
		return new POSpage(driver); 
		
	}
	public boolean isScanSerchFeildDisplayed() {
		return ScanSerchFeild.isDisplayed();
		
	}
	public boolean isSelectClientFeildDisplayed() {
		return SelectClientFeild.isDisplayed();
		
	}
	
	public void selectClient() throws Exception
	{
		SelectClient.click();
		
	}
	public boolean isSelectClientnameDisplayed() {
		return SelectClientnamedisplay.isDisplayed();
		
	}
	public void selectPurchase()
	{
		babyproduct.click();
		myproduct.click();
	}
	
	public void clearPurchase()
	{
		clearSale.click();
	}
	public boolean isProductaddedDisplayed()
	{
		return productadded.isDisplayed();
	}
	
	public void submitPurchase()
	{
		submitpurchasebutton.click();
	}
	
	public boolean isaddclientalrtdDisplayed()
	{
		return addClientAlert.isDisplayed();
	}
	public void purchaseAlertOkay()
	{
		addClientAlert.click();
	}

}
