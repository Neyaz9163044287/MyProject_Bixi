package Bixi_Open_Debit;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_02_GopisirTest 
{
	public static void main(String[] args) throws IOException, Exception 
	{	
		Properties pobj = new Properties();
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\project.properties");
		pobj.load(fi);
		
		String Browser = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("staff_un");
		String PASSWORD = pobj.getProperty("staff_pwd");
				
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get(URL);
		
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("apprvac")).click();
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("logout_btn")).click();
		
		System.out.println("**********Staff logged out successfully and home page is displayed**********");
		driver.quit();
		

	}

}
