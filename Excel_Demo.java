package com.example.demo.Demos;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Demo {
    FileInputStream fis = null;
    XSSFWorkbook workbook = null;
    Sheet sheet = null;
    Row row = null;

    // Constructor
    Excel_Demo(String excelPath, String sheetName) {
        try {
            fis = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get specific row
    public Row getRow(int rowNum) {
        if (sheet != null) {
            row = sheet.getRow(rowNum);
        }
        return row;
    }

    // Get specific cell from the previously accessed row
    public Cell getColumn(int columnIndex) {
        if (row != null) {
            return row.getCell(columnIndex);
        }
        return null;
    }

    public int rowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int colCount() {
        if (sheet != null) {
            Row firstRow = sheet.getRow(0);
            if (firstRow != null) {
                return firstRow.getPhysicalNumberOfCells();
            }
        }
        return 0;
    }
    
    public String getShallData(int row,int col) {
    	 String value="";
    	try {
    		value=sheet.getRow(row).getCell(col).getStringCellValue();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return value;
    }

    // Close resources
    public void closeWorkbook() {
        try {
            if (workbook != null) {
                workbook.close();
            }
            if (fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
