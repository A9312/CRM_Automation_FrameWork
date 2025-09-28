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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import generic_utility.FileUtility_1;
import generic_utility.WebdriverUtility;
import object_repository.SignOutPage;
import object_repository.Vtiger_LoginPage;

public class BaseClass1 {
	
	public static WebDriver driver = null;
	
	@BeforeSuite
	public void dbconn()
	{
		System.out.println("database connectivity + report configuration");
	}
	
	@BeforeTest
	public void precon()
	{
		System.out.println("pre conditions");
	}

	@BeforeClass
	public void openbro() throws IOException
	{
		FileUtility_1 FUtil = new FileUtility_1();
		
		String BROWSER = FUtil.getDataFromPropertiesFile("bro");
		
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	
	@BeforeMethod
	public void login() throws IOException
	{
		FileUtility_1 FUtil = new FileUtility_1();
		
		String URL = FUtil.getDataFromPropertiesFile("url");
		String USERNAME = FUtil.getDataFromPropertiesFile("un");
		String PASSWORD = FUtil.getDataFromPropertiesFile("pwd");
		
		driver.get(URL);
		
		Vtiger_LoginPage vop = new Vtiger_LoginPage(driver);
		
		vop.logintocrm(USERNAME, PASSWORD);
		
	}
	
	
	@AfterMethod
	public void logout()
	{
		SignOutPage sop = new SignOutPage(driver);
		
		WebElement profile = sop.getProfile();
		
		WebdriverUtility WUtil = new WebdriverUtility(driver);
		
		WUtil.Hover(profile);
		
		sop.getSignOut().click();
	}
	
	@AfterClass
	public void closebro() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.quit();
	}
	
	@AfterTest
	public void postcon()
	{
		System.out.println("Post Conditions");
	}
	
	@AfterSuite
	public void dbclose()
	{
		System.out.println("database connectivity close + report backup");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
