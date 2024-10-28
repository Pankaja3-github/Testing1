package TestNG;

import org.testng.annotations.Test;

public class Program001_Priority {
	
	@Test(priority = 0)
	public void createContact()
	{

	System.out.println("contact created");

	}
    @Test(priority = -1)
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(priority = 1)
	public void deleteContact()
	{
		System.out.println("delete contact");
	}

}
