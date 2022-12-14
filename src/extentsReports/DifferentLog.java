package extentsReports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DifferentLog {
	public static void main(String[] args) throws Exception {
		
		ExtentReports extentReport = new ExtentReports();
		File file=new File("reoprter.html");
//		ExtentSparkReporter sparkRporter = new ExtentSparkReporter("reporter.html");
		ExtentSparkReporter sparkRporter = new ExtentSparkReporter(file);
		extentReport.attachReporter(sparkRporter);
		
		extentReport
		.createTest("Test1")
		.log(Status.PASS, "pass")
		.log(Status.PASS, "pass")
		.log(Status.FAIL, "fail")
		.log(Status.WARNING, "warning")
		.log(Status.WARNING, "warning")
		.log(Status.WARNING, "warning")
		.log(Status.SKIP, "skip")
		.log(Status.INFO, "info");
	
		// order of extends logs
		//fail
		//skip
		//warning
		//pass
		//info
		
		extentReport.flush();
		Desktop.getDesktop().browse(new File("reoprter.html").toURI());
	}


}
