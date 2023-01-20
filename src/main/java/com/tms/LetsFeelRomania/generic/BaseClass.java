package com.tms.LetsFeelRomania.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//creating object for all the utility classes
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public static WebDriver ddriver; 
	
	//launching the browser
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void configureBC() throws Throwable
	{
		String browser=fLib.readPropertyFile("browser");
		String url=fLib.readPropertyFile("url");
		if(browser.equalsIgnoreCase("chrome")) 
		{
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\suman\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		ddriver=driver;
		wLib.maximizeWindow(driver);
		wLib.implicityWait(driver);
		driver.get(url);
	}
	@AfterClass(alwaysRun = true)
	public void configureAC()
	{
		driver.quit();
	}

}
