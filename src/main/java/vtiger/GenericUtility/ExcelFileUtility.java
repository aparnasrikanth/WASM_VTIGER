
package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	/**
	 * This method will read the data from excel sheet and return value
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */


	public  String readDataFromExcel(String sheet,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(sheet);
		Row r=s.getRow(row);
		 Cell cel=r.getCell(cell);
		 String value=cel.getStringCellValue();
		 wb.close();
		 return value;
	}
	
	public int getRowCount(String sheet) throws IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(sheet);
		int lastRow=s.getLastRowNum();
		return lastRow;
		
	}
	
	public void writeDataIntoExcel(String sheet,int row,int cel,String value) throws EncryptedDocumentException, IOException 
	
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(sheet);
		Row r=s.getRow(row);
		Cell cell = r.createCell(cel);
		 
		 cell.setCellValue(value);
		 FileOutputStream fos=new FileOutputStream(ConstantsUtility.ExcelPath);
		 wb.write(fos);
		 wb.close();
	}
	/**
	 * This method is used to execute a test script with multiple set of data
	 * hence it will return 2 dimensional object[][] so that it can be direct used in dataprovider
	 * @param sheetName
	 * @return
	 * @throws Throwable 
	 * @throws  
	 * @throws  
	 * @throws  
	 * 
	 * 
	 */
	
	
	
	public Object[][] readMultipleDataFromExcel(String sheetName) throws Throwable {
		
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				
				
			}
		}
		return data;
	}
	
	
	
	
	

}
