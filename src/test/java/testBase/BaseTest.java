package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.exec.OS;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	public WebDriver driver;
	public Logger log;
	public Properties prop;

	@BeforeMethod()
	@Parameters({ "browser", "OS" })
	public void setUp(String browserName, String operatingSystem) throws IOException {
		log = LogManager.getLogger(BaseTest.class);
		FileInputStream fis = new FileInputStream("C:\\Users\\perei\\eclipse-workspace\\OpenCartProject\\config");
		prop = new Properties();
		prop.load(fis);

		DesiredCapabilities dc = new DesiredCapabilities();
		if (prop.getProperty("executionEnv").equalsIgnoreCase("remote")) {

			if (operatingSystem.equalsIgnoreCase("windows")) {
				dc.setPlatform(Platform.WIN11);
			} else if (operatingSystem.equalsIgnoreCase("Linux")) {
				dc.setPlatform(Platform.LINUX);
			}

			if (browserName.equalsIgnoreCase("Chrome")) {
				dc.setBrowserName("chrome");

			} else if (browserName.equalsIgnoreCase("edge")) {
				dc.setBrowserName("MicrosoftEdge");
			}

			driver = new RemoteWebDriver(new URL("http://192.168.1.35:4444/wd/hub"), dc);
		}

		if (prop.getProperty("executionEnv").equalsIgnoreCase("local")) {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}
			if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			if (browserName.equalsIgnoreCase("fireFox")) {
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Browser initiated succefully");
		driver.get(prop.getProperty("appUrl"));

	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;

	}

	public String randomNumbers() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return generatedString;

	}

	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphanumeric(5);
		return generatedString;

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
