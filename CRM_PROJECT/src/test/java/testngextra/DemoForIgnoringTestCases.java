package testngextra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoForIgnoringTestCases {

	
	@Test
	public void login()
	{
		System.out.println("logged in");
	}
	
	@Test(alwaysRun = true, enabled = false)
	public void search()
	{
		System.out.println("searched watch");
	}
	
	@Test(enabled = false)
	public void addtocart()
	{
		Assert.assertTrue(false);
		System.out.println("add to cart");
		Assert.assertTrue(true);
	}
	
	@Test
	public void payment()
	{
		System.out.println("payment successfully done !!!");
	}
	
	
}
