package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffDashBoardPage
{
	@FindBy(xpath = "//input[@value='View Active Customer']")
	private WebElement btn_viewactivecustomer;
	
	@FindBy(xpath = "//input[@value='View Customer by A/c No']")
	private WebElement btn_viewcustomerbyaccountno;
	
	@FindBy(xpath = "//input[@value='Approve Pending Account']")
	private WebElement btn_approvependingaccount;
	
	@FindBy(xpath = "//input[@value='Delete Customer A/c']")
	private WebElement btn_deletecusaccount;
	
	@FindBy(xpath = "//input[@value='Credit Customer']")
	private WebElement btn_creditcustomer;
	
	@FindBy(xpath = "//input[@value='Home']")
	private WebElement btn_home;
	
	@FindBy(xpath = "//input[@value='Logout']")
	private WebElement btn_logout;
	
	@FindBy(xpath = "//a[contains(text(),'Staff Login')]")
	private WebElement btn_stafflogin;
	
	
	public StaffDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getBtn_viewactivecustomer() {
		return btn_viewactivecustomer;
	}


	public WebElement getBtn_viewcustomerbyaccountno() {
		return btn_viewcustomerbyaccountno;
	}


	public WebElement getBtn_approvependingaccount() {
		return btn_approvependingaccount;
	}


	public WebElement getBtn_deletecusaccount() {
		return btn_deletecusaccount;
	}


	public WebElement getBtn_creditcustomer() {
		return btn_creditcustomer;
	}


	public WebElement getBtn_home() {
		return btn_home;
	}


	public WebElement getBtn_logout() {
		return btn_logout;
	}


	public WebElement getBtn_stafflogin() {
		return btn_stafflogin;
	}
	
	//Business Logic
	public void click_viewactivecustomer() 
	{
		btn_viewactivecustomer.click();
	}
	
	public void click_viewcustomerbyaccountno() 
	{
		btn_viewcustomerbyaccountno.click();
	}
	
	public void click_approvependingaccount() 
	{
		btn_approvependingaccount.click();		
	}
	
	public void click_deletecusaccount() 
	{
		btn_deletecusaccount.click();
	}
	
	public void click_creditcustomer() 
	{
		btn_creditcustomer.click();
	}
	
	public void click_home() 
	{
		btn_home.click();
	}
	
	public void click_logout() 
	{
		btn_logout.click();
	}
	
	public void click_stafflogin() 
	{
		btn_stafflogin.click();
	}
	
}
