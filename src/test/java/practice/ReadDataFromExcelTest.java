package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest 
{
	public static void main(String[] args) throws IOException 
	{
		// get obj for physical representation
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		String value = sh.getRow(0).getCell(1).getStringCellValue();
		
		System.out.println(value);
	}

}
