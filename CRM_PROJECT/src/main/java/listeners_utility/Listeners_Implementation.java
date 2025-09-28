package listeners_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base_utility.BaseClass1;

public class Listeners_Implementation implements ISuiteListener, ITestListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {

		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

		String time = now.format(dtf);

		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\Hp\\git\\SeleniumProject\\CRM_PROJECT\\Advance_html_reports" + time + ".html");

		spark.config().setDocumentTitle("facebook-reports");

		spark.config().setReportName("first report");

		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();

		report.attachReporter(spark);

		report.setSystemInfo("browser", "chromium");

		report.setSystemInfo("OS", "window");

		report.setSystemInfo("version", "11");
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Congrats!!!");
		test.log(Status.PASS, "this is passed....");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("take the screenshot");
		test.log(Status.FAIL, "this is failed....");

		TakesScreenshot tks = (TakesScreenshot) BaseClass1.driver;

		String ss = tks.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(ss, "image of ss");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("skipped.....");
		test.log(Status.SKIP, "this is skipped....");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

}
