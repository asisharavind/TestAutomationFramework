package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.LoginPage;
import Utilities.ExcelDataProvider;

public class LoginTest extends BaseClass {

	@Test
	public void loginApp() {

		logger = report.createTest("Login to Amazon");
		ExcelDataProvider excel = new ExcelDataProvider();
		LoginPage lpage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("starting application");
		
		lpage.logintoAmazon(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		logger.pass("Login Success");

	}
	
}
