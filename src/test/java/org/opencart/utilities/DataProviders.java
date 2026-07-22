package org.opencart.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String path = ".//testData//LoginData.xlsx";
		
		ExcelUtility xlUtil = new ExcelUtility(path);
		
		int totalRows = xlUtil.getRowCount("LoginData");
		int totalColls = xlUtil.getCellCount("LoginData", 0);
		
		String[][] loginData = new String[totalRows][totalColls];
		
		for(int i=1; i<=totalRows; i++) {
			for(int j=0; j<totalColls; j++) {
				loginData[i-1][j] =  xlUtil.getCellData("LoginData", i, j);
			}
		}
	return loginData;
	}

}
