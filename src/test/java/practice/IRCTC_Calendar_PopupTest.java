package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC_Calendar_PopupTest {

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new ChromeDriver();			//launch empty browser
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();			//maximize the browser
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		   //div[@class='ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted']/descendant::a[text()='9']
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
	}
	
}
