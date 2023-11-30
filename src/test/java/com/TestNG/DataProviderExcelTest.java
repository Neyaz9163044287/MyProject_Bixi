package com.TestNG;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.bixi.GenericUtils.IPathConstants;

public class DataProviderExcelTest 
{
	@DataProvider()
	public Object[][] data() throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");
		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowcount][cellcount];
		
		for(int i=0; i<rowcount; i++)
		{
			for(int j=0; j<cellcount; j++)
			{
				obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
		
	}
}
