package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility_1 {
	
	public String getDataFromPropertiesFile(String Key) throws IOException
	{
		FileInputStream fis1 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\commonData.properties");
		
		Properties pObj = new Properties();
		
		pObj.load(fis1);
		
		String value1 = pObj.getProperty(Key);
		
		return value1;
	}
	
	public String getOrgNameDataFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		String inputOrg = sh.getRow(RowNum).getCell(CellNum).getStringCellValue()+(int)(Math.random()*9999);
		
		return inputOrg;
	}
	
	public String getPhoneDataFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		String inputPhone = String.valueOf((long) sh.getRow(RowNum).getCell(CellNum).getNumericCellValue());
		
		return inputPhone;
	}
	
	
	public String getIndustryNameDataFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		String inputIndustry = sh.getRow(RowNum).getCell(CellNum).getStringCellValue();
		
		return inputIndustry;
	}
	
	public String getEmpNoDataFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		String EmployeeNo = String.valueOf((long) sh.getRow(RowNum).getCell(CellNum).getNumericCellValue());
		
		return EmployeeNo;
	}
	
	public String getDocumentTitleDataFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		String inputDocTitle = sh.getRow(RowNum).getCell(CellNum).getStringCellValue();
		
		return inputDocTitle;
	}
	
	public String getGroupNameFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		String inputGroup = sh.getRow(RowNum).getCell(CellNum).getStringCellValue();
		
		return inputGroup;
	}
	
	public String getNotesFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		String inputnotes = sh.getRow(RowNum).getCell(CellNum).getStringCellValue();
		
		return inputnotes;
	}
	
	public String getVersionFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2 = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Test_Script_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet(SheetName);
		
		String inputversion = sh.getRow(RowNum).getCell(CellNum).getStringCellValue();
		
		return inputversion;
	}
}
