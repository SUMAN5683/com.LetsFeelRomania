package com.tms.LetsFeelRomania.admin.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tms.LetsFeelRomania.generic.BaseClass;
import com.tms.LetsFeelRomania.generic.FileUtility;
import com.tms.LetsFeelRomania.generic.WebDriverUtility;
import com.tms.objectRepository.AdminHomePage;
import com.tms.objectRepository.AdminLoginPage;
import com.tms.objectRepository.HomePage;
import com.tms.objectRepository.ManagePackagePage;
import com.tms.objectRepository.UpdateTourPackagePage;

public class Integration_2Test extends BaseClass{

	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		String ur=fu.readPropertyFile("url");
		String username = fu.readPropertyFile("adminUN");
		String password = fu.readPropertyFile("adminPWD");
		WebDriverUtility wu=new WebDriverUtility();
		wu.launchBrowser();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		HomePage hp=new HomePage(driver);
		driver.get(ur);
		Thread.sleep(2000);
		hp.getAdminLoginLink().click();
		Thread.sleep(2000);
		AdminLoginPage al=new AdminLoginPage(driver);
		al.adminLogin(username, password);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getTourPackageTab().click();
		Thread.sleep(500);
		ahp.getManagetourPackageTab().click();
		String name="Kerla";
		ManagePackagePage mp=new ManagePackagePage();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@class='sidebar-icon']")).click();
		mp.viewDetails(name,driver);
		UpdateTourPackagePage utp=new UpdateTourPackagePage(driver);
		//string to be updated
		String toupdate="updated";
		WebElement element = utp.getPackageDetailsTextField();
		wu.scrollAction(driver, element);
		Thread.sleep(3000);
		String previousdetails = element.getText();
		String expDetails=previousdetails+toupdate;
		element.sendKeys(toupdate);
		utp.getUpdateBtn().click();
		ahp.getTourPackageTab().click();
		Thread.sleep(500);
		ahp.getManagetourPackageTab().click();
		mp.viewDetails(name,driver);
		Thread.sleep(2000);
		wu.scrollAction(driver, element);
		String updateddetails = utp.getPackageDetailsTextField().getText();
		
		//comparing the results for verification of test case
		if(updateddetails.equals(expDetails))
		{
			System.out.println("test passed");
		}
	}

}
