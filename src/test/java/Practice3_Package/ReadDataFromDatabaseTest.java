package Practice3_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws SQLException {
	Connection con=null;
	try {
		Driver driver=new Driver();

		//register the database
		DriverManager.registerDriver(driver);
		//get connection for the database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root","root");
		//issue create statement
		 java.sql.Statement state = con.createStatement();
		String query="select * from studentinfo;";
		//execute query
		ResultSet result = state.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			
		}
	}
	catch(Exception e) {
		
	}
	finally {
		
	
		//close the database
	con.close();
	System.out.println("database connection ended ");
	
	
	}
	
	
	}
}
