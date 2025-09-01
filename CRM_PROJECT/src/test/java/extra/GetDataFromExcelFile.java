package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile 
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\Vtiger_Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Organisation");
		
		Row row = sh.getRow(2);
		
		Cell cell = row.getCell(0);
		
		String value = cell.getStringCellValue();
		
		System.out.println(value);
		
		wb.close();

	}

}
