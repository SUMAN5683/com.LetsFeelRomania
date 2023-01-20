package Practice3_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintText {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/package-list.php");
		
		Thread.sleep(1000);
		WebElement desiredelement = driver.findElement(By.xpath("//h4[contains(.,'Package Name: etrtrr')]"));
		boolean status = desiredelement.isDisplayed();
		System.out.println(status);
		if(status==false) {
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()",desiredelement);
		Thread.sleep(4000);
			String text = desiredelement.getText();
			Thread.sleep(4000);
			System.out.println(text);
		}
		
		
	}

}
