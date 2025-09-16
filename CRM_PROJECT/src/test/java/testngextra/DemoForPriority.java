package testngextra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoForPriority {

	@Test(priority = 1)
	public void login()
	{
		System.out.println("logged in");
	}
	
	@Test(priority = 2)
	public void search()
	{
		System.out.println("logged in");
		System.out.println("searched watch");
	}
	
	@Test(priority = 3)
	public void addtocart()
	{
		Assert.assertTrue(true);
		System.out.println("added to cart");
		Assert.assertTrue(true);
	}
	
	@Test(priority = 4)
	public void payment()
	{
		System.out.println("payemnt successfully done!!!");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
