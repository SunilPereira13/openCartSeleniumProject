package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "logindata")
	public String[][] getData() throws IOException {

		String filePath = System.getProperty("user.dir") + "\\testData\\OpenCartData.xlsx";

		ExcelUtilities utility = new ExcelUtilities(filePath);
		int rowCount = utility.getRowCount("Sheet1"); // 4
		int cellCount = utility.getCellCount("Sheet1", 1);

		String[][] loginData = new String[rowCount][cellCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				loginData[i][j] = utility.getCellData("Sheet1", i, j);
			}
		}
		return loginData;

//		String loginData[][] = { { "Sunper@gmail.com", "Sunper@1994" }, { "SunPer@gmail.com", "SunPer@1995" } };
//		return loginData;
	}
}
