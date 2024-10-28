package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import com.mysql.cj.jdbc.Driver;
import com.mysql.jdbc.Driver;


public class Program012_FetchingDataFromDatabase {
	public static void main(String[] args) throws Throwable {
		//Step 1: register/load mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		// Step 2: get the connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false&serverTimezone=UTC","root","root");
		
		// Step 3: create SQL statement
		Statement state = conn.createStatement();
		String query = "select * from customers";
		
		//Step 4: execute statement
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)+"\t"+result.getString(7)+"\t"+result.getString(8)+"\t"+result.getString(9)+"\t"+result.getString(10)+"\t"+result.getString(11)+"\t"+result.getString(12)+"\t"+result.getString(13));
		}
		
		//Step5: close the database
		conn.close();
		
	}

}

