package excelReader;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base_Class.baseTest;

public class Exceldata {

	public static void getRowsCount() throws Exception
	{

		baseTest.log.info("-------------------Inside getrow count method-------------------");
		String excelPath = "./ExcelData/data.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No. of Rows " + rowCount);

	}

	public String getCellData(int row_num, int cell_num) throws Exception {
		baseTest.log.info("-------------------Inside get cell data method--------------------");
		File file = new File("./ExcelData/data.xlsx");
		
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		String value = sheet.getRow(row_num).getCell(cell_num).getStringCellValue();
		return value;
	}

}
