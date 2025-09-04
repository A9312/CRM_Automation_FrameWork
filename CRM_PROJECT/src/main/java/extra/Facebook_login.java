package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import object_repository.Facebook_LoginPage;

public class Facebook_login {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.facebook.com/");
		
//		WebElement username = driver.findElement(By.id("email"));
//		
//		WebElement password = driver.findElement(By.id("pass"));
//		
//		WebElement loginbtn = driver.findElement(By.name("login"));
		
		Facebook_LoginPage lp = new Facebook_LoginPage(driver);
		
		WebElement username = lp.getUsername();
		
		WebElement password = lp.getPassword();
		
		WebElement loginbtn= lp.getLoginbtn();
		
		
		username.sendKeys("admin");
		
		password.sendKeys("admin@123");
		
		loginbtn.click();
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
