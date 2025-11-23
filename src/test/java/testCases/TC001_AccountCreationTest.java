package testCases;

import java.time.Duration;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountCreationPageObject;
import pageObjects.HomePageObject;
import testBase.BaseTest;

public class TC001_AccountCreationTest extends BaseTest {

	@Test(groups = "sanity")
	public void verifyAccountRegistration() {

		try {
			log.info("********TC001 verifyAccountRegistration testcase is started to execute********");
			HomePageObject homePage = new HomePageObject(driver);
			homePage.clickMyAccountButton();
			homePage.clickRegesterButton();

			AccountCreationPageObject accountPage = new AccountCreationPageObject(driver);
			accountPage.enterFirstName(randomString());
			accountPage.enterLastName(randomString());
			accountPage.enterEmail(randomString().concat("@gmail.com"));
			accountPage.enterTelephoneNumber(randomNumbers());
			accountPage.enterPassword("Sunper@1994");
			accountPage.enterConfirmPassword("Sunper@1994");
			accountPage.clickConfirmBox();
			accountPage.submittingButton();
			log.info("********TC001 verifyAccountRegistration testcase execution is ended********");

		} catch (Exception e) {
			log.info("Testcase failed");
		

		}
	}

}
