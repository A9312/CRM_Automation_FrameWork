package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility 
{
	public String getDataFromPropertiesFile(String Key) throws IOException
	{
		FileInputStream fis1 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\commonData.properties");
		
		Properties pObj = new Properties();
		
		pObj.load(fis1);
		
		String value1 = pObj.getProperty(Key);
		
		return value1;
	}
	
	public String getStringDataFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		String inputOrg = sh.getRow(RowNum).getCell(CellNum).getStringCellValue()+(int)(Math.random()*9999);
		
		return inputOrg;
	}
	
	public long getNumericDataFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		long phoneNumber = (long) sh.getRow(RowNum).getCell(CellNum).getNumericCellValue();
		
		return phoneNumber;
	}

	public static void main(String[] args) throws IOException {
		
		FileUtility fUtil = new FileUtility();
		
		System.out.println(fUtil.getDataFromPropertiesFile("bro"));
		
		System.out.println(fUtil.getStringDataFromExcelFile("Organisation", 1, 0));
		
		System.out.println(fUtil.getNumericDataFromExcelFile("Organisation", 1, 2));
		
		
		
	}
}
