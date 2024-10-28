package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Program003_DataProvider {
	@Test (dataProvider = "setOfData")
	public void bookingTickets(String src, String dest,String pass)
	{
		System.out.println("Book Tickets from " +src+ " to " +dest+ " with " +pass+ " passengers");
	}
	
	@DataProvider
	public Object[][] setOfData()
	{
		Object[][] objArr = new Object[4][3];
		objArr[0][0] = "Bangalore";
		objArr[0][1] = "Goa";
		objArr[0][2] = "3";
		
		objArr[1][0] = "Mumbai";
		objArr[1][1] = "Pune";
		objArr[1][2] = "5";
		
		objArr[2][0] = "Delhi";
		objArr[2][1] = "Noida";
		objArr[2][2] = "7";
		
		objArr[3][0] = "Hyderabad";
		objArr[3][1] = "Nagpur";
		objArr[3][2] = "9";
		
		return objArr;
	}
	
}
