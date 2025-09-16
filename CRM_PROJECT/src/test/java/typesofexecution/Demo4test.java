package typesofexecution;

import org.testng.annotations.Test;

public class Demo4test {
	
	@Test(groups = "smoke")
	public void case4()
	{
		System.out.println("i am smoke");
	}
	
	@Test(groups = "reg")
	public void case5()
	{
		System.out.println("i am regression");
	}
	
	@Test(groups = "reg")
	public void case6()
	{
		System.out.println("i am regression");
	}

}
