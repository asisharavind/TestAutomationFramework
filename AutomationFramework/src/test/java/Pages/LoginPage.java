package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(name = "email")
	WebElement uname;
	@FindBy(name = "password")
	WebElement pass;
	@FindBy(id = "continue")
	WebElement cont;
	@FindBy(id = "signInSubmit")
	WebElement signIn;

	public void logintoAmazon(String username, String Password) {
		uname.sendKeys(username);
		cont.click();
		pass.sendKeys(Password);
		//signIn.click();

	}
}
