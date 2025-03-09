package syedsaifali.Test.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportConfig {
	
	static ExtentReports extent;

	public static ExtentReports reportConfig() {
		   String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";

	        // ExtentSparkReporter
			//It is a helper class
	        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
	        reporter.config().setReportName("Web Automation Results");
	        reporter.config().setDocumentTitle("Automation Results");

	        // ExtentReports
			//Responsible Reporting execution
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Test", "Syed Saif Ali");
	        return extent;
	}
	
}
