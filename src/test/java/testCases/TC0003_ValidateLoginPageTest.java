package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC0003_ValidateLoginPageTest extends BaseTest {

	@Test(dataProvider = "logindata", dataProviderClass = DataProviders.class, groups = { "datadriven", "sanity" })
	public void validLoginTest(String username, String password) {
		log.info("TC003 is started");
		HomePageObject homepage = new HomePageObject(driver);
		homepage.clickMyAccountButton();
		homepage.clickLogin();

		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSubmit();

		MyAccountPageObject myAccountPage = new MyAccountPageObject(driver);

		Boolean headerFlag = myAccountPage.ValidationMyAccountHeader();

		Assert.assertEquals(true, headerFlag);
		log.info("TC003 ended");
	}
}
