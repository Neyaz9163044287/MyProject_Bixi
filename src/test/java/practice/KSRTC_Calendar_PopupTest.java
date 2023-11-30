package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRTC_Calendar_PopupTest {

	
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();			//launch empty browser
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();			//maximize the browser
		
		driver.get("https://www.ksrtc.in/oprs-web/");
		
		driver.findElement(By.xpath("//input[@name='txtJourneyDate']")).click();
												
					//div[@id='ui-datepicker-div']/descendant::a[text()='7']
		
		driver.findElement(By.xpath("//a[text()='9']")).click();
		
		Thread.sleep(2000);
		 
		driver.quit();
		
	}

}
