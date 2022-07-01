package webActionHelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserHelper {
WebDriver driver;
	
	public void chromeBrowser(WebDriver driver , String URL)
	{
		try {
			System.setProperty("webdriver.chrome.driver","D:\\chrome driver\\CHromeDriver_102\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		catch(Exception e) {
			
			System.out.println("Exception Occured"+e);
			
		}
	}
}
