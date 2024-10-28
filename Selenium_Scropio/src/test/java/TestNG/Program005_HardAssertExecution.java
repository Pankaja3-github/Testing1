package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Program005_HardAssertExecution {
	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(false, false);
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void m2()
	{
		int a = 1 ;
		int b = 10;
		Assert.assertEquals(a, b, "Both are not equal = ");
		System.out.println("It is Equal");
		
	}
	
	@Test
	public void m3()
	{
		int a = 10 ;
		int b = 10;
		Assert.assertNotEquals(a, b, "Both are equal = ");
		System.out.println("It is not Equal");
	}
	
	@Test
	public void m4() 
	{
		String s1 = "Hello";
		String s2 = "Hello1";
		Assert.assertTrue(s1.equalsIgnoreCase(s2), "False = ");
		System.out.println("True = ");
	}
	
	@Test
	public void m5()
	{
		String s1 = "Hello";
		String s2 = "Hello";
		Assert.assertFalse(s1.equalsIgnoreCase(s2),"Assert contains");
		System.out.println("Assert not contains");
	}
	
	@Test
	public void m6()
	{
		String s = "Hi";
		Assert.assertNull(s, "It is not Null");
		System.out.println("It is Null");
	}
	
	@Test
	public void m7()
	{
		String s = null;
		Assert.assertNull(s, "It is not Null");
		System.out.println("It is Null");
	}
	
	@Test
	public void m8()
	{
		int a = 1;
		int b = 1;
		Assert.assertSame(a, b, "Not same");
		System.out.println("Assert Same");
	}
	
	@Test
	public void m9()
	{
		int a = 10;
		int b = 20;
		Assert.assertNotSame(a, b, "Assert same");
		System.out.println("Assert Not Same");
	}
	
//	@Test
//	public void m10()
//	{
//		Assert.fail("I am failing the TestScript");
//	}

}
