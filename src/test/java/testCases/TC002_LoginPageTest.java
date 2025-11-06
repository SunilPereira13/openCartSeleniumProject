package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountCreationPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import testBase.BaseTest;

public class TC002_LoginPageTest extends BaseTest {
	@Test(groups = { "sanity", "regression" })
	public void validateLoginAccountTest() {

		log.info("TC002 is started");
		HomePageObject homepage = new HomePageObject(driver);
		homepage.clickMyAccountButton();
		homepage.clickLogin();

		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.enterUserName(prop.getProperty("emailID"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickSubmit();

		MyAccountPageObject myAccountPage = new MyAccountPageObject(driver);

		Boolean headerFlag = myAccountPage.ValidationMyAccountHeader();

		Assert.assertEquals(true, headerFlag);
		log.info("TC002 ended");

	}
}
