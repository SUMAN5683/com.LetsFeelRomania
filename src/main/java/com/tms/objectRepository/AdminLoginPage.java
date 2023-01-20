package com.tms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameTextField;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//input[@name='login']")
	private WebElement signinBtn;
	
	//initializing
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}
	
	//businesslogic
	public void adminLogin(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		signinBtn.click();
	}
	
	
}
