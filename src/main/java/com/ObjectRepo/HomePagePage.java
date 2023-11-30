package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePage
{
	// Initializing the element in Home Page
	
		@FindBy(xpath = "//li[contains(text(),'Open Account')]")
		private WebElement openacbtn;
		
		@FindBy(xpath = "//li[contains(text(),'Apply Debit Card')]")
		private WebElement applydebitbtn;
		
		@FindBy(xpath = "//a[contains(text(),'Internet Banking')]")
		private WebElement intbanklink;
		
		@FindBy(xpath = "//li[contains(text(),'Login')]")
		private WebElement internetlogbtn;
		
		@FindBy(xpath = "//li[contains(text(),'Register')]")
		private WebElement internetregbtn;
		
		
		@FindBy(xpath = "//li[contains(text(),'Fund Transfer')]")
		private WebElement fundtransbtn;
		
		@FindBy(xpath = "//a[contains(text(),'Staff Login')]")
		private WebElement staffbtn;
	
		
	// Declaration
		
		public HomePagePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}


	//Utilization
		public WebElement getOpenacbtn() {
			return openacbtn;
		}


		public WebElement getApplydebitbtn() {
			return applydebitbtn;
		}


		public WebElement getIntbanklink() {
			return intbanklink;
		}


		public WebElement getInternetlogbtn() {
			return internetlogbtn;
		}


		public WebElement getInternetregbtn() {
			return internetregbtn;
		}


		public WebElement getFundtransbtn() {
			return fundtransbtn;
		}


		public WebElement getStaffbtn() {
			return staffbtn;
		}
		
	// Business Logic
		public void Click_OpenAccount() 
		{
			openacbtn.click();
		}
		
		public void Click_ApplyDebitCard() 
		{
			applydebitbtn.click();
		}
		
		public void Click_InternetRegister() 
		{
			internetregbtn.click();
		}
		
		public void Click_InternetLogin() 
		{
			internetlogbtn.click();
		}
		
		public void Click_FundTransfer() 
		{
			fundtransbtn.click();
		}
		
		public void Click_Staff() 
		{
			staffbtn.click();
		}	
}
