package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest01 
{
	public static void main(String[] args) throws SQLException 
	{
		//Register the Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Get connection of Database (Search in Google: mysql connection url)
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52","root","root");
		
		//Create Statement
		Statement state = con.createStatement();
		String query = "select * from marks;";
		
		//Execute Query
		 ResultSet result = state.executeQuery(query);
		 
		while(result.next())
		{
			System.out.println(result.getString(1)+"    "+result.getString(2)+"    "+result.getString(3)+"    "+result.getString(4)+"    "+result.getString(5));
		}
		
		//Close Database
		con.close();
	}

}
