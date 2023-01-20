package com.tms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.LetsFeelRomania.generic.WebDriverUtility;

public class CreatePackagePage {
	@FindBy(xpath = "//input[@id='packagename']")
	private WebElement packageNameTxtField;
	@FindBy(xpath = "//input[@id='packagetype']")
	private WebElement packageTypeTxtField ;
	@FindBy(xpath = "//input[@id='packagelocation']")
	private WebElement packageLocTxtField;
	@FindBy(xpath = "//input[@id='packageprice']")
	private WebElement packagePriceTxtField;
	@FindBy(xpath = "//input[@id='packagefeatures']")
	private WebElement packageFeatureTxtField ;
	@FindBy(xpath = "//textarea[@id='packagedetails']")
	private WebElement packageDetailsTxtField;
	@FindBy(xpath = "//input[@id='packageimage']")
	private WebElement packageImgBtn;
	@FindBy(xpath = "//button[.='Create']")
	private WebElement createPackageBtn;
	
	public CreatePackagePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getPackageNameTxtField() {
		return packageNameTxtField;
	}

	public WebElement getPackageTypeTxtField() {
		return packageTypeTxtField;
	}

	public WebElement getPackageLocTxtField() {
		return packageLocTxtField;
	}

	public WebElement getPackagePriceTxtField() {
		return packagePriceTxtField;
	}

	public WebElement getPackageFeatureTxtField() {
		return packageFeatureTxtField;
	}

	public WebElement getPackageDetailsTxtField() {
		return packageDetailsTxtField;
	}

	public WebElement getPackageImgBtn() {
		return packageImgBtn;
	}

	public WebElement getCreatePackageBtn() {
		return createPackageBtn;
	}
	
	//business logic 
	public void createPackage(WebDriver driver,String name,String type,String loc,String price,String feature,String details,String img)
	{
		getPackageNameTxtField().sendKeys(name);
		getPackageTypeTxtField().sendKeys(type);
		getPackageLocTxtField().sendKeys(loc);
		getPackagePriceTxtField().sendKeys(price);
		WebElement ele = getPackageFeatureTxtField();
		WebDriverUtility wu=new WebDriverUtility();
		wu.scrollAction(driver,ele);
		ele.sendKeys(feature);
		getPackageDetailsTxtField().sendKeys(details);
		getPackageImgBtn().sendKeys(img);
		getCreatePackageBtn().click();
	}

}
