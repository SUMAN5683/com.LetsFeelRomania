package Practice3_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGTest {

	public static void main(String[] args) throws InterruptedException, SQLException {
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.=\"Sign in\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.=\"Create Project\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"projectName\"]")).sendKeys("LetsFeelRomania..SUMAN");
		driver.findElement(By.xpath("//input[@name=\"createdBy\"]")).sendKeys("SANJAY");
	 WebElement option = driver.findElement(By.xpath("(//select[@name=\"status\"])[2]"));
	 Select s=new Select(option);
	 s.selectByVisibleText("Created");
	 driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();*/
	 
	 
	 Connection con=null;
		
		ResultSet result;
		try {
			Driver driver1=new Driver();
			DriverManager.registerDriver(driver1);
		
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement state = con.createStatement();
		String query = "select * from project where lower(created_by)='sanjay';";
		result= state.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
		}
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			
			con.close();
		}
	 
	 
	 
	
			
		}



}
