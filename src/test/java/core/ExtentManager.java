package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	private ExtentManager() {
		
	}
	
	public static ExtentReports getInstance(String reportPath) {
		if(extent==null) {
			
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
			
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName("Alaska Trips Regression Suite");
			htmlReporter.config().setDocumentTitle("Revision5Day1_2002");
			
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			extent.setSystemInfo("Browser", Config.getBrowser());
			extent.setSystemInfo("Execution Mode", Config.getExecutionMode());
			extent.setSystemInfo("Headless Mode", String.valueOf(Config.isHeadless()));
			extent.setSystemInfo("Base URL", Config.getBaseUrl());
		}
		return extent;
		
	}
	
	public static ExtentReports getExtent() {
		return extent;
	}

}
