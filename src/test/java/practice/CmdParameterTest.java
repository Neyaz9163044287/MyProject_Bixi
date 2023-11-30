package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CmdParameterTest 
{
	@Test
	public void cmdParametertest() throws Exception
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println(BROWSER);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.quit();
	}
}
