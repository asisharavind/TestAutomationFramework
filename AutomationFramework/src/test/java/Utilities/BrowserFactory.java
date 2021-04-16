//https://www.youtube.com/watch?v=vFXL4nMWvXI&list=PL6flErFppaj0WwNOMFeXPVlNCDuJyPYFi&index=1
package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		
		if(browserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"./Drivers/chromedriver.exe");
			driver = new ChromeDriver();	
			
		}else if(browserName.contentEquals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"./Drivers/geckodriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.contentEquals("IE")) {
			
		}else {
			System.out.println("we do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	
	}
}
