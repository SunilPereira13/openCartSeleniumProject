package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageObject extends BasePageObject {

	public MyAccountPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement headerMyAccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement buttonLogout;

	@FindBy(xpath = "//i[@class='fa fa-home']")
	WebElement buttonHomePage;

	public Boolean ValidationMyAccountHeader() {
		Boolean flag;
		try {
			flag = headerMyAccount.isDisplayed();
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogoutButton() {
		buttonLogout.click();
	}

	public void clickHomePage() {
		buttonHomePage.click();
	}

}
