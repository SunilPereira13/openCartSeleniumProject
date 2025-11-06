package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePageObject {

	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtUserName;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement buttonSubmit;

	public void enterUserName(String userName) {
		txtUserName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickSubmit() {
		buttonSubmit.click();
	}

}
