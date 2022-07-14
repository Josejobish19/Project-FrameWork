package automationBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.propertyDataHandler.PropertyDataHand;
import com.utility.AutomationConstants;

import io.github.bonigarcia.wdm.WebDriverManager;
import webActionHelpers.ActionHelper;
import webActionHelpers.BrowserHelper;


public class AutomationBase {
	


	 PropertyDataHand prop = new PropertyDataHand();
	 ActionHelper ab  = new ActionHelper();
	 BrowserHelper browserHelp = new BrowserHelper();

	 public static WebDriver driver;
		
		public WebDriver launchChromeBrowser()
		{
			try {
				WebDriverManager.chromedriver().setup();;
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
				WebDriverManager.edgedriver().setup();;;
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			BrowserHelper browserHelp = new BrowserHelper();
			 browserHelp.launchUrl(driver,"edge");
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
		public static WebDriver getDriver() {
			return driver;
		}
		public WebDriver launchBrowser(String browserName)
		{
			switch(browserName)
			{
			case "chrome" :
				launchChromeBrowser();
				break;
			case "edge":
				launchEdgeBrowser();
				break;

			default:
				System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
				break;
			}
			return driver;
				
		}

}

