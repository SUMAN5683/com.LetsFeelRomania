package Practice3_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HowAnnotationWorks {
	@BeforeSuite
	public void connectDb() {
		System.out.println("connect db");
	}
	
	@AfterSuite
	public void closeDb() {
		System.out.println("disconnect db");
	}
	
	@BeforeClass
	public void openBrowser()
	{
		System.out.println("open browser");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("close browser");
	}
	
	@BeforeMethod
	public void loginapp() {
		System.out.println("login app");
	}
	
	@AfterMethod
	public void logoutApp() {
		System.out.println("logout app");
	}
	
	@Test()
	public void create() {
		System.out.println("create");
	}
	@Test(dependsOnMethods = "create")
	public void update() {
		System.out.println("updated");
	}
	@Test(priority = 1)
	public void delete() {
		System.out.println("deleted");
	}
}

