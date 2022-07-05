package automationBase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.exceptions.AutomationExceptions.AutomationException;
import com.propertyDataHandler.PropertyDataHandler;
import com.utility.AutomationConstants;

import webActionHelpers.ActionHelper;


public class AutomationBase {
	
	public WebDriver driver;
	 PropertyDataHandler prop = new PropertyDataHandler();
	 ActionHelper ab  = new ActionHelper();

	 private void launchChromeBrowser() throws IOException{
			
			
			System.setProperty("webdriver.chrome.driver","D:\\chrome driver\\CHromeDriver_102\\chromedriver.exe");
			driver = new ChromeDriver();
			Properties allProp = prop.readPropertiesFile("configuration.properties");
			
		ab.navigateURL(driver, allProp.getProperty("URL"));
		ab.windowMaximize(driver);
			
		
		}
	 public void launchBrowser(String browserName) throws AutomationException, IOException {
			switch (browserName) {
			case "chrome":
				launchChromeBrowser();
				break;

			case "firefox":
				// launchFirefoxBrowser();
				break;

			default:
				System.out.println(AutomationConstants.CHECKBROWSER_MESSAGE);
				break;
			}
		}

}

