package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtilities {

	private String filePath;
	private Workbook workbook;
	private Sheet sheet;

	public ExcelUtilities(String filePath, String sheetName) throws IOException {
		this.filePath = filePath;
		FileInputStream fis = new FileInputStream(filePath);
		this.workbook = new XSSFWorkbook(fis); // For .xlsx files
		this.sheet = workbook.getSheet(sheetName);
		fis.close();
	}

	// Method to get data from a specific cell
	public String getCellData(int rowNum, int colNum) {
		Row row = sheet.getRow(rowNum);
		if (row == null) {
			return "";
		}
		Cell cell = row.getCell(colNum);
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}
	}

	// Method to set data in a specific cell
	public void setCellData(int rowNum, int colNum, String data) throws IOException {
		Row row = sheet.getRow(rowNum);
		if (row == null) {
			row = sheet.createRow(rowNum);
		}
		Cell cell = row.getCell(colNum);
		if (cell == null) {
			cell = row.createCell(colNum);
		}
		cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		fos.close();
	}

	// Method to get the total number of rows in the sheet
	public int getRowCount() {
		return sheet.getLastRowNum() + 1;
	}

	// Method to get the total number of columns in a specific row
	public int getColumnCount(int rowNum) {
		Row row = sheet.getRow(rowNum);
		if (row == null) {
			return 0;
		}
		return row.getLastCellNum();
	}

	// Close the workbook when done
	public void closeWorkbook() throws IOException {
		workbook.close();
	}
}
