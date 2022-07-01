package com.mobileTest;



import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


import com.propertyDataHandler.PropertyDataHandler;

import webActionHelpers.ActionHelper;
import webActionHelpers.BrowserHelper;

public class BaseTest {
	WebDriver driver;
	BrowserHelper ae = new  BrowserHelper();
	ActionHelper ab  = new ActionHelper();
	 PropertyDataHandler prop = new PropertyDataHandler();
	@BeforeTest
	public void launch() throws IOException{
		
		System.setProperty("webdriver.chrome.driver","D:\\chrome driver\\CHromeDriver_102\\chromedriver.exe");
		driver = new ChromeDriver();
		Properties allProp = prop.readPropertiesFile("configuration.properties");
		
	ab.navigateURL(driver, allProp.getProperty("URL"));
	ab.windowMaximize(driver);
		
		
	}

		
	}


