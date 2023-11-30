package com.bixi.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass_Sample
{
	public DatabaseUtlis dlib = new DatabaseUtlis();
	public FileUtlis flib = new FileUtlis();
	public ExcelUtlis elib = new ExcelUtlis();
	public WebDriverUtils wlib = new WebDriverUtils();
	public WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable
	{
		dlib.connectDB();
		System.out.println("--connected to DB--");
	}
	
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void config_BC(String BROWSER) throws Throwable
	{
		//String BROWSER = flib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("forefox")) 
		{
			driver = new FirefoxDriver();
		}
		else 
		{
			System.out.println("--Invalid browser--");
		}
		wlib.maximizeWindow(driver);
		//String URL = flib.readDataFromPropertyFile("url");
		//driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable
	{
		String URL = flib.readDataFromPropertyFile("url");
		//USERNAME
		//PASSWORD
		
		driver.get(URL);
		wlib.waitForPageLoad(driver, 10);
		System.out.println("--login to appication--");
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM()
	{
		//logout from application
		System.out.println("--logged out of application--");
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC()
	{
		driver.quit();
		System.out.println("--Browser Close--");
	}
	
	@AfterSuite(alwaysRun = true)
	public void config_AS()
	{
		//disconnect database
		System.out.println("--Disconnect database");
	}
	
}
