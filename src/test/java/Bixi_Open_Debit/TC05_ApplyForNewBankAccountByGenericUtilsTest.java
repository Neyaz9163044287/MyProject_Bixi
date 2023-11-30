package Bixi_Open_Debit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.GenericUtils.ExcelUtlis;
import com.bixi.GenericUtils.FileUtlis;
import com.bixi.GenericUtils.WebDriverUtils;

public class TC05_ApplyForNewBankAccountByGenericUtilsTest 
{
	public static void main(String[] args) throws Throwable 
	{
		FileUtlis flib = new FileUtlis();
		ExcelUtlis elib = new ExcelUtlis();
		WebDriverUtils wlib = new WebDriverUtils();
		
		//String BROWSER = flib.readDataFromPropertyFile("browser");
		String URL = flib.readDataFromPropertyFile("url");
		
		WebDriver driver = new ChromeDriver();
		wlib.maximizeWindow(driver);
		driver.get(URL);
		wlib.waitForPageLoad(driver, 15);
		
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		
		int count = elib.getLastRowNo("Sheet2");
		elib.readMultipleData("Sheet2", driver);
		
		WebElement gender_drop = driver.findElement(By.name("gender"));
		wlib.dropdown(gender_drop, "Male");
		
		WebElement state_drop = driver.findElement(By.name("state"));
		wlib.dropdown(state_drop, "California");
		
		WebElement city_drop = driver.findElement(By.name("city"));
		wlib.dropdown(city_drop, "Los Angeles");
		
		WebElement acctype_drop = driver.findElement(By.name("acctype"));
		wlib.dropdown(acctype_drop, "Saving");
		
		driver.findElement(By.name("dob")).click();
		
		for(int i=1; i<=9; i++)
		{
			wlib.keyPress_UpArrow();
			wlib.keyRelease_UpArrow();
		}
		
		wlib.keyPress_Tab();
		wlib.keyRelease_Tab();
		
		for(int i=1; i<=9; i++)
		{
			wlib.keyPress_UpArrow();
			wlib.keyRelease_UpArrow();
		}
		
		wlib.keyPress_Tab();
		wlib.keyRelease_Tab();
		
		for(int i=1; i<=21; i++)
		{
			wlib.keyPress_DownArrow();
			wlib.keyRelease_DownArrow();
		}
		
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.name("cnfrm-submit")).click();
		
		wlib.alertPopupWithText(driver);
		wlib.alertPopupAccept(driver);
		
		Thread.sleep(3000);
		driver.quit();

	}

}
