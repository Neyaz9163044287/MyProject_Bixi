package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AirAsia 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.airasia.com/en/gb");
		
		driver.findElement(By.xpath("//div[@id='departclick-handle']")).click();
		
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[text()='December 2023']/ancestor::div[@class='calendarwidget__CalendarInstance-sc-u2xaxz-3 kvwKiR']/descendant::div[text()='1']")).click();
				break;
			}
			catch (Exception e) 
			{
				WebElement svg = driver.findElement(By.xpath("(//*[local-name()='svg'])[15]"));
				Actions act=new Actions(driver);
				act.moveToElement(svg).click().perform();
			}
		}
		Thread.sleep(4000);
		driver.quit();
	}
}

