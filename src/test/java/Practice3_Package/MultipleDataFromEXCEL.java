package Practice3_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleDataFromEXCEL {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TMSlogincredentials.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		int rowcount=wb.getSheet("Login").getLastRowNum();
		
		ArrayList<String> array=new ArrayList<String>();
		for(int i=0;i<=rowcount;i++) {
			String data = wb.getSheet("Login").getRow(i).getCell(0).getStringCellValue();
		     array.add(data);
		;
		}
		String url = array.get(0);
		String adminUN = array.get(1);
		String adminPW = array.get(2);
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//a[.=\"Admin Login\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(adminUN);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(adminPW);
		driver.findElement(By.xpath("//input[@name=\"login\"]")).click();	

	}


}
