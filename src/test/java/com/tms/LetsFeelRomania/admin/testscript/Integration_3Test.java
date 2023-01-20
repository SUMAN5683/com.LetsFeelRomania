package com.tms.LetsFeelRomania.admin.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tms.LetsFeelRomania.generic.BaseClass;
import com.tms.LetsFeelRomania.generic.ExcelUtility;
import com.tms.LetsFeelRomania.generic.FileUtility;
import com.tms.LetsFeelRomania.generic.JavaUtility;
import com.tms.LetsFeelRomania.generic.WebDriverUtility;
import com.tms.objectRepository.AdminHomePage;
import com.tms.objectRepository.AdminLoginPage;
import com.tms.objectRepository.CreatePackagePage;
import com.tms.objectRepository.HomePage;

public class Integration_3Test extends BaseClass{
	
	@BeforeMethod
	public void loginasAdmmin() throws Throwable {
		String username = fLib.readPropertyFile("adminUN");
		String password = fLib.readPropertyFile("adminPWD");
		HomePage hp=new HomePage(driver);
		hp.getAdminLoginLink().click();
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogin(username, password);
	}
	@Test
	public void createTourPackage() throws Throwable

	{
		//FileUtility fu=new FileUtility();
		//String ur=fu.readPropertyFile("url");
		//String username = fu.readPropertyFile("adminUN");
		//String password = fu.readPropertyFile("adminPWD");
		//fetch package details data from excel
		//JavaUtility ju=new JavaUtility();
		int random = jLib.getRandomNo();
		//ExcelUtility eu=new ExcelUtility();
		
		ArrayList<String> data = eLib.getList("TourPackage", 1);
		String name=data.get(0)+random;
		String type=data.get(1)+random;
		String loc=data.get(2)+random;
		String price=data.get(3)+random;
		String feature=data.get(4);
		String details=data.get(5);
		String img=data.get(6);
		//WebDriverUtility wu=new WebDriverUtility();
		//wu.launchBrowser();
		//WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//HomePage hp=new HomePage(driver);
		//driver.get(ur);
		//Thread.sleep(2000);
		//hp.getAdminLoginLink().click();
		//Thread.sleep(2000);
		//AdminLoginPage al=new AdminLoginPage(driver);
		//al.adminLogin(username, password);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getTourPackageTab().click();
		Thread.sleep(500);
		ahp.getCreatetourPackageTab().click();
		
		CreatePackagePage cp=new CreatePackagePage(driver);
		cp.createPackage(driver,name, type, loc, price, feature, details, img);
		boolean status = driver.findElement(By.xpath("//div[contains(text(),':Package Created Successfully ')]")).isDisplayed();
		if(status)
		{
			System.out.println("package created successfully");
		}
	}

}
