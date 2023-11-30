package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel 
{
	public static void main(String[] args) throws IOException 
	{
		// get obj for physical representation
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int rowcount = sh.getLastRowNum();
		
		int cellcount = sh.getRow(0).getLastCellNum();
//		System.out.println(sh.getRow(0).getCell(1).getStringCellValue());
		for(int i=0;i<=rowcount;i++)	// Row
		{
			for(int j=0;i<cellcount;j++)	//Cell
			{
				String value = sh.getRow(i).getCell(j).toString();				
				System.out.print(value);
				System.out.print("    ");
			}
			System.out.println();
		}
	}
}*/

public class ReadMultipleDataFromExcel 
{
	
public static void main(String[] args) throws Throwable {
	 
	FileInputStream fis=new FileInputStream("./src/test/resources/testdatapractise.xlsx");
	
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("OrgLoc");
	
	int rowCount = sheet.getLastRowNum(); //5--0,1,2,3,4
	System.out.println(rowCount);//printing index of last Row
	
	int cellcount= sheet.getRow(0).getLastCellNum(); //2--0,1
	System.out.println(cellcount);//printing actual cell count and not index
	
	for(int i=0;i<=rowCount;i++) {  //5 iterations
		for(int j=0;j<cellcount;j++) { //2 iterations
			
			String value=sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println();
	}
	
}

}
