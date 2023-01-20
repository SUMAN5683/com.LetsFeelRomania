package com.tms.LetsFeelRomania.customer.testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class System_01Test {
	
	
	

	private static WebElement latest;

	public static void main(String[] args) throws Throwable {
		DataBaseUtility db=new DataBaseUtility();
		ExcelUtility ex=new ExcelUtility();
		FileUtility fl=new FileUtility();
		JavaUtility jv=new JavaUtility();
		WebDriverUtility wd=new WebDriverUtility();
		//fetching data from property file using utility class
		String browser = fl.readPropertyFile("browser");
		String url = fl.readPropertyFile("url");
		String adminUN = fl.readPropertyFile("adminUN");
		String adminPWD = fl.readPropertyFile("adminPWD");
		
		
		
		
		//fetching data from property file
			/*	FileInputStream fs = new FileInputStream("./src/test/resources/CommonData.properties");
				Properties p = new Properties();
				p.load(fs);
				String browser=p.getProperty("browser");
				String url = p.getProperty("url");
				String adminUN = p.getProperty("adminUN");
				String adminPW = p.getProperty("adminPWD");*/
				
		//random class to change input tour data random
				Random ran=new Random();
				int random=ran.nextInt(500);
				
		//data formatter(will fetch data from excel only in string format)
				DataFormatter format=new DataFormatter();
				
				
				
		//fetching package data from excel(Tour package sheet)
				FileInputStream fis = new FileInputStream("./src/test/resources/TMSlogincredentials.xlsx");
				Workbook wb= WorkbookFactory.create(fis);
				Sheet book = wb.getSheet("TourPackage");
				
				 String name = wb.getSheet("TourPackage").getRow(1).getCell(0).getStringCellValue()+random;
					String type = wb.getSheet("TourPackage").getRow(1).getCell(1).getStringCellValue()+random;
					String location = wb.getSheet("TourPackage").getRow(1).getCell(2).getStringCellValue()+random;
					String price = format.formatCellValue(book.getRow(1).getCell(3))+random;
				 
				 	String feature = wb.getSheet("TourPackage").getRow(1).getCell(4).getStringCellValue()+random;
					String details = wb.getSheet("TourPackage").getRow(1).getCell(5).getStringCellValue()+random;
					System.out.println(name);
				
					//test script execution
					//WebDriver driver = WebDriverManager.chromedriver().create();
					//WebDriverUtility wd=new WebDriverUtility();
					wd.launchBrowser();
					WebDriver driver=null;
					if(browser.equalsIgnoreCase("chrome")) {
						driver=new ChromeDriver();
						//driver=WebDriverManager.chromedriver().create();
						
					}
					else {
						
					}
					//WebDriver driver=new ChromeDriver();
					driver.manage().window().maximize();
					driver.get(url);
					driver.findElement(By.xpath("//a[.=\"Admin Login\"]")).click();
					driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(adminUN);
					driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(adminPWD);
					driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
				
					//creating package
					driver.findElement(By.xpath("//span[.=\" Tour Packages\"]")).click();
					driver.findElement(By.xpath("//a[.=\"Create\"]")).click();
					driver.findElement(By.xpath("//input[@id='packagename']")).sendKeys(name);
					driver.findElement(By.xpath("//input[@id='packagetype']")).sendKeys(type);
					driver.findElement(By.xpath("//input[@id='packagelocation']")).sendKeys(location);
					driver.findElement(By.xpath("//input[@id='packageprice']")).sendKeys(price);
					JavascriptExecutor j=(JavascriptExecutor)driver;
					j.executeScript("window.scrollBy(0,1000)");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@id='packagefeatures']")).sendKeys(feature);
					Thread.sleep(500);
					driver.findElement(By.id("packagedetails")).sendKeys(details);
					driver.findElement(By.xpath("//input[@id='packageimage']")).sendKeys("D:\\laptop\\DOWNLOAD/wall.jpg");
					driver.findElement(By.xpath("//button[.='Create']")).click();
					driver.findElement(By.xpath("//span[.=\" Tour Packages\"]")).click();
					driver.findElement(By.xpath("//a[.=\"Manage\"]")).click();
					Thread.sleep(2000);
					//driver.findElement(By.xpath("//span[.='"+name+"']/../following-sibling::td[5]/descendant::button[.='View Details']")).click();
					latest=driver.findElement(By.xpath("(//td[@data-th=\"Name\"])[last()]"));
				JavascriptExecutor jse=(JavascriptExecutor) driver;
				jse.executeScript("arguments[0].scrollIntoView()",latest);
				driver.findElement(By.xpath("(//td[@data-th=\"Name\"])[last()]/following-sibling::td[5]/descendant::button[.=\"View Details\"]")).click();
				jse.executeScript("window.scrollBy(0,500)");
				driver.findElement(By.xpath("//textarea[@id=\"packagedetails\"]")).sendKeys("updated");
				WebElement upd = driver.findElement(By.xpath("//button[.='Update']"));
				jse.executeScript("arguments[0].scrollIntoView()",upd);
				upd.click();
				if(driver.findElement(By.xpath("//strong[.='SUCCESS']")).isDisplayed()) {
					System.out.println("test success");
				}


	}

}
