package webActionHelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseAction {

	Actions act; 
	public void mouseClick(WebDriver driver , WebElement dragableButton)
	{
		act = new Actions(driver);
		try {
			act.moveToElement(dragableButton).click().build().perform();
		}
		catch (Exception e) {

			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
	
	public void  mouseDragDrop(WebDriver driver , WebElement source ,int a , int b  )
	{
		try {
			act.moveToElement(source).clickAndHold().moveByOffset( a, b).build().perform();
		}
		catch (Exception e) {

			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
	public void  mouseDragDrop(WebDriver driver, WebElement source, WebElement target)
	{
		try {
			act.moveToElement(source).clickAndHold().moveToElement(target).build().perform();
		}
		catch (Exception e) {

			System.out.println("Exceptiom occured" +e);
			// TODO: handle exception
		}
	}
}
