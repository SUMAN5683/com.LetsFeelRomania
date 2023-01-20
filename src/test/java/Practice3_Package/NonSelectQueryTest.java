package Practice3_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		int result=0;
		try {
			Driver driver=new Driver();
			//register database
			DriverManager.registerDriver(driver);
			
			//get connection for database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root","root");
			
			//create statement
			 java.sql.Statement state = con.createStatement();
			 String query = "insert into studentinfo values('suman','btm','appium',1);";
			 
			//update query
			 result=state.executeUpdate(query);
			 
		}
		catch(Exception e) {
			
		}
		finally {
			if(result==1) {
				
				System.out.println("data inserted successfull"); 
			}
			else {
				System.out.println("data not inserted ");
			}
			//close the database connection
			con.close();
			
		}
		

	}

}
