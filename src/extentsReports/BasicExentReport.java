package extentsReports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicExentReport {
	public static void main(String[] args) throws Exception {
		
		ExtentReports extentReport = new ExtentReports();
		File file=new File("reoprter.html");
//		ExtentSparkReporter sparkRporter = new ExtentSparkReporter("reporter.html");
		ExtentSparkReporter sparkRporter = new ExtentSparkReporter(file);
		extentReport.attachReporter(sparkRporter);
		
		ExtentTest test1 = extentReport.createTest("Test1");
		test1.pass("Test 1 Passed");
		ExtentTest test2 = extentReport.createTest("Test2");
		test2.log(Status.FAIL, "test 2 failed");
		extentReport.createTest("test 3").skip("test 3 skipped");
		
		
		extentReport.flush();
		Desktop.getDesktop().browse(new File("reoprter.html").toURI());
	}

}
