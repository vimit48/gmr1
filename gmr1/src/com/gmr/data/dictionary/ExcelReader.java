package com.gmr.data.dictionary;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader {
	
	public List<List<String>> readExcel(String file) {
		
		List<List<String>> dataList = new ArrayList<List<String>>();
		
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    for(int i = 0; i < rows; i++) {
		        row = sheet.getRow(i);
		        
		        List<String> dataRow = new ArrayList<String>();
		        
		        if(row != null) {
		            cols = sheet.getRow(i).getPhysicalNumberOfCells();
		            int col=0;
		            while (col < cols) {
		            	dataRow.add(sheet.getRow(i).getCell(col).getStringCellValue());
		            	col++;
		            }
		        }
		        dataList.add(dataRow);
		    }

		    
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}
	    return dataList;
	}

}
