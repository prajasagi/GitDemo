package DatabaseValidations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import resources.ReusableFunctions;

// note : you need to add mysql-connector-java.jar to the libraries to connect mysql
//            need to add sql-connector-java.jar to the libraries to connect sqlserver

public class DatabaseValidation extends ReusableFunctions {
	
	public String database;
@Test
	public  void testmethod() throws Exception {
		// TODO Auto-generated method stub
		//String database="SQLServer";
	String DB=DBserver();
       	
	   if ("MySQLServer".equals(DB))
		{
            System.out.println("in fun");
            Connection con =MySQLConnect();
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from EmployeeInfo");


			while(rs.next())
			{ 

				System.out.println(rs.getInt("id")); 
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("location"));
				System.out.println(rs.getInt("age"));
				System.out.println("************");
			}

		}

	   else if ("SQLServer".equals(DB))
		{
			Connection con=SQLServerConnect();
			try {
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery("SELECT TOP 10 * FROM Person.Person");
				// Iterate through the data in the result set and display it.
				while (rs.next()) {
					System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}


	}

}


