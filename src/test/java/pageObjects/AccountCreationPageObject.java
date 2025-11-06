package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPageObject extends BasePageObject {

	public AccountCreationPageObject(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement buttonAgree;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement buttonSubmit;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkBoxConfirm;



	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void ClickingAgreeButton() {
		buttonAgree.click();
	}

	public void enterTelephoneNumber(String number) {
		txtTelephone.sendKeys(number);
	}

	public void submittingButton() {
		buttonSubmit.click();
	}

	public void enterConfirmPassword(String confPassword) {
		txtConfirmPassword.sendKeys(confPassword);
	}

	public void clickConfirmBox() {
		txtConfirmPassword.click();

	}

	

}
