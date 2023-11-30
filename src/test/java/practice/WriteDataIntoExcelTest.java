package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Sheet1");
		sh.createRow(6).createCell(0).setCellValue("Click");
		sh.getRow(6).createCell(1).setCellValue("ABC");
		
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fout);
		wb.close();

	}

}
