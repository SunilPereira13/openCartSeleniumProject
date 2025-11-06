package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends BasePageObject {

	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement buttonregister;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement buttonMyAccount;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement buttonLogin;

	public void clickMyAccountButton() {
		buttonMyAccount.click();
	}

	public void clickRegesterButton() {
		buttonregister.click();
	}

	public void clickLogin() {
		buttonLogin.click();
	}

}
