package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class QueryAssignmentByPrakashSirTest  
{
	public static void main(String[] args) throws SQLException
	{	Connection conn = null;
		
		System.out.println("==================");
		try {
			
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String nm = sc.nextLine();
		
		Driver driverRef = new Driver();
		
		// load mysql to the database
		DriverManager.registerDriver(driverRef);
		
		// connect to database
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet52","root","root");
		
		//create query statement
		Statement state = conn.createStatement();
		String query = "select name from emp;";
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			String data = result.getString(1);
			if(data!=nm)
			{
				Statement state1 = conn.createStatement();
				String query1 = "insert into emp value('"+nm+"', 28);";
				int result1 = state1.executeUpdate(query1);
				//break;				
			}
			else
			{
				System.out.println("Name already Pesesnt");
			}
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
			
		finally {
			conn.close();	
		}
					
	}

}
