package Practice3_Package;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MicTest {
	public static void main(String[] args) throws Throwable {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-media-stream");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(opt);
		driver.get("https://mictests.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[.='Test my mic']")).click();
		Thread.sleep(4000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		
		
		// WebElement resulttext = driver.findElement(By.xpath("//h3[.='Testing Area']/../ul/li[@class='notice-done done_testingComplete']"));
		WebElement element = driver.findElement(By.xpath("//ul[@id='mic-notices']"));
		WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
			//String status = resulttext.getText();
			//System.out.println(status);
			System.out.println(element.getText());
		
	}
}
