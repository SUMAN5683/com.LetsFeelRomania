package Practice3_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchData_Mock {
	public static void main(String[]arg) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/TMSlogincredentials.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String brand="Vivo";
		int rowcount = wb.getSheet("Sheet1").getLastRowNum();
		short cellcount = wb.getSheet("Sheet1").getRow(0).getLastCellNum();
		for(int i=1;i<rowcount;i++) {
			for(int j=0;j<cellcount;j++) {
				String brand1="";
				try {
				 brand1= wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
				}
				catch(Exception e) {
				}
				if(brand1.contains(brand)) {
					String price = wb.getSheet("Sheet1").getRow(i).getCell(j+1).getStringCellValue();
					System.out.println(brand+"----->"+price);
				}
				
			}
		}
		
	}

}
