package com.tms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	@FindBy(xpath = "//span[.=' Tour Packages']")
	private WebElement tourPackageTab;
	
	@FindBy(xpath = "//a[.='Manage']")
	private WebElement managetourPackageTab;
	
	@FindBy(xpath = "//a[.='Create']")
	private WebElement createtourPackageTab;
	
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTourPackageTab() {
		return tourPackageTab;
	}

	public WebElement getManagetourPackageTab() {
		return managetourPackageTab;
	}

	public WebElement getCreatetourPackageTab() {
		return createtourPackageTab;
	}
	
}
