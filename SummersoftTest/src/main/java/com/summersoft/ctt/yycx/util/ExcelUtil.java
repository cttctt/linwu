package com.summersoft.ctt.yycx.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;



//此类事实现操作指定的excel文件中的指定sheet页、读取指定的单元格内容、获取sheet中最后一行的行号的功能
public class ExcelUtil {


	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;

	//Constructor to connect to the Excel with sheetname and Path
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			throw (e);
		}
	}

	//This method is to set the rowcount of the excel.
	public int excel_get_rows() throws Exception {
		try {
			return ExcelWSheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			throw (e);

		}
	}


	//This method to get the data and get the value as strings.
	public static String getCellAsString(int RowNum, int ColNum) throws Exception {
		try {
			String CellData = ExcelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
			//Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			//String CellData = Cell.getStringCellValue();
			System.out.println("The value of CellData " + CellData);
			return CellData;
		} catch (Exception e) {
			return "Errors in Getting Cell Data";
		}
	}

	public static String getCellAsDate(int RowNum, int ColNum) {


		try {
			Date date = ExcelWSheet.getRow(RowNum).getCell(ColNum).getDateCellValue();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String CellData = format.format(date);

			//Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			//String CellData = Cell.getStringCellValue();
			System.out.println("The value of CellData " + CellData);
			return CellData;
		} catch (Exception e) {
			return "Errors in Getting Cell Data";
		}
	}


	//This method to get the data and get the value as number.
	public static String getCellAsNumber(int RowNum, int ColNum) throws Exception {
		try {
			int CellData = (int) ExcelWSheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();

			//Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			//String CellData = Cell.getStringCellValue();
			System.out.println("The value of CellData " + CellData);
			return String.valueOf(CellData);
		} catch (Exception e) {
			return String.valueOf(0);
		}
	}
}
