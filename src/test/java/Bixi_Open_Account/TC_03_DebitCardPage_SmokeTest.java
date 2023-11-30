package Bixi_Open_Account;

import org.testng.annotations.Test;
import com.ObjectRepo.HomePagePage;
import com.bixi.GenericUtils.BaseClass;

public class TC_03_DebitCardPage_SmokeTest extends BaseClass
{
		@Test
		public void DebitCardPage() throws Throwable
		{			
			HomePagePage home = new HomePagePage(driver);
			home.Click_ApplyDebitCard();
		
			//fetching the page title from test-data
			String exp = elib.readDataFromExcel("Sheet1", 5, 1);
			
			String act = driver.getTitle();
		
			if(act.contains(exp))
				{
					System.out.println("**** Redirecting to 'Apply Debit Card' Page ***");
				}
			else
				{
					System.out.println(" NOT Redirecting to 'Apply Debit Card' Page ");
				}				
		}
}
