package Practice3_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
	public static void main(String[]arg) throws Throwable
	{
		String from="patna";
		String to="ranchi";
		String dat = "19 Mar 2023"; //(enter July,Sept,rest months like Jan)
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//label[.='FROM']/../input")).sendKeys(from);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/li[1]")).click();
		driver.findElement(By.xpath("//label[.='TO']/../input")).sendKeys(to);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/li[1]")).click();
		
		driver.findElement(By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']")).click();
		
		String[] date = dat.split(" ");
		String cdate=date[0];
		String month = date[1];
		String currm = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		String[] currentmth=currm.split(" ");
		String currentmonth=currentmth[0];
		System.out.println(currentmonth);
		boolean res = currentmonth.equals(month);

			while(res==false)
			{
			driver.findElement(By.xpath("//td[@class='next']")).click();
			String currmup = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText(); 
			String[] currmm=currmup.split(" ");
			String upmonth=currmm[0];
			System.out.println(upmonth);
			//currm=upmonth;
			//System.out.println(currm);
			if(upmonth.equals(month))
				res=true;
			else
				res=false;
			}
			driver.findElement(By.xpath("//td[.='"+cdate+"']")).click();
		
		driver.findElement(By.xpath("//button[.='Search Buses']")).click();
	}


}