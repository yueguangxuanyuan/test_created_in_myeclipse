package POI;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestPOI {

	public static void main(String[] args) {
      try {
    	  
		InputStream is = new FileInputStream("xls/test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		System.out.println(sheet.getRow(0).getCell(1).toString());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
