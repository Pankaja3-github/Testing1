package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//import com.mysql.jdbc.Driver;


public class Program013_InsertIntoDatabase {
	public static void main(String[] args) throws Throwable {
		//step 1: register/load mysql database
		
//		Driver driverRef = new Driver();
		
		//Step 2 : get the connect of database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","PHW#84#jeor");
	    System.out.println("Connection successful. Username and password are correct.");

		// Step 3 : create SQL statement
		Statement state = conn.createStatement();
		String query = "insert into trainer(first_name,last_name,address)values('Ram','Sam',;Goa')";
	    int result = state.executeUpdate(query);
	

		if (result == 1) {
			System.out.println("data is created");
		} else {
			System.out.println("data not created");
		}
		conn.close();
	}

}
