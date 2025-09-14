package testngextra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Saucedemo {
	
	@Test(dataProvider = "getdata")
	public void testSauceDemo(String username, String password)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.saucedemo.com/v1/");
		
		WebElement USERNAME = driver.findElement(By.id("user-name"));
		
		USERNAME.sendKeys(username);
		
		WebElement PASSWORD = driver.findElement(By.id("password"));
		
		PASSWORD.sendKeys(password);
		
		driver.findElement(By.id("login-button")).click();
		
		driver.quit();
		
	}
	
	@DataProvider
	public Object getdata()
	{
		String password = "secret_sauce";
		
		Object[][] credentials = new Object[4][2];
		
		credentials[0][0] = "standard_user";
		credentials[0][1] = password;
		
		credentials[1][0] = "locked_out_user";
		credentials[1][1] = password;
		
		credentials[2][0] = "problem_user";
		credentials[2][1] = password;
		
		credentials[3][0] = "performance_glitch_user";
		credentials[3][1] = password;
		
		return credentials;
		
	}

}
