package Practice3_Package;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
	
		String departuredate = "13 Jan 23";// 00 Mon YY
		String returndate=""
				+ "";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//div[@class='loginModal displayBlock modalLogin dynHeight personal']")).click();
		
		if (returndate.equals(""))
		{
			driver.findElement(By.xpath("//li[.='OneWay']")).click();
			
		}
		else
		{
			driver.findElement(By.xpath("//li[.='Round Trip']")).click();
		}
		
		
		
		
		
	}

}
