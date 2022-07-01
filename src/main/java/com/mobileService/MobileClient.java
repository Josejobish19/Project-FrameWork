package com.mobileService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import webActionHelpers.ActionHelper;
import webActionHelpers.AlertFrameWindowHelper;
import webActionHelpers.MouseAction;
import webActionHelpers.SendkeysActionHelper;

public class MobileClient {
	
	WebDriver driver;
	ActionHelper ab  = new ActionHelper();
	MouseAction ac = new MouseAction();
	SendkeysActionHelper  ad = new SendkeysActionHelper();
	AlertFrameWindowHelper ae = new AlertFrameWindowHelper();
	
public  MobileClient(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver,this);
}

}
