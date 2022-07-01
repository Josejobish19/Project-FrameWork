package com.mobileService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webActionHelpers.ActionHelper;
import webActionHelpers.AlertFrameWindowHelper;
import webActionHelpers.MouseAction;
import webActionHelpers.SendkeysActionHelper;




public class LoginPage {
	
	WebDriver driver;
	ActionHelper ab  = new ActionHelper();
	MouseAction ac = new MouseAction();
	SendkeysActionHelper  ad = new SendkeysActionHelper();
	AlertFrameWindowHelper ae = new AlertFrameWindowHelper();
	
	@FindBy(xpath = "//input[@name=\"identity\"]")
	WebElement username;
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	@FindBy(xpath = "//input[@name=\"remember\"]")
	WebElement passReminder;
	
	@FindBy(xpath = "//input[@name=\"submit\"]")
	WebElement passSubmit;
	@FindBy(xpath = "//p[contains(.,'Logged In Successfully')]")
	WebElement loggedSuccessful;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String pageURL()
	{
		return ab.getPageCurrentUrl(driver);
		
	}
public boolean isUserNamefeildDisplayed() {
	return username.isDisplayed();
		
	}
	public boolean isPasswordfeildDisplayed() {
		return password.isDisplayed();
		
	}
	
	public void loginUsername(String Username1) {
		ad.clearAndsendkeys(driver, username, Username1);
		
	}
	public void loginPassword(String Password1) {
		ad.clearAndsendkeys(driver,password , Password1);
	}
	
	public void loginButtonandSavePassword()
	{
		ac.mouseClick(driver, passReminder);
		ac.mouseClick(driver, passSubmit);
	}
	
	public boolean isLogSuccessMessageDispalyed()
	{
		return loggedSuccessful.isDisplayed();
	}

}
