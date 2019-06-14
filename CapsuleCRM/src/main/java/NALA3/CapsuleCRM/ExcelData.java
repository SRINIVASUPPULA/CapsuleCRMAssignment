package NALA3.CapsuleCRM;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public Object[][] getData(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\Testing\\cnu programs\\CapsuleCRM\\src\\main\\java\\resources\\CRMdata.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet(sheetName);
		//int rows = sheet.getLastRowNum() + 1;
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object data[][] = new Object[1][cols];

		for (int j = 0; j < cols; j++) {
			if (j == 6) {
				long i = (long) sheet.getRow(1).getCell(j).getNumericCellValue();
				data[0][j] = String.valueOf(i);
			} else {
				data[0][j] = sheet.getRow(1).getCell(j).getStringCellValue();
			}
		}
		book.close();
		return data;
	}
}
