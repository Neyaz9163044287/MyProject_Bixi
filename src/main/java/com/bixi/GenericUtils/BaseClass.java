package com.bixi.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	public DatabaseUtlis dlib = new DatabaseUtlis();
	public FileUtlis flib = new FileUtlis();
	public ExcelUtlis elib = new ExcelUtlis();
	public WebDriverUtils wlib=new WebDriverUtils();
	public WebDriver driver;
	
	public static WebDriver sdriver;
	
	
	@BeforeSuite
	public void connect_DB() throws Throwable 
	{
		dlib.connectDB();
	}
	
	
	@BeforeClass
	public void launch_Browser() throws Throwable
	{
		 String BROWSER = flib.readDataFromPropertyFile("browser");
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 driver=new ChromeDriver();
			 System.out.println("*****  Chrome Launched  *****");
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 driver=new FirefoxDriver();
			 System.out.println("*****  Firefox Launched  *****");
		 }
		 else
		 {
			 driver=new EdgeDriver();
			 System.out.println("*****  Edge Launched  *****");

		 }
		 
		 sdriver = driver;
		  wlib.maximizeWindow(driver);
	}
	
	
	@BeforeMethod
	public void luanch_url() throws Throwable
	{
		String URL = flib.readDataFromPropertyFile("url");
		wlib.implicitWait(driver);
		driver.get(URL);
	}
	
	
	@AfterClass
	public void close_browser() 
	{	
		wlib.quit(driver);
	}
	
	
	@AfterSuite
	public void disconnect_DB() throws Throwable 
	{
		dlib.disconnectDB();
	}
	

}