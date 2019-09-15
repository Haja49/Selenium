package org.testng;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInputProvider {
	public Object[][] readExcel(String fileName) throws IOException, InvalidFormatException {

		File input = new File("./data/" + fileName + ".xlsx");

		// Open the workbook
		XSSFWorkbook wbook = new XSSFWorkbook(input);

		// Go to the specific sheet using name or index
		XSSFSheet sheet = wbook.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);

		Object[][] data = new Object[rowCount][columnCount];

		// For Rows
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			// For Column
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				if (cell == null) {
					data[i - 1][j] = "";
					System.out.println("Blank Cell");
				} else if (cell.getCellType() == CellType.STRING) {
					data[i - 1][j] = cell.getStringCellValue();
					System.out.println(cell.getStringCellValue());
				} else if (cell.getCellType() == CellType.NUMERIC) {
					data[i - 1][j] = cell.getNumericCellValue();
					System.out.println(cell.getNumericCellValue());
				}

			}
		}
		wbook.close();
		return data;
	}
	
	public void writeExcel() throws IOException, InvalidFormatException{
		// Set File name to write and append the data in excel
		File file = new File("./data/FileName.xlsx");
		FileOutputStream fos = new FileOutputStream(file);

		// Create work book
		XSSFWorkbook wbook = new XSSFWorkbook();

		// Create sheet
		XSSFSheet sheet = wbook.createSheet("sheetName");

		// Create row
		XSSFRow row = sheet.createRow(0);

		// create cell
		XSSFCell cell = row.createCell(0);

		// Enter data
		cell.setCellValue("Success");


		// Write is the data in your excel sheet
		wbook.write(fos);

		// Close the file stream and work book to avoid leakage
		wbook.close();
		fos.close();
	}

}
