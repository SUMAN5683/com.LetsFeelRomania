package com.tms.LetsFeelRomania.customer.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tms.LetsFeelRomania.generic.DataBaseUtility;
import com.tms.LetsFeelRomania.generic.ExcelUtility;
import com.tms.LetsFeelRomania.generic.FileUtility;
import com.tms.LetsFeelRomania.generic.JavaUtility;
import com.tms.LetsFeelRomania.generic.WebDriverUtility;

public class System_02Test {
	public static void main(String[]arg) throws Throwable {
		//creating object for utility classes
		DataBaseUtility db=new DataBaseUtility();
		ExcelUtility ex=new ExcelUtility();
		FileUtility fl=new FileUtility();
		JavaUtility jv=new JavaUtility(); 
		WebDriverUtility wd=new WebDriverUtility();
		
		//fetching data from property file using utility class
		//String browser = fl.readPropertyFile("browser");
		String url = fl.readPropertyFile("url");
		String adminUN = fl.readPropertyFile("adminUN");
		String adminPWD = fl.readPropertyFile("adminPWD");
		
		//opening browser
		wd.launchBrowser();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		wd.maximizeWindow(driver);
		//login as admin 
		driver.findElement(By.xpath("//a[.=\"Admin Login\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(adminUN);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(adminPWD);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		//tour package-->manage
		driver.findElement(By.xpath("//span[.=\" Tour Packages\"]")).click();
		driver.findElement(By.xpath("//a[.=\"Manage\"]")).click();
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("(//td[@data-th=\"Name\"])[last()]/following-sibling::td[5]/descendant::button[.=\"View Details\"]")).click();
		
		//changing image
		 WebElement target = driver.findElement(By.xpath("//a[.='Change Image']"));
		jse.executeScript("arguments[0].scrollIntoView()",target);
		target.click();
		
		//changing image and update
		driver.findElement(By.xpath("//input[@id='packageimage']")).sendKeys("C:\\Users\\suman\\OneDrive\\Pictures\\Saved Pictures\\romanian.jpg");
		driver.findElement(By.xpath("//button[.='Update']")).click();
		//validating successfull message
		if(driver.findElement(By.xpath("//strong[.='SUCCESS']")).isDisplayed()) {
			System.out.println("image update success");
		}

	}

}
