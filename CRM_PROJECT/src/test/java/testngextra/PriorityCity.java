package testngextra;

import org.testng.annotations.Test;

public class PriorityCity {
	
	@Test
	public void createcity()
	{
		System.out.println("noida created");
	}
	
	@Test
	public void modify()
	{
		System.out.println("noida created");
		System.out.println("noida modified to okhla");
	}
	
	@Test
	public void deletecity()
	{
		System.out.println("okhla created");
		System.out.println("okhla deleted");
	}

}
