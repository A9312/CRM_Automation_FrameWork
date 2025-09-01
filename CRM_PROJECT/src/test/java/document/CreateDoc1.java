package document;

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
import org.openqa.selenium.support.ui.Select;

public class CreateDoc1 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		FileInputStream fis1 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\commonData.properties");

		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Vtiger_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Document");
		
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
		
		WebElement username = driver.findElement(By.name("user_name"));
		
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.name("user_password"));
		
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Documents")).click();
		
		driver.findElement(By.cssSelector("img[title='Create Document...']")).click();
		
		WebElement Title = driver.findElement(By.name("notes_title"));
		
//		String inputTitle = "qsp"+(int)(Math.random()*9999);
		
		String inputTitle = sh.getRow(2).getCell(0).getStringCellValue()+(int)(Math.random()*9999);
		
		Title.sendKeys(inputTitle);
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		
		WebElement AssignedTo = driver.findElement(By.name("assigned_group_id"));
		
		Select selType = new Select(AssignedTo);
		
		selType.selectByVisibleText(sh.getRow(2).getCell(2).getStringCellValue());
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		WebElement notes = driver.findElement(By.tagName("body"));
		
		notes.sendKeys(sh.getRow(2).getCell(1).getStringCellValue());
		
		driver.switchTo().defaultContent();
		
		WebElement version = driver.findElement(By.name("fileversion"));
		
		Actions act = new Actions(driver);
		
		act.scrollToElement(version).perform();
		
		version.sendKeys(""+sh.getRow(2).getCell(3).getNumericCellValue());
		
		wb.close();
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String outputTitle = driver.findElement(By.id("dtlview_Title")).getText();
		
		if(outputTitle.equals(inputTitle))
		{
			System.out.println("Document Successfully created");
		}
		else
		{
			System.out.println("document not created");
		}
		
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();

	}

}
