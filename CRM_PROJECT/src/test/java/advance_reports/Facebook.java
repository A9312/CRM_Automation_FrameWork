package advance_reports;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Facebook {

	ExtentReports report;

	@BeforeSuite
	public void reportconfig() {
		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

		String time = now.format(dtf);

		ExtentSparkReporter spark = new ExtentSparkReporter(
				"./advance_html_reports/" + time + ".html");

		spark.config().setDocumentTitle("facebook-reports");

		spark.config().setReportName("first-report");

		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();

		report.attachReporter(spark);

		report.setSystemInfo("browser", "chromium");

		report.setSystemInfo("OS", "windows");

		report.setSystemInfo("version", "11");
	}

	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.facebook.com/");

		ExtentTest test = report.createTest("login");

		test.log(Status.INFO, "this is info....");

		test.log(Status.PASS, "this is passed...");

		test.log(Status.WARNING, "this is warning....");

		test.log(Status.SKIP, "this is skipped....");

		test.log(Status.FAIL, "this is failed...");

		TakesScreenshot tks = (TakesScreenshot) driver;

		String ss = tks.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(ss, "image of ss");

		driver.quit();

	}

	@AfterSuite
	public void repotbackup() {
		report.flush();
	}

}
