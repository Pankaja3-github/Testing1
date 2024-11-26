package Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Program006_JDBCExecuteUpdate {
	public static void main(String[] args) throws SQLException 
	{
		//Step 1: Register the driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Establish connection with database - give database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Step 3: Issue create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute Update the query
		int result = state.executeUpdate("insert into customerinfo values('Ketan',07,'Austin');");
		if(result == 1)
		{
			System.out.println("Data Added");
		}
		System.out.println();
		
		ResultSet res = state.executeQuery("select * from customerinfo;");
		while(res.next())
		{
			System.out.println(res.getString(1));
		}
		System.out.println();
		
		//Step 5: Close the database
		con.close();
		System.out.println("Database closed");
	}

}
