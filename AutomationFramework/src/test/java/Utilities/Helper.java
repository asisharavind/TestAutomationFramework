package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/"+ getCurrentDateTime() + ".png";

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(screenshotPath); // created a folder Screenshots
			// under the project
			FileUtils.copyFile(source, DestFile);
			System.out.println("screenshot ready");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenshotPath;
	}

	public static void highLightElement(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// highlight the element in yellow
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
		// highlight the element in white
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');");

	}

	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date dt = new Date();
		return customFormat.format(dt);
		
	}
}
