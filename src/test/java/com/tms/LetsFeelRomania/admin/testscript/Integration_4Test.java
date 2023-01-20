package com.tms.LetsFeelRomania.admin.testscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Integration_4Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		//fetching data from property file
		FileInputStream fs = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fs);
		String url = p.getProperty("url");
		String adminUN = p.getProperty("adminUN");
		String adminPW = p.getProperty("adminPWD");
		String custUN=p.getProperty("custUN");
		String custPWD = p.getProperty("custPWD");
		
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
		//System.out.println(name);
	
		//test script execution
		//WebDriver driver = WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//a[.=\"Admin Login\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(adminUN);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(adminPW);
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
		
		//logging out as admin
		driver.findElement(By.xpath("//div[@class='user-name']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		
		//login as customer
		driver.findElement(By.xpath("//a[.='Back to home']")).click();
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(custUN);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(custPWD);
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Tour Packages")).click();
		
	
		List<WebElement> createdpackage = driver.findElements(By.xpath("//div[@class='rom-btm']/div[2]/h4"));
		System.out.println(createdpackage.size());
		
		for(int i=0;i<createdpackage.size();i++) {
			//if(createdpackage.get(i).getText().equals("Package Name:" +name)) {
			
			//System.out.println("test success");
			//Thread.sleep(5000);
				System.out.println(createdpackage.get(i).getText());
	
		}
		
		}
		
		
			
		
	}

		
		
		
	



