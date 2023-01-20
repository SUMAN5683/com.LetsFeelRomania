package Practice3_Package;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tms.LetsFeelRomania.generic.ExcelUtility;

public class DataProviderFromExcelTest {
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eu=new ExcelUtility();
		Object[][] value=eu.readDataDataProvider("DataProvider");
		return value;
				
	}
	@Test(dataProvider = "getData")
	public void readData(String from, String to)
	{
		Reporter.log(from+"----->"+to,true);
		
	}

}
