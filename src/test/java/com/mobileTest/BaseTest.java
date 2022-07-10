package com.mobileTest;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import com.propertyDataHandler.PropertyDataHand;
import com.utility.AutomationConstants;

import webActionHelpers.ActionHelper;
import webActionHelpers.BrowserHelper;


public class BaseTest {
	

	 PropertyDataHand prop = new PropertyDataHand();
	 ActionHelper ab  = new ActionHelper();
	 BrowserHelper browserHelp = new BrowserHelper();

	 public static WebDriver driver;
		
		public WebDriver launchChromeBrowser()
		{
			try {
			System.setProperty("webdriver.chrome.driver","D:\\chrome driver\\CHromeDriver_102\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			 BrowserHelper browserHelp = new BrowserHelper();
			 browserHelp.launchUrl(driver,"chrome");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return driver;
			
		}
		
		public WebDriver launchEdgeBrowser()
		{
			try {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Jose.T\\Desktop\\work\\EdgeDriver\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			BrowserHelper browserHelp = new BrowserHelper();
			 browserHelp.launchUrl(driver,"chrome");
			if(driver==null)
			{
				System.out.println("***************launch browser");
			}
			
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			return driver;
			
		}
	

		public WebDriver launchBrowser(String browserName)
		{
			switch(browserName)
			{
			case "chrome" :
				launchChromeBrowser();
				break;
			case "firefox":
				launchEdgeBrowser();
				break;

			default:
				System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
				break;
			}
			return driver;
				
		}
			
	}


