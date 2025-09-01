package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("E:\\java_workspace\\CRM_PROJECT\\src\\test\\resources\\commonData.properties");
		
		Properties pObj = new Properties();
		
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("bro");
		
		String URL = pObj.getProperty("url");
		
		String USERNAME = pObj.getProperty("un");
		
		String PASSWORD = pObj.getProperty("pwd");
		
		System.out.println(BROWSER);
		
		System.out.println(URL);
		
		System.out.println(USERNAME);
		
		System.out.println(PASSWORD);
	}

}
