package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Make {

	public static void main(String[] args) throws InterruptedException 
	{
		String monthandyear = "January 2024";
		int date = 12;
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.goibibo.com");
		
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		
		driver.findElement(By.xpath("(//div[@class='sc-12foipm-16 wRKJm fswFld '])[3]")).click();
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		driver.findElement(By.xpath("//div[@class='gr_fswFld active']")).click();
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[text()='February 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='2']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		Thread.sleep(5000);
		driver.quit();

	}

}


