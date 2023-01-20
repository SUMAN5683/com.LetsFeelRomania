package Practice3_Package;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.tms.LetsFeelRomania.generic.WebDriverUtility;

public class Vtiger {

	public static void main(String[] args) throws InterruptedException {
	String url = "http://rmgtestingserver:8888/";
	String UN="admin";
	String PW="admin";
	WebDriverUtility wu=new WebDriverUtility();
	wu.launchBrowser();
	WebDriver driver=new ChromeDriver();
	driver.get(url);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PW);
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	driver.findElement(By.xpath("//span[.=' Administrator']/../following-sibling::td[3]")).click();
	driver.findElement(By.xpath("//a[.='CRM Settings']")).click();
	WebElement workflow = driver.findElement(By.xpath("//img[@title='Workflows']"));
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeScript("arguments[0].scrollIntoView()", workflow);
	workflow.click();
	driver.findElement(By.xpath("//input[@id='new_workflow']")).click();
	Set<String> windows = driver.getWindowHandles();
	for(String wd:windows) {
		driver.switchTo().window(wd);
	}
	Select s=new Select(driver.findElement(By.id("module_list")));
	s.selectByIndex(2);
	driver.findElement(By.xpath("//input[@value='Create']")).click();
	driver.findElement(By.xpath("//input[@id='save_description']")).sendKeys("creating new");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='save_submit']")).click();
	
	driver.findElement(By.partialLinkText("Workflow")).click();
	}
	

}
