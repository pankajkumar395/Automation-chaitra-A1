package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class Consist Of Reusable Method Of Excel Class
 * @author Pankaj k
 * 
 */

public class ExelFileUtility {
	
	/**
	 * 
	 * @param Sheetname
	 * @param rowNum
	 * @param cellno
	 * @return Data
	 * @throws Throwable
	 */
	
	public String readDataFromExelFile(String Sheetname,int rowNum,int cellno) throws Throwable {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	String	Data=wb.getSheet(Sheetname).getRow(rowNum).getCell(cellno).getStringCellValue();
	wb.close();
	return Data;
	}
	
	public void writeDataIntoExelFile(String sheet,int rowname,int cellno,String value) throws Throwable {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		wb.createSheet(sheet).createRow(rowname).createCell(cellno).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
	}
	/**
	 * This Method Will Read Multiple Data From Excel File For The Sheet Provided
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][]readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis =	new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)//navigate through Rows
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

	
}
