package Bixi_Open_Debit;

import org.testng.annotations.Test;

import com.ObjectRepo.HomePagePage;
import com.ObjectRepo.StaffDashBoardPage;
import com.ObjectRepo.StaffLoginPage;
import com.bixi.GenericUtils.BaseClass;

public class TC02_StaffloginPOMTest extends BaseClass
{
	@Test
	public void TC02_Stafflogin() throws Throwable
	{
		String URL = flib.readDataFromPropertyFile("url");	
		String USERNAME = flib.readDataFromPropertyFile("staff_un");
		String PASSWORD = flib.readDataFromPropertyFile("staff_pwd");
				
		HomePagePage home = new HomePagePage(driver);
		home.Click_Staff();
		
		StaffLoginPage sl = new StaffLoginPage(driver);
		sl.Login_function(USERNAME, PASSWORD);
		
		StaffDashBoardPage sdb = new StaffDashBoardPage(driver);
		sdb.click_approvependingaccount();
		sdb.click_home();
		sdb.click_logout();
		System.out.println("Staff Successfully logged out and Staff login page is displayed");
				
		driver.quit();
	}
		
		
}
