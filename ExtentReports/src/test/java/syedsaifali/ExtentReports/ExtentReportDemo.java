package syedsaifali.ExtentReports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportDemo {

    ExtentReports extent;

    @BeforeTest
    public void config() {

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
    }

    @Test
    public void initialDemo() {
        ExtentTest test = extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver", "D://Automation//Appium//chromedriver-win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com");

        System.out.println("Page title: " + driver.getTitle());

        test.pass("Navigated to website successfully");

        driver.close();
        extent.flush();
    }
}