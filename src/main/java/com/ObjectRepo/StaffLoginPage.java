package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage 
{	
	// declaration
	@FindBy(name = "staff_id")
	private WebElement un_txtfld;
	
	@FindBy(name = "password")
	private WebElement pwd_txtfld;
	
	@FindBy(name = "staff_login-btn")
	private WebElement login_btn;
	
	//Initialization
	public StaffLoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUn_txtfld() {
		return un_txtfld;
	}

	public WebElement getPwd_txtfld() {
		return pwd_txtfld;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}	
	
	// Business logic
	public void Login_function(String username, String password)
	{
		un_txtfld.sendKeys(username);
		pwd_txtfld.sendKeys(password);
		login_btn.click();
	}
}
