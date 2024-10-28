package TestNG;

import org.testng.annotations.Test;

public class Program002_DependsOnMethodTest {
	
	@Test
	public void createProduct()
	{
		System.out.println("Product Created");
	}
	
	@Test (dependsOnMethods = "createProduct")
	public void modifyProduct()
	{
		System.out.println("Product Modified");
	}
	
	@Test (dependsOnMethods = "createProduct")
	public void deleteProduct()
	{
		System.out.println("Product Deleted");
	}
	
	//Whether methods on this class/method are enabled.
	@Test (enabled = false)
	public void enableTestMethod()
	{
		System.out.println("Disable Method");
	}
	
	//The number of times this method should be invoked
	@Test (invocationCount = 2)
	public void invocationTestMethod()
	{
		System.out.println("Invocation Method");
	}

}
