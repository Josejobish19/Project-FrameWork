package webActionHelpers;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class UtilityActionHelpers {
	
	public void capturePageScreenshot(WebDriver driver) throws Exception {
	try {
		String random = RandomStringUtils.randomAlphanumeric(10);
		String fileNm = "FailedSS "+ random;
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("PageScreenshot.png"));
		FileHandler.copy(src, new File(fileNm+".png"));
	}catch (Exception e) {
		throw new Exception("capturePageScreenshot (UtilityActionHelper) : "+e.getMessage());
	}

	}
}
