package Bixi_Open_Account;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.bixi.GenericUtils.BaseClass;

public class TC_02_StaffloginGenericUtilsTest extends BaseClass
{
	@Test
	public void method() throws Throwable
	{		
		String USERNAME= flib.readDataFromPropertyFile("staff_un");
		String PASSWORD = flib.readDataFromPropertyFile("staff_pwd");	
		
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("apprvac")).click();
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("logout_btn")).click();
		
		System.out.println("**********Staff logged out successfully and home page is displayed**********");
	}
		
	}

