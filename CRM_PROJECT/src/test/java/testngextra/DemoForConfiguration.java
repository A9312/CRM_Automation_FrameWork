package testngextra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoForConfiguration {

	@BeforeSuite
	public void DBConn()
	{
		System.out.println("database connectivity + report configuration");
	}
	
	@BeforeTest
	public void PREConn()
	{
		System.out.println("pre-conditions");
	}
	
	@BeforeClass
	public void OpenBrowser()
	{
		System.out.println("browser open");
	}
	
	@BeforeMethod
	public void logIn()
	{
		System.out.println("logIn");
	}
	
	@AfterMethod
	public void logOut()
	{
		System.out.println("logOut");
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		System.out.println("browser close");
	}
	
	@AfterTest
	public void postCon()
	{
		System.out.println("post conditions");
	}

	@Test
	public void createtest()
	{
		System.out.println("abcd");
	}
	
}
