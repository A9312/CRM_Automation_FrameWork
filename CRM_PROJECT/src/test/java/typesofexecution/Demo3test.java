package typesofexecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo3test {
	
	@Parameters("bro")
	@Test
	public void case3(String browser) throws InterruptedException
	{
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.get("https://qspiders.com/");
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
