package testngextra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoForDependency {

	@Test
	public void login()
	{
		System.out.println("logged in");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "login")
	public void search()
	{
		System.out.println("searched watch");
	}
	
	@Test(dependsOnMethods = "search")
	public void addtocart()
	{
		Assert.assertTrue(false);
		System.out.println("added to cart");
	}
	
	@Test(dependsOnMethods = "addtocart", alwaysRun = true)
	public void payment()
	{
		System.out.println("payment successfully done!!!");
	}
	
	
	
	
	
	
}
