package com.example.demo.Demos;

public class DataProvider1 {

	public Object[][] testData(String XMLPath,String Sheet) {
		  Excel_Demo excel=new Excel_Demo("C:\\Users\\me\\OneDrive\\Desktop\\logical question\\Log4jDemo\\Excel\\abx.xm.xlsx","Sheet1");
           int row= excel.rowCount();
            int col=excel.colCount();
            Object obj[][]=new Object[row][col];
            for(int i=1;i<row;i++) {
            	for(int j=0;j<col;j++) {
            	obj[i][j]=excel.getShallData(i,j);
            	}
            }
            
            return obj;
	}
	
}
