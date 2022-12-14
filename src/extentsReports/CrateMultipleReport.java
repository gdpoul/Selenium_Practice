package extentsReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CrateMultipleReport {
	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter sparkRporter_all = new ExtentSparkReporter("AllTests.html");
		
		ExtentSparkReporter sparkRporter_failed = new ExtentSparkReporter("FailedTest.html");
		sparkRporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		ExtentSparkReporter sparkRporter_SkipAndWarning = new ExtentSparkReporter("SkipAndWarningTest.html");
		sparkRporter_SkipAndWarning.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
				}).apply();
		
		extentReport.attachReporter(sparkRporter_all,sparkRporter_failed,sparkRporter_SkipAndWarning);
	
		extentReport.createTest("Test1")
		.pass("Test is PAsseed")
		.assignAuthor("Ganesh")
		.assignCategory("SmokeTesting")
		.assignDevice("Chrome101");
		
		extentReport.createTest("Test2")
		.info("Test is PAsseed")
		.assignAuthor("David")
		.assignCategory("Sanity")
		.assignDevice("Firefox 80");
	
		extentReport.createTest("Test3")
		.fail("Test is PAsseed")
		.assignAuthor("David","Sam","Smith")
		.assignCategory("Sanity","Functional")
		.assignDevice("Firefox 80","Opera");
		
		extentReport.createTest("Test4")
		.skip("Test is PAsseed")
		.assignAuthor("Ganesh")
		.assignCategory("SmokeTesting")
		.assignDevice("Chrome101");

	
		extentReport.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTest.html").toURI());
		Desktop.getDesktop().browse(new File("SkipAndWarningTest.html").toURI());

	}

}
