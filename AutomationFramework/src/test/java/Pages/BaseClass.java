package Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.BrowserFactory;
import Utilities.ConfigDataProvider;
import Utilities.ExcelDataProvider;
import Utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupData() {
		Reporter.log("Test is in Base Class- setting up the data", true);
		excel = new ExcelDataProvider();
		config= new ConfigDataProvider();
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/"+Helper.getCurrentDateTime()+".html"));
		report= new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Test is in Base Class- Done with data setup", true);
	}

	@BeforeClass
	public void setUp() {

		Reporter.log("Test is in Base Class- driver setup started", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(),
				config.getQAUrl());

		Reporter.log("Test is in Base Class- driver setup completed", true);
	}

	@AfterClass
	public void tearDown() {

		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("Test is in Base Class- tearDown Method started", true);
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			Helper.captureScreenshot(driver);
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test is in Base Class- tearDown Method completed", true);
	}

}
