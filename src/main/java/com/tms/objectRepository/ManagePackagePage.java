package com.tms.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tms.LetsFeelRomania.generic.WebDriverUtility;

public class ManagePackagePage {
	
  
	public void viewDetails(String name,WebDriver driver)
	{
		WebElement ele = driver.findElement(By.xpath("//span[.='"+name+"']/../following-sibling::td[5]//button"));
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.scrollAction(driver, ele);
		ele.click();
	}

}
