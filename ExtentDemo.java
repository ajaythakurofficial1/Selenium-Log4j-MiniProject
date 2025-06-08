package com.example.demo.Demos;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentDemo {
 public static ExtentReports extent=null;
	public static ExtentReports getExtent() {
		
        ExtentSparkReporter printer = new ExtentSparkReporter("abcd.html");
          printer.config().setDocumentTitle("Automation testing");
          printer.config().setReportName("Regerssion suite");
          printer.config().setTheme(Theme.STANDARD);
          
          extent=new ExtentReports();
		return extent;
		
	
	}
	}

