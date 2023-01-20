package Practice3_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TMSlogincredentials.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		
		 String url = wb.getSheet("Login").getRow(0).getCell(0).getStringCellValue();
		String adminUN = wb.getSheet("Login").getRow(1).getCell(0).getStringCellValue();
		String adminPW = wb.getSheet("Login").getRow(2).getCell(0).getStringCellValue();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//a[.=\"Admin Login\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(adminUN);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(adminPW);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();	

	}

}
