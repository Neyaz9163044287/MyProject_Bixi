package com.bixi.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtlis 
{	
	/**
	 * This method is used to read data from excel
	 * @author Neyaz
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return 
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetName, int row, int cell) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to get the total row count
	 * @author Neyaz
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */
	public int getLastRowNo (String sheetName) throws Throwable 
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	
	/**
	 * This method is used to write the data into Excel
	 * @author Manju	 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName, int row, int cell, String data) throws Throwable 
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fout);
		wb.close();
	}
	
	/**
	 * This method is used to read multiple data from excel
	 * @author Neyaz
	 * @param sheetName
	 * @param driver
	 * @throws Throwable
	 */
	public void readMultipleData(String sheetName, WebDriver driver) throws Throwable 
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		
		 HashMap<String, String> map = new HashMap<String, String>();
			for(int i=1;i<=count;i++)
			{
				String key = sh.getRow(i).getCell(0).getStringCellValue();
				String value = sh.getRow(i).getCell(1).getStringCellValue();
				map.put(key, value);
			}
			for(Entry<String, String> set:map.entrySet())
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			
		
	}
	
	public Object[][] getMultipleSetOfData(String sheetName) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowcount][cellcount];
		
		for(int i=0; i<rowcount; i++)		//ROW
		{
			for(int j=0; j<cellcount; j++)	//CELL
			{
				obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
		
}
