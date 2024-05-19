package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    
    public static ExtentReports getExtentReport() {
   	
   	 String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
   	 ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
   	 reporter.config().setReportName("Pizzahut Application Results");
   	 reporter.config().setDocumentTitle("Pizahuit Application Test Results");
   	 
   	 ExtentReports extentReport = new ExtentReports();
   	 extentReport.attachReporter(reporter);
   	 extentReport.setSystemInfo("Operating System","Windows 11");
   	 extentReport.setSystemInfo("Executed By","Sakshi Jindal");
   	 
   	 return extentReport;
    }

}

