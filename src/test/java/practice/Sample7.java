package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sample7 {

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("(//*[local-name()='svg'])[11]")).click();
		WebElement from = driver.findElement(By.xpath("//div[text()='From']"));
		from.click();
		Actions act = new Actions(driver);
		
		WebElement fr = driver.findElement(By.xpath("//div[text()='Agartala']"));
		act.moveToElement(fr).click().perform();
		
		WebElement to = driver.findElement(By.xpath("//div[text()='Jaipur']"));
		act.moveToElement(to).click().perform();
		for(;;)
		{
			try
				{
					driver.findElement(By.xpath("//div[text()='February ' and text()='2024']/ancestor::div[@data-testid='undefined-month-February-2024']/div[3]/descendant::div[text()='16']")).click();
					break;
				}
		catch (Exception e) 
				{
						driver.findElement(By.xpath("(//*[local-name()='svg'])[16]")).click();
				}
		
		}	
		WebElement departure = driver.findElement(By.xpath("//div[text()='Return Date']"));
		act.moveToElement(departure).click().perform();
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[text()='April ' and text()='2024']/ancestor::div[@data-testid='undefined-month-April-2024']/div[3]/descendant::div[text()='16']"));
				break;
			}
			catch (Exception e) 
			{
				driver.findElement(By.xpath("(//*[local-name()='svg'])[16]")).click();
			}
		}
		
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		WebElement done = driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']"));
		act.moveToElement(done).click().perform();
		driver.findElement(By.xpath("//div[text()='Currency']")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
