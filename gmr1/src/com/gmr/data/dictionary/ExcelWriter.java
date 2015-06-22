package com.gmr.data.dictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelWriter {
	
	public void writeExcel(String bucket, String attribute, String column, String platform, String dataEle, 
			String dataType, String nullDefi, String busiDefi) {
		
		//FileInputStream file = new FileInputStream(new File("GMRDataDictionary.xls"));
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("GMRDataDictionary.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			
		    int rows = sheet.getPhysicalNumberOfRows();
		    HSSFRow row;
		    //HSSFCell cell;
		    
		    row = sheet.getRow(rows);
		    // Create a cell and put a value in it.
		    Cell cell = row.createCell(columnCount);
		    cell.setCellValue(data);
		    columnCount++;
			
		    try {
			    // Write the output to a file
			    FileOutputStream fileOut = new FileOutputStream("workbook.xls");
			    wb.write(fileOut);
			    fileOut.close();
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
	}
	
	public void writeNodeExcel(List<List<String>> nodeDataList) {
		
		if(nodeDataList !=null && !nodeDataList.isEmpty()) {
			
			Workbook wb = new HSSFWorkbook();
		    //Workbook wb = new XSSFWorkbook();
		    CreationHelper createHelper = wb.getCreationHelper();
		    
		    Sheet sheet = wb.createSheet("new sheet");
			
		    int rowCount = 0;
		    
			for(List<String> dataList : nodeDataList) {
				
			    // Create a row and put some cells in it. Rows are 0 based.
			    Row row = sheet.createRow((short) rowCount);
			    
			    int columnCount=0;
				for(String data: dataList) {

				    // Create a cell and put a value in it.
				    Cell cell = row.createCell(columnCount);
				    cell.setCellValue(data);
				    columnCount++;
				}
				rowCount++;
			}
			
		    try {
			    // Write the output to a file
			    FileOutputStream fileOut = new FileOutputStream("workbook.xls");
			    wb.write(fileOut);
			    fileOut.close();
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
	}

}
