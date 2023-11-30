package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataIntoPropertyFileTest 
{
	public static void main(String[] args) throws Exception 
	{
		// Create object for property file
		Properties pObj = new Properties();
		//Writing the data into property file
		pObj.setProperty("browser", "chrome");
		pObj.setProperty("url", "http://rmgtestingserver:8084");
		pObj.setProperty("username", "rmgyantra");
		pObj.setProperty("password", "rmgy@9999");
		
		// Create Obj for FileOutputStream
		FileOutputStream fOut = new FileOutputStream("src\\test\\resources\\CommonData.properties");
		pObj.store(fOut, "Write Data");
		
		FileInputStream fi = new FileInputStream("src\\test\\resources\\CommonData.properties");
		pObj.load(fi);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
				
	}

}
