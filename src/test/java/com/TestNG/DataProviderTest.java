package com.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bixi.GenericUtils.ExcelUtlis;

public class DataProviderTest 
{
	@Test(dataProvider = "data")
	public void getdata(String From, String To, int Price)
	{
		System.out.println(From+"------"+To+"------"+Price);
	}	
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[4][3];
		
		obj[0][0] = "Bangalore";
		obj[0][1] = "Mysore";
		obj[0][2] = 200;
		
		obj[1][0] = "Bangalore";
		obj[1][1] = "Delhi";
		obj[1][2] = 600;
		
		obj[2][0] = "Mysore";
		obj[2][1] = "Pune";
		obj[2][2] = 500;
		
		obj[3][0] = "Chennai";
		obj[3][1] = "Hyderabad";
		obj[3][2] = 800;
		
		return obj;
	}
	
	//Calling data from generic libraries
	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable 
	{
		ExcelUtlis elib = new ExcelUtlis();
		Object[][] value = elib.getMultipleSetOfData("Sheet2");
		return value;
		
	}
}
