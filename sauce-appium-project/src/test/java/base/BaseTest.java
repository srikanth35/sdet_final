package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.DriverManager;

public class BaseTest {
	protected AndroidDriver<MobileElement> driver;
	protected static ExtentReports extent;
	protected ExtentTest test; // 

	@BeforeSuite
	public void setupExtentReport() {
		// Initialize ExtentReports only once for the entire suite
		if (extent == null) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
			extent.attachReporter(spark);
		}
	}

	@BeforeClass
	public void setup() {
		driver = DriverManager.getDriver();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {  driver.quit();}
	}

	@AfterSuite
	public void tearDownReporting() {
		// Flush the report (write to file)
		if (extent != null) {
			extent.flush();
		}
	}
}
