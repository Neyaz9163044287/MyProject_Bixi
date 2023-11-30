package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Makemytrip_Calendar_PopupTest {
public static void main(String[] args) throws InterruptedException {
	/*String monthandyear = "January 2024";
	int date = 12;*/
	WebDriver driver = new ChromeDriver();			//launch empty browser
	
	
	driver.manage().window().maximize();			//maximize the browser
	
	driver.get("https://www.makemytrip.com/");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//i[contains(@class,'wewidgeticon we_close')]")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	/*for(;;)
	{
		try
		{
			driver.findElement(By.xpath(""))
		}
	}
	
*/
}


}
