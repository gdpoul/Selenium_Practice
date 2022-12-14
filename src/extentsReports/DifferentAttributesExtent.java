package extentsReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DifferentAttributesExtent {
	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReport = new ExtentReports();
		File file=new File("reoprter.html");
		ExtentSparkReporter sparkRporter = new ExtentSparkReporter(file);
		extentReport.attachReporter(sparkRporter);
	
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
		Desktop.getDesktop().browse(new File("reoprter.html").toURI());

	}

}
