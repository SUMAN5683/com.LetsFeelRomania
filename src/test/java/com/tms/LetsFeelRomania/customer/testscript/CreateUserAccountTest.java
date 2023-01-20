package com.tms.LetsFeelRomania.customer.testscript;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tms.LetsFeelRomania.generic.DataBaseUtility;
import com.tms.LetsFeelRomania.generic.ExcelUtility;
import com.tms.LetsFeelRomania.generic.FileUtility;
import com.tms.LetsFeelRomania.generic.IpathConstants;
import com.tms.LetsFeelRomania.generic.WebDriverUtility;
import com.tms.objectRepository.HomePage;

public class CreateUserAccountTest {

	public static void main(String[] args) throws Throwable {
		ExcelUtility excel=new ExcelUtility();
		ArrayList<String> createAccData = excel.getList("CreateAccount", 0);
		String firstname = createAccData.get(0);
		String mobilenumber = createAccData.get(1);
		String email = createAccData.get(2);
		String password = createAccData.get(3);
		WebDriverUtility wu=new WebDriverUtility();
		wu.launchBrowser();
		WebDriver driver=new ChromeDriver();
		FileUtility f=new FileUtility();
		String ur = f.readPropertyFile("url");
		driver.get(ur);
		HomePage hp=new HomePage(driver);
		hp.signup(firstname, mobilenumber, email, password);
	}

}
