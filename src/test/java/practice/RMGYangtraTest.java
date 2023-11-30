package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RMGYangtraTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//signin to Yangtra
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//create project
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("Astor1");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Deepak H R");
		WebElement status = driver.findElement(By.xpath("//select[@name='status']"));
		
		Select sel = new Select(status);
		sel.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
				
		driver.quit();
	}

}
