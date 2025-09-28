package document;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base_utility.BaseClass2;
import generic_utility.FileUtility_1;
import generic_utility.WebdriverUtility;
import object_repository.CreateDocPage;
import object_repository.SignOutPage;
import object_repository.VerifyDocPage;

public class CreateDoc1 extends BaseClass2
{
	
	@Test
	public void createdoc() throws EncryptedDocumentException, IOException
	{
		

//	public static void main(String[] args) throws InterruptedException, IOException 
//	{
//		FileInputStream fis1 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\commonData.properties");
//
//		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Vtiger_Data.xlsx");
//		
//		Workbook wb = WorkbookFactory.create(fis2);
//		
//		Sheet sh = wb.getSheet("Document");
//		
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
//		
//		WebDriver driver = null;
//		
//		if(BROWSER.equals("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equals("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(BROWSER.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			driver = new ChromeDriver();
//		}
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		
//		driver.get(URL);
//		
//		WebElement username = driver.findElement(By.name("user_name"));
//		
//		username.sendKeys(USERNAME);
//		
//		WebElement password = driver.findElement(By.name("user_password"));
//		
//		password.sendKeys(PASSWORD);
		

		
		FileUtility_1 futil = new FileUtility_1();
		
		CreateDocPage cop = new CreateDocPage(driver);
//		
//		driver.findElement(By.id("submitButton")).click();
		
//		driver.findElement(By.linkText("Documents")).click();
		
		cop.getDocuments().click();
		
//		driver.findElement(By.cssSelector("img[title='Create Document...']")).click();
		
		cop.getCreatedocbtn().click();
		
//		WebElement Title = driver.findElement(By.name("notes_title"));
		
//		String inputTitle = "qsp"+(int)(Math.random()*9999);
		
//		String inputTitle = sh.getRow(2).getCell(0).getStringCellValue()+(int)(Math.random()*9999);
		
		String inputTitle = futil.getDocumentTitleDataFromExcelFile("Document", 1, 0)+(int)(Math.random()*9999);
		
//		Title.sendKeys(inputTitle);
		
		cop.getTitle().sendKeys(inputTitle);
		
//		driver.findElement(By.xpath("//input[@value='T']")).click();
		
		cop.getGroupradiobtn().click();
		
//		WebElement AssignedTo = driver.findElement(By.name("assigned_group_id"));
		
//		Select selType = new Select(AssignedTo);
		
		Select selType = new Select(cop.getAssignedTo());
		
//		selType.selectByVisibleText(sh.getRow(2).getCell(2).getStringCellValue());
		
		String inputGroup = futil.getGroupNameFromExcelFile("Document", 1, 2);
		
		selType.selectByVisibleText(inputGroup);
		
//		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		driver.switchTo().frame(cop.getDescriptionframe());
		
//		WebElement notes = driver.findElement(By.tagName("body"));
		
		String inputnotes = futil.getNotesFromExcelFile("Document", 1, 1);
		
		cop.getNotes().sendKeys(inputnotes);
		
//		notes.sendKeys(sh.getRow(2).getCell(1).getStringCellValue());
		
		driver.switchTo().defaultContent();
		
//		WebElement version = driver.findElement(By.name("fileversion"));
		
		WebdriverUtility wutil = new WebdriverUtility(driver);
		
//		Actions act = new Actions(driver);
		
//		act.scrollToElement(version).perform();
		
		wutil.Hover(cop.getVersion());
		
//		version.sendKeys(""+sh.getRow(2).getCell(3).getNumericCellValue());
		
		String inputverison = futil.getVersionFromExcelFile("Document", 1, 3);
		
		cop.getVersion().sendKeys(inputverison);
		
//		wb.close();
		
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		cop.getSavebtn().click();
		
//		String outputTitle = driver.findElement(By.id("dtlview_Title")).getText();
		
//		String outputTitle = 
		
//		if(outputTitle.equals(inputTitle))
//		{
//			System.out.println("Document Successfully created");
//		}
//		else
//		{
//			System.out.println("document not created");
//		}
		
		VerifyDocPage vop = new VerifyDocPage(driver);
		
		vop.DocTitleVerify(vop.getOutputTitle().getText(), inputTitle);
		
		vop.GroupVerify(vop.getOutputGroup().getText(), inputGroup);
		
		vop.NotesVerify(vop.getOutputNotes().getText(), inputnotes);
		
		vop.VersionVerify(vop.getOutputVersion().getText(), inputverison);
		
//		SignOutPage sop = new SignOutPage(driver);
//		
//		wutil.Hover(sop.getProfile());
//		
//		wutil.Click(sop.getSignOut());

		
//		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
//		act.moveToElement(profile).build().perform();
		
//		driver.findElement(By.linkText("Sign Out")).click();
		
//		driver.quit();

	}

}
