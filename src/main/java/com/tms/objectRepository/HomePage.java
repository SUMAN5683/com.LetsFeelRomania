package com.tms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.LetsFeelRomania.generic.IpathConstants;

public class HomePage {
	//main 3 links from home page
	@FindBy(xpath = "//a[.='Admin Login']")
	private WebElement adminLoginLink;
	
	@FindBy(xpath = "//a[.='Sign Up']")
	private WebElement signupLink;
	
	@FindBy(xpath = "//a[.='/ Sign In']")
	private WebElement signinLink;
	
	//elements from signup dialogue box
	@FindBy(xpath = "//input[@placeholder='Full Name']")
	private WebElement firstnameTextField;
	
	@FindBy(xpath = "//input[@placeholder='Mobile number']")
	private WebElement mobilenumberTextField;
	
	@FindBy(xpath = "//input[@placeholder='Email id']")
	private WebElement signupemailTextField;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement signuppasswordTextField;
	
	@FindBy(xpath = "//input[@value='CREATE ACCOUNT']")
	private WebElement createaccountBtn;
	
	//elements from signin dialogue box
	@FindBy(xpath = "//input[@placeholder='Enter your Email']")
	private WebElement signinemailTextField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement signinpasswordTextField;
	
	@FindBy(xpath = "//input[@name='signin']")
	private WebElement signinBtn;
	
	//intializing
		
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//getter methods for each element
	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}

	public WebElement getSignupLink() {
		return signupLink;
	}

	public WebElement getSigninLink() {
		return signinLink;
	}

	public WebElement getFirstnameTextField() {
		return firstnameTextField;
	}

	public WebElement getMobilenumberTextField() {
		return mobilenumberTextField;
	}

	public WebElement getSignupemailTextField() {
		return signupemailTextField;
	}

	public WebElement getSignuppasswordTextField() {
		return signuppasswordTextField;
	}

	public WebElement getCreateaccountBtn() {
		return createaccountBtn;
	}

	public WebElement getSigninemailTextField() {
		return signinemailTextField;
	}

	public WebElement getSigninpasswordTextField() {
		return signinpasswordTextField;
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}
	
	//creating bussiness logic methods for signup
	public void signup(String firstname,String mobilenumber,String email,String password) throws Throwable
	{
		getSignupLink().click();
		Thread.sleep(2000);
		getFirstnameTextField().sendKeys(firstname);
		getMobilenumberTextField().sendKeys(mobilenumber);
		getSignupemailTextField().sendKeys(email);
		getSignuppasswordTextField().sendKeys(password);
		getCreateaccountBtn().click();
	}
	
	
}