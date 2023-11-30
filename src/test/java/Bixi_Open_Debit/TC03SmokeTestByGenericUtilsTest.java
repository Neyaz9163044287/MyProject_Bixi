package Bixi_Open_Debit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.GenericUtils.FileUtlis;
import com.bixi.GenericUtils.WebDriverUtils;

public class TC03SmokeTestByGenericUtilsTest 
{
	public static void main(String[] args) throws Throwable 
	{
		FileUtlis fLib = new FileUtlis();
		WebDriverUtils wLib = new WebDriverUtils();
		
		String URL = fLib.readDataFromPropertyFile("url");
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String TITLE = fLib.readDataFromPropertyFile("title");
		
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.waitForPageLoad(driver, 20);
		
		driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
		String ac_title = driver.getTitle();
		if(TITLE.equals(ac_title))
		{
			System.out.println("**** Redirecting to 'Apply Debit Card' Page ***");
		}
		else
		{
			System.out.println(" NOT Redirecting to 'Apply Debit Card' Page ");
		}		
		driver.quit();

	}

}
