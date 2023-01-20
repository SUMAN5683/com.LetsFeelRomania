
package com.tms.LetsFeelRomania.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	
	public void connectToDB() throws Throwable{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBUSERNAME,IpathConstants.DBPASSWORD);
	}
	public String executeQueryAndgetData(String query,int columnIndex,String expData) throws Throwable
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data = result.getString(columnIndex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag)
		{
			
			System.out.println("project created");
			return expData;
		}
		else {
			System.out.println("project not created");
			return "";
		}
	}
	

}
