package com.tms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateTourPackagePage {
	@FindBy(xpath = "//textarea[@name='packagedetails']")
	private WebElement packageDetailsTextField;
	
	@FindBy(xpath = "//button[.='Update']")
	private WebElement updateBtn;
	
	

	public UpdateTourPackagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPackageDetailsTextField() {
		return packageDetailsTextField;
	}
	public WebElement getUpdateBtn() {
		return updateBtn;
	}

}
