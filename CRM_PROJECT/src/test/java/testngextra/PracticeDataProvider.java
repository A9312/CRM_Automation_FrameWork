package testngextra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeDataProvider {
	
	@Test(dataProvider = "getdata")
	public void case1(String un, String pwd)
	{
		System.out.println(un);
		System.out.println(pwd);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] credentials = new Object[5][2];
		
		credentials[0][0] = "amit";
		credentials[0][1] = "amit";
		
		credentials[1][0] = "amit";
		credentials[1][1] = "amit";
		
		credentials[2][0] = "amit";
		credentials[2][1] = "amit";
		
		credentials[3][0] = "amit";
		credentials[3][1] = "amit";
		
		credentials[4][0] = "amit";
		credentials[4][1] = "amit";
		
		return credentials;
	}
}
