package Practice3_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyDataTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String adminUN = p.getProperty("adminUN");
		String adminPW = p.getProperty("adminPWD");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//a[.=\"Admin Login\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(adminUN);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(adminPW);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();
		
		
		

	}

}
