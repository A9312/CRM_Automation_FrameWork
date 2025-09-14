package organisations;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
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

import generic_utility.FileUtility;
import generic_utility.FileUtility_1;
import generic_utility.WebdriverUtility;
import object_repository.CreateOrgPage;
import object_repository.SignOutPage;
import object_repository.VerifyOrgPage;
import object_repository.Vtiger_LoginPage;

public class CreateOrg2 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		FileUtility_1 FUtil = new FileUtility_1();
		
//		FileInputStream fis1 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\commonData.properties");
		
//		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
//		
//		Workbook wb = WorkbookFactory.create(fis2);
//		
//		Sheet sh = wb.getSheet("Organisation");
		
//		Properties pObj = new Properties();
//		
//		pObj.load(fis1);
//		
//		String BROWSER = pObj.getProperty("bro");
//		
//		String URL = pObj.getProperty("url");
//		
//		String USERNAME = pObj.getProperty("un");
//		
//		String PASSWORD = pObj.getProperty("pwd");
		
		String BROWSER = FUtil.getDataFromPropertiesFile("bro");
		
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
		
		driver.get(FUtil.getDataFromPropertiesFile("url"));
		
//		WebElement username = driver.findElement(By.name("user_name"));
//		
//		WebElement password = driver.findElement(By.name("user_password"));
		
		Vtiger_LoginPage vp = new Vtiger_LoginPage(driver);
		
//		username.sendKeys(USERNAME);
//		
//		password.sendKeys(PASSWORD);
		
		vp.getUsername().sendKeys(FUtil.getDataFromPropertiesFile("un"));
		vp.getPassword().sendKeys(FUtil.getDataFromPropertiesFile("pwd"));
		
//		
//		WebElement loginbtn = driver.findElement(By.id("submitButton"));
		
//		loginbtn.click();
		vp.getLoginbtn().click();
		
//		WebElement Organisations= driver.findElement(By.linkText("Organizations"));
		
		CreateOrgPage op = new CreateOrgPage(driver);
		
		op.getOrganisations().click();
		
//		Organisations.click();
		
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		op.getPlusicon().click();
		
//		String inputOrg = "qsp"+(int)(Math.random()*9999);
		
//		String inputOrg = sh.getRow(1).getCell(0).getStringCellValue()+(int)(Math.random()*9999);
		
		String inputOrg= FUtil.getOrgNameDataFromExcelFile("Organisation", 1, 0);
		
//		WebElement orgField = driver.findElement(By.name("accountname"));
		
		op.getOrgField().sendKeys(inputOrg);
		
//		orgField.sendKeys(inputOrg);
		
//		WebElement phoneField = driver.findElement(By.id("phone"));
		
//		String inputPhone = String.valueOf((long) sh.getRow(1).getCell(2).getNumericCellValue());
		
		String inputPhone = FUtil.getPhoneDataFromExcelFile("Organisation",1, 2);
		
		op.getPhoneField().sendKeys(inputPhone);
		
		//		phoneField.sendKeys(String.valueOf(phoneNumber));
		
		WebdriverUtility WUtil = new WebdriverUtility(driver);
		
//		WebElement IndustryDD = driver.findElement(By.name("industry"));
		
//		List<WebElement> opts = WUtil.GetOptions(IndustryDD);
//		for (WebElement i : opts) {
//			System.out.println(i.getText());
//		}
		
		
//		Select selIndustry = new Select(op.getIndustryDD());
//		
//		selIndustry.selectByValue(sh.getRow(1).getCell(4).getStringCellValue());
		
//		String inputIndustry = sh.getRow(1).getCell(4).getStringCellValue();
		
		String inputIndustry = FUtil.getIndustryNameDataFromExcelFile("Organisation", 1, 4);
		
		WUtil.SelectByValue(op.getIndustryDD(), inputIndustry);
		
//		WebElement Employees = driver.findElement(By.id("employees"));
	
//		String EmployeeNo = String.valueOf((long) sh.getRow(1).getCell(3).getNumericCellValue());
		
		String EmployeeNo = FUtil.getEmpNoDataFromExcelFile("Organisation", 1, 3);
		
		op.getEmployees().sendKeys(EmployeeNo);
		
//		Employees.sendKeys(""+EmployeeNo);
		
//		wb.close();
		
		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		
		op.getSaveBtn().click();
		
		Thread.sleep(2000);
		
//		String outputOrg = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		
//		if(outputOrg.equals(inputOrg))
//		{
//			System.out.println("Organisation created successfully");
//		}
//		else
//		{
//			System.out.println("organisation not created successfully");
//		}
		
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		
		vop.OrgVerify(vop.getOutputOrg().getText(), inputOrg);
		
//		String outputPhone = driver.findElement(By.id("dtlview_Phone")).getText();
//		
//		String outputEMPno = driver.findElement(By.id("dtlview_Employees")).getText();
//		
//		String outputIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		
		vop.PhoneVerify(vop.getOutputPhone().getText(), inputPhone);
		
		vop.IndustryVerify(vop.getOutputIndustry().getText(), inputIndustry);
		
		vop.EMPNOVerify(vop.getOutputEMPno().getText(), EmployeeNo);
		
//		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		SignOutPage sop = new SignOutPage(driver);
	
//		Actions act = new Actions(driver);
//		
//		act.moveToElement(profile).build().perform();
		
//		WUtil.Hover(profile);
		
		WUtil.Hover(sop.getProfile());
		
//		driver.findElement(By.linkText("Sign Out")).click();
		
		sop.getSignOut().click();
	
		driver.close();

	}

}
