package Practice3_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorldPopulationTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup		();
		//WebDriver driver=new ChromeDriver();
		
		
	//	ChromeOptions opt=new ChromeOptions();
		//opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		Thread.sleep(10000);
		String population = driver.findElement(By.xpath("//h1/../descendant::span[1]")).getText();
		//Thread.sleep(10000);
		System.out.println(population);
		

	}

}
