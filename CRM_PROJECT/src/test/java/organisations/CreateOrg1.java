package organisations;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrg1 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		FileInputStream fis1 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\commonData.properties");
		
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Vtiger_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Organisation");
		
		Properties pObj = new Properties();
		
		pObj.load(fis1);
		
		String BROWSER = pObj.getProperty("bro");
		
		String URL = pObj.getProperty("url");
		
		String USERNAME = pObj.getProperty("un");
		
		String PASSWORD = pObj.getProperty("pwd");
		
		WebDriver driver = null;
		
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
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
//		String inputOrg = "qsp"+(int)(Math.random()*9999);
		
		String inputOrg = sh.getRow(3).getCell(0).getStringCellValue();
		
		driver.findElement(By.name("accountname")).sendKeys(inputOrg);

		driver.findElement(By.name("website")).sendKeys(sh.getRow(3).getCell(1).getStringCellValue());
		
		wb.close();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		
		String outputOrg = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if(outputOrg.equals(inputOrg))
		{
			System.out.println("Organisation created successfully");
		}
		else
		{
			System.out.println("organisation not created successfully");
		}
		
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
	
		driver.close();
		
		

	}

}
