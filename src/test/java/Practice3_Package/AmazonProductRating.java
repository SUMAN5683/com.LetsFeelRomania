package Practice3_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonProductRating {
	public static void main(String[]arg)
	{
		String prod="samsung";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(prod);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		String value = driver.findElement(By.xpath("(//span[contains(text(),'.')and @class='a-size-base'])[1]")).getText();
		System.out.println(value);
	}

}
