package Bixi_Open_Account;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.HomePagePage;
import com.ObjectRepo.OpenAccountConfirmRegisterForm;
import com.ObjectRepo.OpenAccountFormPage;
import com.bixi.GenericUtils.BaseClass;

@Listeners(com.bixi.GenericUtils.ListenerImplementation.class)
public class TC_05_NewBankAccount_SystemTest extends BaseClass
{
		@Test //(retryAnalyzer = com.bixi.GenericUtils.RetryImpclass.class)
		public void NewBankAccount() throws Throwable 
		{
		HomePagePage hm = new HomePagePage(driver);
		hm.Click_OpenAccount();
		
		OpenAccountFormPage open = new OpenAccountFormPage(driver);
		
		String NAME = elib.readDataFromExcel("Sheet2", 1, 1);
		String MOBILE = elib.readDataFromExcel("Sheet2", 2, 1);
		String EMAIL = elib.readDataFromExcel("Sheet2", 3, 1);
		String LANDLINE = elib.readDataFromExcel("Sheet2", 4, 1);
		String PAN = elib.readDataFromExcel("Sheet2", 5, 1);
		String CITI = elib.readDataFromExcel("Sheet2", 6, 1);
		String HOME = elib.readDataFromExcel("Sheet2", 7, 1);
		String OFFICE = elib.readDataFromExcel("Sheet2", 8, 1);
		String PIN = elib.readDataFromExcel("Sheet2", 9, 1);
		String AREA = elib.readDataFromExcel("Sheet2", 10, 1);
		String NOMINEE_NAME = elib.readDataFromExcel("Sheet2", 11, 1);
		String NOMINEE_AC_NO = elib.readDataFromExcel("Sheet2", 12, 1);
		
		open.OpenAccount(NAME, MOBILE, EMAIL, LANDLINE, PAN, CITI, HOME, OFFICE, PIN, AREA, NOMINEE_NAME, NOMINEE_AC_NO);
		
		String GENDER = elib.readDataFromExcel("Sheet3", 1, 1);
		String STATE = elib.readDataFromExcel("Sheet3", 2, 1);
		String CITY = elib.readDataFromExcel("Sheet3", 3, 1);
		String ACC = elib.readDataFromExcel("Sheet3", 4, 1);
		String DOB = elib.readDataFromExcel("Sheet2", 0, 4);
		
		open.OpenAccount_dropdown(GENDER, STATE, CITY, ACC);
		
		//open.OpenAccount_datepopup(wlib, driver);
		open.getDob_calpopup().click();
		open.getDob_calpopup().sendKeys(DOB);
		
		open.submit();
		
		OpenAccountConfirmRegisterForm openconf = new OpenAccountConfirmRegisterForm(driver);
		openconf.click_submit();
		
		wlib.alertPopupWithText(driver);
		wlib.alertPopupAccept(driver);	
		
		//Assert.fail();
				
		}
}

