package com.tms.LetsFeelRomania.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * to read data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param colNo
	 * @return
	 * @throws Throwable
	 */
	public String readExcelData(String sheetName, int rowNo, int colNo) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh=wb.getSheet(sheetName);
		Row row = sh.getRow(rowNo);
		Cell cell = row.getCell(colNo);
		String value = cell.getStringCellValue();
		return value;
		
	}
	/**
	 * this method is for writing data into excel file
	 * @param sheetName
	 * @param rowNo
	 * @param colNo
	 * @param data
	 * @throws Throwable
	 */
	public void writeExcelData(String sheetName,int rowNo,int colNo,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNo);
		Cell cell = row.getCell(colNo);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);
	}
	/**
	 * this method will give last row count
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */
	public int getLastRow(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	/**
	 * getting data from excel in form of map object
	 * @param sheetName
	 * @param keyCell
	 * @param valueCell
	 * @return
	 * @throws Throwable
	 */
	public Map<String,String> getMap(String sheetName,int keyCell,int valueCell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		Map<String,String> map=new HashMap<String, String>();
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCell).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	/**
	 * this method returns excel one column data in form of array list
	 * @param sheetName
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public ArrayList<String> getList(String sheetName,int rowNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sht = book.getSheet(sheetName);
		 Row row = sht.getRow(rowNum);
		short cell = row.getLastCellNum();
		//String excelvalue=null;
		ArrayList<String> arr=new ArrayList<String>();
		for(int i=0;i<cell;i++)
		{
			String value=sht.getRow(rowNum).getCell(i).toString();
			arr.add(value);
		}
		return arr;
		
	}
	public Object[][] readDataDataProvider(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow+1][lastCell];
		for(int i=0;i<=lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

}
