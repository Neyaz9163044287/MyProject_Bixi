package Bixi_Open_Debit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bixi.GenericUtils.ExcelUtlis;
import com.bixi.GenericUtils.FileUtlis;
import com.bixi.GenericUtils.JavaUtlis;
import com.bixi.GenericUtils.WebDriverUtils;

public class TC15_ApplyForDebitCardWithBlankFieldsByGenericUtilsTest 
{
	public static void main(String[] args) throws Throwable 
	{
		ExcelUtlis eLib = new ExcelUtlis();
		FileUtlis fLib = new FileUtlis();
		JavaUtlis jLib = new JavaUtlis();
		WebDriverUtils wLib = new WebDriverUtils();
		
		String URL = fLib.readDataFromPropertyFile("url");
		
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.waitForPageLoad(driver, 15);
		
		driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
		eLib.getLastRowNo("Sheet1");
		eLib.readMultipleData("Sheet1", driver);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.print("Error message displayed as: ");
		wLib.alertPopupWithText(driver);
		wLib.alertPopupAccept(driver);						
		driver.quit();
	}

}
