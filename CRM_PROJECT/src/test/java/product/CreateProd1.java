package product;

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

public class CreateProd1 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis1 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\commonData.properties");

		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Vtiger_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Product");
		
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
		
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
		
		WebElement ProductName = driver.findElement(By.name("productname"));
		
//		String inputProdName = "qsp"+(int)(Math.random()*9999);
		
		String inputProdName = sh.getRow(1).getCell(0).getStringCellValue()+(int)(Math.random()*9999);
		
		ProductName.sendKeys(inputProdName);
		
		WebElement ProductCategory = driver.findElement(By.name("productcategory"));
		
		Select selCat = new Select(ProductCategory);
		
		selCat.selectByValue(sh.getRow(1).getCell(2).getStringCellValue());
		
		WebElement PartNumber = driver.findElement(By.id("productcode"));
		
		PartNumber.sendKeys(sh.getRow(1).getCell(1).getStringCellValue());
		
		WebElement website = driver.findElement(By.name("website"));
		
		website.sendKeys(sh.getRow(1).getCell(3).getStringCellValue());

		WebElement UnitPrice = driver.findElement(By.id("unit_price"));
		
		Actions act = new Actions(driver);
		
		act.scrollToElement(UnitPrice).build().perform();
		
		UnitPrice.sendKeys(""+sh.getRow(1).getCell(4).getNumericCellValue());
		
		wb.close();
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String outputProdName = driver.findElement(By.id("dtlview_Product Name")).getText();
		
		if(outputProdName.equals(inputProdName))
		{
			System.out.println("Product successfully created");
		}
		else
		{
			System.out.println("Product not created");
		}
		
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();

	}

}
