package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility_1;
import generic_utility.WebdriverUtility;
import object_repository.SignOutPage;
import object_repository.Vtiger_LoginPage;

public class BaseClass2 {

	public WebDriver driver = null;

	@BeforeClass
	public void openBRO() throws IOException {
		FileUtility_1 futil = new FileUtility_1();

		String BROWSER = futil.getDataFromPropertiesFile("bro");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@BeforeMethod
	public void login() throws IOException {
		FileUtility_1 futil = new FileUtility_1();

		String URL = futil.getDataFromPropertiesFile("url");
		String USERNAME = futil.getDataFromPropertiesFile("un");
		String PASSWORD = futil.getDataFromPropertiesFile("pwd");

		driver.get(URL);

		Vtiger_LoginPage vop = new Vtiger_LoginPage(driver);

		vop.logintocrm(USERNAME, PASSWORD);

	}

	@AfterMethod
	public void logout() {
		SignOutPage sop = new SignOutPage(driver);

		WebElement profile = sop.getProfile();

		WebdriverUtility WUtil = new WebdriverUtility(driver);

		WUtil.Hover(profile);

		sop.getSignOut().click();
	}

	@AfterClass
	public void closebro() throws InterruptedException {
		Thread.sleep(3000);

		driver.quit();
	}

}
