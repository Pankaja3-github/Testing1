package Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Program005_JDBCExecuteQuery 
{
	public static void main(String[] args) throws SQLException 
	{
		//Step 1: Register the driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Establish connection with database - give database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Step 3: Issue create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute the query
		ResultSet result = state.executeQuery("select * from customerinfo;");
		while(result.next())
		{
			System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}
		System.out.println();
		
		//Step 5: Close the database
		con.close();
		System.out.println("Database closed");
	}

}
