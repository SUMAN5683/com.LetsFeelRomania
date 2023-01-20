package Practice3_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataOnRMGServer {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		try {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement state = con.createStatement();
		String query = "insert into project values('TY_LFR_00S','SUMAN','21/12/2022','Lets Feel Romania','created',3);";
		result= state.executeUpdate(query);
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(result==1) {
				System.out.println("data base created");
			}
			else {
				System.out.println("dabase not created");
			}
			con.close();
		}
		
		

	}

}
