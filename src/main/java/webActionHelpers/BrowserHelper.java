package webActionHelpers;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


import com.propertyDataHandler.PropertyDataHand;

public class BrowserHelper {
WebDriver driver;
	
public void launchUrl(WebDriver driver, String browserName) throws IOException
{
	try
	{
		
		 PropertyDataHand prop = new PropertyDataHand();
	 Properties allProp = prop.readPropertiesFile("configuration.properties");
	 String url=allProp.getProperty("URL");
	 driver.get(url);
	
}
	catch(Exception e)
	{
		System.out.println("Exception occured "+e.getMessage());
	}

}
	}

