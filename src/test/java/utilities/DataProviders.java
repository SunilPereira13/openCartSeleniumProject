package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "logindata")
	public String[][] getData() throws IOException {

//		String filePath = "C:\\Users\\perei\\eclipse-workspace\\OpenCartProject\\src\\test\\java\\utilities\\ExcelUtilities.java";
//		ExcelUtilities excelUtility = new ExcelUtilities(filePath, "Sheet1");
//		int rowCount = excelUtility.getRowCount();
//		int cellCount = excelUtility.getColumnCount(0);
//
//		String[][] loginData = new String[rowCount][cellCount];
//
//		for (int i = 0; i < rowCount; i++) {
//			for (int j = 0; j < cellCount; j++) {
//				loginData[i - 1][j] = excelUtility.getCellData(i, j);
//			}
//		}

		String loginData[][] = { { "Sunper@gmail.com", "Sunper@1994" }, { "SunPer@gmail.com", "SunPer@1995" } };
		return loginData;
	}
}
