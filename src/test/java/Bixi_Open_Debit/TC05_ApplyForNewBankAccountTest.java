package Bixi_Open_Debit;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC05_ApplyForNewBankAccountTest 
{
	public static void main(String[] args) throws IOException, Exception 
	{	
		Properties pobj = new Properties();
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\project.properties");
		pobj.load(fi);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String TITLE = pobj.getProperty("title");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\project.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2"); 
	    int count = sheet.getLastRowNum();	
	   	    
	    HashMap<String, String> map = new HashMap<String, String>();
		for(int i=1;i<=count;i++)
		{
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		WebElement gender_drop = driver.findElement(By.name("gender"));
		Select sel = new Select(gender_drop);
		sel.selectByVisibleText("Male");
		
		WebElement state_drop = driver.findElement(By.name("state"));
		Select sel1 = new Select(state_drop);
		sel1.selectByVisibleText("California");
		
		WebElement city_drop = driver.findElement(By.name("city"));
		Select sel2 = new Select(city_drop);
		sel2.selectByVisibleText("Los Angeles");
		
		WebElement acctype_drop = driver.findElement(By.name("acctype"));
		Select sel3 = new Select(acctype_drop);
		sel3.selectByVisibleText("Saving");
			    
		
		//WebElement dob = driver.findElement(By.name("dob"));
		//dob.click();
		driver.findElement(By.name("dob")).click();
		
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyRelease(KeyEvent.VK_DOWN);
		
		rbt.keyPress(KeyEvent.VK_TAB);
		rbt.keyRelease(KeyEvent.VK_TAB);
		
		rbt.keyPress(KeyEvent.VK_UP);
		rbt.keyRelease(KeyEvent.VK_UP);
		
		rbt.keyPress(KeyEvent.VK_TAB);
		rbt.keyRelease(KeyEvent.VK_TAB);
		
		for(int i=1;i<=21;i++)
		{
			rbt.keyPress(KeyEvent.VK_DOWN);
			rbt.keyRelease(KeyEvent.VK_DOWN);
		}
		Thread.sleep(6000);
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		//js.executeScript("document.getElementsByName('dob').values='09092000';");
//		js.executeScript("arguments[0].values='09092000';", dob);
		
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.name("cnfrm-submit")).click();
		
		Alert alertpopup = driver.switchTo().alert();
		String textalert = alertpopup.getText();
		System.out.println("Text"+textalert);
		alertpopup.accept();
		
		driver.quit();
		

	}

}
