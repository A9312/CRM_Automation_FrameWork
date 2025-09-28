package testngextra.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	
	@BeforeSuite
	public void dbconn()
	{
		System.out.println("database connectivity + report configuration");
	}

	@BeforeTest
	public void precon()
	{
		System.out.println("pre-conditions");
	}
	
	@BeforeClass
	public void openbro()
	{
		System.out.println("browser open");
	}
	
	@BeforeMethod
	public void login()
	{
		System.out.println("login");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("logout");
	}
	
	@AfterClass
	public void closebro()
	{
		System.out.println("browser close");
	}
	
	@AfterTest
	public void postcon()
	{
		System.out.println("post-conditions");
	}
	
	@AfterSuite
	public void dbclose()
	{
		System.out.println("database connectivity close + report backup");
	}
	
	class testscript extends BaseClass
	{
		@Test
		public void orgtest()
		{
			System.out.println("create organisation");
		}
		
		@Test
		public void contest()
		{
			System.out.println("create contact");
		}
		
	}
	
}
