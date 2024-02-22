package vtigerProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExelFile {

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub
		
		//Step1:Open The Document In Java Readable Format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//Step2:Create A Workbook
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step3:Navigate To Require Sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step4:Navigate To Require Row
		Row rw = sh.getRow(7);
		//Step5:Navigate To require Cell
		Cell cl = rw.getCell(1);
		//Step6:Read The data Inside The Cell
		String data = cl.getStringCellValue();
		System.out.println(data);
		//Step7:Close The Workbook
		wb.close();

	}

}
