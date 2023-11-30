package com.TestNG;

import org.testng.annotations.Test;

public class ExecuteDataProviderTest 
{
	@Test(dataProviderClass = DataProviderExcelTest.class, dataProvider = "data")
	public void execute(String KEY, String VALUE)
	{
		System.out.println(KEY+"=========="+VALUE);
	}
	
//	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "getDataFromExcel")
//	public void execute(String KEY, String VALUE)
//	{
//	System.out.println(KEY+"=========="+VALUE);
//	}
//	
	
	
}
