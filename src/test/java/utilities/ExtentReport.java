package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	public ExtentReports extent;
	public ExtentSparkReporter sparkReporter;
	public ExtentTest test;
	String repName;

	@Override
	public void onStart(ITestContext testContext) {

		// Create timestamp
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// Report name using timestamp
		repName = "Test-Report-" + timeStamp + ".html";

		// Path to store report
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

		// Report configuration
		sparkReporter.config().setDocumentTitle("OpenCartSeleniumProject");
		sparkReporter.config().setReportName("Open cart selenium report");
		sparkReporter.config().setTheme(Theme.DARK);

		// Initialize ExtentReports
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		// System Information
		extent.setSystemInfo("Application", "Open cart UI");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Sunil");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush(); // write report
	}
}
