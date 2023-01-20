package Practice3_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {
	public static void main(String[]arg) {
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("its running");
		driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[2]")).click();
	}

}
