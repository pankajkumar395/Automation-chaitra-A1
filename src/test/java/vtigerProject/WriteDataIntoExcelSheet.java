package vtigerProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//Step1:Open The Document In Java readable Format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//Step2:Create A Workbook
            Workbook wb = WorkbookFactory.create(fis);
		//Step2:Navigate To Sheet
            Sheet sh = wb.createSheet("Trial");
		
		//Step4:Navigate To Required Row
            Row rw = sh.createRow(0);
		
		//Step5:Create A Cell
            Cell cl = rw.createCell(0);
		
		//Step6:Provide Data to Be Read
          cl.setCellValue("TC_ID");;
		
		//step7:Open Document In Java Write Format
            FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step8:Write The Data
            wb.write(fos);
            System.out.println("Data Added Successfully");
		
		//Step9:Close the Workbook
            wb.close();
	}

}
