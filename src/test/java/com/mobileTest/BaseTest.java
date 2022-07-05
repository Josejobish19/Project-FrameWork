package com.mobileTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.propertyDataHandler.PropertyDataHandler;
import webActionHelpers.ActionHelper;


public class BaseTest {
	
 WebDriver driver;
	 PropertyDataHandler prop = new PropertyDataHandler();
	 ActionHelper ab  = new ActionHelper();

	 @BeforeTest
	public void launchChromeBrowser() throws IOException {
			
	
			System.setProperty("webdriver.chrome.driver","D:\\chrome driver\\CHromeDriver_102\\chromedriver.exe");
			driver = new ChromeDriver();
			Properties allProp = prop.readPropertiesFile("configuration.properties");
			
		ab.navigateURL(driver, allProp.getProperty("URL"));
		ab.windowMaximize(driver);
			}
	
	

	/* AutomationBase base;
	 ActionHelper ab  = new ActionHelper();
		
		@BeforeTest
		@Parameters("browserType")
		public void launch(String browserType) throws Exception {
			base = new AutomationBase();
			base.launchBrowser(browserType);
	
			
		}

		@AfterTest
		public void quitBrowser() {
			
			//ab.navigateQuit(driver);
		}
*/
		
	}


