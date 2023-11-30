package Bixi_Open_Account;

import org.testng.annotations.Test;

import com.ObjectRepo.DebitFormPage;
import com.ObjectRepo.HomePagePage;
import com.bixi.GenericUtils.BaseClass;

public class TC_15_DebitCardwithBlankFields_FT extends BaseClass
{	
		@Test
		public void method() throws Throwable
		{
			HomePagePage home = new HomePagePage(driver);
			home.Click_ApplyDebitCard();
		
			String NAME = elib.readDataFromExcel("Sheet1", 1, 1);
			String PAN = elib.readDataFromExcel("Sheet1", 2, 1);
			String MOB = elib.readDataFromExcel("Sheet1", 3, 1);
			String ACCOUNTNO = elib.readDataFromExcel("Sheet1", 4, 1);
	
			DebitFormPage debit = new DebitFormPage(driver);
			debit.send_Detail(NAME, PAN, MOB, ACCOUNTNO);
			debit.click_submit();
	
			wlib.alertPopupWithText(driver);
		}
}

