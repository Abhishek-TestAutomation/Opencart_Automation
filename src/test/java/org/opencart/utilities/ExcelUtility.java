package org.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	private FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private FileOutputStream fos;
	private CellStyle style;
	private String filePath;
	
	public ExcelUtility(String filePath) {
		this.filePath = filePath;
	}
	
	public int getRowCount(String sheetName) throws IOException{
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return totalRows;
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException{
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int totalCell = row.getLastCellNum();
		workbook.close();
		fis.close();
		return totalCell;
	}
	
	public String getCellData(String sheetName , int rowNum, int cellNum) throws IOException{
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data = "";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File xlFile = new File(filePath);
		if(!xlFile.exists()) {  //If file does not exist create new file
			workbook = new XSSFWorkbook();
			fos = new FileOutputStream(filePath);
			workbook.write(fos);
			workbook.close();
			fos.close();
		}
		
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		
		if(workbook.getSheetIndex(sheetName)==-1)   //If sheet does not exist create new sheet
			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);
		
		if(sheet.getRow(rowNum)==null)
			sheet.createRow(rowNum);
		row = sheet.getRow(rowNum);
		
		cell = row.getCell(cellNum);
		if(cell==null) {
			cell = row.createCell(cellNum);
		}
		cell.setCellValue(data);
		fos = new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	
	public void fillGreenColor(String sheetName, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fos = new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	
	public void fillRedColor(String sheetName, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fos = new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
}
