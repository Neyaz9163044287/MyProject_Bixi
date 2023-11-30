package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery 
{
	public static void main(String[] args) throws SQLException
	{	
		int result=0;
		Connection con = null;
		try 
		{
			
		//Register the Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Get connection of Database (Search in Google: mysql connection url)
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52","root","root");
		
		//Create Statement
		Statement state = con.createStatement();
		String query = "insert into marks value(9,'Elina',90,90,90),(10,'Irin',80,80,80);";
		
		//Execute Query
		result = state.executeUpdate(query);
		
		if(result==2)
			{
				System.out.println("data inserted successfully");
			}
		else
			{
				System.out.println("data is not updated");
			}}
	catch(Exception e)
	{
		System.out.println("Exception occured");
	}
	finally
	{
		//Close Database
		con.close();
	}
	}

}
