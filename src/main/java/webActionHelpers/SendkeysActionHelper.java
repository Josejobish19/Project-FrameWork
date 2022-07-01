package webActionHelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendkeysActionHelper {

	WebDriver driver;
	
	public void sendkeys(WebDriver driver , WebElement location, String InputValue)
	{
		try {
		location.sendKeys(InputValue);
		}
		catch (Exception e) {
			
			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
	

	public void clearAndsendkeys(WebDriver driver , WebElement location, String InputValue)
	{
		try {
			location.clear();
		location.sendKeys(InputValue);
		}
		catch (Exception e) {
			
			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
}
